import {BASE_ROUTE_PREFIX} from '@/constants';
import {ApiObject} from "amis/lib/types";

const initSchema = (isBatch: boolean) => (
  {
    title: isBatch ? '批量审批' : '单条审批',
    size: 'md',
    body: [
      {
        type: 'form',
        title: "用户上传信息",
        className: "m-t",
        mode: "horizontal",
        reload: 'auditTaskOrder',
        body: [
          {
            type: "static",
            name: "uploadExt",
            label: "提交说明：",
            hidden: isBatch,
          },
          {
            type: "static-images",
            thumbRatio: "16:9",
            thumbMode: "cover",
            enlargeAble: true,
            name: "uploadAttIdList",
            label: "提交资料：",
            hidden: isBatch,
          },
          {
            type: 'textarea',
            name: 'comment',
            label: '审批意见：',
            required: false,
            clearable: true,
            placeholder: '请输入',
            value: ""
          },
        ],
        messages: {
          saveSuccess: "审批成功",
          saveFailed: "审批失败"
        },
      }
    ],
    actions: [
      {
        type: "button",
        label: "不同意",
        actionType: "submit",
        level: "danger",
        className: "m-r-xs",
        api: {
          url: `${BASE_ROUTE_PREFIX}/taskOrder/audit`,
          method: 'post',
          data: {
            ids: '$ids',
            id: '$id',
            uploadAuditState: 2,
            uploadAuditRemark: '$comment',
          },
          requestAdaptor: (api: ApiObject) => {
            return {
              ...api,
              data: {
                ...api.data,
                ids: api.data?.ids ? api.data?.ids.split(',') : [],
              },
            };
          },
        },
      },
      {
        type: "button",
        label: "同意",
        actionType: "submit",
        level: "primary",
        className: "m-r-sm",
        api: {
          url: `${BASE_ROUTE_PREFIX}/taskOrder/audit`,
          method: 'post',
          data: {
            ids: '$ids',
            id: '$id',
            uploadAuditState: 1,
            uploadAuditRemark: '$comment',
          },
          requestAdaptor: (api: ApiObject) => {
            return {
              ...api,
              data: {
                ...api.data,
                ids: api.data?.ids ? api.data?.ids.split(',') : [],
              },
            };
          },
        },
      }
    ]
  }
);

export default initSchema;
