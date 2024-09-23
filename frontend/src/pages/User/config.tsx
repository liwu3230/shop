import {BASE_ROUTE_PREFIX} from '@/constants';
import {codeStatusList, genderList} from '@/constants/enums';

const initSchema = () => ({
  title: "<%= data.id ? '编辑用户' : '新增用户' %>",
  size: 'md',
  body: {
    type: 'form',
    reload: 'user',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sys/user/save`,
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
        name: 'userName',
        label: '用户账号',
        required: true,
        clearable: true,
        placeholder: '请输入',
        disabledOn: 'data.id && data.id > 0',
        validateOnChange: true,
        validations: {
          matchRegexp: /^[0-9a-zA-Z_]+$/,
        },
        validationErrors: {
          matchRegexp: '只能为数字、字母、下划线的组合',
        },
      },
      {
        type: 'text',
        name: 'nickName',
        label: '用户昵称',
        required: false,
        clearable: true,
        placeholder: '请输入',
      },
      {
        type: 'radios',
        name: 'gender',
        label: '性别',
        options: genderList,
        value: 1,
        required: true,
        placeholder: '请选择',
      },
      {
        type: 'text',
        name: 'phone',
        label: '手机号码',
        required: false,
        clearable: true,
        placeholder: '请输入',
        validateOnChange: true,
        validations: {
          matchRegexp: /^[1][0-9]{10}$/,
        },
        validationErrors: {
          matchRegexp: '请输入正确的手机号码格式',
        },
      },
      {
        type: 'text',
        name: 'email',
        label: '邮箱',
        required: false,
        clearable: true,
        placeholder: '请输入',
        validateOnChange: true,
        validations: {
          matchRegexp: /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
        },
        validationErrors: {
          matchRegexp: '请输入正确的邮箱格式',
        },
      },
      {
        type: 'select',
        name: 'status',
        label: '状态',
        options: codeStatusList,
        value: 0,
        disabledOn: '!data.id || data.id <= 0',
        required: true,
        placeholder: '请选择',
      },
      {
        type: 'nested-select',
        name: 'deptId',
        label: '所属部门',
        searchable: true,
        clearable: true,
        labelField: 'name',
        valueField: 'id',
        size: 'full',
        source: {
          url: `${BASE_ROUTE_PREFIX}/sys/dept/listTree`,
          method: 'post',
          data: {},
        },
      },
      {
        type: 'input-datetime',
        name: 'expireTime',
        label: '过期时间',
        format: 'YYYY-MM-DD HH:mm:ss',
        clearable: true,
        // value: '+24hours'
      },
      {
        type: 'text',
        name: 'remark',
        label: '备注',
        placeholder: '请输入',
        clearable: true,
      },
    ],
  },
});

export default initSchema;
