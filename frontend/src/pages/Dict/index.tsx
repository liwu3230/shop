import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {codeStatusList} from '@/constants/enums';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import initConfig from './config';

const Overview = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'dict',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/sys/dict/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
        },
        filter: {
          title: '',
          submitText: '',
          mode: 'horizontal',
          controls: genSearchPresentList(3, [
            {
              type: 'text',
              name: 'code',
              label: '字典编码：',
              placeholder: '支持模糊搜索',
              clearable: true,
            },
            {
              type: 'text',
              name: 'name',
              label: '字典名称：',
              placeholder: '支持模糊搜索',
              clearable: true,
            },
            {
              type: 'select',
              name: 'status',
              label: '状态：',
              options: codeStatusList,
              placeholder: '请选择状态',
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
        headerToolbar: [
          'columns-toggler',
          'bulk-actions',
          {
            label: '新增',
            type: 'button',
            actionType: 'dialog',
            level: 'primary',
            dialog: initConfig(),
          },
        ],
        source: '${list}',
        columns: [
          {
            name: 'code',
            label: '字典编码',
          },
          {
            name: 'name',
            label: '字典名称',
          },
          {
            name: 'status',
            label: '字典状态',
            type: 'mapping',
            map: convertOptionsToMap(codeStatusList),
          },
          {
            name: 'sort',
            label: '排序',
          },
          {
            name: 'remark',
            label: '备注',
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
                type: 'button',
                label: '删除',
                level: 'link',
                className: 'text-danger',
                actionType: 'dialog',
                dialog: {
                  body: {
                    type: 'form',
                    api: `get:${BASE_ROUTE_PREFIX}/sys/dict/deleteById?id=$id`,
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
