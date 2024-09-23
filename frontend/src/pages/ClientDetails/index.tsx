import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import initConfig from './config';
import {genSearchPresentList} from '@/utils';
import {useModel} from '@umijs/max';
import {ApiObject} from "amis/lib/types";

const Overview = () => {
  const {permissionList} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'clientDetails',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/clientDetails/list`,
          adaptor: (payload: PlainObject) => {
            if (payload.list?.length > 0) {
              payload.list.map((data: PlainObject) => {
                if (data.resourceIds) {
                  data.resourceIds = data.resourceIds.split(',').map((item: PlainObject) => ({name: item}));
                }
              });
            }
            console.log(payload)
            return {
              ...payload,
              total: payload.totalCount
            }
          },
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
              label: '应用名称：',
              placeholder: '请输入名称',
              clearable: true,
            },
            {
              type: 'text',
              name: 'clientId',
              label: 'appId：',
              placeholder: '请输入appId',
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
        ],
        source: '${list}',
        columns: [
          {
            name: 'clientId',
            label: 'appId',
            width: "220px",
          },
          {
            name: 'name',
            label: '应用名称',
          },
          {
            // name: 'accessTokenValidity',
            label: 'token有效期',
            type: "tpl",
            tpl: "${accessTokenValidity}秒",
          },
          {
            type: "each",
            name: "resourceIds",
            label: "资源权限",
            placeholder: "-",
            className: 'word-break',
            items: {
              type: "tpl",
              tpl: "<span>${item.name}</span><br/>"
            }
          },
          {
            type: 'operation',
            label: '操作',
            width: "260px",
            buttons: [
              {
                label: '查看token',
                level: 'link',
                type: 'button',
                onEvent: {
                  click: {
                    actions: [
                      {
                        actionType: 'ajax',
                        args: {
                          api: `get:${BASE_ROUTE_PREFIX}/clientDetails/getClientTokenInfo?clientId=$clientId`,
                        }
                      },
                      {
                        actionType: 'dialog',
                        dialog: {
                          title: '',
                          showCloseButton: false,
                          body: [
                            {
                              type: "static",
                              label: "access_token：",
                              value: "${event.data.result}",
                              copyable: {
                                content: "${event.data.result}"
                              }
                            },
                            {
                              type: "static",
                              label: "expires_in：",
                              value: "${accessTokenValidity}秒",
                            },
                          ],
                          actions: [
                            {
                              type: "button",
                              actionType: "confirm",
                              label: "确定",
                              primary: true,
                            }
                          ]
                        }
                      },
                    ]
                  }
                }
              },
              {
                label: '查看密钥',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: {
                  title: '应用密钥',
                  showCloseButton: false,
                  body: {
                    type: "form",
                    mode: "normal",
                    controls: [
                      {
                        type: "static",
                        label: "appId：",
                        value: '${clientId}',
                        copyable: {
                          content: '${clientId}'
                        }
                      },
                      {
                        type: "static",
                        label: "appSecret：",
                        value: '${clientSecret}',
                        copyable: {
                          content: '$clientSecret'
                        }
                      },
                    ]
                  },
                  actions: [
                    {
                      type: "button",
                      actionType: "confirm",
                      label: "确定",
                      primary: true,
                    }
                  ]
                }
              },
              {
                label: '编辑',
                level: 'link',
                type: 'button',
                actionType: 'dialog',
                dialog: initConfig(),
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
                    api: `get:${BASE_ROUTE_PREFIX}/clientDetails/deleteById?clientId=$clientId`,
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
