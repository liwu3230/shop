import {BASE_ROUTE_PREFIX} from '@/constants';
import {ApiObject} from "amis/lib/types";

const initSchema = () => ({
  title: "<%= data.id ? '编辑应用' : '新增应用' %>",
  size: 'md',
  body: {
    type: 'form',
    reload: 'clientDetails',
    api: {
      url: `${BASE_ROUTE_PREFIX}/clientDetails/saveOrUpdate`,
      method: 'post',
      data: {
        '&': '$$',
        clientId: '$clientId',
        data: '$data',
      },
      requestAdaptor: (api: ApiObject) => {
        return {
          ...api,
          data: {
            ...api.data,
            resourceIds: api.data.resourceIds?.map((obj) => obj.name).join(',') || '',
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
        type: 'text',
        name: 'name',
        label: '应用名称',
        required: true,
        clearable: true,
        placeholder: '请输入应用名称',
        disabledOn: 'data.clientId',
      },
      {
        type: 'text',
        name: 'remarks',
        label: '应用描述',
        required: false,
        clearable: true,
        placeholder: '请输入描述',
      },
      {
        type: "combo",
        label: "资源权限",
        name: "resourceIds",
        multiple: true,
        items: [
          {
            type: "input-text",
            name: "name",
            validateOnChange: true,
            validations: {
              matchRegexp: /^(\/[a-zA-Z0-9_*-]{1,})+$/,
            },
            validationErrors: {
              matchRegexp: '请输入正确的路由Url格式，如/aaa/ccc',
            },
            placeholder: '请输入',
          }
        ],
        multiLine: false,
        joinValues: true,
        messages: {},
        delimiter: ","
      }
    ],
  },
});

export default initSchema;
