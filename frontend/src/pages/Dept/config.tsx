import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
  title: "<%= data.id ? '编辑部门' : '新增部门' %>",
  body: {
    type: 'form',
    reload: 'dept',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sys/dept/save`,
      method: 'post',
      data: {
        parentId: '${parentId|default:0}',
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
        label: '部门名称',
        required: true,
        placeholder: '请输入',
      },
      {
        type: 'tree-select',
        name: 'parentId',
        label: '上级部门',
        searchable: true,
        labelField: 'name',
        valueField: 'id',
        showOutline: true,
        showIcon: false,
        source: {
          url: `${BASE_ROUTE_PREFIX}/sys/dept/listTree`,
          method: 'post',
          data: {},
          // trackExpression: '${type}',
        },
      },
      {
        type: 'number',
        name: 'sort',
        value: 1,
        label: '排序',
        required: true,
        placeholder: '请输入',
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
