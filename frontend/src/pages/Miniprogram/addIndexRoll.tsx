import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
  title:'',
  type: 'form',
  initApi: `${BASE_ROUTE_PREFIX}/sysConfig/findSingleByKey?key=indexRoll`,
  api: {
    url: `${BASE_ROUTE_PREFIX}/sysConfig/saveSingleByKey?key=indexRoll`,
    method: 'post',
    data: {
      '&': '$$',
    },
  },
  messages: {
    saveSuccess: "",
    saveFailed: "操作失败"
  },
  controls: [
    {
      type: 'text',
      name: 'info',
      label: '通知内容',
      placeholder: '请输入',
      clearable: true,
    },
    {
      type: 'text',
      name: 'url',
      label: '跳转链接',
      placeholder: '请输入',
      clearable: true,
    },
  ],
});

export default initSchema;
