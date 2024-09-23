import React, {useState, useEffect} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import '@/components/AmisOpsTag/index';
import {BASE_ROUTE_PREFIX} from '@/constants';
import {genderList, typeList} from '@/constants/enums';
import {convertOptionsToMap} from '@/utils';
import initConfig from './config';

const Overview = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'menu',
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/sys/menu/listTree`,
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
              placeholder: '请输入菜单名称搜索',
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
        // perPageField: 'limit',
        // pageField: 'page',
        source: '${list}',
        footable: {
          // expand: 'first',
          accordion: true,
        },
        columns: [
          {
            name: 'name',
            label: '菜单名称',
          },
          {
            name: 'type',
            label: '菜单类型',
            type: 'mapping',
            map: {
              0: "<span class='label label-success'>目录</span>",
              1: "<span class='label label-info'>菜单</span>",
              2: "<span class='label label-warning'>按钮</span>",
            }
          },
          {
            name: 'icon',
            label: '图标',
            type: 'tpl',
            tpl: "<span class='$icon'>&nbsp;</span>",
          },
          {
            name: 'visible',
            label: '是否可见',
            type: 'mapping',
            map: {
              1: "是",
              0: "否"
            }
          },
          {
            name: 'isBreadCrumb',
            label: '是否显示面包屑',
            type: 'mapping',
            map: {
              1: "是",
              0: "否"
            }
          },
          {
            name: 'sort',
            label: '排序',
          },
          // {
          //   name: 'remark',
          //   label: '备注',
          // },
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
                    api: `get:${BASE_ROUTE_PREFIX}/sys/menu/deleteById?id=$id`,
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
