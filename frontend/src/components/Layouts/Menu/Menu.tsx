import React, {forwardRef, useImperativeHandle, useState} from 'react';
import {Menu} from 'antd';
import {history} from '@umijs/max';
import {MenuInfo} from 'rc-menu/lib/interface';
import {BASE_FRONT_ROUTE_PREFIX, IS_LIGHT_STYLE} from '@/constants';
import {MenuData} from './index';
import './menu.less';

const {SubMenu, Item: MenuItem} = Menu;

interface menuProps {
    menuTree: MenuData[];
}

export interface MenuHandle {
    routeTo: (str: string, search?: string) => void;
    handleOpen: (openKeys: string[]) => void;
}

const MyMenu = forwardRef((props: menuProps, ref) => {
    const [current, setCurrent] = useState('');
    const [open, setOpen] = useState<string[]>([]);

    useImperativeHandle(ref, () => ({
        routeTo: (str: string, search?: string) => {
            routeTo(str, search);
        },
        // handleOpen: (openKeys: string[]) => {
        //   handleOpen(openKeys);
        // }
    }));

    const routeTo = (str: string, search = '') => {
        const router = str.split('_'),
            randomId = str.split('#')[1];
        if (!randomId && router[1]) {
            history.push(`${BASE_FRONT_ROUTE_PREFIX}${router[1]}${search}`);
        } else {
            history.push(`${BASE_FRONT_ROUTE_PREFIX}/404`);
        }
        setCurrent(str);
        const openKeys = (router[0] && router[0].split('.')) || [];
        openKeys.length && setOpen(openKeys);
    };
    const handleOpen = (openKeys: string[]) => {
        setOpen(openKeys);
    };
    const handleClick = (e: MenuInfo) => {
        const props = e.item.props;
        if (props.opentype === 3) {
            const link =
                props.link.indexOf('http') === 0
                    ? props.link
                    : 'http://' + props.link + '/';
            window.open(link, '_blank');
            return;
        }
        routeTo(e.key);
    };

    const getMenu = (menu: MenuData) => {
        if (!menu.visible) {
            return null;
        }
        return (
            <React.Fragment key={`${menu.id}`}>
                {menu.children?.length ? (
                    <SubMenu
                        key={`${menu.id}`}
                        title={menu.name}
                        icon={menu.icon ? <i className={menu.icon}/> : null}
                    >
                        {menu.children.map((child) => getMenu(child))}
                    </SubMenu>
                ) : (
                    <MenuItem
                        key={`${menu.key}`}
                        icon={menu.icon ? <i className={menu.icon}/> : null}
                        opentype={menu.openType}
                        link={menu.link}
                    >
                        {menu.name}
                    </MenuItem>
                )}
            </React.Fragment>
        );
    };
    return (
        <Menu
            className="menu-container"
            style={{
                height: 'calc(100vh - 95px)',
                overflowY: 'auto',
                overflowX: 'hidden',
            }}
            onClick={handleClick}
            selectedKeys={[current]}
            onOpenChange={handleOpen}
            openKeys={open}
            theme={IS_LIGHT_STYLE ? 'light' : 'dark'}
            mode="inline"
        >
            {props.menuTree.map((item: MenuData) => getMenu(item))}
        </Menu>
    );
});

export default MyMenu;
