import {BASE_ROUTE_PREFIX} from "@/constants";

const initSchema = (procInsId: string, procDefKey: string) => (
  {
    type: 'form',
    title: '基础信息',
    actions: [],
    mode: "horizontal",
    initApi: `${BASE_ROUTE_PREFIX}/taskOrder/queryByProcInsId?procInsId=${procInsId}`,
    api: {
      url: `${BASE_ROUTE_PREFIX}/taskOrder/queryByProcInsId?procInsId=${procInsId}`,
      method: 'post',
      data: {
        '&': '$$',
      },
    },
    body: [
      {
        type: "static",
        name: "projectName",
        label: "项目名称："
      },
      {
        type: "static",
        name: "taskName",
        label: "任务名称："
      },

    ],
  });

export default initSchema;
