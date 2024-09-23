import React from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {convertOptionsToMap, useQuery} from '@/utils';
import {useParams} from '@umijs/max';
import {BASE_ROUTE_PREFIX} from '@/constants';
import {flowableCommentList} from "@/constants/enums";
import {getProcessFormSchema, getBpmnHeight} from "@/pages/Process/Form/config";

export default () => {
  const {procDefName} = useParams<{ procDefName: string }>();
  const query = useQuery();
  const procInsId = query.procInsId;
  const procDefKey = query.procDefKey;
  const getListProcessActivityUrl = `${BASE_ROUTE_PREFIX}/flowable/task/queryProcessActivity?procInsId=${query.procInsId}`;

  const schema = {
    // 这里是 amis 的 Json 配置。
    type: 'page',
    title: '',
    initApi: getListProcessActivityUrl,
    interval: 15000,
    stopAutoRefreshWhen: 'this.caseStatus !== 0',
    body: [
      {
        type: 'wrapper',
        className: 'relative',
        body: [
          getProcessFormSchema(procInsId, procDefKey),
          {
            type: "panel",
            title: "流程图",
            body: [
              // {
              //   type: 'tpl',
              //   tpl: '流程[${flowName}]',
              //   className: 'absolute top-1 text-gray-400',
              // },
              {
                type: 'bpmn-viewer',
                height: getBpmnHeight(procDefKey),
              },
            ]
          },
          {
            type: 'table',
            source: '$flowList',
            columns: [
              {
                label: '节点ID',
                name: 'taskId',
              },
              {
                label: '节点名',
                name: 'taskName',
              },
              {
                label: '实际办理',
                name: 'assigneeName',
              },
              {
                label: '候选办理',
                name: 'candidate',
              },
              {
                label: '接收时间',
                name: 'createTime',
              },
              {
                label: '处理时间',
                name: 'finishTime',
              },
              {
                label: '意见类型',
                name: 'comment.type',
                type: 'mapping',
                map: convertOptionsToMap(flowableCommentList),
              },
              {
                label: '意见内容',
                name: 'comment.comment',
              },
            ],
          },
        ],
      },
    ],
  };
  return <div>{schema && <AmisRenderer schema={schema}></AmisRenderer>}</div>;
};
