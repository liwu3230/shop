export const LIST_ADAPTOR =
  'return { items: payload.list, total: payload.totalCount }';
export const SUCCESS_ADAPTOR = 'return { status: 0, msg: response.msg }';

export const IS_LIGHT_STYLE = true;
export const SITE_NAME = '管理平台';
//
export const COPY_RIGHT = 'Copyright © 2024 xxx有限公司 版权所有 ';
export const LOGO_PATH = '/logo.svg';

// export const BASE_ROUTE_PREFIX = window.location.pathname.match(/(\S*)system-web/)
//   ? window.location.pathname.match(/(\S*)system-web/)![0]
//   : '/system-web';
//后端路由
export const BASE_ROUTE_PREFIX = '/system-web';

//前端路由
export const BASE_FRONT_ROUTE_PREFIX = '/web';

export const ROUTE_PATH_REG = /^(\/?[a-zA-Z0-9_-]{1,})+$/;

export const viewTimeFormat = 'YYYY-MM-DD HH:mm:ss';

export const SEARCH_DEBOUNCE = 350;

