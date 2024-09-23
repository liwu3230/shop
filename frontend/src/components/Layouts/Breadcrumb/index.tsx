import React, {Component} from 'react';
import {Breadcrumb} from 'antd';
import {withRouter} from "umi";
import { history } from '@umijs/max';
import {BASE_FRONT_ROUTE_PREFIX} from '@/constants';
import {findBreadcrumb} from '@/api/common';
import styles from './index.less';

const breadcrumbNameMap = new Map();
breadcrumbNameMap.set(BASE_FRONT_ROUTE_PREFIX, "首页");

let UNLISTEN = null;

export interface BreadcrumbData {
  name: string;
  router: string;
  fullRouter: string;
}

class MyBreadcrumb extends Component {

  constructor(props?: any) {
    super(props);
    this.state = {
      pathSnippets: null,
      extraBreadcrumbItems: null
    }
  }

  getPath = () => {
    const path = history.location.pathname;
    const breadcrumbItems = breadcrumbNameMap.get(path) as BreadcrumbData[];
    if (!breadcrumbItems || breadcrumbItems.length <= 0) {
      // 将这个结果，更新到页面
      this.setState({
        extraBreadcrumbItems: []
      })
      return [];
    }
    const elements: PlainObject[] = [];
    breadcrumbItems.forEach((item) => {
      if (item.router) {
        item.fullRouter = BASE_FRONT_ROUTE_PREFIX + item.router;
        elements.push(
          <Breadcrumb.Item href={item.fullRouter} key={item.name}>
            {item.name}
          </Breadcrumb.Item>
        )
      } else {
        elements.push(
          <Breadcrumb.Item key={item.name}>
            {item.name}
          </Breadcrumb.Item>
        )
      }
    });

    // 将这个结果，更新到页面
    this.setState({
      extraBreadcrumbItems: elements
    })
  }

  queryBreadcrumb = async () => {
    const result = await findBreadcrumb();
    if (result && result.code === 0) {
      const resMap = result.data || {};
      Object.keys(resMap).forEach((key) => {
        const value = resMap[key];
        breadcrumbNameMap.set(BASE_FRONT_ROUTE_PREFIX + key, value);
      });
    }
  };

  componentDidMount() {
    this.queryBreadcrumb().then((e) => {
      this.getPath();
      // 监听路由产生变化
      UNLISTEN = history.listen(() => {
        this.getPath()
      })
    });
  }

  componentWillUnmount() {
    UNLISTEN && UNLISTEN();
  }

  render() {
    return (
      this.state.extraBreadcrumbItems?.length ?
        <Breadcrumb separator=">" className={styles.breadcrumb}>
          {this.state.extraBreadcrumbItems}
        </Breadcrumb> : <></>
    )
  }
}

export default withRouter(MyBreadcrumb)
