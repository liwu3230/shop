import React, {FC} from 'react';
import {WithExceptionOpChildren} from '@/components/Exception';
import {ConfigProvider, Layout, Modal} from 'antd';
import {IRoute, useLocation, useModel,Outlet} from '@umijs/max';
import zhCN from 'antd/es/locale/zh_CN';
import {getCurRouteMeta} from '@/utils';
import {IS_LIGHT_STYLE} from '@/constants';
import {routes} from '@/routes';
import {AlertComponent, ToastComponent} from 'amis';
import ReSizer from '../ReSizer';
import '@/components/AmisOpsTag/index';
import MyMenu from '../Menu/index';
import MyBreadcrumb from '../Breadcrumb/index';
import MyHeader from '../Header/index';
import styles from './index.less';

const {Sider, Content} = Layout;

const BaseLayout: FC = (props) => {
  const current = useLocation();
  const pathCfg = getCurRouteMeta(current.pathname, routes as IRoute[]);
  ConfigProvider.config({
    prefixCls: 'ant-cmdb', //设置 Modal、Message、Notification rootPrefixCls
  });
  const {collapsible, siderRef} = useModel('sider');

  return (
    <ConfigProvider prefixCls="ant-cmdb" locale={zhCN}>
      <Layout>
        <MyHeader/>
        <Layout
          className={styles.container} hasSider
        >
          <Sider
            ref={siderRef}
            className={styles.sider}
            style={{display: collapsible ? 'none' : 'block'}}
            theme={IS_LIGHT_STYLE ? 'light' : 'dark'}
          >
            <MyMenu/>
          </Sider>
          <ReSizer/>
          <Layout>
            {/*<Breadcrumb style={{ margin: '16px 0' }}>*/}
            {/*  <Breadcrumb.Item>Home</Breadcrumb.Item>*/}
            {/*  <Breadcrumb.Item>List</Breadcrumb.Item>*/}
            {/*  <Breadcrumb.Item>App</Breadcrumb.Item>*/}
            {/*</Breadcrumb>*/}
            <MyBreadcrumb/>
            <Content className={styles.content}>
              <WithExceptionOpChildren currentPathConfig={pathCfg}>
                <Outlet />
              </WithExceptionOpChildren>
            </Content>
          </Layout>


        </Layout>
        {/* Amis toast、alert 提示组件 */}
        <ToastComponent key="toast" position={'top-right'}/>
        <AlertComponent key="alert"/>
      </Layout>
    </ConfigProvider>
  );
};

export default BaseLayout;
