import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import {useModel} from '@umijs/max';
import {ApiObject} from "amis/lib/types";
import {billStateList} from "@/constants/enums";

const Overview = () => {
  const {permissionList} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: 'crud',
        name: 'taskOrderBill',
        ...COMMON_CRUD_CONFIG,
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/taskOrderBill/list`,
          adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
          requestAdaptor: (api: ApiObject) => {
            let timeArray = api.data.createTimeRange?.split(',');
            return {
              ...api,
              data: {
                ...api.data,
                startTime: timeArray ? timeArray[0] : '',
                endTime: timeArray ? timeArray[1] : '',
                projectIds: api.data?.projectIds ? api.data?.projectIds.split(',') : [],
                taskIds: api.data?.taskIds ? api.data?.taskIds.split(',') : [],
                storeIds: api.data?.storeIds ? api.data?.storeIds.split(',') : [],
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
              name: 'projectIds',
              label: '所属项目：',
              searchable: true,
              multiple: true,
              clearable: true,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/project/findAll?authEnabled=true`,
                method: 'get',
              },
            },
            {
              type: 'select',
              name: 'taskIds',
              label: '所属任务：',
              searchable: true,
              multiple: true,
              clearable: true,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/taskInfo/findAll?authEnabled=true`,
                method: 'get',
              },
            },
            {
              type: 'select',
              name: 'storeIds',
              label: '所属网点：',
              searchable: true,
              clearable: true,
              multiple: true,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/store/findAll`,
                method: 'get',
              },
            },
            {
              type: 'text',
              name: 'appUserNickName',
              label: '用户昵称：',
              placeholder: '请输入用户昵称',
              clearable: true,
            },
            {
              type: 'text',
              name: 'appUserRealName',
              label: '用户姓名：',
              placeholder: '请输入用户姓名',
              clearable: true,
            },
            // {
            //   type: 'text',
            //   name: 'appUserOpenId',
            //   label: 'OpenId：',
            //   placeholder: '请输入用户OpenId',
            //   clearable: true,
            // },
            {
              type: 'text',
              name: 'mchBillno',
              label: '商户订单号：',
              placeholder: '请输入商户订单号',
              clearable: true,
            },
            {
              type: 'text',
              name: 'sendListid',
              label: '微信单号：',
              placeholder: '请输入微信单号',
              clearable: true,
            },
            {
              type: 'select',
              name: 'state',
              label: '付款状态：',
              options: billStateList,
              placeholder: '请选择付款状态',
              clearable: true,
            },
            {
              type: 'text',
              name: 'resultCode',
              label: '业务结果：',
              placeholder: '请输入业务结果',
              clearable: true,
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
            label: '导出',
            type: 'button',
            icon: 'fa fa-download',
            actionType: "download",
            api: {
              method: 'post',
              url: `${BASE_ROUTE_PREFIX}/taskOrderBill/export`,
              adaptor: 'return {\n    ...payload,}',
              requestAdaptor: (api: ApiObject) => {
                let timeArray = api.data.createTimeRange?.split(',');
                return {
                  ...api,
                  data: {
                    ...api.data,
                    startTime: timeArray ? timeArray[0] : '',
                    endTime: timeArray ? timeArray[1] : '',
                    projectIds: api.data?.projectIds ? api.data?.projectIds.split(',') : [],
                    taskIds: api.data?.taskIds ? api.data?.taskIds.split(',') : [],
                    storeIds: api.data?.storeIds ? api.data?.storeIds.split(',') : [],
                  },
                };
              },
            },
          },
        ],
        source: '${list}',
        columns: [
          {
            name: 'projectName',
            label: '项目名称',
            width: "180px",
          },
          {
            name: 'taskName',
            label: '任务名称',
            width: "180px",
          },
          {
            name: 'storeName',
            label: '网点名称',
          },
          {
            name: 'appUserNickName',
            label: '用户昵称',
          },
          {
            name: 'appUserRealName',
            label: '用户姓名',
          },
          {
            name: 'mchBillno',
            label: '商户订单号',
            width: "200px",
          },
          {
            name: 'sendListid',
            label: '微信单号',
            width: "200px",
          },
          {
            name: 'redValueYuan',
            label: '金额(元)',
            prefix: "￥",
            type: "number",
            classNameExpr: "text-danger font-bold"
          },
          {
            name: 'resultCode',
            label: '业务结果',
          },
          {
            name: 'errCodeDes',
            label: '错误描述',
          },
          {
            name: 'state',
            label: '付款状态',
            type: 'mapping',
            map: convertOptionsToMap(billStateList),
          },
          {
            name: 'createTime',
            label: '发送时间',
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
