import {BASE_ROUTE_PREFIX} from '@/constants';
import {orderStatusList} from "@/constants/enums";
import {ApiObject} from 'amis/lib/types';

const initSchema = (isBatch: boolean) => ({
  title: isBatch ? '批量编辑' : '单条编辑',
  size: 'md',
  body: {
    type: 'form',
    reload: 'taskOrder',
    canAccessSuperData: !isBatch,
    api: {
      url: `${BASE_ROUTE_PREFIX}/taskOrder/updateOrderStatus`,
      method: 'post',
      data: {
        '&': '$$',
        ids: '$ids',
        id: '$id',
        data: '$data',
      },
      requestAdaptor: (api: ApiObject) => {
        return {
          ...api,
          data: {
            ...api.data,
            ids: api.data?.ids.toString().split(','),
          },
        };
      },
    },
    messages: {
      saveSuccess: "",
      saveFailed: "操作失败"
    },
    controls: [
      {
        type: 'select',
        name: 'status',
        label: '订单状态：',
        options: orderStatusList,
        placeholder: '请选择状态',
        clearable: true,
        required: true,
      },

    ],
  },
});

export default initSchema;
