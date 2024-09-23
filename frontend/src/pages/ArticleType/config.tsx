import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
    title: "<%= data.id ? '编辑文章分类' : '新增文章分类' %>",
    size: 'md',
    body: {
        type: 'form',
        reload: 'articleType',
        api: {
            url: `${BASE_ROUTE_PREFIX}/article/saveArticleType`,
            method: 'post',
            data: {
                '&': '$$',
                uuid: '$uuid',
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
