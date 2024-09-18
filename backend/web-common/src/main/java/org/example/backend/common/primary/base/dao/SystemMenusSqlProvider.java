package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemMenus;
import org.example.backend.common.primary.entity.SystemMenusExample.Criteria;
import org.example.backend.common.primary.entity.SystemMenusExample.Criterion;
import org.example.backend.common.primary.entity.SystemMenusExample;

public class SystemMenusSqlProvider {

    public String countByExample(SystemMenusExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_menus");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemMenusExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_menus");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemMenus record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_menus");
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuName() != null) {
            sql.VALUES("menu_name", "#{menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getModule() != null) {
            sql.VALUES("`module`", "#{module,jdbcType=VARCHAR}");
        }
        
        if (record.getController() != null) {
            sql.VALUES("controller", "#{controller,jdbcType=VARCHAR}");
        }
        
        if (record.getAction() != null) {
            sql.VALUES("`action`", "#{action,jdbcType=VARCHAR}");
        }
        
        if (record.getApiUrl() != null) {
            sql.VALUES("api_url", "#{apiUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMethods() != null) {
            sql.VALUES("methods", "#{methods,jdbcType=VARCHAR}");
        }
        
        if (record.getParams() != null) {
            sql.VALUES("params", "#{params,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=TINYINT}");
        }
        
        if (record.getIsShow() != null) {
            sql.VALUES("is_show", "#{isShow,jdbcType=TINYINT}");
        }
        
        if (record.getIsShowPath() != null) {
            sql.VALUES("is_show_path", "#{isShowPath,jdbcType=BIT}");
        }
        
        if (record.getAccess() != null) {
            sql.VALUES("`access`", "#{access,jdbcType=TINYINT}");
        }
        
        if (record.getMenuPath() != null) {
            sql.VALUES("menu_path", "#{menuPath,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.VALUES("`path`", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthType() != null) {
            sql.VALUES("auth_type", "#{authType,jdbcType=BIT}");
        }
        
        if (record.getHeader() != null) {
            sql.VALUES("`header`", "#{header,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHeader() != null) {
            sql.VALUES("is_header", "#{isHeader,jdbcType=BIT}");
        }
        
        if (record.getUniqueAuth() != null) {
            sql.VALUES("unique_auth", "#{uniqueAuth,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=BIT}");
        }
        
        if (record.getMark() != null) {
            sql.VALUES("mark", "#{mark,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemMenusExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("pid");
        sql.SELECT("icon");
        sql.SELECT("menu_name");
        sql.SELECT("`module`");
        sql.SELECT("controller");
        sql.SELECT("`action`");
        sql.SELECT("api_url");
        sql.SELECT("methods");
        sql.SELECT("params");
        sql.SELECT("sort");
        sql.SELECT("is_show");
        sql.SELECT("is_show_path");
        sql.SELECT("`access`");
        sql.SELECT("menu_path");
        sql.SELECT("`path`");
        sql.SELECT("auth_type");
        sql.SELECT("`header`");
        sql.SELECT("is_header");
        sql.SELECT("unique_auth");
        sql.SELECT("is_del");
        sql.SELECT("mark");
        sql.FROM("eb_system_menus");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        if (example != null && example.getOffset() != null && example.getLimit() != null) {
            return sql.toString() + " limit " + example.getOffset() + "," + example.getLimit();
        }
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SystemMenus record = (SystemMenus) parameter.get("record");
        SystemMenusExample example = (SystemMenusExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_menus");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getModule() != null) {
            sql.SET("`module` = #{record.module,jdbcType=VARCHAR}");
        }
        
        if (record.getController() != null) {
            sql.SET("controller = #{record.controller,jdbcType=VARCHAR}");
        }
        
        if (record.getAction() != null) {
            sql.SET("`action` = #{record.action,jdbcType=VARCHAR}");
        }
        
        if (record.getApiUrl() != null) {
            sql.SET("api_url = #{record.apiUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMethods() != null) {
            sql.SET("methods = #{record.methods,jdbcType=VARCHAR}");
        }
        
        if (record.getParams() != null) {
            sql.SET("params = #{record.params,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=TINYINT}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{record.isShow,jdbcType=TINYINT}");
        }
        
        if (record.getIsShowPath() != null) {
            sql.SET("is_show_path = #{record.isShowPath,jdbcType=BIT}");
        }
        
        if (record.getAccess() != null) {
            sql.SET("`access` = #{record.access,jdbcType=TINYINT}");
        }
        
        if (record.getMenuPath() != null) {
            sql.SET("menu_path = #{record.menuPath,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthType() != null) {
            sql.SET("auth_type = #{record.authType,jdbcType=BIT}");
        }
        
        if (record.getHeader() != null) {
            sql.SET("`header` = #{record.header,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHeader() != null) {
            sql.SET("is_header = #{record.isHeader,jdbcType=BIT}");
        }
        
        if (record.getUniqueAuth() != null) {
            sql.SET("unique_auth = #{record.uniqueAuth,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        }
        
        if (record.getMark() != null) {
            sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_menus");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        sql.SET("`module` = #{record.module,jdbcType=VARCHAR}");
        sql.SET("controller = #{record.controller,jdbcType=VARCHAR}");
        sql.SET("`action` = #{record.action,jdbcType=VARCHAR}");
        sql.SET("api_url = #{record.apiUrl,jdbcType=VARCHAR}");
        sql.SET("methods = #{record.methods,jdbcType=VARCHAR}");
        sql.SET("params = #{record.params,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=TINYINT}");
        sql.SET("is_show = #{record.isShow,jdbcType=TINYINT}");
        sql.SET("is_show_path = #{record.isShowPath,jdbcType=BIT}");
        sql.SET("`access` = #{record.access,jdbcType=TINYINT}");
        sql.SET("menu_path = #{record.menuPath,jdbcType=VARCHAR}");
        sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        sql.SET("auth_type = #{record.authType,jdbcType=BIT}");
        sql.SET("`header` = #{record.header,jdbcType=VARCHAR}");
        sql.SET("is_header = #{record.isHeader,jdbcType=BIT}");
        sql.SET("unique_auth = #{record.uniqueAuth,jdbcType=VARCHAR}");
        sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        
        SystemMenusExample example = (SystemMenusExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemMenus record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_menus");
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getModule() != null) {
            sql.SET("`module` = #{module,jdbcType=VARCHAR}");
        }
        
        if (record.getController() != null) {
            sql.SET("controller = #{controller,jdbcType=VARCHAR}");
        }
        
        if (record.getAction() != null) {
            sql.SET("`action` = #{action,jdbcType=VARCHAR}");
        }
        
        if (record.getApiUrl() != null) {
            sql.SET("api_url = #{apiUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMethods() != null) {
            sql.SET("methods = #{methods,jdbcType=VARCHAR}");
        }
        
        if (record.getParams() != null) {
            sql.SET("params = #{params,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=TINYINT}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{isShow,jdbcType=TINYINT}");
        }
        
        if (record.getIsShowPath() != null) {
            sql.SET("is_show_path = #{isShowPath,jdbcType=BIT}");
        }
        
        if (record.getAccess() != null) {
            sql.SET("`access` = #{access,jdbcType=TINYINT}");
        }
        
        if (record.getMenuPath() != null) {
            sql.SET("menu_path = #{menuPath,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{path,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthType() != null) {
            sql.SET("auth_type = #{authType,jdbcType=BIT}");
        }
        
        if (record.getHeader() != null) {
            sql.SET("`header` = #{header,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHeader() != null) {
            sql.SET("is_header = #{isHeader,jdbcType=BIT}");
        }
        
        if (record.getUniqueAuth() != null) {
            sql.SET("unique_auth = #{uniqueAuth,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=BIT}");
        }
        
        if (record.getMark() != null) {
            sql.SET("mark = #{mark,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemMenusExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}