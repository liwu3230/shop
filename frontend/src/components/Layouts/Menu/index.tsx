import React, {FC, useEffect, useRef, useState} from 'react';
import {useLocation, useModel} from '@umijs/max';
import {v4 as uuidv4} from 'uuid';
import {cloneDeep} from 'lodash';
import {BASE_FRONT_ROUTE_PREFIX} from '@/constants';
import Menu, {MenuHandle} from './Menu';
import SearchMenu from './SearchMenu';

export interface MenuData {
    name: string;
    router: string;
    path: string;
    key: string;
    id: number;
    parentId: number;
    type: number;
    children: MenuData[];
    matcher: string;
    isInit: boolean;
    visible: boolean;
    viewId: number | null;
    icon: string;
    link: string | null;
    pageType: number | null;
    openType: number;
}

const MainMenu: FC = () => {
    const {menuList, fetchMenuList} = useModel('list');
    const [menuData, setMenuData] = useState<MenuData[]>([]);
    const originMenuData = useRef<MenuData[]>([]);
    const menuRef = useRef<MenuHandle>();

    const location = useLocation(), locationMap = new Map();

    useEffect(() => {
        fetchMenuList();
    }, []);

    // useEffect(() => {
    //   const firstRoute = getFirstRoute(menuList);
    //   const locationStr = locationMap.get(location.pathname + location.search);
    //   if (locationStr) {
    //     menuRef.current?.routeTo(locationStr);
    //   }
    // }, [menuList]);

    useEffect(() => {
        const firstRoute = getFirstRoute(menuList);
        const routerKey = locationMap.get(location.pathname);
        if (routerKey) {
            menuRef.current?.routeTo(routerKey, location.search)
        }
    }, [menuList]);

    //没找到就跳转到第一个路由
    // useEffect(() => {
    //   const firstRoute = getFirstRoute(menuList);
    //   const locationStr = locationMap.get(location.pathname + location.search);
    //   if (!firstRoute) return;
    //   locationStr ? menuRef.current?.routeTo(locationStr) : routeToFirst(firstRoute);
    // }, [menuList]);

    // const routeToFirst = (firstRoute: string) => {
    //   firstRoute &&
    //   // new RegExp(`${BASE_FRONT_ROUTE_PREFIX}\/?$`).test(location.pathname) &&
    //   menuRef.current?.routeTo(firstRoute);
    // };

    // 深度遍历 找到菜单
    const getFirstRoute = (menuList: MenuData[]): string => {
        let routerPath = '';
        if (!menuList.length) return routerPath;
        for (let i = 0; i < menuList.length; i++) {
            const item = menuList[i];
            const stack: MenuData[] = [];
            stack.push(item);
            while (stack.length > 0) {
                var curItem = stack.shift() as MenuData;
                if (curItem.type === 1) {
                    //菜单级 key由父级id跟路由/随机值组成
                    const router = (() => {
                        if (curItem.router) {
                            return curItem.router;
                        }
                        if (curItem.link) {
                            const link =
                                curItem.link.indexOf('http') === 0
                                    ? curItem.link
                                    : 'http://' + curItem.link + '/';
                            return `/view/frame/${curItem.id}?link=${encodeURIComponent(
                                link,
                            )}`;
                        }
                        return '#' + uuidv4(); //link形式，无前端路由
                    })();

                    curItem.key = `${
                        curItem.path?.slice?.(2) || item.id || ''
                    }_${router}`;

                    locationMap.set(BASE_FRONT_ROUTE_PREFIX + router, curItem.key);
                    !routerPath && !router.includes('#') && (routerPath = curItem.key);
                }
                if (curItem.children) {
                    for (const children of curItem.children) {
                        stack.push(children);
                    }
                }
            }
        }
        setMenuData(menuList);
        originMenuData.current = cloneDeep(menuList);
        return routerPath;
    };
    const reset = () => {
        setMenuData(originMenuData.current);
    };
    // const setOpen = (openKeys: string[])=> {
    //   menuRef.current?.handleOpen(openKeys);
    // }

    return (
        <>
            <SearchMenu
                menuTree={originMenuData.current}
                setMenuData={setMenuData}
                reset={reset}
            />
            <Menu menuTree={menuData} ref={menuRef}/>
        </>
    );
};

export default MainMenu;
