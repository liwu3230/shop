import React, {FC} from 'react';
import {Button, Form, Input} from 'antd';

const formItemLayout = {
  labelCol: {span: 4},
  wrapperCol: {span: 18},
};

interface updatePasswordProps {
  onSubmit: (values: PlainObject) => void;
  onCancel: () => void;
}

const updatePassword: FC<updatePasswordProps> = (props) => {
  const [form] = Form.useForm();
  const init = () => {

  };
  init();

  const onSubmit = async () => {
    try {
      const values = await form.validateFields();
      Object.assign(values, {
        oldPassword: values.oldPassword || '',
        password: values.password || '',
        confirmPassword: values.confirmPassword || '',
      });
      props.onSubmit(values);
    } catch (errorInfo) {
      console.log('Failed:', errorInfo);
    }
  };

  return (
    <Form form={form} name="dynamic_rule">
      <Form.Item
        {...formItemLayout}
        name="oldPassword"
        label="旧密码"
        rules={[
          {
            required: true,
            message: '请输入旧密码',
          },
        ]}
      >
        <Input.Password placeholder="请输入旧密码"/>
      </Form.Item>

      <Form.Item
        {...formItemLayout}
        name="password"
        label="新密码"
        rules={[
          {
            required: true,
            message: '请输入新密码',
          },
        ]}
      >
        <Input.Password placeholder="请输入新密码"/>
      </Form.Item>

      <Form.Item
        {...formItemLayout}
        name="confirmPassword"
        label="确认密码"
        rules={[
          {
            required: true,
            message: '请重新输入新密码',
          },
        ]}
      >
        <Input.Password placeholder="请重新输入新密码"/>
      </Form.Item>

      <Form.Item wrapperCol={{span: 24, offset: 15}}>
        <Button onClick={props.onCancel} style={{marginRight: '10px'}}>
          取消
        </Button>
        <Button type="primary" htmlType="submit" onClick={onSubmit}>
          提交
        </Button>
      </Form.Item>
    </Form>
  );
};

export default updatePassword;
