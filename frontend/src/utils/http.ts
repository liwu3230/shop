import axios, {AxiosError} from 'axios';
import {message} from 'antd';
import {dealBlob, getApiBaseUrl, jumpToLogin} from './common';
import {BASE_ROUTE_PREFIX} from "@/constants";

export interface ResponseData {
  code: number;
  data: Array<any> | { [key: string]: any } | number | string | Page;
  page?: Page;
  msg?: string;
  message?: string;
}

const instance = axios.create({baseURL: getApiBaseUrl()});

// 配置请求信息
instance.defaults.timeout = 1000 * 60 * 10;
// 表示跨域请求时是否需要使用凭证, 默认为 false
instance.defaults.withCredentials = true;

// 添加请求拦截器
instance.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("x-access-token");
    token ? config.headers.Authorization = "Bearer " + token : null;
    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

// 添加响应拦截器
instance.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      const {data: responseData} = response;
      // 兼容后端以及gslb后端返回格式
      if (responseData.code === 0 || responseData.code === 200) {
        // if (!responseData.data) {
        //   // 避免 amis 在 data === null 的情况下判断为请求失败
        //   responseData.data = 'data';
        // }
        if (
          responseData.success &&
          responseData.msg &&
          responseData.msg !== 'success'
        ) {
          message.success(responseData.msg);
        }
        // 返回的data字段不能为字符串：避免amis responseAdaptor报错
        typeof responseData.data !== 'object' &&
        (responseData.data = {data: responseData.data});
        return Promise.resolve(responseData);
      } else if (responseData.code === 401) {
        jumpToLogin();
        return Promise.reject(response);
      } else if (responseData.code === 403) {
        return Promise.reject({message: responseData.msg});
      } else {
        if (responseData.toString() === '[object Blob]') {
          const isSuccess = dealBlob(response);
          if (isSuccess) {
            return Promise.resolve(response);
          } else {
            return new Promise((resolve, reject) => {
              const reader = new FileReader();
              reader.onload = function (event) {
                try {
                  const res = JSON.parse(event.target.result);
                  reject({message: res.msg});
                } catch (error) {
                  reject({message: '导出失败'});
                }
              };
              reader.onerror = function (event) {
                reject({message: '导出失败'});
              };
              reader.readAsText(responseData);
            });
          }
          // return isSuccess
          //   ? Promise.resolve(response)
          //   : Promise.reject({message: '导出失败'});
        }
        const messageTips = responseData.message || responseData.msg;
        // 注释掉非amis的异常消息提醒，因为全部用的amis组件
        const url = response.config.url;
        if (url?.startsWith(`${BASE_ROUTE_PREFIX}/common/`)) {
          message[responseData.code === -2 ? 'warn' : 'error'](
            messageTips || responseData.data || responseData.info,
          );
        }

        responseData.message = messageTips;
        return Promise.reject(responseData);
      }
    } else {
      return Promise.reject(response);
    }
  },
  (error) => {
    // 相应错误处理
    // 比如：token 过期，无权限访问，路径不存在，服务器问题等
    switch (error.response.status) {
      case 401:
        jumpToLogin();
        break;
      case 403:
        break;
      case 404:
        break;
      case 500:
        handleSystemError(error);
        break;
      default:
        console.log('其他错误信息');
    }
    return Promise.reject(error);
  },
);

const handleSystemError = (error: AxiosError) => {
  let detailMsg;
  const msg = error?.response?.data.msg || '';
  if (!msg.startsWith('Forwarding error')) {
    detailMsg = msg.replace(/.+-->cause by:/, '');
  }
  if (detailMsg && detailMsg !== 'null') {
    message.error(detailMsg);
  } else {
    // 添加所属发布系统提示
    const url = error.config.url || '';
    let msg = '';
    let matchValue = url.match(/\/?([\w-]*)\//);
    if (matchValue && matchValue[1]) {
      msg = matchValue[1] as string;
    } else {
      msg = '';
    }
    msg += '系统异常，请稍后重试';
    message.warn(msg);
  }
};

export default instance;
