import {forwardRef, Ref} from 'react';
import copy from 'copy-to-clipboard';
import {render as renderSchema, setIconVendor} from 'amis';
import {fetcher} from '@/utils';
import {history} from '@umijs/max';
import {message} from 'antd';
import {CRUDRenderer} from 'amis/lib/renderers/CRUD';

interface RendererProps {
    schema?: any;

    [propName: string]: any;
}

export type AmisScopedRef = {
    getComponentByName: (componentName: string) => CRUDRenderer;
    getComponents: () => Element[] | Element;
};

const AmisRenderer = (props: RendererProps, ref: Ref<any>): JSX.Element => {
    const {schema, ...rest} = props;

    const env = {
        theme: 'antd',
        fetcher,
        jumpTo:
            props.jumpTo ||
            ((to: string, action?: any) => {
                if (to === 'goBack') {
                    return history.back;
                }
                // to = normalizeLink(to);
                if (action && action.actionType === 'url') {
                    action.blank === false
                        ? (window.location.href = to)
                        : window.open(to);
                    return;
                }
                if (/^http|s?:\/\//.test(to)) {
                    window.location.replace(to);
                } else {
                    history.push(to);
                }
            }),
        copy: (content: string) => {
            copy(content);
            message.success('内容已复制到粘贴板');
        },
        affixOffsetTop: 46,
    };

    return renderSchema(
        schema,
        ref?.hasOwnProperty('current') ? {ref} : {},
        env,
    );
};

setIconVendor([
    {
        name: 'Font Awesome',
        prefix: 'fa fa-',
        icons: [
            'house', 'user', 'user-shield', 'user-lock', 'users', 'user-group', 'person', 'person-dress', 'envelope',
            'check', 'image', 'download', 'bell', 'bars', 'cart-shopping',
            'cloud', 'comment', 'comments', 'filter', 'gift', 'arrow-up-from-bracket',
            'list', 'list-ul', 'list-ol', 'list-check', 'rectangle-list',
            'gear', 'gears', 'pen', 'docker', 'tag', 'hashtag', 'book',
            'address-book', 'print', 'pen-to-square', 'folder', 'folder-open',
            'code', 'plus', 'minus', 'key', 'wifi', 'sliders', 'link', 'layer-group',
            'bug', 'shop', 'database', 'user-nurse', 'laptop', 'desktop', 'sitemap', 'cubes', 'cogs',
            'wechat', 'qrcode', 'chart-column', 'chart-simple', 'chart-line', 'chart-bar',
            'chart-pie', 'chart-area', 'stamp', 'wallet', 'address-card', 'map', 'id-card', 'shield-halved',
            'file-signature', 'file-contract', 'globe', 'ranking-star', 'rectangle-ad',
            'calendar-check', 'house-user', 'cube', 'house-chimney', 'book-bookmark', 'paper-plane',
            'child-dress', 'apple-whole', 'children', 'puzzle-piece', 'dashcube', 'cubes-stacked',
        ],
    },
]);

export const ForwardAmisRenderer = forwardRef(AmisRenderer);

export default AmisRenderer;
