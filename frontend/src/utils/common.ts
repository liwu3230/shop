import {history, IRoute} from '@umijs/max';
import {BASE_FRONT_ROUTE_PREFIX, LIST_ADAPTOR} from '@/constants';

/**
 * 是否处于本地开发环境
 */
export const IS_DEV = process.env.NODE_ENV === 'development';

/**
 * 一级域名
 */
export const TOP_DOMAIN = document.domain.split('.').slice(-2).join('.');

export function jumpToLogin() {
    // 跳转登录页面
    history.push(`${BASE_FRONT_ROUTE_PREFIX}/login`)
}

export function jumpToToDo() {
    // 跳转我的待办
    history.push(`${BASE_FRONT_ROUTE_PREFIX}/process/toDo`)
}

export function getCurRouteMeta(pathName: string, routes: IRoute[]) {
    return {};
}

/**
 * 获取接口基础 URL
 * @returns {String}
 */
export const getApiBaseUrl = () => {
    if (IS_DEV) {
        return `//localhost:8585`;
    }
    return `//yjz.mimr-china.com`;
};

/**
 * 扁平化对象数组
 * @param {T[]} objectArray 对象数组
 * @param {string} objectKey 需要扁平化的Key
 * @returns {T[]}
 */
export const flattenObjectArray = <T extends Record<string, any>>(
    objectArray: T[],
    objectKey: string,
): T[] => {
    let selectedIndex = 0;
    while (
        objectArray.some((item: T, index: number) => {
            selectedIndex = index;
            return item?.[objectKey]?.length;
        })
        ) {
        const result = objectArray[selectedIndex] as T;
        objectArray.push(...(result[objectKey] as T[]));
        delete result.routes;
    }

    return objectArray;
};

/**
 * 转化成options的adaptor字符串
 * @param {string} varName 循环的变量
 * @param {string} valueKey 值
 * @param {string} labelKey 文字
 * @returns
 */
export const toOptionsAdaptor = (
    varName: string,
    valueKey = 'value',
    labelKey = 'label',
): string => {
    if (valueKey === labelKey) {
        return `return { options: ${varName}.map(({ ${valueKey} }) => ({ value: ${valueKey}, label: ${labelKey} })) }`;
    } else {
        return `return { options: ${varName}.map(({ ${valueKey}, ${labelKey} }) => ({ value: ${valueKey}, label: ${labelKey} })) }`;
    }
};

/**
 * 获取处理后端表格数据的字符串代码
 * @param mapFnBody 遍历的字符串函数体
 * @returns {string}
 */
export const getListAdaptor = (mapFnBody?: string) => {
    if (mapFnBody) {
        return `return { items: payload.list.map((item, index, array) => ${mapFnBody}), total: payload.totalCount }`;
    } else {
        return LIST_ADAPTOR;
    }
};

/**
 * options数组转map
 * @param array 需要转换的数组
 * @returns {object}
 */
export const convertOptionsToMap = (
    data: Recordable[],
    valueField = 'value',
    labelField = 'label',
) => {
    if (!data?.length) return null;
    return Object.fromEntries(
        data.map((ele) => [ele[valueField], ele[labelField]]),
    );
};

/**
 * map转options数组
 * @param data 需要转换的对象
 * @returns {array}
 */
export const convertMapToOptions = (
    data: PlainObject,
    labelIndex: number = 1,
    valueIndex: number = 0,
) => {
    if (Object.prototype.toString.call(data) !== '[object Object]') return [];
    return Object.entries(data).map((item) => ({
        label: item[labelIndex],
        value: +item[valueIndex],
    }));
};

/**
 * 数组转options数组
 * @param labelField label字段
 * @param valueField value字段
 * @param isRetain 是否保留其他属性
 * @returns options
 */
export const convertToOptions = <T extends Recordable<unknown>,
    K extends keyof T,
>(
    arr: T[],
    valueField: K,
    labelField: K[] | K,
    isRetain = true,
): OptionsItem[] => {
    return arr.reduce((prev, next: T) => {
        if (next) {
            let label = Array.isArray(labelField)
                ? labelField.reduce(
                    (pre, elem) => (
                        (pre = `${
                            pre
                                ? pre + (next[elem] ? '(' + next[elem] + ')' : '')
                                : next[elem]
                        }`),
                            pre
                    ),
                    '',
                )
                : `${next[labelField]}`;
            label = label.replace(/\)\(/g, ' ');
            const target = {
                label: `${label}`,
                value: next[valueField] as StrOrNum,
            };
            prev.push(isRetain ? {...next, ...target} : target);
        }
        return prev;
    }, [] as OptionsItem[]);
};

/**
 * @param { Promise } promise
 * @return { Promise }
 */
export function wrapper<T, U = any>(
    promise: Promise<T>,
): Promise<[U | null, T | undefined]> {
    return promise
        .then<[null, T]>((data: T) => [null, data])
        .catch<[U, undefined]>((err) => {
            return [err, undefined];
        });
}

/**
 * 用 html5 a 标签的 download 属性下载blob
 * @param {Object} params 参数
 * @param {String} params.blob 文件内容
 * @param {String} params.filename 文件名
 */
export function downloadBlob(blob: Blob, filename: string) {
    // 创建隐藏的可下载链接
    let eleLink: HTMLAnchorElement | null = document.createElement('a');
    eleLink.download = filename;

    // 字符内容转变成 blob 地址
    eleLink.href = URL.createObjectURL(blob);
    // 触发点击
    eleLink.click();
    // 释放节点
    eleLink = null;
}

/**
 * 用 html5 a 标签的 download 属性下载blob
 * @param {Object} params 参数
 * @param {String} params.blob 文件内容
 * @param {String} params.filename 文件名
 */
export function dealBlob(response: { data: Blob; headers: PlainObject }) {
    const {data, headers} = response;
    const excludesType = ['application/json'];
    const disposition = headers['content-disposition'];
    let filename = '';
    if (disposition && disposition.indexOf('attachment') !== -1) {
        let filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
        let matches = filenameRegex.exec(disposition);
        if (matches != null && matches[1]) {
            filename = matches[1].replace(/['"]/g, '');
        }

        // 很可能是中文被 url-encode
        if (filename && filename.replace(/[^%]/g, '').length > 2) {
            filename = decodeURIComponent(filename);
        }
    }
    if (data && !excludesType.includes(data.type)) {
        downloadBlob(data, filename);
        return true;
    } else {
        return false;
    }
}

export async function getBlobMsg(blob: Blob) {
    try {
        const reponse = JSON.parse(await blob.text());
        return reponse.msg || reponse.message;
    } catch {
        return '';
    }
}

/**
 * 转换 textarea 的字符串值为数组
 * @param {String} str 字符串
 * @returns {Array} 结果
 */
export function textareaValueToArray(str = '') {
    return str
        .split(/\n+/)
        .map((li) => li.trim())
        .filter((li) => li);
}

/**
 * 转换 textarea 的字符串值为数组
 * @param {String} str 字符串
 * @returns {Array} 结果
 */
export function arrayToTextareaValue(arr = []): string {
    if (!Array.isArray(arr)) return arr;
    return arr.join('\n');
}

/**
 * 成一个双向枚举, 并挂载一些工具方法
 * ex:
 * 1. 值非对象
 * { serial: 0 } ==> { 0: 'serial' }
 * 2. 值为对象
 * { serial: { value: 0, label: '串行' }} ==> { 0: { value: 'serial', label: '串行' } }
 *
 * 注意, 反向挂载的 key 是不可枚举的.
 *
 * @param {Object} obj 初始对象, 其值必须对齐
 * @param {string} key 当数据值为对象时, 必须指定, 用于反向映射
 * @template T * @param {T} obj * @return {T}
 */
export const getFakeEnum = (obj: PlainObject, key: string) => {
    const map = {...obj};

    (function (map) {
        Object.keys(map).forEach((mapKey) => {
            const reverseKey = key ? map[mapKey][key] : map[mapKey];

            if (typeof reverseKey === 'object' && reverseKey) {
                throw new TypeError('A key must be provided as the value is Object');
            }

            const value =
                typeof map[mapKey] === 'object' && map[mapKey]
                    ? {...map[mapKey], [key]: mapKey}
                    : map[mapKey];

            Object.defineProperty(map, reverseKey, {
                value,
                enumerable: false,
            });
        });
    })(map);

    Object.defineProperties(map, {
        getKeys: {
            value: function () {
                return Object.keys(obj);
            },
            enumerable: false,
        },
        getValues: {
            value: function () {
                return Object.values(obj);
            },
            enumerable: false,
        },
    });

    return map;
};

export const getAllCookies = (): Recordable<string> => {
    const cookies: Recordable<string> = {};
    if (document.cookie) {
        const split = document.cookie.split(';');
        for (let i = 0; i < split.length; i++) {
            let [key, value] = split[i].split('=');
            key = key.replace(/^ /, '');
            cookies[decodeURIComponent(key)] = decodeURIComponent(value);
        }
    }

    return cookies;
};
