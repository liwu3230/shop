import {BASE_ROUTE_PREFIX} from '@/constants';
import {convertOptionsToMap} from '@/utils';
import {billStateList, codeStatusList, genderList} from '@/constants/enums';
import {ApiObject} from 'amis/lib/types';
import initAssocUser from '@/pages/Role/assocUser';

const initSchema = () => ({
  title: '发送奖励记录',
  size: 'xl',
  actions: [
    {
      type: 'action',
      actionType: 'close',
      label: '取消',
    },
  ],
  body: {
    type: 'crud',
    name: 'awardList',
    api: {
      method: 'get',
      url: `${BASE_ROUTE_PREFIX}/taskOrderBill/findByOrderId?orderId=$id`,
      adaptor: 'return {\n  list: payload\n}',
    },
    // primaryField: 'id',
    syncLocation: false,
    headerToolbar: [
      'bulkActions',
    ],
    bulkActions: [

    ],
    loadDataOnce: true,
    source:
      '${list | filter:mchBillno:match:mchBillno | filter:sendListid:match:sendListid}',
    filter: {
      title: '',
      submitText: '',
      controls: [
        {
          type: 'text',
          name: 'mchBillno',
          size: 'md',
          placeholder: '通过商户订单号搜索',
          clearable: true,
        },
        {
          type: 'text',
          name: 'sendListid',
          size: 'md',
          placeholder: '通过微信单号搜索',
          clearable: true,
        },
        {
          label: '搜索',
          type: 'submit',
        },
      ],
    },
    columns: [
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
      },
      {
        name: 'sendListid',
        label: '微信单号',
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
});

export default initSchema;
