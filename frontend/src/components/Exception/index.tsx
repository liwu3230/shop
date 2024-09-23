import React from 'react';
import { history, Navigate } from '@umijs/max';
import { Result, Button } from 'antd';

export interface IRouteLayoutConfig {
  hideMenu?: boolean;
  hideNav?: boolean;
  hideFooter?: boolean;
  [key: string]: any;
}

function backToHome() {
  history.push('/');
}

const Exception404 = () => (
  <Result
    status="404"
    title="404"
    subTitle="抱歉，你访问的页面不存在"
    extra={
      <Button type="primary" onClick={backToHome}>
        返回首页
      </Button>
    }
  />
);

const Exception403 = () => (
  <Result
    status="403"
    title="403"
    subTitle="抱歉，你无权访问该页面"
    extra={
      <Button type="primary" onClick={backToHome}>
        返回首页
      </Button>
    }
  />
);

const WithExceptionOpChildren: React.FC<{
  currentPathConfig?: IRouteLayoutConfig;
  children: any;
}> = (props) => {
  const { children, currentPathConfig } = props;
  if (!currentPathConfig) {
    return <Exception404 />;
  }

  if (currentPathConfig.unaccessible) {
    return <Exception403 />;
  }

  return children;
};

export default WithExceptionOpChildren;
export { Exception404, Exception403, WithExceptionOpChildren };
