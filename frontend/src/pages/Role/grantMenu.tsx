import { ApiObject } from 'amis/lib/types';
import { BASE_ROUTE_PREFIX } from '@/constants';

const initSchema = () => ({
  title: '授权菜单',
  size: 'md',
  body: {
    type: 'form',
    api: {
      url: `${BASE_ROUTE_PREFIX}/sys/role/grantMenu`,
      method: 'post',
      data: {
        id: '$id',
        grantMenuIdList: '$grantMenu',
      },
      requestAdaptor: (api: ApiObject) => {
        return {
          ...api,
          data: {
            ...api.data,
            grantMenuIdList:
              api.data.grantMenuIdList
                .split?.(',')
                .map((str) => parseInt(str)) || api.data.grantMenuIdList,
          },
        };
      },
    },
    initApi: {
      url: `${BASE_ROUTE_PREFIX}/sys/role/findMenuIdsByRoleId?roleId=$roleId`,
      method: 'get',
      adaptor: 'return {\n  grantMenu: payload\n}',
    },
    messages: {
      saveSuccess: "",
      saveFailed: "操作失败"
    },
    controls: [
      {
        type: 'tree',
        name: 'grantMenu',
        label: false,
        showOutline: true,
        multiple: true,
        cascade: true,
        withChildren: false,
        initiallyOpen: true,
        labelField: 'name',
        valueField: 'id',
        showIcon: false,
        source: {
          url: `${BASE_ROUTE_PREFIX}/common/queryMenuTree`,
          method: 'post',
          adaptor: (payload: any) =>
            payload.map((ele) => {
              return {
                ...ele,
                icon: '',
              };
            }),
        },
      },
    ],
  },
});

export default initSchema;
