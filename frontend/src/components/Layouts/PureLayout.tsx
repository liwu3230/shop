import React from 'react';
import { WithExceptionOpChildren } from '@/components/Exception';
import { useLocation, IRoute,Outlet  } from '@umijs/max';
import { getCurRouteMeta } from '@/utils';
import { routes } from '@/routes';

const PureLayout: React.FC = (props) => {
  const current = useLocation();
  const pathCfg = getCurRouteMeta(current.pathname, routes as IRoute[]);
  return (
    <div>
      <WithExceptionOpChildren currentPathConfig={pathCfg}>
          <Outlet />
      </WithExceptionOpChildren>
    </div>
  );
};

export default PureLayout;
