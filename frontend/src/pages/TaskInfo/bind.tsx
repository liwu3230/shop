import {BASE_ROUTE_PREFIX} from '@/constants';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import {ApiObject} from 'amis/lib/types';
import addStoreBind from './addStroreBind';
import {orderStatusList} from "@/constants/enums";

const initSchema = () => ({
    title: '',
    size: 'xl',
    actions: [],
    body: {
        type: "tabs",
        activeKey: "storeBindKey",
        tabs: [
            {
                title: "网点列表",
                hash: "storeBindKey",
                reload: true,
                tab: {
                    type: 'crud',
                    name: 'storeBind',
                    api: {
                        method: 'post',
                        url: `${BASE_ROUTE_PREFIX}/taskInfo/findStoreListByTaskId`,
                        adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
                        requestAdaptor: (api: ApiObject) => {
                            return {
                                ...api,
                                data: {
                                    ...api.data,
                                    taskId: api.data.taskId,
                                },
                            };
                        },
                    },
                    // primaryField: 'id',
                    syncLocation: false,
                    footerToolbar: [
                        {
                            type: 'tpl',
                            tpl: ' 总共：${total} 项 ',
                            align: 'right',
                        },
                        {
                            type: 'switch-per-page',
                            align: 'right',
                        },
                        'pagination',
                    ],
                    perPageField: 'limit',
                    pageField: 'page',
                    perPage: 10,
                    perPageAvailable: [10, 50, 100, 500, 1000],
                    headerToolbar: [
                        {
                            label: '新增任务网点',
                            type: 'button',
                            actionType: 'dialog',
                            level: 'primary',
                            name: "addStoreBindDialog",
                            dialog: addStoreBind(),
                        },
                        'bulkActions',
                    ],
                    bulkActions: [
                        {
                            label: '批量取消关联',
                            actionType: 'ajax',
                            confirmText: '确定要批量取消关联?',
                            api: {
                                url: `${BASE_ROUTE_PREFIX}/taskInfo/cancelBindStore`,
                                method: 'post',
                                data: {
                                    taskId: '$taskId',
                                    storeIds: '$ids',
                                },
                                requestAdaptor: (api: ApiObject) => {
                                    return {
                                        ...api,
                                        data: {
                                            ...api.data,
                                            storeIds: api.data?.storeIds.split(','),
                                        },
                                    };
                                },
                            },
                        },
                    ],
                    source: '${list}',
                    filter: {
                        title: '',
                        submitText: '',
                        mode: 'horizontal',
                        controls: genSearchPresentList(3, [
                            {
                                type: 'text',
                                name: 'name',
                                label: '名称：',
                                placeholder: '请输入名称',
                                canAccessSuperData: false,
                                clearable: true,
                            },
                            {
                                type: 'text',
                                name: 'alias',
                                label: '别名：',
                                placeholder: '请输入别名',
                                clearable: true,
                            },
                            {
                                type: 'text',
                                name: 'staff',
                                label: '联系人：',
                                placeholder: '请输入联系人',
                                clearable: true,
                            },
                            {
                                type: 'text',
                                name: 'address',
                                label: '地址：',
                                placeholder: '请输入地址',
                                clearable: true,
                            },
                            {
                                type: 'text',
                                name: 'detailedAddress',
                                label: '详细地址：',
                                placeholder: '请输入详细地址',
                                clearable: true,
                            },
                        ]),
                        actions: [
                            {
                                type: 'submit',
                                label: '查询',
                                icon: 'fa fa-search',
                                level: 'primary',
                            },
                            {
                                type: 'reset',
                                actionType: 'reset-and-submit',
                                label: '重置',
                                icon: 'fa fa-rotate-right',
                            },
                        ],
                    },
                    columns: [
                        // {
                        //   type: "image",
                        //   name: "logo",
                        //   label: "图标",
                        //   thumbMode: "cover",
                        //   enlargeAble: true,
                        //   height: "40px",
                        //   width: "40px",
                        // },
                        {
                            name: 'name',
                            label: '名称',
                        },
                        {
                            name: 'alias',
                            label: '别名',
                        },
                        {
                            name: 'staff',
                            label: '联系人',
                        },
                        {
                            name: 'phone',
                            label: '手机号码',
                        },
                        {
                            name: 'address',
                            label: '地址',
                        },
                        {
                            name: 'detailedAddress',
                            label: '详细地址',
                        },
                        {
                            name: 'longitude',
                            label: '经度',
                        },
                        {
                            name: 'latitude',
                            label: '纬度',
                        },
                        {
                            type: 'operation',
                            label: '操作',
                            buttons: [
                                {
                                    type: 'button',
                                    tooltip: '取消关联',
                                    actionType: 'dialog',
                                    icon: 'fa fa-trash',
                                    className: 'text-red-400 text-md',
                                    dialog: {
                                        body: {
                                            type: 'form',
                                            api: {
                                                url: `${BASE_ROUTE_PREFIX}/taskInfo/cancelBindStore`,
                                                method: 'post',
                                                data: {
                                                    taskId: '$taskId',
                                                    storeIds: '$id',
                                                },
                                                requestAdaptor: (api: ApiObject) => {
                                                    return {
                                                        ...api,
                                                        data: {
                                                            ...api.data,
                                                            storeIds: api.data?.storeIds.toString().split(','),
                                                        },
                                                    };
                                                },
                                            },
                                            controls: [
                                                {
                                                    type: 'tpl',
                                                    tpl: '您确认要取消关联吗？',
                                                },
                                            ],
                                        },
                                    },
                                },
                            ],
                        },
                    ],
                },
            },
            {
                title: "订单列表",
                hash: "orderBindKey",
                reload: true,
                tab: {
                    type: 'crud',
                    name: 'orderBind',
                    api: {
                        method: 'post',
                        url: `${BASE_ROUTE_PREFIX}/taskInfo/findOrderListByTaskId`,
                        adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
                        requestAdaptor: (api: ApiObject) => {
                            let sendTimeArray = api.data.sendTimeRange?.split(',');
                            let acceptTimeArray = api.data.acceptTimeTimeRange?.split(',');
                            return {
                                ...api,
                                data: {
                                    ...api.data,
                                    tid: api.data.taskId,
                                    startSendTime: sendTimeArray ? sendTimeArray[0] : '',
                                    endSendTime: sendTimeArray ? sendTimeArray[1] : '',
                                    startAcceptTime: acceptTimeArray ? acceptTimeArray[0] : '',
                                    endAcceptTime: acceptTimeArray ? acceptTimeArray[1] : '',
                                    storeIds: api.data?.storeIds ? api.data?.storeIds.split(',') : [],
                                    statusList: api.data?.statusList ? api.data?.statusList.split(',') : [],
                                },
                            };
                        },
                    },
                    // primaryField: 'id',
                    syncLocation: false,
                    footerToolbar: [
                        {
                            type: 'tpl',
                            tpl: ' 总共：${total} 项 ',
                            align: 'right',
                        },
                        {
                            type: 'switch-per-page',
                            align: 'right',
                        },
                        'pagination',
                    ],
                    perPageField: 'limit',
                    pageField: 'page',
                    perPage: 30,
                    perPageAvailable: [30, 50, 100, 500, 1000],
                    headerToolbar: [
                        // {
                        //   type: 'button',
                        //   level: 'primary',
                        //   label: '派发订单',
                        //   actionType: 'ajax',
                        //   confirmText: '确定要派发订单?',
                        //   api: {
                        //     url: `${BASE_ROUTE_PREFIX}/taskInfo/genOrder`,
                        //     method: 'post',
                        //     data: {
                        //       taskId: '$taskId',
                        //     },
                        //     requestAdaptor: (api: ApiObject) => {
                        //       return {
                        //         ...api,
                        //         data: {
                        //           ...api.data,
                        //         },
                        //       };
                        //     },
                        //   },
                        // },
                        'bulkActions',
                    ],
                    bulkActions: [
                        // {
                        //   label: '批量派发订单',
                        //   actionType: 'ajax',
                        //   confirmText: '确定要批量派发订单?',
                        //   api: {
                        //     url: `${BASE_ROUTE_PREFIX}/taskOrder/sendByIds`,
                        //     method: 'post',
                        //     data: {
                        //       ids: '$ids',
                        //     },
                        //     requestAdaptor: (api: ApiObject) => {
                        //       return {
                        //         ...api,
                        //         data: {
                        //           ...api.data,
                        //           ids: api.data?.ids.split(','),
                        //         },
                        //       };
                        //     },
                        //   },
                        // },
                    ],
                    source: '${list}',
                    filter: {
                        title: '',
                        submitText: '',
                        mode: 'horizontal',
                        controls: genSearchPresentList(3, [
                            {
                                type: 'select',
                                name: 'storeIds',
                                label: '所属网点：',
                                searchable: true,
                                clearable: true,
                                multiple: true,
                                labelField: 'name',
                                valueField: 'id',
                                source: {
                                    url: `${BASE_ROUTE_PREFIX}/store/findAll`,
                                    method: 'get',
                                },
                            },
                            {
                                type: 'text',
                                name: 'appUserNickName',
                                label: '用户昵称：',
                                placeholder: '请输入用户昵称',
                                clearable: true,
                            },
                            {
                                type: 'text',
                                name: 'appUserRealName',
                                label: '用户姓名：',
                                placeholder: '请输入用户姓名',
                                clearable: true,
                            },
                            {
                                type: 'text',
                                name: 'orderNo',
                                label: '订单号：',
                                placeholder: '请输入订单号',
                                clearable: true,
                            },
                            {
                                type: 'select',
                                name: 'statusList',
                                label: '状态：',
                                options: orderStatusList,
                                placeholder: '请选择状态',
                                clearable: true,
                                multiple: true,
                            },
                            {
                                type: 'select',
                                name: 'isExpired',
                                label: '是否超时：',
                                options: [
                                    {
                                        value: 1,
                                        label: '是',
                                    },
                                    {
                                        value: 0,
                                        label: '否',
                                    },
                                ],
                                clearable: true,
                                placeholder: '请选择',
                            },
                            {
                                type: 'input-datetime-range',
                                name: 'sendTimeRange',
                                label: '派发时间：',
                                format: 'YYYY-MM-DD HH:mm:ss',
                            },
                            {
                                type: 'input-datetime-range',
                                name: 'acceptTimeTimeRange',
                                label: '承接时间：',
                                format: 'YYYY-MM-DD HH:mm:ss',
                            },
                        ]),
                        actions: [
                            {
                                type: 'submit',
                                label: '查询',
                                icon: 'fa fa-search',
                                level: 'primary',
                            },
                            {
                                type: 'reset',
                                actionType: 'reset-and-submit',
                                label: '重置',
                                icon: 'fa fa-rotate-right',
                            },
                        ],
                    },
                    columns: [
                        {
                            name: 'storeName',
                            label: '网点名称',
                        },
                        {
                            name: 'orderNo',
                            label: '订单号',
                        },
                        {
                            name: 'price',
                            label: '金额',
                            prefix: "￥",
                            type: "number",
                        },
                        {
                            name: 'appUserNickName',
                            label: '用户昵称',
                        },
                        {
                            name: 'appUserRealName',
                            label: '用户姓名',
                        },
                        {
                            name: 'appUserIsPassExam',
                            label: '已考试',
                            type: 'mapping',
                            map: {
                                1: "是",
                                0: "否"
                            }
                        },
                        {
                            name: 'appUserIsPassCert',
                            label: '已认证',
                            type: 'mapping',
                            map: {
                                1: "是",
                                0: "否"
                            }
                        },
                        {
                            name: 'status',
                            label: '订单状态',
                            type: 'mapping',
                            map: convertOptionsToMap(orderStatusList)
                        },
                        {
                            name: 'taskExpired',
                            label: '是否超时',
                            type: 'mapping',
                            map: {
                                true: "<span style='background:#ffa940' class='label'>是</span>",
                                false: "<span style='background:#87d068' class='label'>否</span>",
                            }
                        },
                        {
                            name: 'taskEndTime',
                            label: '任务结束时间',
                        },
                        {
                            name: 'sendTime',
                            label: '派发时间',
                        },
                        {
                            name: 'acceptTime',
                            label: '承接时间',
                        },
                        {
                            name: 'doneTime',
                            label: '完成时间',
                        },
                        {
                            type: 'operation',
                            label: '操作',
                            buttons: [
                                {
                                    type: 'button',
                                    level: 'link',
                                    className: 'text-danger',
                                    label: '删除',
                                    actionType: 'dialog',
                                    visibleOn: "this.status === 0",
                                    dialog: {
                                        body: {
                                            type: 'form',
                                            api: {
                                                url: `${BASE_ROUTE_PREFIX}/taskInfo/deleteOrder`,
                                                method: 'post',
                                                data: {
                                                    orderIds: '$id',
                                                },
                                                requestAdaptor: (api: ApiObject) => {
                                                    return {
                                                        ...api,
                                                        data: {
                                                            ...api.data,
                                                            orderIds: api.data?.orderIds.toString().split(','),
                                                        },
                                                    };
                                                },
                                            },
                                            controls: [
                                                {
                                                    type: 'tpl',
                                                    tpl: '您确认要删除吗？',
                                                },
                                            ],
                                        },
                                    },
                                },
                            ],
                        },
                    ],
                },
            },
            // {
            //   title: "用户名单",
            //   hash: "appUserBindKey",
            //   reload: true,
            //   tab: {
            //     type: 'crud',
            //     name: 'appUserBind',
            //     api: {
            //       method: 'post',
            //       url: `${BASE_ROUTE_PREFIX}/taskInfo/findAppUserListByTaskId`,
            //       adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
            //       requestAdaptor: (api: ApiObject) => {
            //         return {
            //           ...api,
            //           data: {
            //             ...api.data,
            //             taskId: api.data.taskId,
            //           },
            //         };
            //       },
            //     },
            //     // primaryField: 'id',
            //     syncLocation: false,
            //     footerToolbar: [
            //       {
            //         type: 'tpl',
            //         tpl: ' 总共：${total} 项 ',
            //         align: 'right',
            //       },
            //       {
            //         type: 'switch-per-page',
            //         align: 'right',
            //       },
            //       'pagination',
            //     ],
            //     perPageAvailable: [10, 50, 100, 500, 1000],
            //     headerToolbar: [
            //       {
            //         label: '新增用户名单',
            //         type: 'button',
            //         actionType: 'dialog',
            //         level: 'primary',
            //         name: "addAppUserBindDialog",
            //         dialog: addAppUserBind(),
            //       },
            //       'bulkActions',
            //     ],
            //     bulkActions: [
            //       {
            //         label: '批量取消名单',
            //         actionType: 'ajax',
            //         confirmText: '确定要批量取消名单?',
            //         api: {
            //           url: `${BASE_ROUTE_PREFIX}/taskInfo/cancelBindAppUser`,
            //           method: 'post',
            //           data: {
            //             taskId: '$taskId',
            //             appUserIds: '$ids',
            //           },
            //           requestAdaptor: (api: ApiObject) => {
            //             return {
            //               ...api,
            //               data: {
            //                 ...api.data,
            //                 appUserIds: api.data?.appUserIds.split(','),
            //               },
            //             };
            //           },
            //         },
            //       },
            //       {
            //         label: '生成待派发订单',
            //         actionType: 'ajax',
            //         confirmText: '确定要批量生成待派发订单?',
            //         api: {
            //           url: `${BASE_ROUTE_PREFIX}/taskInfo/generateOrder`,
            //           method: 'post',
            //           data: {
            //             taskId: '$taskId',
            //             appUserIds: '$ids',
            //           },
            //           requestAdaptor: (api: ApiObject) => {
            //             return {
            //               ...api,
            //               data: {
            //                 ...api.data,
            //                 appUserIds: api.data?.appUserIds.split(','),
            //               },
            //             };
            //           },
            //         },
            //       },
            //     ],
            //     source: '${list}',
            //     filter: {
            //       title: '',
            //       submitText: '',
            //       mode: 'horizontal',
            //       controls: genSearchPresentList(3, [
            //         {
            //           type: 'text',
            //           name: 'openId',
            //           label: 'openId：',
            //           placeholder: '请输入openId',
            //           clearable: true,
            //         },
            //         {
            //           type: 'text',
            //           name: 'realName',
            //           label: '姓名：',
            //           placeholder: '请输入姓名',
            //           clearable: true,
            //         },
            //         {
            //           type: 'text',
            //           name: 'phone',
            //           label: '手机号码：',
            //           placeholder: '请输入手机号码',
            //           clearable: true,
            //         },
            //         {
            //           type: 'select',
            //           name: 'tagId',
            //           label: '标签：',
            //           searchable: true,
            //           clearable: true,
            //           labelField: 'name',
            //           valueField: 'id',
            //           source: {
            //             url: `${BASE_ROUTE_PREFIX}/appUserTag/findAll`,
            //             method: 'get',
            //           },
            //         },
            //       ]),
            //       actions: [
            //         {
            //           type: 'submit',
            //           label: '查询',
            //           icon: 'fa fa-search',
            //           level: 'primary',
            //         },
            //         {
            //           type: 'reset',
            //           actionType: 'reset-and-submit',
            //           label: '重置',
            //           icon: 'fa fa-rotate-right',
            //         },
            //       ],
            //     },
            //     columns: [
            //       {
            //         name: 'id',
            //         label: 'ID',
            //       },
            //       {
            //         name: 'openId',
            //         label: 'openId',
            //       },
            //       {
            //         name: 'nickName',
            //         label: '昵称',
            //       },
            //       {
            //         name: 'realName',
            //         label: '姓名',
            //       },
            //       {
            //         name: 'gender',
            //         label: '性别',
            //         type: 'mapping',
            //         map: {
            //           1: "男",
            //           2: "女",
            //           "*": "未知"
            //         }
            //       },
            //       {
            //         name: 'cardId',
            //         label: '身份证号',
            //       },
            //       {
            //         name: 'phone',
            //         label: '手机号码',
            //       },
            //       {
            //         type: "each",
            //         name: "tagNames",
            //         label: "标签",
            //         width: "300px",
            //         className: 'word-break',
            //         placeholder: "-",
            //         items: {
            //           type: "tpl",
            //           tpl: "<div class='label label-info m-r-sm text-xs'>${item}</div>"
            //         }
            //       },
            //       {
            //         name: 'isPassExam',
            //         label: '已考试',
            //         type: 'mapping',
            //         map: {
            //           1: "是",
            //           0: "否"
            //         }
            //       },
            //       {
            //         name: 'passCert',
            //         label: '已认证',
            //         type: 'mapping',
            //         map: {
            //           1: "是",
            //           0: "否"
            //         }
            //       },
            //       {
            //         name: 'taskOrders',
            //         label: '是否派发',
            //         type: 'tpl',
            //         tpl: "${taskOrders.length > 0 ? '已派发' : '未派发'}"
            //       },
            //       {
            //         type: 'operation',
            //         label: '操作',
            //         buttons: [
            //           {
            //             type: 'button',
            //             tooltip: '取消关联',
            //             actionType: 'dialog',
            //             icon: 'fa fa-trash',
            //             className: 'text-red-400 text-md',
            //             dialog: {
            //               body: {
            //                 type: 'form',
            //                 api: {
            //                   url: `${BASE_ROUTE_PREFIX}/taskInfo/cancelBindAppUser`,
            //                   method: 'post',
            //                   data: {
            //                     taskId: '$taskId',
            //                     appUserIds: '$id',
            //                   },
            //                   requestAdaptor: (api: ApiObject) => {
            //                     return {
            //                       ...api,
            //                       data: {
            //                         ...api.data,
            //                         appUserIds: api.data?.appUserIds.toString().split(','),
            //                       },
            //                     };
            //                   },
            //                 },
            //                 controls: [
            //                   {
            //                     type: 'tpl',
            //                     tpl: '您确认要取消关联吗？',
            //                   },
            //                 ],
            //               },
            //             },
            //           },
            //         ],
            //       },
            //     ],
            //   },
            // },

        ],
    }

});

export default initSchema;
