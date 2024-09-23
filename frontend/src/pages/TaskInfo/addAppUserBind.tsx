import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import {convertOptionsToMap, genSearchPresentList} from '@/utils';
import {codeStatusList, genderList} from '@/constants/enums';
import {ApiObject} from 'amis/lib/types';

const initSchema = () => ({
  title: '可导入用户名单列表',
  size: 'lg',
  actions: [
  ],
  body: {
    type: 'crud',
    name: 'notBindStore',
    api: {
      method: 'post',
      url: `${BASE_ROUTE_PREFIX}/taskInfo/findNotBindAppUserListByTaskId`,
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
    perPage: 10,
    keepItemSelectionOnPageChange: true,
    labelTpl: '${id}',
    maxKeepItemSelectionLength: 11,
    selectable: true,
    multiple: true,
    perPageAvailable: [10, 50, 100, 500, 1000],
    headerToolbar: ['bulkActions'],
    bulkActions: [
      {
        label: '批量关联',
        actionType: 'ajax',
        level: 'primary',
        confirmText: '确定要批量关联?',
        api: {
          url: `${BASE_ROUTE_PREFIX}/taskInfo/bindAppUser`,
          method: 'post',
          data: {
            taskId: '$taskId',
            appUserIds: '$ids',
          },
          requestAdaptor: (api: ApiObject) => {
            return {
              ...api,
              data: {
                ...api.data,
                appUserIds: api.data?.appUserIds.split(','),
              },
            };
          },
        },
        reload: 'appUserBind',
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
          name: 'openId',
          label: 'openId：',
          placeholder: '请输入openId',
          clearable: true,
        },
        {
          type: 'text',
          name: 'realName',
          label: '姓名：',
          placeholder: '请输入姓名',
          clearable: true,
        },
        {
          type: 'text',
          name: 'phone',
          label: '手机号码：',
          placeholder: '请输入手机号码',
          clearable: true,
        },
        {
          type: 'select',
          name: 'tagId',
          label: '标签：',
          searchable: true,
          clearable: true,
          labelField: 'name',
          valueField: 'id',
          source: {
            url: `${BASE_ROUTE_PREFIX}/appUserTag/findAll`,
            method: 'get',
          },
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
    footerToolbar: ['switch-per-page', 'pagination'],
    perPageField: 'limit',
    pageField: 'page',
    source: '${list}',
    columns: [
      {
        name: 'id',
        label: 'ID',
      },
      {
        type: "image",
        name: "avatar",
        label: "头像",
        thumbMode: "cover",
        enlargeAble: true,
        height: "40px",
        width: "40px",
      },
      {
        name: 'openId',
        label: 'openId',
      },
      {
        name: 'nickName',
        label: '昵称',
      },
      {
        name: 'realName',
        label: '姓名',
      },
      {
        name: 'gender',
        label: '性别',
        type: 'mapping',
        map: {
          1: "男",
          2: "女",
          "*": "未知"
        }
      },
      {
        name: 'cardId',
        label: '身份证号',
      },
      {
        name: 'phone',
        label: '手机号码',
      },
      {
        type: "each",
        name: "tagNames",
        label: "标签",
        width: "300px",
        className: 'word-break',
        placeholder: "-",
        items: {
          type: "tpl",
          tpl: "<div class='label label-info m-r-sm text-xs'>${item}</div>"
        }
      },
      {
        name: 'isPassExam',
        label: '已考试',
        type: 'mapping',
        map: {
          1: "是",
          0: "否"
        }
      },
      {
        name: 'passCert',
        label: '已认证',
        type: 'mapping',
        map: {
          1: "是",
          0: "否"
        }
      },
    ],
  },
});

export default initSchema;
