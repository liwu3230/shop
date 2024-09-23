import order from "@/pages/Process/Form/Process/order";

export const getProcessFormSchema = (procInsId: string, procDefKey: string) => {
  let formSchema = {};
  switch (procDefKey) {
    case 'order':
      formSchema = order(procInsId, procDefKey);
      break;

  }
  return formSchema;
};

export const getBpmnHeight = (procDefKey: string) => {
  let height = 300;
  switch (procDefKey) {
    case 'order':
      height = 300;
      break;

  }
  return height;
};

export const flowStatusMapping = {
  '已结单': {
    type: "tag",
    label: "已结单",
    displayMode: "normal",
    style: {
      backgroundColor: "#fafafa",
      border: "1px solid #d9d9d9",
      color: "#333",
      borderRadius: "0.375em",
      opacity: "0.9"
    }
  },
  '已驳回': {
    type: "tag",
    label: "已驳回",
    displayMode: "normal",
    style: {
      backgroundColor: "#fafafa",
      border: "1px solid #d9d9d9",
      color: "#333",
      borderRadius: "0.375em",
      opacity: "0.9"
    }
  },
  '已撤回': {
    type: "tag",
    label: "已撤回",
    displayMode: "normal",
    style: {
      backgroundColor: "#fafafa",
      border: "1px solid #d9d9d9",
      color: "#333",
      borderRadius: "0.375em",
      opacity: "0.9"
    }
  },
  '*': {
    type: 'tag',
    label: '${curStatus}',
    displayMode: 'normal',
    style: {
      backgroundColor: '#e6f7ff',
      border: '1px solid #91d5ff',
      color: '#1890ff',
      borderRadius: "0.375em",
      opacity: "0.8",
    }
  },
};
