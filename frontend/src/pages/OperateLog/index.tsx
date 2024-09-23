import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {ApiObject} from 'amis/lib/types';
import {genSearchPresentList} from '@/utils';

const Overview = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'operateLog',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/sys/operateLog/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
          requestAdaptor: (api: ApiObject) => {
            let timeArray = api.data.operateTimeRange?.split(',');
            return {
              ...api,
              data: {
                ...api.data,
                userName: api.data?.userName?.value,
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
              name: 'opType',
              label: '操作类型：',
              placeholder: '请输入操作类型',
              clearable: true,
            },
            {
              type: 'text',
              name: 'subject',
              label: '操作对象：',
              placeholder: '请输入',
              clearable: true,
            },
            {
              type: 'text',
              name: 'subjectExt',
              label: '扩展操作对象：',
              placeholder: '请输入',
              clearable: true,
            },
            {
              type: 'text',
              name: 'content',
              label: '内容：',
              placeholder: '请输入',
              clearable: true,
            },
            {
              type: 'input-datetime-range',
              name: 'operateTimeRange',
              label: '操作时间：',
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
            name: 'opType',
            label: '操作类型',
          },
          {
            name: 'subject',
            label: '操作对象',
          },
          {
            name: 'subjectExt',
            label: '扩展操作对象',
          },
          {
            name: 'userName',
            label: '操作人',
          },
          {
            name: 'createTime',
            label: '操作时间',
          },
          {
            type: 'operation',
            actionType: 'dialog',
            label: '操作内容',
            buttons: [
              {
                label: '查看',
                level: 'enhance',
                type: 'button',
                actionType: 'dialog',
                dialog: {
                  title: '操作内容：',
                  size: 'md',
                  body: {
                    type: "tpl",
                    className: "word-break",
                    tpl: "${content}"
                  },
                  actions: [
                    {
                      type: 'action',
                      actionType: 'close',
                      label: '关闭',
                    },
                  ],
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
