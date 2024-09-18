package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemStoreStaff;
import org.example.backend.common.primary.entity.SystemStoreStaffExample.Criteria;
import org.example.backend.common.primary.entity.SystemStoreStaffExample.Criterion;
import org.example.backend.common.primary.entity.SystemStoreStaffExample;

public class SystemStoreStaffSqlProvider {

    public String countByExample(SystemStoreStaffExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_store_staff");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemStoreStaffExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_store_staff");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemStoreStaff record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_store_staff");
        
        if (record.getUid() != null) {
            sql.VALUES("`uid`", "#{uid,jdbcType=INTEGER}");
        }
        
        if (record.getAvatar() != null) {
            sql.VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreId() != null) {
            sql.VALUES("store_id", "#{storeId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffName() != null) {
            sql.VALUES("staff_name", "#{staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=CHAR}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.VALUES("verify_status", "#{verifyStatus,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("`status`", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemStoreStaffExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("`uid`");
        sql.SELECT("avatar");
        sql.SELECT("store_id");
        sql.SELECT("staff_name");
        sql.SELECT("phone");
        sql.SELECT("verify_status");
        sql.SELECT("`status`");
        sql.SELECT("add_time");
        sql.FROM("eb_system_store_staff");
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
        SystemStoreStaff record = (SystemStoreStaff) parameter.get("record");
        SystemStoreStaffExample example = (SystemStoreStaffExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_store_staff");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("`uid` = #{record.uid,jdbcType=INTEGER}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreId() != null) {
            sql.SET("store_id = #{record.storeId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffName() != null) {
            sql.SET("staff_name = #{record.staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=CHAR}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{record.verifyStatus,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_store_staff");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("`uid` = #{record.uid,jdbcType=INTEGER}");
        sql.SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        sql.SET("store_id = #{record.storeId,jdbcType=INTEGER}");
        sql.SET("staff_name = #{record.staffName,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=CHAR}");
        sql.SET("verify_status = #{record.verifyStatus,jdbcType=TINYINT}");
        sql.SET("`status` = #{record.status,jdbcType=TINYINT}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        
        SystemStoreStaffExample example = (SystemStoreStaffExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemStoreStaff record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_store_staff");
        
        if (record.getUid() != null) {
            sql.SET("`uid` = #{uid,jdbcType=INTEGER}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreId() != null) {
            sql.SET("store_id = #{storeId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffName() != null) {
            sql.SET("staff_name = #{staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=CHAR}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{verifyStatus,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemStoreStaffExample example, boolean includeExamplePhrase) {
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