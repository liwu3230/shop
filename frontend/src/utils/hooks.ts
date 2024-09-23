import {
  DependencyList,
  useEffect,
  useState,
  useRef,
  useCallback,
  MutableRefObject,
} from 'react';
import { useLocation, useMatch, useModel } from '@umijs/max';
import { routes } from '@/routes';
import { flattenObjectArray } from './common';
import pathToRegexp from 'path-to-regexp';
import { cloneDeep, isFunction, pick } from 'lodash';

interface RouteConfig {
  path: string;
  component: string;
  routes?: RouteConfig[];
  meta?: Record<string, string | number | boolean>;
}

export const flattenRoutes = flattenObjectArray<RouteConfig>(
  cloneDeep(routes),
  'routes',
);

export function useQuery() {
  const res: Record<string, string> = {};
  const searchParams = new URLSearchParams(useLocation().search);
  for (const [key, value] of searchParams) {
    res[key] = value;
  }
  return res;
}

/**
 * 获取routes当前路由对象
 * @returns {Array}
 */
export const useCurrentRoute = () => {
  const rLocation = useLocation();
  const match = useMatch({
    path: rLocation.pathname,
    strict: true,
    sensitive: true,
  });
  const findRouteByPath = () => {
    return flattenRoutes.find((item: RouteConfig) =>
      pathToRegexp(item.path).test(match?.path as string),
    )!;
  };
  const [currentRoute, setCurrentRoute] = useState<RouteConfig>(
    findRouteByPath(),
  );

  useEffect(() => {
    setCurrentRoute(findRouteByPath());
  }, [match]);

  return [currentRoute];
};

/**
 * 绑定message事件
 * @param callback 回调函数
 */
export const usePostMessage = (
  callback: (event: MessageEvent) => void,
  deps: DependencyList,
) => {
  useEffect(() => {
    window.addEventListener('message', callback);
    return () => window.removeEventListener('message', callback);
  }, deps);
};

/**
 * 状态变更后执行回调函数
 * @returns [state, setStateCallback]
 */
export function useStateCallback(initialState: unknown) {
  const [state, setState] = useState(initialState);
  const cbRef = useRef(null);
  const setStateCallback = useCallback((state, cb) => {
    cbRef.current = cb;
    setState(state);
  }, []);
  useEffect(() => {
    if (cbRef.current && isFunction(cbRef.current)) {
      //@ts-ignore
      cbRef.current(state);
      cbRef.current = null;
    }
  }, [state]);

  return [state, setStateCallback];
}

type ModelName = 'auth' | 'list';
export const useSelectModel = (
  modelName: ModelName,
  keys: string[],
): Recordable => {
  return useModel(modelName, (m) => pick(m, keys));
};
