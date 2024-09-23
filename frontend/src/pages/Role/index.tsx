import React, {useState, useEffect} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {codeStatusList} from '@/constants/enums';
import {convertOptionsToMap} from '@/utils';
import initConfig from './config';
import initGrantMenu from './grantMenu';
import initGrantUser from './grantUser';

const Overview = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'role',
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/sys/role/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
        },
        ...COMMON_CRUD_CONFIG,
        filter: {
          title: '',
          submitText: '',
          controls: [
            {
              type: 'text',
              name: 'name',
              placeholder: '请输入角色名称搜索',
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
        source: '${list}',
        columns: [
          {
            name: 'name',
            label: '角色名称',
          },
          {
            name: 'status',
            label: '状态',
            type: 'mapping',
            map: convertOptionsToMap(codeStatusList),
          },
          {
            name: 'creator',
            label: '创建人',
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
                label: '授权菜单',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: initGrantMenu(),
                hiddenOn: 'this.type === 2',
              },
              {
                label: '授权用户',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: initGrantUser(),
                hiddenOn: 'this.type === 1',
              },
              {
                label: '编辑',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: initConfig(),
                // icon: 'fa fa-pencil-square-o',
                // className: 'text-primary text-md',
                hiddenOn: 'this.type !== 0',
              },
              {
                type: 'button',
                level: 'link',
                label: '删除',
                className: 'text-danger',
                actionType: 'dialog',
                // icon: 'fa fa-trash',
                // classNameName: 'text-red-400 text-md',
                hiddenOn: 'this.type !== 0',
                dialog: {
                  body: {
                    type: 'form',
                    api: `get:${BASE_ROUTE_PREFIX}/sys/role/deleteById?id=$id`,
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
