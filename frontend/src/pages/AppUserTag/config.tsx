import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
    title: "<%= data.id ? '编辑用户标签' : '新增用户标签' %>",
    size: 'md',
    body: {
        type: 'form',
        reload: 'appUserTag',
        api: {
            url: `${BASE_ROUTE_PREFIX}/appUserTag/saveOrUpdate`,
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
