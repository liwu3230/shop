import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {useLocation, useModel} from '@umijs/max';
import {BASE_ROUTE_PREFIX} from '@/constants';

const Overview = () => {
  const [schema, setSchema] = useState(null as any);
  const {permissionList} = useModel('auth')
  const [breadCrumb, setBreadCrumb] = useState([]);
  const [loading, setLoading] = useState(true);

  const id = new URLSearchParams(useLocation().search).get('id');
  const title = new URLSearchParams(useLocation().search).get('title');
  const sourceData = JSON.parse(
    new URLSearchParams(useLocation().search).get('source') as string,
  )

  const genSchema = async () => {
    try {
      setLoading(true);
      setSchema({
        body: {
          type: 'form',
          reload: 'taskInfo',
          api: {
            url: `${BASE_ROUTE_PREFIX}/taskInfo/saveOrUpdate`,
            method: 'post',
            data: {
              '&': '$$',
              id: '$id',
              data: '$data',
            },
          },
          messages: {
            saveSuccess: "",
            saveFailed: "操作失败"
          },
          controls: [
            {
              type: 'select',
              name: 'pid',
              label: '所属项目：',
              searchable: true,
              clearable: true,
              value: 0,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/project/findAll?authEnabled=true`,
                method: 'get',
                data: {},
              },
            },
            {
              type: 'text',
              name: 'name',
              label: '任务名称',
              required: true,
              clearable: true,
              placeholder: '请输入',
            },
            {
              type: 'input-number',
              name: 'price',
              label: '任务金额',
              prefix: "￥",
              required: true,
              clearable: true,
              placeholder: '请输入',
            },
            {
              type: 'select',
              name: 'tagId',
              label: '任务标签：',
              searchable: true,
              clearable: true,
              multiple: true,
              value: 0,
              labelField: 'name',
              valueField: 'id',
              source: {
                url: `${BASE_ROUTE_PREFIX}/project/findAll?authEnabled=true`,
                method: 'get',
                data: {},
              },
            },
            {
              type: 'input-datetime',
              name: 'acceptDeadlineTime',
              label: '承接截止时间',
              format: 'YYYY-MM-DD HH:mm:ss',
              clearable: true,
              // value: '+24hours'
            },
            {
              type: 'input-datetime',
              name: 'doneDeadlineTime',
              label: '完成截止时间',
              format: 'YYYY-MM-DD HH:mm:ss',
              clearable: true,
              // value: '+24hours'
            },
            {
              type: 'number',
              name: 'sort',
              value: 1,
              label: '排序',
              required: false,
              placeholder: '请输入',
            },
            {
              type: 'input-image',
              name: 'image',
              label: '任务封面',
              placeholder: '请输入',
              required: true,
              receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
            },
            {
              type: 'input-rich-text',
              name: 'content',
              label: '其他要求',
              placeholder: '请输入',
              receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
              videoReceiver: `${BASE_ROUTE_PREFIX}/file/upload`,
              size: 'lg',
              options: {
                height: 500,
              }
            }
          ],
        },
        data: {
          id,
          ...sourceData,
        },
      });
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    genSchema();
  }, []);

  return (
    <div>
      {loading && 'loading...'}
      {schema && (
        <>
          {/*<Breadcrumb style={{ padding: '12px', paddingBottom: 0 }}>*/}
          {/*  <Breadcrumb.Item>{breadCrumb[0]}</Breadcrumb.Item>*/}
          {/*  <Breadcrumb.Item>*/}
          {/*    <Link to={`/dataview/crud/${id}`} style={{ color: '#5ca3ff' }}>*/}
          {/*      {breadCrumb[1]}*/}
          {/*    </Link>*/}
          {/*  </Breadcrumb.Item>*/}
          {/*  {pageTitle && <Breadcrumb.Item>{pageTitle}</Breadcrumb.Item>}*/}
          {/*</Breadcrumb>*/}
          <AmisRenderer schema={schema}/>
        </>
      )}
    </div>
  );
};

export default Overview;
