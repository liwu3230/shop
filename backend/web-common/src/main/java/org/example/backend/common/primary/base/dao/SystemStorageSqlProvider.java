package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemStorage;
import org.example.backend.common.primary.entity.SystemStorageExample.Criteria;
import org.example.backend.common.primary.entity.SystemStorageExample.Criterion;
import org.example.backend.common.primary.entity.SystemStorageExample;

public class SystemStorageSqlProvider {

    public String countByExample(SystemStorageExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_storage");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemStorageExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_storage");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemStorage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_storage");
        
        if (record.getAccessKey() != null) {
            sql.VALUES("access_key", "#{accessKey,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=BIT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.VALUES("region", "#{region,jdbcType=VARCHAR}");
        }
        
        if (record.getAcl() != null) {
            sql.VALUES("acl", "#{acl,jdbcType=CHAR}");
        }
        
        if (record.getDomain() != null) {
            sql.VALUES("`domain`", "#{domain,jdbcType=VARCHAR}");
        }
        
        if (record.getCdn() != null) {
            sql.VALUES("cdn", "#{cdn,jdbcType=VARCHAR}");
        }
        
        if (record.getCname() != null) {
            sql.VALUES("cname", "#{cname,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSsl() != null) {
            sql.VALUES("is_ssl", "#{isSsl,jdbcType=BIT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("`status`", "#{status,jdbcType=BIT}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("is_delete", "#{isDelete,jdbcType=BIT}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemStorageExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("access_key");
        sql.SELECT("`type`");
        sql.SELECT("`name`");
        sql.SELECT("region");
        sql.SELECT("acl");
        sql.SELECT("`domain`");
        sql.SELECT("cdn");
        sql.SELECT("cname");
        sql.SELECT("is_ssl");
        sql.SELECT("`status`");
        sql.SELECT("is_delete");
        sql.SELECT("add_time");
        sql.SELECT("update_time");
        sql.FROM("eb_system_storage");
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
        SystemStorage record = (SystemStorage) parameter.get("record");
        SystemStorageExample example = (SystemStorageExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_storage");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAccessKey() != null) {
            sql.SET("access_key = #{record.accessKey,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=BIT}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.SET("region = #{record.region,jdbcType=VARCHAR}");
        }
        
        if (record.getAcl() != null) {
            sql.SET("acl = #{record.acl,jdbcType=CHAR}");
        }
        
        if (record.getDomain() != null) {
            sql.SET("`domain` = #{record.domain,jdbcType=VARCHAR}");
        }
        
        if (record.getCdn() != null) {
            sql.SET("cdn = #{record.cdn,jdbcType=VARCHAR}");
        }
        
        if (record.getCname() != null) {
            sql.SET("cname = #{record.cname,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSsl() != null) {
            sql.SET("is_ssl = #{record.isSsl,jdbcType=BIT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{record.status,jdbcType=BIT}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("is_delete = #{record.isDelete,jdbcType=BIT}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_storage");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("access_key = #{record.accessKey,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=BIT}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("acl = #{record.acl,jdbcType=CHAR}");
        sql.SET("`domain` = #{record.domain,jdbcType=VARCHAR}");
        sql.SET("cdn = #{record.cdn,jdbcType=VARCHAR}");
        sql.SET("cname = #{record.cname,jdbcType=VARCHAR}");
        sql.SET("is_ssl = #{record.isSsl,jdbcType=BIT}");
        sql.SET("`status` = #{record.status,jdbcType=BIT}");
        sql.SET("is_delete = #{record.isDelete,jdbcType=BIT}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=INTEGER}");
        
        SystemStorageExample example = (SystemStorageExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemStorage record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_storage");
        
        if (record.getAccessKey() != null) {
            sql.SET("access_key = #{accessKey,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=BIT}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.SET("region = #{region,jdbcType=VARCHAR}");
        }
        
        if (record.getAcl() != null) {
            sql.SET("acl = #{acl,jdbcType=CHAR}");
        }
        
        if (record.getDomain() != null) {
            sql.SET("`domain` = #{domain,jdbcType=VARCHAR}");
        }
        
        if (record.getCdn() != null) {
            sql.SET("cdn = #{cdn,jdbcType=VARCHAR}");
        }
        
        if (record.getCname() != null) {
            sql.SET("cname = #{cname,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSsl() != null) {
            sql.SET("is_ssl = #{isSsl,jdbcType=BIT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{status,jdbcType=BIT}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("is_delete = #{isDelete,jdbcType=BIT}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemStorageExample example, boolean includeExamplePhrase) {
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