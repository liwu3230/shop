import {BASE_ROUTE_PREFIX} from '@/constants';
import {ApiObject} from "amis/lib/types";

const initSchema = () => ({
  title: "<%= data.id ? '修改网点' : '新增网点' %>",
  size: 'md',
  body: {
    type: 'form',
    reload: 'store',
    api: {
      url: `${BASE_ROUTE_PREFIX}/store/saveOrUpdate`,
      method: 'post',
      data: {
        '&': '$$',
        id: '$id',
        data: '$data',
      },
      requestAdaptor: (api: ApiObject) => {
        return {
          ...api,
          data: {
            ...api.data,
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
        label: '名称',
        required: true,
        clearable: true,
        placeholder: '请输入',
      },
      {
        type: 'text',
        name: 'alias',
        label: '别名',
        required: false,
        clearable: true,
        placeholder: '请输入',
      },
      // {
      //   type: 'input-image',
      //   name: 'logo',
      //   label: '网点logo',
      //   placeholder: '请输入',
      //   required: false,
      //   receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
      // },
      {
        type: 'text',
        name: 'staff',
        label: '联系人',
        required: false,
        clearable: true,
        placeholder: '请输入',
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
      // {
      //   type: 'input-city',
      //   name: 'address',
      //   label: '地址',
      //   required: false,
      //   clearable: true,
      //   extractValue: false,
      //   placeholder: '请输入',
      // },
      {
        type: 'tree-select',
        initiallyOpen: false,
        name: 'address',
        label: '省市区：',
        searchable: true,
        required: false,
        labelField: 'name',
        valueField: 'mergerName',
        source: {
          url: `${BASE_ROUTE_PREFIX}/common/listCityTree`,
          method: 'get',
        },
        // autoFill: {
        //   longitude: '$lng',
        //   latitude: '$lat',
        // },
      },
      // {
      //   type: 'text',
      //   name: 'longitude',
      //   label: '经度',
      //   required: false,
      //   clearable: true,
      //   placeholder: '请输入',
      // },
      // {
      //   type: 'text',
      //   name: 'latitude',
      //   label: '纬度',
      //   required: false,
      //   clearable: true,
      //   placeholder: '请输入',
      // },
      {
        type: 'text',
        name: 'detailedAddress',
        label: '详细地址',
        required: false,
        clearable: true,
        searchable: true,
        placeholder: '请输入',
      },
      // {
      //   type: "location-picker",
      //   name: "location",
      //   ak: "LiZT5dVbGTsPI91tFGcOlSpe5FDehpf7",
      //   label: "经纬度",
      //   required: false,
      // },
    ],
  },
});

export default initSchema;
