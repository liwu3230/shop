import React, {FC, useState} from 'react';
import {BellOutlined, ExclamationCircleOutlined, LogoutOutlined, UserOutlined} from '@ant-design/icons';
import type {MenuProps} from 'antd';
import {Avatar, Badge, Card, Dropdown, Empty, Layout, List, message, Modal, Space} from 'antd';
import {useModel} from '@umijs/max';
import {LOGO_PATH, SITE_NAME} from '@/constants';
import '@/components/AmisOpsTag/index';
import {Link} from "react-router-dom";
import styles from './index.less';
import UpdatePassword from './UpdatePassword';
import {allReadNotice, updatePassword} from '@/api/common';
import {jumpToLogin, jumpToUrl} from '@/utils/common';

const {Header} = Layout;
const {confirm} = Modal;

const MyHeader: FC = (props) => {
  const [modalVisible, setModalVisible] = useState(false);

  // const {currentUser, todoCount} = useModel('auth');
  const {newsList, setNewsList} = useModel('news');

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

  const personItems: MenuProps['items'] = [
    {
      label: '修改密码',
      key: 'updatePassword',
      icon: <UserOutlined className={styles.user_info__menu__icon}/>,
    },
    {
      label: '退出登录',
      key: 'logout',
      icon: <LogoutOutlined className={styles.user_info__menu__icon}/>,
    }
  ];

  const handleMenuClick: MenuProps['onClick'] = (e) => {
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

  // 全部已读
  const handleAllReadClick = async () => {
    const result = await allReadNotice();
    if (result && result.code === 0) {
      setNewsList([])
    }
  }

  const getIconSrc = (type: string) => {
    return require(`@/assets/images/news-${type}.png`);
  }

  const newsItems = (
    <Card className={styles.message_card} title="系统通知"
          extra={<a onClick={e => {
            e.preventDefault();
            handleAllReadClick().then()
          }}>{newsList?.length ? "全部已读" : ""}</a>} bordered={true} size="small"
          style={{width: 340}}>
      <List size="small" style={{cursor: 'pointer'}}
            dataSource={newsList} split={false}
            locale={{emptyText: <Empty image={Empty.PRESENTED_IMAGE_DEFAULT} description={"暂无通知"}/>}}
            renderItem={(item) => (
              <a onClick={e => {
                e.preventDefault();
                jumpToUrl(item.url)
              }}>
                <List.Item>
                  <List.Item.Meta
                    avatar={<Avatar src={getIconSrc(item.type)}/>}
                    title={item.title}
                    description={item.desc}
                  />
                </List.Item>
              </a>
            )}
      />
    </Card>
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

          <div className={styles.message}>
            <Dropdown className={styles.message__dropdown}
                      dropdownRender={(menu) => (newsItems)}
                      placement="bottomRight" arrow>
              <a onClick={e => e.preventDefault()}>
                <Badge dot={!!newsList?.length} className={styles.message__badge}
                       style={{boxShadow: 'none'}}
                       offset={[-14, 0]}>
                  <BellOutlined className={styles.message__icon}/>
                </Badge>
              </a>
            </Dropdown>
          </div>

          <div className={styles.user_info}>
            <Dropdown className={styles.user_info__dropdown} menu={{
              items: personItems,
              onClick: handleMenuClick,
            }} placement="bottomRight" arrow>
              <a onClick={e => e.preventDefault()}>
                <UserOutlined className={styles.user_info__icon}/>
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
