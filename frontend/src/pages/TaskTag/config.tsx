import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
    title: "<%= data.id ? '编辑任务标签' : '新增任务标签' %>",
    size: 'md',
    body: {
        type: 'form',
        reload: 'taskTag',
        api: {
            url: `${BASE_ROUTE_PREFIX}/taskTag/saveOrUpdate`,
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
        ],
    },
});

export default initSchema;
