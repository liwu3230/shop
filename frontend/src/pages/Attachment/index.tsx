import React, {useEffect, useState} from 'react';
import AmisRenderer from '@/components/AmisRenderer';
import {SchemaObject} from 'amis/lib/Schema';
import {BASE_ROUTE_PREFIX} from '@/constants';
import {useModel} from '@umijs/max';
import uploadFile from "./uploadFile";
import {ApiObject} from "amis/lib/types";

const Overview = () => {
    const {permissionList} = useModel('auth');

    const [schema, setSchema] = useState<SchemaObject>();
    const genSchema = (): SchemaObject => {
        const schema: SchemaObject = {
            type: 'page',
            title: '',
            asideClassName: 'w-lg p-3 pt-0',
            aside: {
                type: "form",
                wrapWithPanel: false,
                target: "attachmentList",
                submitOnInit: true,
                body: [
                    {
                        type: "input-tree",
                        name: "pid",
                        inputClassName: "no-border no-padder mt-3",
                        heightAuto: true,
                        submitOnChange: true,
                        selectFirst: true,
                        labelField: 'name',
                        valueField: 'id',
                        initiallyOpen: true,
                        showOutline: true,
                        rootCreatable: false,
                        enableDefaultIcon: false,
                        value: "0",
                        addApi: {
                            url: `${BASE_ROUTE_PREFIX}/fileCategory/save`,
                            method: 'post',
                            data: {
                                '&': '$$',
                                id: '$id',
                                data: '$data',
                            },
                        },
                        editApi: {
                            url: `${BASE_ROUTE_PREFIX}/fileCategory/update`,
                            method: 'post',
                            data: {
                                '&': '$$',
                                id: '$id',
                                data: '$data',
                            },
                        },
                        deleteApi: `get:${BASE_ROUTE_PREFIX}/fileCategory/deleteById?id=$id`,
                        addControls: [
                            {
                                label: "分组名称",
                                type: "input-text",
                                required: true,
                                name: "name",
                                placeholder: '请输入分组名称',
                            }
                        ],
                        source: {
                            url: `${BASE_ROUTE_PREFIX}/fileCategory/tree`,
                            method: 'get',
                        },
                    }
                ]
            },
            toolbar: [],
            bodyClassName: "pt-0",
            body: {
                type: 'crud',
                name: 'attachmentList',
                mode: "cards",
                affixHeader: false,
                footerToolbar: [
                    {
                        type: 'tpl',
                        tpl: ' 总共：${total} 项 ',
                        align: 'right',
                    },
                    'pagination',
                ],
                pageField: 'page',
                perPageField: 'limit',
                perPage: 18,
                defaultParams: {
                    perPage: 18
                },
                columnsCount: 6,
                api: {
                    // sendOn: "this.pid",
                    method: 'post',
                    url: `${BASE_ROUTE_PREFIX}/file/listAttByPage?pid=$pid`,
                    adaptor: 'return {\n  ...payload, total: payload.totalCount\n}',
                },
                primaryField: 'attId',
                filter: {
                    title: '',
                    submitText: '',
                    wrapWithPanel: false,
                    controls: []
                },
                headerToolbar: [
                    {
                        label: '上传文件',
                        type: 'button',
                        actionType: 'dialog',
                        level: 'info',
                        dialog: uploadFile(),
                    },
                    'bulk-actions',
                ],
                source: '${list}',
                bulkActions: [
                    {
                        type: 'button',
                        level: 'info',
                        label: '图片移至',
                        actionType: 'dialog',
                        quickEdit: false,
                        dialog: {
                            title: "图片移至分组",
                            body: {
                                type: "form",
                                labelWidth: 0,
                                reload: 'attachmentList',
                                api: {
                                    url: `${BASE_ROUTE_PREFIX}/file/updatePidByAttIds`,
                                    method: 'get',
                                    data: {
                                        '&': '$$',
                                        data: '$data',
                                        attIds: '$ids',
                                    },
                                    requestAdaptor: (api: ApiObject) => {
                                        return {
                                            ...api,
                                            data: {
                                                attIds: api.data?.attIds.split(','),
                                            },
                                        };
                                    },
                                    messages: {
                                        success: "",
                                        failed: ""
                                    }
                                },
                                body: [
                                    {
                                        type: "hidden",
                                        name: "ids"
                                    },
                                    {
                                        type: "tree-select",
                                        name: "pid",
                                        labelField: 'name',
                                        valueField: 'id',
                                        initiallyOpen: true,
                                        showOutline: false,
                                        enableDefaultIcon: false,
                                        value: "0",
                                        searchable: true,
                                        required: true,
                                        source: {
                                            url: `${BASE_ROUTE_PREFIX}/fileCategory/tree`,
                                            method: 'get',
                                        },
                                    }
                                ]
                            }
                        }
                    },
                    {
                        label: '批量删除',
                        level: 'danger',
                        actionType: 'ajax',
                        confirmText: '确定要批量删除?',
                        api: {
                            url: `${BASE_ROUTE_PREFIX}/file/deleteByAttIds`,
                            method: 'get',
                            data: {
                                attIds: '$ids',
                            },
                            requestAdaptor: (api: ApiObject) => {
                                return {
                                    ...api,
                                    data: {
                                        attIds: api.data?.attIds.split(','),
                                    },
                                };
                            },
                            messages: {
                                success: "批量删除成功！",
                                failed: ""
                            }
                        },
                    },
                ],
                card: {
                    type: "card",
                    checkOnItemClick: true,
                    hideCheckToggler: true,
                    className: 'flex items-center justify-center',
                    header: {
                        title: '',
                        subTitle: '',
                        description: '',
                        subTitlePlaceholder: '',
                        avatar: '<%= data.downloadUrl %>',
                        className: 'bg-light-dark w-24 h-24 mt-4 flex items-center justify-center flex-col',
                        avatarClassName:
                            'pull-none thumb b-3x w-20 h-20 m-r-none flex items-center justify-center flex-1 flex-grow-0 ',
                    },
                    body: [
                        {
                            label: "",
                            name: "realName",
                            className: 'word-break text-sm font-bold',
                            quickEdit: {
                                mode: "popOver",
                                type: "text",
                                saveImmediately: {
                                    api: `get:${BASE_ROUTE_PREFIX}/file/updateFileName?attId=$attId&realName=$realName`,
                                },
                                resetOnFailed: true,
                            },
                        }
                    ],
                    actions: [
                        // {
                        //     type: "dropdown-button",
                        //     level: "link",
                        //     align: "right",
                        //     icon: "fa fa-ellipsis-h",
                        //     className: "pr-1 flex",
                        //     hideCaret: true,
                        //     buttons: [
                        //         {
                        //             type: "button",
                        //             label: "删除",
                        //             actionType: "ajax",
                        //             confirmText: "您确认要删除吗？",
                        //             api: `get:${BASE_ROUTE_PREFIX}/file/delete?attId=$attId`,
                        //         }
                        //     ]
                        // }
                    ],
                }
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
