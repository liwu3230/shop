import { BASE_ROUTE_PREFIX } from '@/constants';
import {codeStatusList, orderStatusList} from '@/constants/enums';

const initSchema = () => ({
  title: "<%= data.uuid ? '编辑' : '新增' %>",
  body: {
    type: 'form',
    reload: 'appUserOrderMenuList',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sysConfig/saveListByKey?key=appUserOrderMenu`,
      method: 'post',
      data: {
        '&': '$$',
        uuid: '$uuid',
      },
    },
    messages: {
      saveSuccess: "",
      saveFailed: "操作失败"
    },
    controls: [
      {
        type: 'text',
        name: 'title',
        label: '标题',
        placeholder: '请输入',
        clearable: true,
      },
      {
        type: 'input-image',
        name: 'img',
        label: '图片',
        placeholder: '请输入',
        required: false,
        receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
      },
      {
        type: 'select',
        name: 'status',
        label: '订单状态：',
        options: orderStatusList,
        placeholder: '请选择状态',
        multiple: true,
        clearable: true,
        required: true,
      },
      {
        type: 'text',
        name: 'url',
        label: '跳转链接',
        placeholder: '请输入',
        clearable: true,
      },
      {
        type: 'number',
        name: 'sort',
        value: 1,
        label: '排序',
        required: true,
        placeholder: '请输入',
      },
    ],
  },
});

export default initSchema;
