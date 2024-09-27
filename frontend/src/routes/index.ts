import {IConfig} from '@umijs/preset-umi';

const ROUTE_PATH_PREFIX = '/web';

export const routes: IConfig['routes'] = [
  {
    exact: true,
    path: `${ROUTE_PATH_PREFIX}/login`,
    component: '@/pages/Login/index',
  },
  {
    path: '/',
    component: '@/components/Layouts/BaseLayout',
    routes: [
      {
        path: '/',
        // redirect: `${ROUTE_PATH_PREFIX}/process/toDo/list`,
        redirect: `${ROUTE_PATH_PREFIX}/appUser/list`,
      },
      {
        exact: true,
        path: `${ROUTE_PATH_PREFIX}/404`,
        component: '@/components/Exception/index',
      },
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/user`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/user`,
            redirect: `${ROUTE_PATH_PREFIX}/user/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/user/list`,
            component: '@/pages/User',
          },
        ],
      },
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/dept`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/dept`,
            redirect: `${ROUTE_PATH_PREFIX}/dept/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/dept/list`,
            component: '@/pages/Dept',
          },
        ],
      },
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/role`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/role`,
            redirect: `${ROUTE_PATH_PREFIX}/role/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/role/list`,
            component: '@/pages/Role',
          },
        ],
      },
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/menu`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/menu`,
            redirect: `${ROUTE_PATH_PREFIX}/menu/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/menu/list`,
            component: '@/pages/Menu',
          },
        ],
      },
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/dict`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/dict`,
            redirect: `${ROUTE_PATH_PREFIX}/dict/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/dict/list`,
            component: '@/pages/Dict',
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/dict/config`,
            component: '@/pages/Dict/config',
          },
        ],
      },
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/operatelog`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/operatelog`,
            redirect: `${ROUTE_PATH_PREFIX}/operatelog/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/operatelog/list`,
            component: '@/pages/OperateLog',
          },
        ],
      },
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/view`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/view/frame/:id`,
            component: '@/pages/View/Frame',
          },
        ],
      },
      //流程中心-我的待办
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/process/toDo`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/toDo`,
            redirect: `${ROUTE_PATH_PREFIX}/process/toDo/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/toDo/list`,
            component: '@/pages/Process/ToDo',
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/toDo/viewer`,
            component: '@/pages/Process/BpmnViewer',
          },
        ],
      },
      //我的申请
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/process/apply`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/apply`,
            redirect: `${ROUTE_PATH_PREFIX}/process/apply/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/apply/list`,
            component: '@/pages/Process/Apply',
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/apply/viewer`,
            component: '@/pages/Process/BpmnViewer',
          },
        ],
      },
      //我的已办
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/process/done`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/done`,
            redirect: `${ROUTE_PATH_PREFIX}/process/done/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/done/list`,
            component: '@/pages/Process/Done',
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/done/viewer`,
            component: '@/pages/Process/BpmnViewer',
          },
        ],
      },
      //全部工单
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/process/all`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/all`,
            redirect: `${ROUTE_PATH_PREFIX}/process/all/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/all/list`,
            component: '@/pages/Process/All',
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/process/all/viewer`,
            component: '@/pages/Process/BpmnViewer',
          },
        ],
      },
      //附件相关
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/attachment`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/attachment`,
            redirect: `${ROUTE_PATH_PREFIX}/attachment/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/attachment/list`,
            component: '@/pages/Attachment',
          },
        ],
      },
      /**
       * 业务相关
       */
      {
        exact: false,
        path: `${ROUTE_PATH_PREFIX}/clientDetails`,
        component: '@/components/PureRouter',
        routes: [
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/clientDetails`,
            redirect: `${ROUTE_PATH_PREFIX}/clientDetails/list`,
          },
          {
            exact: true,
            path: `${ROUTE_PATH_PREFIX}/clientDetails/list`,
            component: '@/pages/ClientDetails',
          },
        ],
      },
      // 404兜底
      {
        path: '/*',
        component: '@/components/Exception/index',
      }
    ],
  },

];
