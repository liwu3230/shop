import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import '@/components/AmisOpsTag/index';
import {BASE_ROUTE_PREFIX} from '@/constants';
import initConfig from './config';

const Overview = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'dept',
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/sys/dept/listTree`,
          adaptor: 'return {\n  list: payload\n}',
        },
        data: {
          $: '&&',
        },
        filter: {
          title: '',
          submitText: '',
          controls: [
            {
              type: 'text',
              name: 'name',
              placeholder: '请输入部门名称搜索',
              size: 'lg',
              clearable: true,
              addOn: {
                label: '搜索',
                type: 'submit',
              },
            },
            {
              label: '新增',
              type: 'button',
              actionType: 'dialog',
              level: 'primary',
              dialog: initConfig(),
            },
          ],
        },
        footable: {
          expand: 'first' //first all
        },
        // perPageField: 'limit',
        // pageField: 'page',
        source: '${list}',
        columns: [
          {
            name: 'name',
            label: '部门名称',
          },
          {
            name: 'sort',
            label: '排序',
          },
          {
            type: 'operation',
            label: '操作',
            buttons: [
              {
                label: '编辑',
                type: 'button',
                level: 'link',
                actionType: 'dialog',
                dialog: initConfig(),
              },
              {
                label: '删除',
                type: 'button',
                level: 'link',
                className: 'text-danger',
                actionType: 'dialog',
                hiddenOn: 'this.isInit',
                dialog: {
                  body: {
                    type: 'form',
                    api: `get:${BASE_ROUTE_PREFIX}/sys/dept/deleteById?id=$id`,
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
