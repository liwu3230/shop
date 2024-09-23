import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
  title:'',
  type: 'form',
  initApi: `${BASE_ROUTE_PREFIX}/sysConfig/findSingleByKey?key=taskTip`,
  api: {
    url: `${BASE_ROUTE_PREFIX}/sysConfig/saveSingleByKey?key=taskTip`,
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
      type: 'input-rich-text',
      name: 'content',
      label: '提示内容',
      placeholder: '请输入',
      receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
      videoReceiver: `${BASE_ROUTE_PREFIX}/file/upload`,
      size: 'lg',
      options: {
        height: 500,
        convert_urls: false,
      }
    },
  ],
});

export default initSchema;
