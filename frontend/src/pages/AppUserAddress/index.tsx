import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX, COMMON_CRUD_CONFIG} from '@/constants';
import initConfig from './config';
import {genSearchPresentList} from '@/utils';
import {useModel} from '@umijs/max';
import {ApiObject} from "amis/lib/types";

const Overview = () => {
    const {permissionList} = useModel('auth');

    const [schema, setSchema] = useState<SchemaObject>();
    const genSchema = (): SchemaObject => {
        const schema: SchemaObject = {
            type: 'page',
            title: '',
            body: {
                type: 'crud',
                name: 'appUserAddress',
                ...COMMON_CRUD_CONFIG,
                api: {
                    method: 'post',
                    url: `${BASE_ROUTE_PREFIX}/appUserAddress/list`,
                    adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
                    requestAdaptor: (api: ApiObject) => {
                        let timeArray = api.data.createTimeRange?.split(',');
                        return {
                            ...api,
                            data: {
                                ...api.data,
                                startTime: timeArray ? timeArray[0] : '',
                                endTime: timeArray ? timeArray[1] : '',
                            },
                        };
                    },
                },
                filter: {
                    title: '',
                    submitText: '',
                    mode: 'horizontal',
                    controls: genSearchPresentList(3, [
                        {
                            type: 'text',
                            name: 'name',
                            label: '用户账号：',
                            placeholder: '请输入名称',
                            clearable: true,
                        },
                        {
                            type: 'input-datetime-range',
                            name: 'createTimeRange',
                            label: '创建时间：',
                            format: 'YYYY-MM-DD HH:mm:ss',
                        },
                    ]),
                    actions: [
                        {
                            type: 'submit',
                            label: '查询',
                            icon: 'fa fa-search',
                            level: 'primary',
                        },
                        {
                            type: 'reset',
                            actionType: 'reset-and-submit',
                            label: '重置',
                            icon: 'fa fa-rotate-right',
                        },
                    ],
                },
                footerToolbar: [
                    {
                        type: 'tpl',
                        tpl: ' 总共：${total} 项 ',
                        align: 'right',
                    },
                    {
                        type: 'switch-per-page',
                        align: 'right',
                    },
                    'pagination',
                ],
                headerToolbar: [
                    {
                        type: 'tpl',
                        tpl: ' 总共：${total} 项 ',
                        align: 'right',
                    },
                    'pagination',
                    'columns-toggler',
                    'bulk-actions',
                    {
                        label: '新增',
                        type: 'button',
                        actionType: 'dialog',
                        level: 'primary',
                        dialog: initConfig(),
                    },
                    {
                        label: '导入',
                        type: 'button',
                        icon: 'fa fa fa-upload',
                        // level: 'light',
                        actionType: 'dialog',
                        dialog: {
                            title: "导入",
                            body: {
                                type: 'form',
                                mode: 'normal',
                                reload: 'appUserAddress',
                                api: {
                                    url: `${BASE_ROUTE_PREFIX}/appUserAddress/import`,
                                    method: 'post',
                                    // data: {
                                    //   '&': '$$',
                                    //   id: '$id',
                                    //   data: '$data',
                                    // },
                                },
                                messages: {
                                    saveSuccess: '导入成功',
                                    saveFailed: '导入失败',
                                },
                                controls: [
                                    //隐藏项，解决单个input-file组件不触发form保存api的bug
                                    {
                                        type: "hidden",
                                        name: "hidden",
                                    },
                                    {
                                        type: "input-file",
                                        name: "file",
                                        label: "",
                                        accept: ".xlsx,.xls",
                                        asBlob: true,
                                        drag: true,
                                        // receiver: `${BASE_ROUTE_PREFIX}/appUserAddress/import`,
                                    }
                                ],
                            },
                        }
                    },
                    {
                        label: '导出',
                        type: 'button',
                        icon: 'fa fa-download',
                        actionType: "download",
                        api: {
                            method: 'post',
                            url: `${BASE_ROUTE_PREFIX}/appUserAddress/export`,
                            adaptor: 'return {\n    ...payload,}',
                        },
                    },
                ],
                source: '${list}',
                columns: [
                    {
                        name: 'name',
                        label: '名称',
                    },
                    {
                        name: 'alias',
                        label: '别名',
                    },
                    {
                        type: 'operation',
                        label: '操作',
                        buttons: [
                            {
                                label: '编辑',
                                level: 'link',
                                type: 'button',
                                actionType: 'dialog',
                                dialog: initConfig(),
                            },
                            {
                                type: 'button',
                                level: 'link',
                                className: 'text-danger',
                                label: '删除',
                                actionType: 'dialog',
                                dialog: {
                                    body: {
                                        type: 'form',
                                        api: `get:${BASE_ROUTE_PREFIX}/appUserAddress/deleteById?id=$id`,
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
