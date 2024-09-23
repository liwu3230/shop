import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {genSearchPresentList} from '@/utils';
import {useModel} from '@umijs/max';
import {ApiObject} from "amis/lib/types";
import initAddress from "./address";

const Overview = () => {
  const {permissionList, currentUser} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'appUser',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/appUser/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
          requestAdaptor: (api: ApiObject) => {
            let timeArray = api.data.createTimeRange?.split(',');
            return {
              ...api,
              data: {
                ...api.data,
                startTime: timeArray ? timeArray[0] : '',
                endTime: timeArray ? timeArray[1] : '',
              },
            };
          },
        },
        filter: {
          title: '',
          submitText: '',
          mode: 'horizontal',
          controls: genSearchPresentList(3, [
            {
              type: 'text',
              name: 'openId',
              label: 'openId：',
              placeholder: '请输入openId',
              clearable: true,
            },
            {
              type: 'text',
              name: 'realName',
              label: '姓名：',
              placeholder: '请输入姓名',
              clearable: true,
            },
            {
              type: 'text',
              name: 'phone',
              label: '手机号码：',
              placeholder: '请输入手机号码',
              clearable: true,
            },
            {
              type: 'select',
              name: 'tagIds',
              label: '标签：',
              searchable: true,
              multiple: true,
              clearable: true,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/appUserTag/findAll`,
                method: 'get',
              },
            },
            {
              type: 'select',
              name: 'isPassCert',
              label: '是否认证：',
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
              type: 'select',
              name: 'isPassExam',
              label: '是否考试：',
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
        perPageField: 'limit',
        pageField: 'page',
        perPage: 30,
        perPageAvailable: [30, 50, 100, 500, 1000],
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
        keepItemSelectionOnPageChange: false,
        bulkActions: [
          {
            label: "批量设置标签",
            actionType: "dialog",
            level: 'enhance',
            type: "button",
            dialog: {
              title: "设置标签",
              name: "sample-bulk-edit",
              body: {
                size: 'md',
                type: "form",
                reload: 'appUser',
                api: {
                  url: `${BASE_ROUTE_PREFIX}/appUser/setTag`,
                  method: 'post',
                  data: {
                    '&': '$$',
                    ids: '$ids',
                    data: '$data',
                  },
                  requestAdaptor: (api: ApiObject) => {
                    return {
                      ...api,
                      data: {
                        ...api.data,
                        ids: api.data?.ids.split(','),
                        tagId: api.data?.batchTagId,
                      },
                    };
                  },
                },
                body: [
                  {
                    type: 'select',
                    name: 'batchTagId',
                    label: '标签：',
                    searchable: true,
                    multiple: true,
                    clearable: true,
                    labelField: 'name',
                    valueField: 'id',
                    source: {
                      url: `${BASE_ROUTE_PREFIX}/appUserTag/findAll`,
                      method: 'get',
                    },
                  },
                ]
              }
            },
          },
          {
            label: "批量添加标签",
            actionType: "dialog",
            level: 'enhance',
            type: "button",
            dialog: {
              title: "添加标签",
              name: "sample-bulk-edit",
              body: {
                size: 'md',
                type: "form",
                reload: 'appUser',
                api: {
                  url: `${BASE_ROUTE_PREFIX}/appUser/setTagWithAdd`,
                  method: 'post',
                  data: {
                    '&': '$$',
                    ids: '$ids',
                    data: '$data',
                  },
                  requestAdaptor: (api: ApiObject) => {
                    return {
                      ...api,
                      data: {
                        ...api.data,
                        ids: api.data?.ids.split(','),
                        tagId: api.data?.batchTagId,
                      },
                    };
                  },
                },
                body: [
                  {
                    type: 'select',
                    name: 'batchTagId',
                    label: '标签：',
                    searchable: true,
                    required: true,
                    multiple: true,
                    clearable: true,
                    labelField: 'name',
                    valueField: 'id',
                    source: {
                      url: `${BASE_ROUTE_PREFIX}/appUserTag/findAll`,
                      method: 'get',
                    },
                  },
                ]
              }
            },
          }
        ],
        headerToolbar: [
          {
            type: 'tpl',
            tpl: ' 总共：${total} 项 ',
            align: 'right',
          },
          'pagination',
          'columns-toggler',
          'bulk-actions',
          // {
          //   label: '导入',
          //   type: 'button',
          //   icon: 'fa fa fa-upload',
          //   // level: 'light',
          //   actionType: 'dialog',
          //   dialog: {
          //     title: "导入",
          //     body: {
          //       type: 'form',
          //       mode: 'normal',
          //       reload: 'appUser',
          //       api: {
          //         url: `${BASE_ROUTE_PREFIX}/appUser/import`,
          //         method: 'post',
          //         // data: {
          //         //   '&': '$$',
          //         //   id: '$id',
          //         //   data: '$data',
          //         // },
          //       },
          //       messages: {
          //         saveSuccess: '导入成功',
          //         saveFailed: '导入失败',
          //       },
          //       controls: [
          //         //隐藏项，解决单个input-file组件不触发form保存api的bug
          //         {
          //           type: "hidden",
          //           name: "hidden",
          //         },
          //         {
          //           type: "input-file",
          //           name: "file",
          //           label: "",
          //           accept: ".xlsx,.xls",
          //           asBlob: true,
          //           drag: true,
          //           // receiver: `${BASE_ROUTE_PREFIX}/appUser/import`,
          //         }
          //       ],
          //     },
          //   }
          // },
          {
            label: '导出',
            type: 'button',
            icon: 'fa fa-download',
            actionType: "download",
            visibleOn: `this._currentUser?.isAdmin === 1`,
            api: {
              method: 'post',
              url: `${BASE_ROUTE_PREFIX}/appUser/export`,
              adaptor: 'return {\n    ...payload,}',
              requestAdaptor: (api: ApiObject) => {
                let timeArray = api.data.createTimeRange?.split(',');
                return {
                  ...api,
                  data: {
                    ...api.data,
                    startTime: timeArray ? timeArray[0] : '',
                    endTime: timeArray ? timeArray[1] : '',
                  },
                };
              },
            },
          },
        ],
        source: '${list}',
        columns: [
          {
            name: 'id',
            label: 'ID',
          },
          {
            type: "image",
            name: "avatar",
            label: "头像",
            thumbMode: "cover",
            enlargeAble: true,
            height: "40px",
            width: "40px",
            toggled: false,
          },
          {
            name: 'openId',
            label: 'openId',
            width: "100px",
          },
          {
            name: 'nickName',
            label: '昵称',
            width: "90px",
          },
          {
            name: 'realName',
            label: '姓名',
            width: "90px",
          },
          {
            name: 'gender',
            label: '性别',
            type: 'mapping',
            map: {
              1: "男",
              2: "女",
              "*": "未知"
            },
            toggled: false,
          },
          {
            name: 'cardId',
            label: '身份证号',
            toggled: false,
          },
          {
            name: 'phone',
            label: '手机号码',
          },
          {
            type: "each",
            name: "tagNames",
            label: "标签",
            width: "150px",
            className: 'word-break',
            placeholder: "-",
            items: {
              type: "tpl",
              tpl: "<div class='label label-info m-r-sm text-xs'>${item}</div>"
            }
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
            name: 'locationEnable',
            label: '开启定位',
            type: 'mapping',
            map: {
              1: "<span style='background:#87d068' class='label'>是</span>",
              0: "<span style='background:#ffa940' class='label'>否</span>",
              "*": "<span style='background:#ffa940' class='label'>否</span>",
            }
          },
          {
            name: 'isPassExam',
            label: '已考试',
            type: 'mapping',
            map: {
              1: "<span style='background:#87d068' class='label'>是</span>",
              0: "<span style='background:#ffa940' class='label'>否</span>",
              "*": "<span style='background:#ffa940' class='label'>否</span>",
            }
          },
          {
            name: 'passCert',
            label: '已认证',
            type: 'mapping',
            map: {
              1: "<span style='background:#87d068' class='label'>是</span>",
              0: "<span style='background:#ffa940' class='label'>否</span>",
              "*": "<span style='background:#ffa940' class='label'>否</span>",
            }
          },
          {
            name: 'spreadTime',
            label: '注册时间',
          },
          {
            type: 'operation',
            label: '操作',
            buttons: [
              {
                label: '设置标签',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: {
                  title: "设置标签",
                  name: "sample-bulk-edit",
                  body: {
                    size: 'md',
                    type: "form",
                    reload: 'appUser',
                    api: {
                      url: `${BASE_ROUTE_PREFIX}/appUser/setTag`,
                      method: 'post',
                      data: {
                        '&': '$$',
                        appUserId: '$id',
                        data: '$data',
                      },
                      requestAdaptor: (api: ApiObject) => {
                        debugger
                        return {
                          ...api,
                          data: {
                            ...api.data,
                            ids: [api.data?.appUserId],
                          },
                        };
                      },
                    },
                    body: [
                      {
                        type: 'select',
                        name: 'tagId',
                        label: '标签：',
                        searchable: true,
                        multiple: true,
                        clearable: true,
                        labelField: 'name',
                        valueField: 'id',
                        source: {
                          url: `${BASE_ROUTE_PREFIX}/appUserTag/findAll`,
                          method: 'get',
                        },
                      },
                    ]
                  }
                },
              },
              {
                label: '地址列表',
                type: 'button',
                actionType: 'dialog',
                level: 'link',
                dialog: initAddress(),
              },
              {
                type: 'button',
                level: 'link',
                label: '通过考试',
                actionType: 'dialog',
                dialog: {
                  title: "提示",
                  body: {
                    type: 'form',
                    api: `get:${BASE_ROUTE_PREFIX}/appUser/passExamById?id=$id`,
                    controls: [
                      {
                        type: 'tpl',
                        tpl: '您确认设置该用户已通过考试吗？',
                      },
                    ],
                  },
                },
              },
              {
                type: 'button',
                level: 'link',
                className: 'text-danger',
                label: '删除',
                actionType: 'dialog',
                dialog: {
                  title: "提示",
                  body: {
                    type: 'form',
                    api: `get:${BASE_ROUTE_PREFIX}/appUser/deleteById?id=$id`,
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
    };
    // 注入amis数据链参数
    schema.data = {_permissionList: permissionList, _currentUser: currentUser};
    return schema;
  };

  useEffect(() => {
    (async () => {
      const schema = await genSchema();
      setSchema(schema);
    })();
  }, []);

  return <div>{schema && <AmisRenderer schema={schema}/>}</div>;
};

export default Overview;
