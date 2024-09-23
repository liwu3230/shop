import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import {codeStatusList, genderList} from '@/constants/enums';
import {ApiObject} from 'amis/lib/types';

const initSchema = () => ({
  title: '可关联网点列表',
  size: 'lg',
  actions: [
  ],
  body: {
    type: 'crud',
    name: 'notBindStore',
    api: {
      method: 'post',
      url: `${BASE_ROUTE_PREFIX}/taskInfo/findNotBindStoreListByTaskId`,
      adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
      requestAdaptor: (api: ApiObject) => {
        return {
          ...api,
          data: {
            ...api.data,
            taskId: api.data.taskId,
          },
        };
      },
    },
    // primaryField: 'id',
    syncLocation: false,
    perPage: 30,
    keepItemSelectionOnPageChange: true,
    labelTpl: '${id}',
    maxKeepItemSelectionLength: 50,
    selectable: true,
    multiple: true,
    perPageAvailable: [30, 50, 100, 500, 1000],
    headerToolbar: ['bulkActions'],
    bulkActions: [
      {
        label: '批量关联',
        actionType: 'ajax',
        level: 'primary',
        confirmText: '确定要批量关联?',
        api: {
          url: `${BASE_ROUTE_PREFIX}/taskInfo/bindStore`,
          method: 'post',
          data: {
            taskId: '$taskId',
            storeIds: '$ids',
          },
          requestAdaptor: (api: ApiObject) => {
            return {
              ...api,
              data: {
                ...api.data,
                storeIds: api.data?.storeIds.split(','),
              },
            };
          },
        },
        reload: 'storeBind',
        close: 'addStoreBindDialog',
      },
    ],
    filter: {
      title: '',
      submitText: '',
      mode: 'horizontal',
      controls: genSearchPresentList(3, [
        {
          type: 'text',
          name: 'name',
          label: '名称：',
          placeholder: '请输入名称',
          clearable: true,
        },
        {
          type: 'text',
          name: 'alias',
          label: '别名：',
          placeholder: '请输入别名',
          clearable: true,
        },
        {
          type: 'text',
          name: 'staff',
          label: '联系人：',
          placeholder: '请输入联系人',
          clearable: true,
        },
        {
          type: 'text',
          name: 'address',
          label: '地址：',
          placeholder: '请输入地址',
          clearable: true,
        },
        {
          type: 'text',
          name: 'detailedAddress',
          label: '详细地址：',
          placeholder: '请输入详细地址',
          clearable: true,
        },
      ]),
      actions: [
        {
          type: 'submit',
          label: '查询',
          icon: 'fa fa-search',
          level: 'primary',
        },
        {
          type: 'reset',
          actionType: 'reset-and-submit',
          label: '重置',
          icon: 'fa fa-rotate-right',
        },
      ],
    },
    footerToolbar: [
      {
        type: 'tpl',
        tpl: ' 总共：${total} 项 ',
        align: 'right',
      },
      {
        type: 'switch-per-page',
        align: 'right',
      },
      'pagination',
    ],
    // footerToolbar: ['switch-per-page', 'pagination'],
    perPageField: 'limit',
    pageField: 'page',
    source: '${list}',
    columns: [
      {
        name: 'id',
        label: 'ID',
      },
      // {
      //   type: "image",
      //   name: "logo",
      //   label: "图标",
      //   thumbMode: "cover",
      //   enlargeAble: true,
      //   height: "40px",
      //   width: "40px",
      // },
      {
        name: 'name',
        label: '名称',
      },
      {
        name: 'alias',
        label: '别名',
      },
      {
        name: 'staff',
        label: '联系人',
      },
      {
        name: 'phone',
        label: '手机号码',
      },
      {
        name: 'address',
        label: '地址',
      },
      {
        name: 'detailedAddress',
        label: '详细地址',
      },
      {
        name: 'longitude',
        label: '经度',
      },
      {
        name: 'latitude',
        label: '纬度',
      },
    ],
  },
});

export default initSchema;
