import {BASE_ROUTE_PREFIX} from '@/constants';
import {convertOptionsToMap} from '@/utils';
import {codeStatusList, genderList} from '@/constants/enums';
import {ApiObject} from 'amis/lib/types';

const initSchema = () => ({
  title: '用户列表',
  size: 'lg',
  actions: [
    // {
    //   type: 'action',
    //   actionType: 'close',
    //   label: '取消',
    // },
  ],
  body: {
    type: 'crud',
    name: 'assocUser',
    api: {
      method: 'post',
      url: `${BASE_ROUTE_PREFIX}/sys/role/listUser`,
      adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
    },
    // primaryField: 'id',
    syncLocation: false,
    perPage: 10,
    keepItemSelectionOnPageChange: true,
    labelTpl: '${userName}',
    maxKeepItemSelectionLength: 11,
    selectable: true,
    multiple: true,
    headerToolbar: ['bulkActions'],
    bulkActions: [
      {
        label: '批量关联',
        actionType: 'ajax',
        confirmText: '确定要批量关联?',
        api: {
          url: `${BASE_ROUTE_PREFIX}/sys/role/roleAssocUser`,
          method: 'post',
          data: {
            id: '$roleId',
            assocUserIds: '$ids',
          },
          requestAdaptor: (api: ApiObject) => {
            return {
              ...api,
              data: {
                ...api.data,
                assocUserIds: api.data?.assocUserIds.split(','),
              },
            };
          },
        },
        reload: 'grantUser',
      },
    ],
    filter: {
      title: '',
      submitText: '',
      controls: [
        {
          type: 'text',
          name: 'userName',
          size: 'md',
          placeholder: '通过用户账号搜索',
          clearable: true,
        },
        {
          type: 'text',
          name: 'nickName',
          size: 'md',
          placeholder: '通过姓名搜索',
          clearable: true,
        },
        {
          label: '搜索',
          type: 'submit',
        },
      ],
    },
    footerToolbar: ['switch-per-page', 'pagination'],
    perPageField: 'limit',
    pageField: 'page',
    source: '${list}',
    columns: [
      {
        name: 'userName',
        label: '用户账号',
      },
      {
        name: 'nickName',
        label: '姓名',
      },
      {
        name: 'gender',
        label: '性别',
        type: 'mapping',
        map: convertOptionsToMap(genderList),
      },
      {
        name: 'status',
        label: '状态',
        type: 'mapping',
        map: convertOptionsToMap(codeStatusList),
      },
      {
        name: 'phone',
        label: '手机号码',
      },
    ],
  },
});

export default initSchema;
