import http, {ResponseData} from '@/utils/http';
import {BASE_ROUTE_PREFIX} from '@/constants';

// 获取当前用户面包屑列表
export function findBreadcrumb(): Promise<ResponseData> {
  return http.get(`${BASE_ROUTE_PREFIX}/common/findBreadcrumb`);
}

// 获取当前用户菜单列表
export function getMainMenu(): Promise<ResponseData> {
  return http.get(`${BASE_ROUTE_PREFIX}/common/menu`);
}

//获取当前用户信息
export function getCurrentUser(): Promise<ResponseData> {
  return http.get(`${BASE_ROUTE_PREFIX}/common/getCurrentUser`);
}

//获取当前用户待办列表
export function getTodoCount(): Promise<ResponseData> {
  return http.get(`${BASE_ROUTE_PREFIX}/flowable/task/todoCount`);
}

// 获取当前用户拥有的按钮权限
export function getButtonPermission(): Promise<ResponseData> {
  return http.get(`${BASE_ROUTE_PREFIX}/common/buttonAbility`);
}

// 登录
export function login(data: PlainObject): Promise<ResponseData> {
  return http.post(`${BASE_ROUTE_PREFIX}/common/login`, data);
}

export function updatePassword(data: PlainObject): Promise<ResponseData> {
  return http.post(`${BASE_ROUTE_PREFIX}/common/updatePassword`, data);
}
// 查询字典列表
export function findDictByCode(params: Object): Promise<ResponseData> {
  return http.get(`${BASE_ROUTE_PREFIX}/common/findDictByCode`, {params});
}
