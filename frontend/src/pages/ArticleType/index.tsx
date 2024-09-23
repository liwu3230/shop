import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX} from '@/constants';
import initConfig from './config';
import {useModel} from '@umijs/max';

const Overview = () => {
    const {permissionList} = useModel('auth');

    const [schema, setSchema] = useState<SchemaObject>();
    const genSchema = (): SchemaObject => {
        const schema: SchemaObject = {
            type: 'page',
            title: '',
            body: {
                type: 'crud',
                name: 'articleType',
                api: {
                    method: 'post',
                    url: `${BASE_ROUTE_PREFIX}/article/findArticleType`,
                    adaptor: 'return {\n  list: payload\n}',
                },
                loadDataOnce: true,
                source: '${list | filter:name:match:name}',
                filter: {
                    title: '',
                    submitText: '',
                    controls: [
                        {
                            type: 'text',
                            name: 'name',
                            size: 'md',
                            placeholder: '通过名称搜索',
                            clearable: true,
                        },
                        {
                            label: '搜索',
                            type: 'submit',
                        },
                        {
                            label: '新增',
                            type: 'button',
                            actionType: 'dialog',
                            level: 'primary',
                            dialog: initConfig(),
                        },
                    ],
                },
                columns: [
                    {
                        name: 'name',
                        label: '名称',
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
                                dialog: initConfig(),
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
                                        api: `get:${BASE_ROUTE_PREFIX}/article/deleteArticleType?name=$name`,
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
