import { BASE_ROUTE_PREFIX } from '@/constants';
import { codeStatusList } from '@/constants/enums';

const initSchema = () => ({
  title: "<%= data.id ? '编辑角色' : '新增角色' %>",
  body: {
    type: 'form',
    reload: 'role',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sys/role/save`,
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
        name: 'name',
        label: '角色名',
        required: true,
        placeholder: '请输入',
      },
      {
        type: 'select',
        name: 'status',
        label: '状态',
        options: codeStatusList,
        value: 0,
        required: true,
        placeholder: '请选择',
      },
      {
        type: 'text',
        name: 'remark',
        label: '备注',
        placeholder: '请输入',
      },
    ],
  },
});

export default initSchema;
