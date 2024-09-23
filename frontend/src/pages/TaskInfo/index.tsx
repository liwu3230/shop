import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {genSearchPresentList} from '@/utils';
import {useModel} from '@umijs/max';
import initConfig from './config';
import {ApiObject} from "amis/lib/types";
import initBind from "./bind";

const Overview = () => {
  const {permissionList} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'taskInfo',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/taskInfo/list`,
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
              name: 'name',
              label: '名称：',
              placeholder: '请输入名称',
              clearable: true,
            },
            {
              type: 'select',
              name: 'pid',
              label: '项目：',
              searchable: true,
              required: false,
              clearable: true,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/project/findAll?authEnabled=true`,
                method: 'get',
              },
            },
            {
              type: 'select',
              name: 'tagId',
              label: '任务标签：',
              searchable: true,
              clearable: true,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/taskTag/findAll`,
                method: 'get',
              },
            },
            {
              type: 'input-datetime-range',
              name: 'createTimeRange',
              label: '创建时间：',
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
        keepItemSelectionOnPageChange: false,
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
        headerToolbar: [
          {
            type: 'tpl',
            tpl: ' 总共：${total} 项 ',
            align: 'right',
          },
          'pagination',
          'columns-toggler',
          {
            label: '新增',
            type: 'button',
            level: 'primary',
            // actionType: 'link',
            // link: `${BASE_ROUTE_PREFIX}/taskInfo/config/title=新增任务`,
            actionType: 'dialog',
            dialog: initConfig(),
          },
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
          //       reload: 'taskInfo',
          //       api: {
          //         url: `${BASE_ROUTE_PREFIX}/taskInfo/import`,
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
          //           // receiver: `${BASE_ROUTE_PREFIX}/taskInfo/import`,
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
            api: {
              method: 'post',
              url: `${BASE_ROUTE_PREFIX}/taskInfo/export`,
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
                reload: 'taskInfo',
                api: {
                  url: `${BASE_ROUTE_PREFIX}/taskInfo/setTag`,
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
                      url: `${BASE_ROUTE_PREFIX}/taskTag/findAll`,
                      method: 'get',
                    },
                  },
                ]
              }
            },
          }
        ],
        source: '${list}',
        columns: [
          {
            name: 'projectName',
            label: '项目名称',
          },
          {
            name: 'name',
            label: '任务名称',
          },
          // {
          //     type: "image",
          //     name: "image",
          //     label: "封面",
          //     thumbMode: "cover",
          //     enlargeAble: true,
          //     height: "40px",
          //     width: "40px",
          // },
          {
            type: "each",
            name: "tagNames",
            label: "标签",
            placeholder: "-",
            // width: "300px",
            className: 'word-break',
            items: {
              type: "tpl",
              tpl: "<span class='label label-info m-r-sm text-xs'>${item}</span>"
            }
          },
          {
            name: 'price',
            label: '任务金额',
            prefix: "￥",
            type: "number",
            classNameExpr: "text-danger font-bold"
          },
          {
            name: 'acceptDeadlineTime',
            label: '领取截止时间',
          },
          {
            name: 'taskBeginTime',
            label: '任务开始时间',
          },
          {
            name: 'taskEndTime',
            label: '任务结束时间',
          },
          // {
          //   name: 'sort',
          //   label: '排序',
          // },
          {
            name: 'createTime',
            label: '创建时间',
          },
          {
            type: 'operation',
            label: '操作',
            buttons: [
              {
                label: '编辑',
                level: 'link',
                type: 'button',
                // actionType: 'link',
                // link: `${BASE_ROUTE_PREFIX}/taskInfo/config/title=编辑任务&id=$id`,
                actionType: 'dialog',
                dialog: initConfig(),
              },
              {
                label: '任务管理',
                type: 'button',
                actionType: 'dialog',
                level: 'link',
                dialog: initBind(),
              },
              {
                type: 'button',
                level: 'link',
                label: '派发订单',
                actionType: 'ajax',
                confirmText: '确定要派发订单?',
                api: {
                  url: `${BASE_ROUTE_PREFIX}/taskInfo/genOrder`,
                  method: 'post',
                  data: {
                    taskId: '$taskId',
                  },
                  requestAdaptor: (api: ApiObject) => {
                    return {
                      ...api,
                      data: {
                        ...api.data,
                      },
                    };
                  },
                  messages: {
                    success: "派发订单成功！",
                    failed: ""
                  }
                },
              },
              {
                type: 'button',
                level: 'link',
                className: 'text-danger',
                label: '删除',
                actionType: 'dialog',
                dialog: {
                  body: {
                    type: 'form',
                    api: `get:${BASE_ROUTE_PREFIX}/taskInfo/deleteById?id=$id`,
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
    schema.data = {_permissionList: permissionList};
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
