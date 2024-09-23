import {BASE_ROUTE_PREFIX} from '@/constants';
import {ApiObject} from "amis/lib/types";

const initSchema = () => ({
  title: "<%= data.id ? '编辑任务' : '新增任务' %>",
  size: 'lg',
  body: {
    type: 'form',
    reload: 'taskInfo',
    mode: 'normal',
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
      // {
      //   type: 'input-image',
      //   name: 'image',
      //   label: '封面',
      //   placeholder: '请输入',
      //   required: false,
      //   receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
      // },
      {
        type: "group",
        className: "m-t-lg",
        body: [
          {
            type: 'select',
            name: 'pid',
            label: '所属项目:',
            searchable: true,
            required: true,
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
            type: 'input-text',
            name: 'name',
            label: '任务名称:',
            required: true,
            clearable: true,
            placeholder: '请输入',
          },
        ]
      },
      {
        type: "group",
        className: "m-t-lg",
        body: [
          {
            type: 'select',
            name: 'tagId',
            label: '任务标签:',
            searchable: true,
            clearable: true,
            multiple: true,
            value: 0,
            labelField: 'name',
            valueField: 'id',
            source: {
              url: `${BASE_ROUTE_PREFIX}/taskTag/findAll`,
              method: 'get',
              data: {},
            },
          },
          {
            type: 'input-number',
            name: 'price',
            label: '任务金额:',
            prefix: "￥",
            required: true,
            clearable: true,
            precision: 2,
            placeholder: '请输入',
          },
        ]
      },
      {
        type: "group",
        className: "m-t-lg",
        body: [
          {
            type: 'input-datetime',
            name: 'acceptDeadlineTime',
            label: '领取截止时间:',
            format: 'YYYY-MM-DD HH:mm:ss',
            clearable: true,
            // value: '+24hours'
          },
          {
            type: 'input-datetime-range',
            name: 'taskBeginTime',
            extraName: "taskEndTime",
            label: '任务时间:',
            format: 'YYYY-MM-DD HH:mm:ss',
            clearable: true,
            required: true,
            // value: '+24hours'
          },
        ]
      },
      {
        type: "divider",
        title: "任务派发限制条件",
        titlePosition: "center",
        color: " #007bff"
      },
      {
        type: "group",
        className: "m-t-lg",
        body: [
          {
            type: 'input-text',
            name: 'maxSendDistance',
            label: '任务派发最大距离:',
            required: true,
            value: 30000,
            suffix: "米",
            validations: {
              isInt: true
            },
            placeholder: '请输入',
            labelRemark: "小于或等于0则不限制",
          },
          {
            type: 'input-text',
            name: 'minStoreGapDay',
            label: '同一用户同一门店派发间隔时间:',
            required: true,
            value: 180,
            suffix: "天",
            validations: {
              isInt: true
            },
            placeholder: '请输入',
            labelRemark: "小于或等于0则不限制",
          },
          {
            type: 'input-number',
            name: 'maxStoreNum',
            label: '同一用户最大派发门店数量:',
            required: true,
            value: 10,
            placeholder: '请输入',
            labelRemark: "小于或等于0则不限制",
          },
          {
            type: 'input-number',
            name: 'maxAcceptNum',
            label: '同一用户可接受最大订单数量:',
            required: true,
            value: 3,
            placeholder: '请输入',
            labelRemark: "小于或等于0则不限制",
          },
        ]
      },
      {
        type: 'condition-builder',
        label: '任务派发条件:',
        name: 'sendCondition',
        description: '指定标签组合条件限制任务派发，「且」表示多个条件同时满足，「或」表示至少有一个条件满足',
        showANDOR: true,
        builderMode: 'simple',
        fields: [
          {
            type: 'select',
            name: 'tagId',
            label: '用户标签',
            searchable: true,
            source: {
              url: `${BASE_ROUTE_PREFIX}/appUserTag/findAll`,
              method: 'get',
              adaptor:
                'return ({options: payload.map(item => ({label: item.name, value: item.id}))})',
            },
            operators: ['select_any_in', 'select_not_any_in'],
            defaultOp: 'select_any_in',
          },
        ]
      },
      {
        type: "divider",
        color: " #007bff"
      },
      // {
      //   type: 'input-number',
      //   name: 'sort',
      //   value: 1,
      //   label: '排序',
      //   required: false,
      //   placeholder: '请输入',
      // },
      {
        type: 'input-rich-text',
        name: 'content',
        label: '其他要求:',
        placeholder: '请输入',
        receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
        videoReceiver: `${BASE_ROUTE_PREFIX}/file/upload`,
        size: 'lg',
        options: {
          height: 500,
          convert_urls: false,
        }
      }
    ],
  }
});

export default initSchema;
