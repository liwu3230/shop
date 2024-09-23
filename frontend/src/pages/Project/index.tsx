import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import initConfig from './config';
import {convertToOptions, genSearchPresentList} from '@/utils';
import {useModel} from '@umijs/max';
import {ApiObject} from "amis/lib/types";

export let userList = [] as OptionsItem[];

const Overview = () => {
  const {permissionList} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      initApi: {
        url: `${BASE_ROUTE_PREFIX}/common/getAllSimple`,
        method: 'get',
        adaptor: (payload: PlainObject) => {
          userList = convertToOptions(payload, 'userName', [
            'nickName',
            'userName',
          ]);
          return {userList};
        },
      },
      body: {
        type: 'crud',
        name: 'project',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/project/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
          requestAdaptor: (api: ApiObject) => {
            let timeArray = api.data.createTimeRange?.split(',');
            return {
              ...api,
              data: {
                ...api.data,
                admins: api.data?.admins?.value,
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
              type: 'text',
              name: 'alias',
              label: '别名：',
              placeholder: '请输入别名',
              clearable: true,
            },
            {
              type: 'select',
              name: 'admins',
              label: '项目管理员：',
              source: {
                url: `${BASE_ROUTE_PREFIX}/common/getAllSimple`,
                adaptor: `return ({options: payload.map(item => ({label: item.nickName + '(' + item.userName + ')', value: item.userName }))})`,
              },
              searchable: true,
              clearable: true,
              joinValues: false,
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
          //       reload: 'project',
          //       api: {
          //         url: `${BASE_ROUTE_PREFIX}/project/import`,
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
          //           // receiver: `${BASE_ROUTE_PREFIX}/project/import`,
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
              url: `${BASE_ROUTE_PREFIX}/project/export`,
              adaptor: 'return {\n    ...payload,}',
              requestAdaptor: (api: ApiObject) => {
                let timeArray = api.data.createTimeRange?.split(',');
                return {
                  ...api,
                  data: {
                    ...api.data,
                    admins: api.data?.admins?.value,
                    startTime: timeArray ? timeArray[0] : '',
                    endTime: timeArray ? timeArray[1] : '',
                  },
                };
              },
            },
          },
        ],
        source: '${list}',
        columns: [
          {
            name: 'name',
            label: '名称',
          },
          {
            name: 'alias',
            label: '别名',
          },
          {
            name: 'adminNicks',
            label: '管理员',
          },
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
                    api: `get:${BASE_ROUTE_PREFIX}/project/deleteById?id=$id`,
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
