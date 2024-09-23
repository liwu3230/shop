import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import initConfig from './config';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import {ApiObject} from "amis/lib/types";
import {orderStatusList} from "@/constants/enums";


const initSchema: SchemaObject = {
  type: 'page',
  title: '',
  body: {
    type: 'crud',
    name: 'auditTaskOrder',
    ...COMMON_CRUD_CONFIG,
    api: {
      method: 'post',
      url: `${BASE_ROUTE_PREFIX}/taskOrder/list`,
      adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
      requestAdaptor: (api: ApiObject) => {
        let sendTimeArray = api.data.sendTimeRange?.split(',');
        let acceptTimeArray = api.data.acceptTimeTimeRange?.split(',');
        return {
          ...api,
          data: {
            ...api.data,
            startSendTime: sendTimeArray ? sendTimeArray[0] : '',
            endSendTime: sendTimeArray ? sendTimeArray[1] : '',
            startAcceptTime: acceptTimeArray ? acceptTimeArray[0] : '',
            endAcceptTime: acceptTimeArray ? acceptTimeArray[1] : '',
            projectIds: api.data?.projectIds ? api.data?.projectIds.split(',') : [],
            taskIds: api.data?.taskIds ? api.data?.taskIds.split(',') : [],
            storeIds: api.data?.storeIds ? api.data?.storeIds.split(',') : [],
          },
        };
      },
    },
    interval: 30000, //查询接口轮询
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
        {
          type: 'text',
          name: 'orderNo',
          label: '订单号：',
          placeholder: '请输入订单号',
          clearable: true,
        },
        {
          type: 'select',
          name: 'isExpired',
          label: '是否超时：',
          options: [
            {
              value: 1,
              label: '是',
            },
            {
              value: 0,
              label: '否',
            },
          ],
          clearable: true,
          placeholder: '请选择',
        },
        {
          type: 'input-datetime-range',
          name: 'sendTimeRange',
          label: '派发时间：',
          format: 'YYYY-MM-DD HH:mm:ss',
        },
        {
          type: 'input-datetime-range',
          name: 'acceptTimeTimeRange',
          label: '承接时间：',
          format: 'YYYY-MM-DD HH:mm:ss',
        },
        {
          type: "hidden",
          name: 'status',
          label: '状态：',
          value: 3,
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
      'bulkActions',
      {
        label: '导出',
        type: 'button',
        icon: 'fa fa-download',
        actionType: "download",
        api: {
          method: 'post',
          url: `${BASE_ROUTE_PREFIX}/taskOrder/export`,
          adaptor: 'return {\n    ...payload,}',
          requestAdaptor: (api: ApiObject) => {
            let sendTimeArray = api.data.sendTimeRange?.split(',');
            let acceptTimeArray = api.data.acceptTimeTimeRange?.split(',');
            return {
              ...api,
              data: {
                ...api.data,
                startSendTime: sendTimeArray ? sendTimeArray[0] : '',
                endSendTime: sendTimeArray ? sendTimeArray[1] : '',
                startAcceptTime: acceptTimeArray ? acceptTimeArray[0] : '',
                endAcceptTime: acceptTimeArray ? acceptTimeArray[1] : '',
                projectIds: api.data?.projectIds ? api.data?.projectIds.split(',') : [],
                taskIds: api.data?.taskIds ? api.data?.taskIds.split(',') : [],
                storeIds: api.data?.storeIds ? api.data?.storeIds.split(',') : [],
              },
            };
          },
        },
      },
    ],
    keepItemSelectionOnPageChange: false,
    bulkActions: [
      {
        label: '批量审批',
        level: 'primary',
        type: 'button',
        actionType: 'dialog',
        dialog: initConfig(true),
      },
    ],
    source: '${list}',
    columns: [
      {
        name: 'orderNo',
        label: '订单号',
      },
      {
        name: 'projectName',
        label: '项目名称',
      },
      {
        name: 'taskName',
        label: '任务名称',
      },
      {
        name: 'storeName',
        label: '网点名称',
      },
      {
        name: 'price',
        label: '金额',
        prefix: "￥",
        type: "number",
        classNameExpr: "text-danger font-bold"
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
        name: 'status',
        label: '订单状态',
        type: 'mapping',
        map: convertOptionsToMap(orderStatusList),
        // classNameExpr: "text-danger"
      },
      {
        name: 'taskExpired',
        label: '是否超时',
        type: 'mapping',
        map: {
          true: "<span style='background:#ffa940' class='label'>是</span>",
          false: "<span style='background:#87d068' class='label'>否</span>",
        }
      },
      {
        name: 'taskEndTime',
        label: '任务结束时间',
      },
      {
        name: 'sendTime',
        label: '派发时间',
      },
      {
        name: 'acceptTime',
        label: '承接时间',
      },
      {
        name: 'doneTime',
        label: '完成时间',
      },
      {
        type: 'operation',
        label: '操作',
        buttons: [
          {
            label: '审批',
            level: 'link',
            type: 'button',
            actionType: 'dialog',
            dialog: initConfig(false),
          },
        ],
      },
    ],
  },
};

export default initSchema;
