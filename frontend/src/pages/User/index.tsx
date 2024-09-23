import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import initAssocRole from './assocRole';
import initConfig from './config';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import {codeStatusList, genderList} from '@/constants/enums';
import {useModel} from '@umijs/max';

const Overview = () => {
  const {permissionList} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'user',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/sys/user/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
        },
        filter: {
          title: '',
          submitText: '',
          mode: 'horizontal',
          controls: genSearchPresentList(3, [
            {
              type: 'text',
              name: 'userName',
              label: '用户账号：',
              placeholder: '通过用户账号搜索',
              clearable: true,
            },
            {
              type: 'text',
              name: 'nickName',
              label: '姓名：',
              placeholder: '通过姓名搜索',
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
            {
              type: 'nested-select',
              name: 'deptId',
              label: '部门：',
              searchable: true,
              clearable: true,
              labelField: 'name',
              valueField: 'id',
              size: 'full',
              source: {
                url: `${BASE_ROUTE_PREFIX}/sys/dept/listTree`,
                method: 'post',
                data: {},
              },
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
          {
            label: '新增',
            type: 'button',
            actionType: 'dialog',
            level: 'primary',
            dialog: initConfig(),
          },
          {
            label: '导入',
            type: 'button',
            icon: 'fa fa fa-upload',
            // level: 'light',
            actionType: 'dialog',
            dialog: {
              title: "导入",
              body: {
                type: 'form',
                mode: 'normal',
                reload: 'user',
                api: {
                  url: `${BASE_ROUTE_PREFIX}/sys/user/import`,
                  method: 'post',
                  // data: {
                  //   '&': '$$',
                  //   id: '$id',
                  //   data: '$data',
                  // },
                },
                messages: {
                  saveSuccess: '导入成功',
                  saveFailed: '导入失败',
                },
                controls: [
                  //隐藏项，解决单个input-file组件不触发form保存api的bug
                  {
                    type: "hidden",
                    name: "hidden",
                  },
                  {
                    type: "input-file",
                    name: "file",
                    label: "",
                    accept: ".xlsx,.xls",
                    asBlob: true,
                    drag: true,
                    // receiver: `${BASE_ROUTE_PREFIX}/sys/user/import`,
                  }
                ],
              },
            }
          },
          {
            label: '导出',
            type: 'button',
            icon: 'fa fa-download',
            actionType: "download",
            api: {
              method: 'post',
              url: `${BASE_ROUTE_PREFIX}/sys/user/export`,
              adaptor: 'return {\n    ...payload,}',
            },
          },
        ],
        source: '${list}',
        columns: [
          {
            name: 'userName',
            label: '用户账号',
          },
          {
            name: 'nickName',
            label: '姓名',
          },
          {
            name: 'gender',
            label: '性别',
            type: 'mapping',
            map: convertOptionsToMap(genderList),
          },
          {
            name: 'status',
            label: '状态',
            type: 'mapping',
            map: convertOptionsToMap(codeStatusList),
          },
          {
            name: 'phone',
            label: '手机号码',
          },
          {
            name: 'email',
            label: '邮箱',
          },
          {
            name: 'deptFullName',
            label: '所属部门',
          },
          {
            name: 'expireTime',
            label: '过期时间',
          },
          {
            type: 'operation',
            label: '操作',
            buttons: [
              {
                label: '角色',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: initAssocRole(),
                hiddenOn: 'this.isAdmin === 1',
                visibleOn: `this._permissionList?.includes('sys_assoc_role') || this._permissionList?.includes('*')`,
              },
              {
                label: '重置密码',
                level: 'link',
                type: 'button',
                // confirmText: "您确认要重置密码吗？",
                hiddenOn: 'this.isAdmin === 1',
                onEvent: {
                  click: {
                    actions: [
                      {
                        actionType: 'ajax',
                        args: {
                          api: `get:${BASE_ROUTE_PREFIX}/sys/user/resetPassword?id=$id`,
                        }
                      },
                      {
                        actionType: 'toast',
                        // expression: '${event.data.responseResult.responseStatus === 0}',
                        args: {
                          position: 'top-center',
                          closeButton: true,
                          level: 'success',
                          msg: '重置密码成功！新密码为：${event.data.result}'
                        }
                      },
                    ]
                  }
                }
              },
              {
                label: '编辑',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: initConfig(),
                hiddenOn: 'this.isAdmin === 1',
              },
              {
                type: 'button',
                level: 'link',
                className: 'text-danger',
                label: '删除',
                actionType: 'dialog',
                hiddenOn: 'this.isAdmin === 1',
                dialog: {
                  body: {
                    type: 'form',
                    api: `get:${BASE_ROUTE_PREFIX}/sys/user/deleteById?id=$id`,
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
