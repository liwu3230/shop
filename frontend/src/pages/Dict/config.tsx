import { BASE_ROUTE_PREFIX } from '@/constants';
import { codeStatusList } from '@/constants/enums';

const initSchema = () => ({
  title: "<%= data.id ? '编辑字典' : '新增字典' %>",
  size: 'md',
  body: {
    type: 'form',
    reload: 'dict',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sys/dict/save`,
      method: 'post',
      data: {
        '&': '$$',
        id: '$id',
        data: '$data',
      },
    },
    messages: {
      saveSuccess: "",
      saveFailed: "操作失败"
    },
    controls: [
      {
        type: 'text',
        name: 'code',
        label: '字典编码',
        required: true,
        placeholder: '请输入',
      },
      {
        type: 'text',
        name: 'name',
        label: '字典名称',
        required: true,
        placeholder: '请输入',
      },
      {
        type: 'select',
        name: 'status',
        label: '字典状态',
        options: codeStatusList,
        value: 0,
        required: true,
        placeholder: '请选择',
      },
      {
        type: 'number',
        name: 'sort',
        label: '排序',
        value: 0,
        required: true,
        placeholder: '请输入',
      },
      {
        type: 'text',
        name: 'remark',
        label: '备注',
        placeholder: '请输入',
      },
      {
        type: 'combo',
        name: 'dataList',
        label: '字典列表',
        required: true,
        multiple: true,
        minLength: 1,
        controls: [
          {
            name: 'name',
            label: '名称',
            type: 'text',
            required: true,
            value: '',
          },
          {
            name: 'value',
            label: '值',
            type: 'text',
            required: true,
            value: '',
          },
          {
            name: 'sort',
            label: '排序',
            type: 'number',
            value: 0,
            required: true,
          },
        ],
      },
    ],
  },
});

export default initSchema;
