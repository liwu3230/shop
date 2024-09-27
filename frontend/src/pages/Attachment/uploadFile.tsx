import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
  title: "上传文件",
  size: 'md',
  actions: [
    {
      type: 'action',
      label: '关闭',
      actionType: 'close',
    },
    {
      type: 'action',
      actionType: 'confirm',
      label: '确认',
      level: 'primary',
      reload: 'attachmentList',
    },
  ],
  showCloseButton: false,
  body: {
    type: 'form',
    reload: 'attachmentList',
    messages: {
      saveSuccess: "",
      saveFailed: "操作失败"
    },
    controls: [
      {
        type: 'tree-select',
        name: 'pid',
        label: '上传至分组：',
        searchable: true,
        labelField: 'name',
        valueField: 'id',
        showOutline: true,
        // showIcon: false,
        initiallyOpen: false,
        required: true,
        selectFirst: true,
        value: 0,
        source: {
          url: `${BASE_ROUTE_PREFIX}/fileCategory/tree`,
          method: 'get',
        },
      },
      {
        type: 'input-image',
        name: 'files',
        label: '上传图片',
        placeholder: '请输入',
        required: false,
        multiple: true,
        autoUpload: false,
        hideUploadButton: true,
        receiver: `${BASE_ROUTE_PREFIX}/file/upload?pid=$pid`,
      },
    ],
  },
});

export default initSchema;
