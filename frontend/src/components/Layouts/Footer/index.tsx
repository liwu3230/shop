import React, {FC} from 'react';
import {Layout} from 'antd';
import {GithubOutlined} from '@ant-design/icons';
import {COPY_RIGHT} from '@/constants';
import '@/components/AmisOpsTag/index';
import styles from './index.less';

const {Footer} = Layout;

const MyHeader: FC = (props) => {
  const links = [
    // {
    //   key: 'Ant Design Pro',
    //   title: 'Ant Design Pro',
    //   href: 'https://pro.ant.design',
    //   blankTarget: true,
    // },
    // {
    //   key: 'github',
    //   title: <GithubOutlined/>,
    //   href: 'https://github.com/ant-design/ant-design-pro',
    //   blankTarget: true,
    // },
    // {
    //   key: 'Ant Design',
    //   title: 'Ant Design',
    //   href: 'https://ant.design',
    //   blankTarget: true,
    // },
  ];

  return (
    <>
      <Footer className={styles.footer}>
        {links && (
          <div className={styles.links}>
            {links.map(link => (
              <a
                key={link.key}
                title={link.key}
                target={link.blankTarget ? '_blank' : '_self'}
                href={link.href}
              >
                {link.title}
              </a>
            ))}
          </div>
        )}
        {COPY_RIGHT && <div className={styles.copyright}>{COPY_RIGHT}</div>}
      </Footer>
    </>
  );
};

export default MyHeader;
