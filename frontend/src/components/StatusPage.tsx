import React, { FC } from 'react';
import { Result, Button } from 'antd';
import { history } from '@umijs/max';

interface StatusPageProps {
  status: 'success' | 'error' | 'info' | 'warning' | 404 | 403 | 500;
  subTitle: string;
  backUrl: string;
}

const StatusPage: FC<StatusPageProps> = ({
  status,
  subTitle = '页面找不到',
  backUrl = '/',
}) => {
  const goBack = (url: string) => {
    history.push(url);
  };

  return (
    <Result
      status={status}
      title={status}
      subTitle={subTitle}
      extra={
        <Button type="primary" onClick={() => goBack(backUrl)}>
          返回
        </Button>
      }
    />
  );
};

export default StatusPage;
