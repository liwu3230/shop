package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemLog;
import org.example.backend.common.primary.entity.SystemLogExample.Criteria;
import org.example.backend.common.primary.entity.SystemLogExample.Criterion;
import org.example.backend.common.primary.entity.SystemLogExample;

public class SystemLogSqlProvider {

    public String countByExample(SystemLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_log");
        
        if (record.getAdminId() != null) {
            sql.VALUES("admin_id", "#{adminId,jdbcType=INTEGER}");
        }
        
        if (record.getAdminName() != null) {
            sql.VALUES("admin_name", "#{adminName,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.VALUES("`path`", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getPage() != null) {
            sql.VALUES("page", "#{page,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.VALUES("`method`", "#{method,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            sql.VALUES("ip", "#{ip,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("admin_id");
        sql.SELECT("admin_name");
        sql.SELECT("`path`");
        sql.SELECT("page");
        sql.SELECT("`method`");
        sql.SELECT("ip");
        sql.SELECT("`type`");
        sql.SELECT("add_time");
        sql.SELECT("merchant_id");
        sql.FROM("eb_system_log");
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
        SystemLog record = (SystemLog) parameter.get("record");
        SystemLogExample example = (SystemLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_log");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{record.adminId,jdbcType=INTEGER}");
        }
        
        if (record.getAdminName() != null) {
            sql.SET("admin_name = #{record.adminName,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        }
        
        if (record.getPage() != null) {
            sql.SET("page = #{record.page,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.SET("`method` = #{record.method,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            sql.SET("ip = #{record.ip,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_log");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("admin_id = #{record.adminId,jdbcType=INTEGER}");
        sql.SET("admin_name = #{record.adminName,jdbcType=VARCHAR}");
        sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        sql.SET("page = #{record.page,jdbcType=VARCHAR}");
        sql.SET("`method` = #{record.method,jdbcType=VARCHAR}");
        sql.SET("ip = #{record.ip,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=INTEGER}");
        
        SystemLogExample example = (SystemLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemLog record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_log");
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{adminId,jdbcType=INTEGER}");
        }
        
        if (record.getAdminName() != null) {
            sql.SET("admin_name = #{adminName,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{path,jdbcType=VARCHAR}");
        }
        
        if (record.getPage() != null) {
            sql.SET("page = #{page,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.SET("`method` = #{method,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            sql.SET("ip = #{ip,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemLogExample example, boolean includeExamplePhrase) {
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