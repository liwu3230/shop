import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_FRONT_ROUTE_PREFIX, BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {ApiObject} from 'amis/lib/types';
import {genSearchPresentList} from '@/utils';
import {flowStatusMapping} from "@/pages/Process/Form/config";

const Overview = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'toDo',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/flowable/task/todoList`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
          requestAdaptor: (api: ApiObject) => {
            let timeArray = api.data.operateTimeRange?.split(',');
            return {
              ...api,
              data: {
                ...api.data,
                applicantUserName: api.data?.applicantUserName?.value,
                processDefinitionKey: api.data?.processDefinitionKey?.value,
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
            // {
            //   type: 'select',
            //   name: 'applicantUserName',
            //   label: '申请人：',
            //   source: {
            //     url: `${BASE_ROUTE_PREFIX}/common/getAllSimple`,
            //     adaptor: `return ({options: payload.map(item => ({label: item.userName, value: item.userName }))})`,
            //   },
            //   searchable: true,
            //   joinValues: false,
            //   clearable: true,
            // },
            {
              type: 'select',
              name: 'processDefinitionKey',
              label: '流程：',
              source: {
                url: `${BASE_ROUTE_PREFIX}/flowable/instance/processDefinitions`,
                adaptor: `return ({options: payload.map(item => ({label: item.name, value: item.key }))})`,
              },
              searchable: true,
              joinValues: false,
              clearable: true,
            },
            {
              type: 'input-datetime-range',
              name: 'operateTimeRange',
              label: '时间：',
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
          'bulk-actions',
        ],
        source: '${list}',
        columns: [
          {
            name: 'taskId',
            label: '任务编号',
          },
          {
            name: 'procDefName',
            label: '流程名称',
          },
          {
            name: 'taskName',
            label: '任务节点',
          },
          {
            name: 'startUserName',
            label: '申请人',
          },
          {
            name: 'createTime',
            label: '申请时间',
          },
          {
            name: 'curProcessor',
            label: '当前处理人',
          },
          {
            name: 'curStatus',
            label: '状态',
            type: 'mapping',
            map: flowStatusMapping,
          },
          {
            type: 'operation',
            label: '操作',
            buttons: [
              {
                label: '审批',
                type: 'button',
                level: 'link',
                actionType: 'dialog',
                dialog: {
                  title: "审批",
                  size: 'md',
                  body: [
                    {
                      type: 'form',
                      reload: 'toDo',
                      className: "m-t",
                      body: [
                        {
                          type: 'textarea',
                          name: 'comment',
                          label: '审批意见：',
                          required: false,
                          clearable: true,
                          placeholder: '请输入',
                          value: ""
                        },
                      ],
                      messages: {
                        saveSuccess: "审批成功",
                        saveFailed: "审批失败"
                      },
                    }
                  ],
                  actions: [
                    {
                      type: "button",
                      label: "驳回",
                      actionType: "submit",
                      level: "danger",
                      className: "m-r-xs",
                      api: {
                        url: `${BASE_ROUTE_PREFIX}/flowable/task/reject`,
                        method: 'post',
                        data: {
                          comment: '$comment',
                          taskId: '$taskId',
                          instanceId: '$procInsId',
                        },
                      },
                    },
                    {
                      type: "button",
                      label: "同意",
                      actionType: "submit",
                      level: "primary",
                      className: "m-r-sm",
                      api: {
                        url: `${BASE_ROUTE_PREFIX}/flowable/task/complete`,
                        method: 'post',
                        data: {
                          comment: '$comment',
                          taskId: '$taskId',
                          instanceId: '$procInsId',
                        },
                      },
                    }
                  ]
                },
              },
              // {
              //   label: '退回',
              //   type: 'button',
              //   level: 'danger',
              //   className: 'ant-cmdb-btn-sm',
              //   actionType: 'dialog',
              //   dialog: {
              //     title: "退回流程",
              //     size: 'md',
              //     body: [
              //       {
              //         type: 'form',
              //         reload: 'toDo',
              //         className: "m-t",
              //         body: [
              //           {
              //             type: "list-select",
              //             label: "退回节点：",
              //             name: "targetKey",
              //             source: {
              //               url: `${BASE_ROUTE_PREFIX}/flowable/task/returnList`,
              //               method: 'post',
              //               data: {
              //                 taskId: '$taskId',
              //                 instanceId: '$procInsId',
              //               },
              //               adaptor: `return ({options: payload.map(item => ({label: item.name, value: item.id }))})`,
              //             },
              //           },
              //           {
              //             type: 'textarea',
              //             name: 'comment',
              //             label: '退回意见：',
              //             required: false,
              //             clearable: true,
              //             placeholder: '请输入',
              //             value: ""
              //           },
              //         ],
              //         messages: {
              //           saveSuccess: "退回成功",
              //           saveFailed: "退回失败"
              //         },
              //       },
              //     ],
              //     actions: [
              //       {
              //         type: 'action',
              //         actionType: 'close',
              //         label: '取消',
              //       },
              //       {
              //         type: "button",
              //         label: "退回",
              //         actionType: "submit",
              //         level: "danger",
              //         className: "m-r-sm",
              //         api: {
              //           url: `${BASE_ROUTE_PREFIX}/flowable/task/return`,
              //           method: 'post',
              //           data: {
              //             comment: '$comment',
              //             taskId: '$taskId',
              //             instanceId: '$procInsId',
              //             targetKey: '$targetKey',
              //           },
              //         },
              //       },
              //     ]
              //   },
              // },
              // {
              //   label: '流程图',
              //   type: 'button',
              //   level: 'link',
              //   actionType: 'dialog',
              //   dialog: {
              //     title: "流程图",
              //     size: 'xl',
              //     body: {
              //       type: 'page',
              //       title: '',
              //       initApi: `${BASE_ROUTE_PREFIX}/flowable/task/queryProcessActivity?procInsId=$procInsId`,
              //       body: {
              //         type: 'bpmn-viewer',
              //         height: 300,
              //       }
              //     },
              //     closeOnEsc: true,
              //     actions: []
              //   }
              // },
              {
                label: '详情',
                type: 'button',
                level: 'link',
                actionType: 'link',
                link: `${BASE_FRONT_ROUTE_PREFIX}/process/toDo/viewer?procInsId=$procInsId&procDefKey=$procDefKey`
              },
            ],
          },
        ],
      },
    };
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
