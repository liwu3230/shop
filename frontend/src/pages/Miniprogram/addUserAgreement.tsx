import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
    title: "<%= data.uuid ? '编辑' : '新增' %>",
    size: 'lg',
    body: {
        type: 'form',
        reload: 'userAgreementList',
        api: {
            url: `${BASE_ROUTE_PREFIX}/sysConfig/saveListByKey?key=userAgreement`,
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
                name: 'title',
                label: '协议标题',
                placeholder: '请输入',
                clearable: true,
            },
            {
                type: 'input-rich-text',
                name: 'content',
                label: '协议内容',
                placeholder: '请输入',
                receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
                videoReceiver: `${BASE_ROUTE_PREFIX}/file/upload`,
                size: 'lg',
                options: {
                    height: 500,
                    convert_urls: false,
                }
            },
        ],
    },
});

export default initSchema;
