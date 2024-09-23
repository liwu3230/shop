import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX} from '@/constants';
import {useModel} from '@umijs/max';
import addIndexBanner from './addIndexBanner';
import addIndexMenu from "@/pages/Miniprogram/addIndexMenu";
import addAppUserMenu from "@/pages/Miniprogram/addAppUserMenu";
import addAppUserOrderMenu from "@/pages/Miniprogram/addAppUserOrderMenu";
import addIndexRoll from "@/pages/Miniprogram/addIndexRoll";
import addUserAgreement from "@/pages/Miniprogram/addUserAgreement";
import addTaskTip from "@/pages/Miniprogram/addTaskTip";
import addExam from "@/pages/Miniprogram/addExam";
import {convertOptionsToMap} from "@/utils";
import {examType} from "@/constants/enums";

const Overview = () => {
  const {permissionList} = useModel('auth');

  const [schema, setSchema] = useState<SchemaObject>();
  const genSchema = (): SchemaObject => {
    const schema: SchemaObject = {
      type: 'page',
      title: '',
      body: {
        type: "tabs",
        activeKey: "indexRoll",
        tabs: [
          // {
          //   title: "任务相关配置",
          //   hash: "taskConfig",
          //   reload: true,
          //   tab: {
          //     type: 'form',
          //     title: '',
          //     initApi: `${BASE_ROUTE_PREFIX}/sysConfig/findSingleByKey?key=taskConfig`,
          //     api: {
          //       url: `${BASE_ROUTE_PREFIX}/sysConfig/saveSingleByKey?key=taskConfig`,
          //       method: 'post',
          //       data: {
          //         '&': '$$',
          //       },
          //     },
          //     messages: {
          //       saveSuccess: "",
          //       saveFailed: "操作失败"
          //     },
          //     controls: [
          //       {
          //         type: 'number',
          //         name: 'storeUserSendDistance',
          //         label: '任务派发最大距离（米）',
          //         required: true,
          //         placeholder: '请输入',
          //       },
          //       {
          //         type: 'number',
          //         name: 'storeUserGapTime',
          //         label: '同一门店同一用户派发间隔时间（天）',
          //         placeholder: '请输入',
          //         required: true,
          //       },
          //       {
          //         type: 'number',
          //         name: 'projectUserStoreNums',
          //         label: '同一项目同一用户最大派发门店数量',
          //         required: true,
          //         placeholder: '请输入',
          //       },
          //       {
          //         type: 'number',
          //         name: 'userAcceptOfDayTaskNums',
          //         label: '同一用户同一任务可接受最大任务数量',
          //         required: true,
          //         placeholder: '请输入',
          //       },
          //     ],
          //   }
          // },
          {
            title: "首页公告通知",
            hash: "indexRoll",
            reload: true,
            tab: addIndexRoll()
          },
          {
            title: "首页轮播图",
            hash: "indexBanner",
            reload: true,
            tab: {
              type: 'crud',
              name: 'indexBannerList',
              api: {
                method: 'post',
                url: `${BASE_ROUTE_PREFIX}/sysConfig/findListByKey?key=indexBanner`,
                adaptor: 'return {\n  list: payload\n}',
              },
              loadDataOnce: true,
              source: '${list}',
              headerToolbar: [
                {
                  label: '新增',
                  type: 'button',
                  actionType: 'dialog',
                  level: 'primary',
                  dialog: addIndexBanner(),
                },
              ],
              columns: [
                {
                  type: "image",
                  name: "pic",
                  label: "图片",
                  thumbMode: "cover",
                  enlargeAble: true,
                  height: "80px",
                  width: "80px",
                },
                {
                  name: 'url',
                  label: '跳转链接',
                },
                {
                  name: 'sort',
                  label: '排序',
                },
                {
                  type: 'operation',
                  label: '操作',
                  buttons: [
                    {
                      label: '编辑',
                      type: 'button',
                      level: 'link',
                      actionType: 'dialog',
                      dialog: addIndexBanner(),
                    },
                    {
                      label: '删除',
                      type: 'button',
                      level: 'link',
                      className: 'text-danger',
                      actionType: 'dialog',
                      dialog: {
                        body: {
                          type: 'form',
                          api: `get:${BASE_ROUTE_PREFIX}/sysConfig/deleteListByUuid?key=indexBanner&uuid=$uuid`,
                          controls: [
                            {
                              type: 'tpl',
                              tpl: '您确认要删除吗？',
                            },
                          ],
                        },
                      },
                    },
                  ],
                },
              ],
            },
          },
          {
            title: "首页导航菜单",
            hash: "indexMenu",
            reload: true,
            tab: {
              type: 'crud',
              name: 'indexMenuList',
              api: {
                method: 'post',
                url: `${BASE_ROUTE_PREFIX}/sysConfig/findListByKey?key=indexMenu`,
                adaptor: 'return {\n  list: payload\n}',
              },
              loadDataOnce: true,
              source: '${list}',
              headerToolbar: [
                {
                  label: '新增',
                  type: 'button',
                  actionType: 'dialog',
                  level: 'primary',
                  dialog: addIndexMenu(),
                },
              ],
              columns: [
                {
                  name: 'name',
                  label: '标题',
                },
                {
                  type: "image",
                  name: "pic",
                  label: "图片",
                  thumbMode: "cover",
                  enlargeAble: true,
                  height: "40px",
                  width: "40px",
                },
                {
                  name: 'url',
                  label: '跳转链接',
                },
                {
                  name: 'sort',
                  label: '排序',
                },
                {
                  type: 'operation',
                  label: '操作',
                  buttons: [
                    {
                      label: '编辑',
                      type: 'button',
                      level: 'link',
                      actionType: 'dialog',
                      dialog: addIndexMenu(),
                    },
                    {
                      label: '删除',
                      type: 'button',
                      level: 'link',
                      className: 'text-danger',
                      actionType: 'dialog',
                      dialog: {
                        body: {
                          type: 'form',
                          api: `get:${BASE_ROUTE_PREFIX}/sysConfig/deleteListByUuid?key=indexMenu&uuid=$uuid`,
                          controls: [
                            {
                              type: 'tpl',
                              tpl: '您确认要删除吗？',
                            },
                          ],
                        },
                      },
                    },
                  ],
                },
              ],
            },
          },
          {
            title: "任务中心提示内容",
            hash: "taskTip",
            reload: true,
            tab: addTaskTip()
          },
          {
            title: "个人中心菜单",
            hash: "appUserMenu",
            reload: true,
            tab: {
              type: 'crud',
              name: 'appUserMenuList',
              api: {
                method: 'post',
                url: `${BASE_ROUTE_PREFIX}/sysConfig/findListByKey?key=appUserMenu`,
                adaptor: 'return {\n  list: payload\n}',
              },
              loadDataOnce: true,
              source: '${list}',
              headerToolbar: [
                {
                  label: '新增',
                  type: 'button',
                  actionType: 'dialog',
                  level: 'primary',
                  dialog: addAppUserMenu(),
                },
              ],
              columns: [
                {
                  name: 'name',
                  label: '标题',
                },
                {
                  type: "image",
                  name: "pic",
                  label: "图片",
                  thumbMode: "cover",
                  enlargeAble: true,
                  height: "40px",
                  width: "40px",
                },
                {
                  name: 'url',
                  label: '跳转链接',
                },
                {
                  name: 'sort',
                  label: '排序',
                },
                {
                  type: 'operation',
                  label: '操作',
                  buttons: [
                    {
                      label: '编辑',
                      type: 'button',
                      level: 'link',
                      actionType: 'dialog',
                      dialog: addAppUserMenu(),
                    },
                    {
                      label: '删除',
                      type: 'button',
                      level: 'link',
                      className: 'text-danger',
                      actionType: 'dialog',
                      dialog: {
                        body: {
                          type: 'form',
                          api: `get:${BASE_ROUTE_PREFIX}/sysConfig/deleteListByUuid?key=appUserMenu&uuid=$uuid`,
                          controls: [
                            {
                              type: 'tpl',
                              tpl: '您确认要删除吗？',
                            },
                          ],
                        },
                      },
                    },
                  ],
                },
              ],
            },
          },
          {
            title: "个人订单统计菜单",
            hash: "orderMenu",
            reload: true,
            tab: {
              type: 'crud',
              name: 'appUserOrderMenuList',
              api: {
                method: 'post',
                url: `${BASE_ROUTE_PREFIX}/sysConfig/findListByKey?key=appUserOrderMenu`,
                adaptor: 'return {\n  list: payload\n}',
              },
              loadDataOnce: true,
              source: '${list}',
              headerToolbar: [
                {
                  label: '新增',
                  type: 'button',
                  actionType: 'dialog',
                  level: 'primary',
                  dialog: addAppUserOrderMenu(),
                },
              ],
              columns: [
                {
                  name: 'title',
                  label: '标题',
                },
                {
                  type: "image",
                  name: "img",
                  label: "图片",
                  thumbMode: "cover",
                  enlargeAble: true,
                  height: "40px",
                  width: "40px",
                },
                {
                  name: 'url',
                  label: '跳转链接',
                },
                {
                  name: 'sort',
                  label: '排序',
                },
                {
                  type: 'operation',
                  label: '操作',
                  buttons: [
                    {
                      label: '编辑',
                      type: 'button',
                      level: 'link',
                      actionType: 'dialog',
                      dialog: addAppUserOrderMenu(),
                    },
                    {
                      label: '删除',
                      type: 'button',
                      level: 'link',
                      className: 'text-danger',
                      actionType: 'dialog',
                      dialog: {
                        body: {
                          type: 'form',
                          api: `get:${BASE_ROUTE_PREFIX}/sysConfig/deleteListByUuid?key=appUserOrderMenu&uuid=$uuid`,
                          controls: [
                            {
                              type: 'tpl',
                              tpl: '您确认要删除吗？',
                            },
                          ],
                        },
                      },
                    },
                  ],
                },
              ],
            },
          },
          {
            title: "用户协议",
            hash: "userAgreement",
            reload: true,
            tab: {
              type: 'crud',
              name: 'userAgreementList',
              api: {
                method: 'post',
                url: `${BASE_ROUTE_PREFIX}/sysConfig/findListByKey?key=userAgreement`,
                adaptor: 'return {\n  list: payload\n}',
              },
              loadDataOnce: true,
              source: '${list}',
              headerToolbar: [
                {
                  label: '新增',
                  type: 'button',
                  actionType: 'dialog',
                  level: 'primary',
                  dialog: addUserAgreement(),
                },
              ],
              columns: [
                {
                  name: 'title',
                  label: '协议标题',
                },
                {
                  name: 'content',
                  label: '协议内容',
                  type: "tpl",
                },
                {
                  type: 'operation',
                  label: '操作',
                  buttons: [
                    {
                      label: '编辑',
                      type: 'button',
                      level: 'link',
                      actionType: 'dialog',
                      dialog: addUserAgreement(),
                    },
                    {
                      label: '删除',
                      type: 'button',
                      level: 'link',
                      className: 'text-danger',
                      actionType: 'dialog',
                      dialog: {
                        body: {
                          type: 'form',
                          api: `get:${BASE_ROUTE_PREFIX}/sysConfig/deleteListByUuid?key=userAgreement&uuid=$uuid`,
                          controls: [
                            {
                              type: 'tpl',
                              tpl: '您确认要删除吗？',
                            },
                          ],
                        },
                      },
                    },
                  ],
                },
              ],
            },
          },
          {
            title: "考试学习",
            hash: "exam",
            reload: true,
            tab: {
              type: 'crud',
              name: 'examList',
              api: {
                method: 'post',
                url: `${BASE_ROUTE_PREFIX}/examConfig/findAll`,
                adaptor: 'return {\n  list: payload\n}',
              },
              loadDataOnce: true,
              source: '${list}',
              headerToolbar: [
                {
                  label: '新增',
                  type: 'button',
                  actionType: 'dialog',
                  level: 'primary',
                  dialog: addExam(),
                },
              ],
              columns: [
                {
                  name: 'type',
                  label: '类型',
                  type: 'mapping',
                  map: convertOptionsToMap(examType),
                },
                {
                  name: 'step',
                  label: '步骤',
                },
                {
                  name: 'title',
                  label: '标题',
                },
                {
                  name: 'content',
                  label: '内容',
                  type: "tpl",
                },
                {
                  type: 'operation',
                  label: '操作',
                  buttons: [
                    {
                      label: '编辑',
                      type: 'button',
                      level: 'link',
                      actionType: 'dialog',
                      dialog: addExam(),
                    },
                    {
                      label: '删除',
                      type: 'button',
                      level: 'link',
                      className: 'text-danger',
                      actionType: 'dialog',
                      dialog: {
                        body: {
                          type: 'form',
                          api: `get:${BASE_ROUTE_PREFIX}/examConfig/deleteById?id=$id`,
                          controls: [
                            {
                              type: 'tpl',
                              tpl: '您确认要删除吗？',
                            },
                          ],
                        },
                      },
                    },
                  ],
                },
              ],
            },
          },

        ]
      }
    };
    // 注入amis数据链参数
    schema.data = {_permissionList: permissionList};
    return schema;
  };

  useEffect(() => {
    (async () => {
      const schema = await genSchema();
      setSchema(schema);
    })();
  }, []);

  return <div>{schema && <AmisRenderer schema={schema}/>}</div>;
};

export default Overview;
