import {BASE_ROUTE_PREFIX} from '@/constants';
import {convertOptionsToMap} from '@/utils';
import {codeStatusList, genderList} from '@/constants/enums';
import {ApiObject} from 'amis/lib/types';
import initAssocUser from '@/pages/Role/assocUser';

const initSchema = () => ({
  title: '已关联用户列表',
  size: 'lg',
  actions: [
    {
      type: 'action',
      actionType: 'close',
      label: '取消',
    },
  ],
  body: {
    type: 'crud',
    name: 'grantUser',
    api: {
      method: 'get',
      url: `${BASE_ROUTE_PREFIX}/sys/role/findUserListByRoleId?roleId=$roleId`,
      adaptor: 'return {\n  list: payload\n}',
    },
    // primaryField: 'id',
    syncLocation: false,
    headerToolbar: [
      {
        label: '新增关联用户',
        type: 'button',
        actionType: 'dialog',
        level: 'primary',
        dialog: initAssocUser(),
      },
      'bulkActions',
    ],
    bulkActions: [
      {
        label: '批量取消关联',
        actionType: 'ajax',
        confirmText: '确定要批量取消关联?',
        api: {
          url: `${BASE_ROUTE_PREFIX}/sys/role/roleCancelUser`,
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
      },
    ],
    loadDataOnce: true,
    source:
      '${list | filter:userName:match:userName | filter:nickName:match:nickName}',
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
      {
        type: 'operation',
        label: '操作',
        buttons: [
          {
            type: 'button',
            tooltip: '取消关联',
            actionType: 'dialog',
            icon: 'fa fa-trash',
            className: 'text-red-400 text-md',
            hiddenOn: "this.userName === 'admin'",
            dialog: {
              body: {
                type: 'form',
                api: {
                  url: `${BASE_ROUTE_PREFIX}/sys/role/roleCancelUser`,
                  method: 'post',
                  data: {
                    id: '$roleId',
                    assocUserIds: '$id',
                  },
                  requestAdaptor: (api: ApiObject) => {
                    return {
                      ...api,
                      data: {
                        ...api.data,
                        assocUserIds: api.data?.assocUserIds.toString().split(','),
                      },
                    };
                  },
                },
                controls: [
                  {
                    type: 'tpl',
                    tpl: '您确认要取消关联吗？',
                  },
                ],
              },
            },
          },
        ],
      },
    ],
  },
});

export default initSchema;
