import React, {FC, useState} from 'react'
import {LockOutlined, UserOutlined,} from '@ant-design/icons';
import {Button, ConfigProvider, Form, Input, message} from 'antd';
import {history, useModel} from '@umijs/max';
import {LOGO_PATH, SITE_NAME} from '@/constants';
import {login} from '@/api/common';
import styles from './index.less';
import zhCN from "antd/es/locale/zh_CN";
import MyFooter from '@/components/Layouts/Footer/index';
import ReactCanvasNest from 'react-canvas-nest';

const Login: FC = (props) => {
  const {fetchCurrentUser, fetchPermissionList} = useModel('auth');
  const {fetchMenuList} = useModel('list');
  const [type] = useState<string>('account');
  ConfigProvider.config({
    prefixCls: 'ant-cmdb', //设置 Modal、Message、Notification rootPrefixCls
  });
  // canvasNest

  const handleSubmit = async (values: PlainObject) => {
    // 登录
    const result = await login({...values, type});
    if (result && result.code === 0) {
      message.success("登录成功！");
      localStorage.setItem("x-access-token", result.data?.data);
      await fetchCurrentUser();
      await fetchMenuList();
      await fetchPermissionList();
      const urlParams = new URL(window.location.href).searchParams;
      history.push(urlParams.get('redirect') || '/');
      return;
    }
  };

  return (
    <ConfigProvider prefixCls="ant-cmdb" locale={zhCN}>

      <div className={styles.container}>
        {/*粒子联结特效*/}
        <ReactCanvasNest className='canvasNest' config={{
          lineColor: '0, 0, 0',
          lineWidth: 1,
          pointColor: '114, 114, 114',
          count: 88,
        }} style={{zIndex: 99}}/>
        <div className={styles.form}>
          <div className={styles.logo}>
            <img alt="logo" src={LOGO_PATH}/>
            <span>{SITE_NAME}</span>
          </div>
          <div>
            <Form
              style={{width: "350px",}}
              name="normal_login"
              initialValues={{remember: true}}
              onFinish={async (values) => {
                await handleSubmit(values);
              }}
            >
              <Form.Item
                name="userName"
                rules={[{required: true, message: '请输入用户名！'}]}
              >
                <Input className={styles.form_radius}
                       size={'large'}

                       prefix={<UserOutlined className="site-form-item-icon"/>}
                       allowClear={true}
                       placeholder="用户名"/>
              </Form.Item>
              <Form.Item
                name="password"
                rules={[{required: true, message: '请输入密码！'}]}
              >
                <Input.Password
                  className={styles.form_radius}
                  size={'large'}
                  prefix={<LockOutlined className="site-form-item-icon"/>}
                  type="password"
                  placeholder="密码"
                  allowClear={true}
                />
              </Form.Item>

              {/*<div style={{marginBottom: 24,}}>*/}
              {/*  <Form.Item>*/}
              {/*    <Form.Item name="remember" valuePropName="checked" noStyle>*/}
              {/*      <Checkbox>自动登录</Checkbox>*/}
              {/*    </Form.Item>*/}

              {/*    <a style={{float: "right",}} href="">*/}
              {/*      忘记密码*/}
              {/*    </a>*/}
              {/*  </Form.Item>*/}
              {/*</div>*/}

              <Form.Item>
                <Button type="primary" className={styles.form_radius} block={true}
                        htmlType="submit" size={'large'}>
                  登录
                </Button>
              </Form.Item>
            </Form>

          </div>
        </div>
        <div className={styles.footer}>
          <MyFooter/>
        </div>
      </div>
    </ConfigProvider>
  );
};

export default Login;
