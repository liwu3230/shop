import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
    title: "<%= data.id ? '编辑订阅消息' : '新增订阅消息' %>",
    size: 'md',
    body: {
        type: 'form',
        reload: 'templateMessage',
        api: {
            url: `${BASE_ROUTE_PREFIX}/templateMessage/saveOrUpdate`,
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
                type: 'text',
                name: 'name',
                label: '名称',
                required: true,
                clearable: true,
                placeholder: '请输入',
            },
            {
                type: 'text',
                name: 'alias',
                label: '别名',
                required: false,
                clearable: true,
                placeholder: '请输入',
            },
            {
                type: 'input-datetime',
                name: 'expireTime',
                label: '过期时间',
                format: 'YYYY-MM-DD HH:mm:ss',
                clearable: true,
                // value: '+24hours'
            },
            {
                type: 'textarea',
                name: 'remark',
                label: '备注',
                placeholder: '请输入',
                clearable: true,
            },
        ],
    },
});

export default initSchema;
