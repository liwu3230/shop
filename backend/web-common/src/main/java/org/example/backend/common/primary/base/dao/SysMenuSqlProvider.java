package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SysMenu;
import org.example.backend.common.primary.entity.SysMenuExample;
import org.example.backend.common.primary.entity.SysMenuExample.Criteria;
import org.example.backend.common.primary.entity.SysMenuExample.Criterion;

import java.util.List;
import java.util.Map;

public class SysMenuSqlProvider {

    public String countByExample(SysMenuExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysMenuExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysMenu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_menu");
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getPath() != null) {
            sql.VALUES("`path`", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getRouter() != null) {
            sql.VALUES("router", "#{router,jdbcType=VARCHAR}");
        }
        
        if (record.getIsBreadCrumb() != null) {
            sql.VALUES("is_bread_crumb", "#{isBreadCrumb,jdbcType=TINYINT}");
        }
        
        if (record.getPermissionPath() != null) {
            sql.VALUES("permission_path", "#{permissionPath,jdbcType=VARCHAR}");
        }
        
        if (record.getPerms() != null) {
            sql.VALUES("perms", "#{perms,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenType() != null) {
            sql.VALUES("open_type", "#{openType,jdbcType=TINYINT}");
        }
        
        if (record.getLink() != null) {
            sql.VALUES("link", "#{link,jdbcType=VARCHAR}");
        }
        
        if (record.getRedirect() != null) {
            sql.VALUES("redirect", "#{redirect,jdbcType=VARCHAR}");
        }
        
        if (record.getVisible() != null) {
            sql.VALUES("visible", "#{visible,jdbcType=TINYINT}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getIsInit() != null) {
            sql.VALUES("is_init", "#{isInit,jdbcType=BIT}");
        }
        
        if (record.getCreator() != null) {
            sql.VALUES("creator", "#{creator,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdater() != null) {
            sql.VALUES("updater", "#{updater,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysMenuExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("parent_id");
        sql.SELECT("`path`");
        sql.SELECT("`name`");
        sql.SELECT("`type`");
        sql.SELECT("icon");
        sql.SELECT("router");
        sql.SELECT("is_bread_crumb");
        sql.SELECT("permission_path");
        sql.SELECT("perms");
        sql.SELECT("open_type");
        sql.SELECT("link");
        sql.SELECT("redirect");
        sql.SELECT("visible");
        sql.SELECT("sort");
        sql.SELECT("remark");
        sql.SELECT("is_init");
        sql.SELECT("creator");
        sql.SELECT("create_time");
        sql.SELECT("updater");
        sql.SELECT("update_time");
        sql.FROM("sys_menu");
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
        SysMenu record = (SysMenu) parameter.get("record");
        SysMenuExample example = (SysMenuExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=TINYINT}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getRouter() != null) {
            sql.SET("router = #{record.router,jdbcType=VARCHAR}");
        }
        
        if (record.getIsBreadCrumb() != null) {
            sql.SET("is_bread_crumb = #{record.isBreadCrumb,jdbcType=TINYINT}");
        }
        
        if (record.getPermissionPath() != null) {
            sql.SET("permission_path = #{record.permissionPath,jdbcType=VARCHAR}");
        }
        
        if (record.getPerms() != null) {
            sql.SET("perms = #{record.perms,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenType() != null) {
            sql.SET("open_type = #{record.openType,jdbcType=TINYINT}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        }
        
        if (record.getRedirect() != null) {
            sql.SET("redirect = #{record.redirect,jdbcType=VARCHAR}");
        }
        
        if (record.getVisible() != null) {
            sql.SET("visible = #{record.visible,jdbcType=TINYINT}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getIsInit() != null) {
            sql.SET("is_init = #{record.isInit,jdbcType=BIT}");
        }
        
        if (record.getCreator() != null) {
            sql.SET("creator = #{record.creator,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdater() != null) {
            sql.SET("updater = #{record.updater,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=TINYINT}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("router = #{record.router,jdbcType=VARCHAR}");
        sql.SET("is_bread_crumb = #{record.isBreadCrumb,jdbcType=TINYINT}");
        sql.SET("permission_path = #{record.permissionPath,jdbcType=VARCHAR}");
        sql.SET("perms = #{record.perms,jdbcType=VARCHAR}");
        sql.SET("open_type = #{record.openType,jdbcType=TINYINT}");
        sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        sql.SET("redirect = #{record.redirect,jdbcType=VARCHAR}");
        sql.SET("visible = #{record.visible,jdbcType=TINYINT}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("is_init = #{record.isInit,jdbcType=BIT}");
        sql.SET("creator = #{record.creator,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updater = #{record.updater,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        SysMenuExample example = (SysMenuExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysMenu record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{path,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getRouter() != null) {
            sql.SET("router = #{router,jdbcType=VARCHAR}");
        }
        
        if (record.getIsBreadCrumb() != null) {
            sql.SET("is_bread_crumb = #{isBreadCrumb,jdbcType=TINYINT}");
        }
        
        if (record.getPermissionPath() != null) {
            sql.SET("permission_path = #{permissionPath,jdbcType=VARCHAR}");
        }
        
        if (record.getPerms() != null) {
            sql.SET("perms = #{perms,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenType() != null) {
            sql.SET("open_type = #{openType,jdbcType=TINYINT}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{link,jdbcType=VARCHAR}");
        }
        
        if (record.getRedirect() != null) {
            sql.SET("redirect = #{redirect,jdbcType=VARCHAR}");
        }
        
        if (record.getVisible() != null) {
            sql.SET("visible = #{visible,jdbcType=TINYINT}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getIsInit() != null) {
            sql.SET("is_init = #{isInit,jdbcType=BIT}");
        }
        
        if (record.getCreator() != null) {
            sql.SET("creator = #{creator,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdater() != null) {
            sql.SET("updater = #{updater,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysMenuExample example, boolean includeExamplePhrase) {
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