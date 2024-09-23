import {BASE_ROUTE_PREFIX} from '@/constants';
import {openTypeList, typeList} from '@/constants/enums';

function disabledTree(tree) {
  return tree.map((ele) => ({
    ...ele,
    children: ele.children.filter((item) => item.type !== 2).length
      ? disabledTree(ele.children)
      : undefined,
    visible: ele.type !== 2,
    icon: '',
  }));
}

const initSchema = () => ({
  title: "<%= data.id ? '编辑菜单' : '新增菜单' %>",
  size: 'lg',
  body: {
    type: 'form',
    reload: 'menu',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sys/menu/save`,
      method: 'post',
      data: {
        parentId: '${parentId|default:0}',
        visible: '$visible',
        openType: '$openType',
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
        label: '名称',
        required: true,
        placeholder: '请输入',
      },
      {
        type: 'radios',
        name: 'type',
        label: '类型',
        value: 1,
        disabledOn: 'this.isInit',
        options: typeList,
        required: true,
        placeholder: '请选择',
      },
      {
        type: 'icon-picker',
        name: 'icon',
        label: '图标',
        visibleOn: 'this.type === 0',
        placeholder: '请选择',
      },
      {
        type: 'tree-select',
        name: 'parentId',
        label: '父级',
        searchable: true,
        labelField: 'name',
        valueField: 'id',
        showOutline: true,
        showIcon: false,
        source: {
          url: `${BASE_ROUTE_PREFIX}/sys/menu/listTree`,
          method: 'post',
          data: {},
          // trackExpression: '${type}',
          adaptor: (payload) => disabledTree(payload),
        },
      },
      {
        type: 'group',
        body: [
          {
            type: 'switch',
            name: 'visible',
            required: true,
            value: true,
            label: '是否可见',
          },
          {
            type: 'switch',
            name: 'isBreadCrumb',
            required: true,
            value: true,
            label: '显示面包屑',
          },
        ]
      },
      {
        type: 'radios',
        name: 'openType',
        label: '打开方式',
        options: openTypeList,
        value: 1,
        disabledOn: 'this.isInit',
        required: true,
        placeholder: '请选择',
      },
      {
        type: 'text',
        name: 'router',
        label: '路由地址',
        value: '',
        visibleOn: 'this.openType === 1',
        requiredOn: 'this.openType === 1 && this.type === 1',
        validateOnChange: true,
        disabledOn: 'this.isInit',
        validations: {
          matchRegexp: /^(\/[a-zA-Z0-9_-]{1,})+$/,
        },
        validationErrors: {
          matchRegexp: '请输入正确的路由Url格式，如/aaa/ccc',
        },
        placeholder: '请输入',
      },
      {
        type: 'text',
        name: 'permissionPath',
        label: '权限URL',
        visibleOn: 'this.type === 1 && this.openType === 1',
        requiredOn: 'this.type === 1 && this.openType === 1',
        validateOnChange: true,
        disabledOn: 'this.isInit',
        placeholder: '多个逗号分割',
      },
      {
        type: 'text',
        name: 'perms',
        label: '权限标识',
        visibleOn: 'this.type === 2 && this.openType === 1',
        requiredOn: 'this.type === 2 && this.openType === 1',
        validateOnChange: true,
        disabledOn: 'this.isInit',
        placeholder: '请输入',
      },
      {
        type: 'text',
        name: 'link',
        label: '链接地址',
        visibleOn: 'this.openType === 2 || this.openType === 3',
        requiredOn: 'this.openType === 2 || this.openType === 3',
        placeholder: '请输入',
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
