import React, {FC, useState} from 'react';
import {BellOutlined, ExclamationCircleOutlined, LogoutOutlined, UserOutlined} from '@ant-design/icons';
import {Badge, Dropdown, Layout, Menu, message, Modal, Space} from 'antd';
import {useModel} from '@umijs/max';
import {LOGO_PATH, SITE_NAME} from '@/constants';
import '@/components/AmisOpsTag/index';
import {Link} from "react-router-dom";
import styles from './index.less';
import {MenuInfo} from "rc-menu/lib/interface";
import UpdatePassword from './UpdatePassword';
import {updatePassword} from '@/api/common';
import {jumpToLogin, jumpToToDo} from '@/utils/common';

const {Header} = Layout;
const {confirm} = Modal;

const MyHeader: FC = (props) => {
  const [modalVisible, setModalVisible] = useState(false);

  const {currentUser, todoCount} = useModel('auth');

  const handleClick = (e: MenuInfo) => {
    if (e.key === 'updatePassword') {
      changeModal(true);
      return;
    }
    if (e.key === 'logout') {
      confirm({
        title: '提示',
        icon: <ExclamationCircleOutlined/>,
        content: '是否确定退出登录？',
        onOk() {
          localStorage.removeItem("x-access-token");
          jumpToLogin();
        },
        onCancel() {
        },
      });
    }
  };

  const changeModal = (visible: boolean) => {
    setModalVisible(visible);
  };

  const handleUpdatePassword = async (params: PlainObject) => {
    if (params.password !== params.confirmPassword) {
      message.warning('两次输入的密码不一致');
      return
    }
    const result = await updatePassword(params);
    if (result && result.code === 0) {
      message.success('密码修改成功，请重新登录');
      localStorage.removeItem("x-access-token");
      jumpToLogin();
      changeModal(false);
    }
  };

  const userInfoMenu = (
    <Menu className={styles.user_info__menu} onClick={handleClick}>
      <Menu.Item key="updatePassword" className={styles.user_info__menu__item}
                 icon={<UserOutlined className={styles.user_info__menu__icon}/>}>
        修改密码
      </Menu.Item>
      <Menu.Item key="logout" className={styles.user_info__menu__item}
                 icon={<LogoutOutlined className={styles.user_info__menu__icon}/>}>
        退出登录
      </Menu.Item>
    </Menu>
  );

  return (
    <>
      <Header style={{position: 'fixed', zIndex: 1, width: '100%'}} className={styles.header}>
        <div className={styles.header__title}>
          <div className={styles.icon_img_box}>
            <Link to='/' className={styles.link_logo}>
              <img src={LOGO_PATH} className={styles.icon_svg}/>
              <Space className={styles.logo_title}>{SITE_NAME}</Space>
            </Link>
          </div>
        </div>

        <div className={styles.middle_blank}></div>

        <div className={styles.right}>

          {/*<div className={styles.notice} onClick={jumpToToDo}>*/}
          {/*  <Badge count={todoCount} style={{boxShadow: 'none'}} offset={[-6, 0]}*/}
          {/*         className={styles.notice__badge}>*/}
          {/*    <div className={styles.notice__icon}>*/}
          {/*      <BellOutlined/>*/}
          {/*    </div>*/}
          {/*  </Badge>*/}
          {/*</div>*/}

          <div className={styles.user_info}>
            <Dropdown className={styles.user_info__dropdown} overlay={userInfoMenu} placement="bottomRight" arrow>
              <a onClick={e => e.preventDefault()}>
                <div className={styles.user_info__icon}>
                  <UserOutlined/>
                </div>
                {/*<span className={styles.user_info__name}>{currentUser.userName}</span>*/}
              </a>
            </Dropdown>

            {modalVisible ? (
              <Modal
                title="修改密码"
                maskClosable={false}
                visible={modalVisible}
                onCancel={() => changeModal(false)}
                footer={null}
              >
                <UpdatePassword
                  onCancel={() => changeModal(false)}
                  onSubmit={handleUpdatePassword}/>
              </Modal>
            ) : (
              ''
            )}
          </div>
        </div>
      </Header>
    </>
  );
};

export default MyHeader;
