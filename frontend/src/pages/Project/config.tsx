import {BASE_ROUTE_PREFIX} from '@/constants';
import { Select } from 'antd';
import { userList } from './index';
import {ApiObject} from "amis/lib/types";
import {omit} from "lodash";

export const getSelect = (value: string[], onChange: Fn, id: string) => {
  return (
    <Select
      options={userList}
      placeholder="请选择"
      showSearch
      value={value as string[]}
      optionFilterProp="label"
      style={{ width: 646 }}
      mode="multiple"
      allowClear
      onChange={(value) => onChange(value)}
      getPopupContainer={() => document.getElementById(id) as HTMLElement}
    />
  );
};
const initSchema = () => ({
  title: "<%= data.id ? '编辑项目' : '新增项目' %>",
  size: 'md',
  body: {
    type: 'form',
    reload: 'project',
    api: {
      url: `${BASE_ROUTE_PREFIX}/project/saveOrUpdate`,
      method: 'post',
      data: {
        '&': '$$',
        id: '$id',
        data: '$data',
      },
      requestAdaptor: (api: ApiObject) => {
        const data = omit(api.data, ['items']);
        return {
          ...api,
          data: {
            ...data,
            admins: data.admins?.join(',') || '',
          },
        };
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
        name: 'admins',
        label: '管理员：',
        searchable: true,
        // joinValues: true,
        required: true,
        asFormItem: true,
        children: ({
                     value,
                     onChange,
                   }: {
          value: string[] | string;
          onChange: Fn;
        }) => {
          const val =
            typeof value === 'object'
              ? value
              : value?.split?.(',')?.filter(Boolean) || [];
          if (value !== val) {
            onChange(val);
          }
          return (
            <div id="adminArea">
              {getSelect(value as string[], onChange, 'adminArea')}
            </div>
          );
        },
      },
      {
        type: 'text',
        name: 'remark',
        label: '简介',
        placeholder: '请输入',
        clearable: true,
      },
    ],
  },
});

export default initSchema;
