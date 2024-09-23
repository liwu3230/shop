import {BASE_ROUTE_PREFIX} from '@/constants';
import {examType} from "@/constants/enums";

const initSchema = () => ({
  title: "<%= data.uuid ? '编辑' : '新增' %>",
  size: 'lg',
  body: {
    type: 'form',
    reload: 'userAgreementList',
    api: {
      url: `${BASE_ROUTE_PREFIX}/examConfig/saveOrUpdate`,
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
        label: '类型：',
        options: examType,
        placeholder: '请选择类型',
        clearable: true,
        value: 1,
        required: true,
      },
      {
        type: 'number',
        name: 'step',
        value: 1,
        label: '步骤：',
        required: true,
        placeholder: '请输入',
      },
      {
        type: 'text',
        name: 'title',
        label: '标题：',
        placeholder: '请输入',
        clearable: true,
      },
      {
        type: 'input-file',
        name: 'content',
        label: '音频：',
        placeholder: '请选择',
        required: true,
        useChunk: false,
        accept: ".mp3,.mav,.aac",
        receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
        hiddenOn: 'this.type !== 0',
      },
      {
        type: 'input-file',
        name: 'content',
        label: '视频：',
        placeholder: '请选择',
        required: true,
        useChunk: false,
        accept: ".mp4,.m3u8",
        receiver: `${BASE_ROUTE_PREFIX}/file/upload`,
        hiddenOn: 'this.type !== 1',
      },
      {
        type: 'text',
        name: 'content',
        label: '问卷链接：',
        placeholder: '请输入',
        clearable: true,
        required: true,
        hiddenOn: 'this.type !== 2',
      },
    ],
  },
});

export default initSchema;
