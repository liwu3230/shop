import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
    title: '地址列表',
    size: 'lg',
    actions: [
        {
            type: 'action',
            actionType: 'close',
            label: '关闭',
        },
    ],
    body: {
        type: 'crud',
        name: 'userAddressList',
        api: {
            method: 'get',
            url: `${BASE_ROUTE_PREFIX}/appUserAddress/listAddressByUid?uid=$id`,
            adaptor: 'return {\n  list: payload\n}',
        },
        // primaryField: 'id',
        syncLocation: false,
        loadDataOnce: true,
        columnsTogglable:false,
        columns: [
            {
                name: 'province',
                label: '省份',
            },
            {
                name: 'city',
                label: '城市',
            },
            {
                name: 'district',
                label: '区域',
            },
            {
                name: 'detail',
                label: '详细地址',
            },
            {
                name: 'isDefault',
                label: '是否默认',
                type: 'mapping',
                map: {
                    1: "<span style='background:#87d068' class='label'>是</span>",
                    "*": "<span style='background:#ffa940' class='label'>否</span>",
                }
            },
            {
                name: 'longitude',
                label: '经度',
            },
            {
                name: 'latitude',
                label: '纬度',
            },
            {
                name: 'createTime',
                label: '创建时间',
            },
            {
                name: 'updateTime',
                label: '修改时间',
            },
        ],
    },
});

export default initSchema;
