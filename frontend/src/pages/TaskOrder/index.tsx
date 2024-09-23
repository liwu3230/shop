import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {useQuery} from '@/utils';
import Audit from './Audit';
import WaitAward from './WaitAward';
import AwardFinish from './AwardFinish';
import All from './All';

const Detail = () => {
  const [schema, setSchema] = useState<SchemaObject>();
  const query = useQuery();

  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: [
        {
          type: 'page',
          data: {
            name: query.name,
            isHide: query.isHide === '1' ? true : false,
          },
          body: {
            type: 'tabs',
            tabs: [
              {
                title: '待审批订单',
                body: Audit,
                className: 'wrapper-xs',
              },
              {
                title: '已完成待奖励订单',
                body: WaitAward,
                className: 'wrapper-xs',
              },
              {
                title: '已奖励订单',
                body: AwardFinish,
                className: 'wrapper-xs',
              },
              {
                title: '全部订单',
                body: All,
                className: 'wrapper-xs',
              },
            ],
          },
        },
      ],
    };

    return schema;
  };

  useEffect(() => {
    (async () => {
      // 路由query变更后，使页面刷新
      setSchema({
        type: 'page',
        body: '',
      });
      const schema = await genSchema();
      setSchema(schema);
    })();
  }, [query.name, query.isHide]);

  return <div>{schema && <AmisRenderer schema={schema}/>}</div>;
};

export default Detail;

