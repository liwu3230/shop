// 步骤模板（用于form的control里面）
export const STEP_TPL = {
  type: 'tpl',
  className: 'block border-0 border-b border-solid border-gray-300 mb-2',
};

interface CommonConfigFields {
  affixHeader: boolean;
  perPage: number;
  headerToolbar: string[];
  footerToolbar: string[];
  pageField: string;
  perPageField: string;
  keepItemSelectionOnPageChange: boolean;
  maxKeepItemSelectionLength: number;
}
// crud 通用配置
export const COMMON_CRUD_CONFIG: CommonConfigFields = {
  affixHeader: false,
  perPage: 10,
  headerToolbar: ['columns-toggler', 'pagination'],
  footerToolbar: ['switch-per-page', 'pagination'],
  pageField: 'page',
  perPageField: 'limit',
  keepItemSelectionOnPageChange: true,
  maxKeepItemSelectionLength: 11,
};
