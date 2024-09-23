import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import {useModel} from '@umijs/max';
import {ApiObject} from "amis/lib/types";
import {msgStatusList, msgTypeList} from "@/constants/enums";

const Overview = () => {
  const {permissionList} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'msgRecord',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/msgRecord/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
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
              name: 'uid',
              label: '用户ID：',
              placeholder: '请输入用户ID',
              clearable: true,
            },
            {
              type: 'text',
              name: 'content',
              label: '消息内容：',
              placeholder: '请输入消息内容',
              clearable: true,
            },
            {
              type: 'select',
              name: 'msgType',
              label: '消息类型：',
              options: msgTypeList,
              placeholder: '请选择状态',
            },
            {
              type: 'select',
              name: 'status',
              label: '消息状态：',
              options: msgStatusList,
              placeholder: '请选择状态',
            },
            {
              type: 'input-datetime-range',
              name: 'createTimeRange',
              label: '发送时间：',
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
            name: 'uid',
            label: '用户ID',
          },
          // {
          //   name: 'openId',
          //   label: '用户openId',
          // },
          {
            name: 'msgType',
            label: '类型',
            type: 'mapping',
            map: convertOptionsToMap(msgTypeList)
          },
          {
            name: 'phone',
            label: '手机号码',
          },
          {
            name: 'content',
            label: '内容',
            width: "40%",
          },
          {
            name: 'status',
            label: '状态',
            type: 'mapping',
            map: convertOptionsToMap(msgStatusList),
          },
          {
            name: 'originalResult',
            label: '状态报告',
            width: "220px",
          },
          {
            name: 'isRead',
            label: '已读',
            type: 'mapping',
            map: {
              1: "是",
              0: "否"
            }
          },
          {
            name: 'postTime',
            label: '发送时间',
          },
          // {
          //   type: 'operation',
          //   label: '操作',
          //   buttons: [
          //     {
          //       label: '编辑',
          //       level: 'link',
          //       type: 'button',
          //       actionType: 'dialog',
          //       dialog: initConfig(),
          //     },
          //     {
          //       type: 'button',
          //       level: 'link',
          //       className: 'text-danger',
          //       label: '删除',
          //       actionType: 'dialog',
          //       dialog: {
          //         body: {
          //           type: 'form',
          //           api: `get:${BASE_ROUTE_PREFIX}/msgRecord/deleteById?id=$id`,
          //           controls: [
          //             {
          //               type: 'tpl',
          //               tpl: '您确认要删除吗？',
          //             },
          //           ],
          //         },
          //       },
          //     },
          //   ],
          // },
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
