import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_FRONT_ROUTE_PREFIX, BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {ApiObject} from 'amis/lib/types';
import {genSearchPresentList} from '@/utils';
import {flowableStatusList} from "@/constants/enums";
import {flowStatusMapping} from "@/pages/Process/Form/config";

const Overview = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'apply',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/flowable/task/myProcess`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
          requestAdaptor: (api: ApiObject) => {
            let timeArray = api.data.operateTimeRange?.split(',');
            return {
              ...api,
              data: {
                ...api.data,
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
              type: 'select',
              name: 'status',
              label: '状态：',
              options: flowableStatusList,
              placeholder: '请选择状态',
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
            name: 'procInsId',
            label: '流程编号',
          },
          {
            name: 'procDefName',
            label: '流程名称',
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
                label: '流程图',
                type: 'button',
                level: 'link',
                actionType: 'dialog',
                dialog: {
                  title: "流程图",
                  size: 'xl',
                  body: {
                    type: 'page',
                    title: '',
                    initApi: `${BASE_ROUTE_PREFIX}/flowable/task/queryProcessActivity?procInsId=$procInsId`,
                    body: {
                      type: 'bpmn-viewer',
                      height: 300,
                    }
                  },
                  closeOnEsc: true,
                  actions: []
                }
              },
              {
                label: '详情',
                type: 'button',
                level: 'link',
                actionType: 'link',
                link: `${BASE_FRONT_ROUTE_PREFIX}/process/apply/viewer?procInsId=$procInsId&procDefKey=$procDefKey`
              },
              {
                type: 'button',
                level: 'link',
                className: 'text-danger b-danger',
                label: '撤回',
                actionType: 'dialog',
                hiddenOn: 'this.isAdmin === 1',
                dialog: {
                  body: {
                    type: 'form',
                    api: {
                      url: `${BASE_ROUTE_PREFIX}/flowable/task/stopProcess`,
                      method: 'post',
                      data: {
                        instanceId: '$procInsId',
                      },
                    },
                    messages: {
                      saveSuccess: "撤回成功",
                      saveFailed: "撤回失败"
                    },
                    controls: [
                      {
                        type: 'tpl',
                        tpl: '您确认要撤回该流程吗？',
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
