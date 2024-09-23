import {BASE_ROUTE_PREFIX} from '@/constants';

const initSchema = () => ({
  title: "<%= data.id ? '编辑文章' : '新增文章' %>",
  size: 'lg',
  body: {
    type: 'form',
    reload: 'article',
    api: {
      url: `${BASE_ROUTE_PREFIX}/article/saveOrUpdate`,
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
        type: 'select',
        name: 'type',
        label: '文章分类：',
        searchable: true,
        required: true,
        clearable: true,
        labelField: 'name',
        valueField: 'name',
        source: {
          url: `${BASE_ROUTE_PREFIX}/article/findArticleType`,
          method: 'get',
          data: {},
        },
      },
      {
        type: 'text',
        name: 'title',
        label: '标题',
        required: true,
        clearable: true,
        placeholder: '请输入',
      },
      {
        type: 'select',
        name: 'hide',
        label: '是否隐藏：',
        options: [
          {
            value: 1,
            label: '是',
          },
          {
            value: 0,
            label: '否',
          },
        ],
        value: 0,
        clearable: true,
        placeholder: '请选择',
      },
      {
        type: 'text',
        name: 'author',
        label: '作者',
        required: false,
        clearable: true,
        placeholder: '请输入',
      },
      {
        type: 'textarea',
        name: 'synopsis',
        label: '文件简介',
        placeholder: '请输入',
        clearable: true,
      },
      // {
      //   type: 'text',
      //   name: 'url',
      //   label: '原文链接',
      //   placeholder: '请输入',
      //   clearable: true,
      // },
      {
        type: 'number',
        name: 'sort',
        value: 1,
        label: '排序',
        required: true,
        placeholder: '请输入',
      },
      // {
      //   type: 'input-image',
      //   name: 'imageInput',
      //   label: '图文封面',
      //   placeholder: '请输入',
      //   required: false,
      //   receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
      // },
      {
        type: 'input-rich-text',
        name: 'content',
        label: '文章内容',
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
