import {ApiObject} from 'amis/lib/types';
import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
  title: '关联角色',
  body: {
    type: 'form',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sys/user/userAssocRole`,
      method: 'post',
      data: {
        id: '$id',
        grantRoleIdList: '$assocRole',
      },
      requestAdaptor: (api: ApiObject) => {
        return {
          ...api,
          data: {
            ...api.data,
            grantRoleIdList:
              api.data.grantRoleIdList
                .split?.(',')
                .map((str) => parseInt(str)) || api.data.grantRoleIdList,
          },
        };
      },
    },
    initApi: {
      url: `${BASE_ROUTE_PREFIX}/sys/user/findRolesByUserId?userId=$id`,
      method: 'get',
      adaptor: 'return {\n  assocRole: payload\n}',
    },
    messages: {
      saveSuccess: "",
      saveFailed: "操作失败"
    },
    controls: [
      {
        type: 'checkboxes',
        name: 'assocRole',
        label: '关联角色',
        labelField: 'name',
        valueField: 'id',
        columnsCount: 2,
        inline: false,
        required: false,
        source: {
          url: `${BASE_ROUTE_PREFIX}/sys/user/listAllRole`,
          adaptor: (payload: PlainObject) =>
            payload.map((ele) => ({
              ...ele,
            })),
        },
      },
    ],
  },
});

export default initSchema;
