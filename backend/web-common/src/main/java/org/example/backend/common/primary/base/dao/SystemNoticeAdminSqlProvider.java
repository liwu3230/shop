package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemNoticeAdmin;
import org.example.backend.common.primary.entity.SystemNoticeAdminExample.Criteria;
import org.example.backend.common.primary.entity.SystemNoticeAdminExample.Criterion;
import org.example.backend.common.primary.entity.SystemNoticeAdminExample;

public class SystemNoticeAdminSqlProvider {

    public String countByExample(SystemNoticeAdminExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_notice_admin");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemNoticeAdminExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_notice_admin");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemNoticeAdmin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_notice_admin");
        
        if (record.getNoticeType() != null) {
            sql.VALUES("notice_type", "#{noticeType,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminId() != null) {
            sql.VALUES("admin_id", "#{adminId,jdbcType=SMALLINT}");
        }
        
        if (record.getLinkId() != null) {
            sql.VALUES("link_id", "#{linkId,jdbcType=INTEGER}");
        }
        
        if (record.getTableData() != null) {
            sql.VALUES("table_data", "#{tableData,jdbcType=VARCHAR}");
        }
        
        if (record.getIsClick() != null) {
            sql.VALUES("is_click", "#{isClick,jdbcType=TINYINT}");
        }
        
        if (record.getIsVisit() != null) {
            sql.VALUES("is_visit", "#{isVisit,jdbcType=TINYINT}");
        }
        
        if (record.getVisitTime() != null) {
            sql.VALUES("visit_time", "#{visitTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemNoticeAdminExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("notice_type");
        sql.SELECT("admin_id");
        sql.SELECT("link_id");
        sql.SELECT("table_data");
        sql.SELECT("is_click");
        sql.SELECT("is_visit");
        sql.SELECT("visit_time");
        sql.SELECT("add_time");
        sql.FROM("eb_system_notice_admin");
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
        SystemNoticeAdmin record = (SystemNoticeAdmin) parameter.get("record");
        SystemNoticeAdminExample example = (SystemNoticeAdminExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_notice_admin");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getNoticeType() != null) {
            sql.SET("notice_type = #{record.noticeType,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{record.adminId,jdbcType=SMALLINT}");
        }
        
        if (record.getLinkId() != null) {
            sql.SET("link_id = #{record.linkId,jdbcType=INTEGER}");
        }
        
        if (record.getTableData() != null) {
            sql.SET("table_data = #{record.tableData,jdbcType=VARCHAR}");
        }
        
        if (record.getIsClick() != null) {
            sql.SET("is_click = #{record.isClick,jdbcType=TINYINT}");
        }
        
        if (record.getIsVisit() != null) {
            sql.SET("is_visit = #{record.isVisit,jdbcType=TINYINT}");
        }
        
        if (record.getVisitTime() != null) {
            sql.SET("visit_time = #{record.visitTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_notice_admin");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("notice_type = #{record.noticeType,jdbcType=VARCHAR}");
        sql.SET("admin_id = #{record.adminId,jdbcType=SMALLINT}");
        sql.SET("link_id = #{record.linkId,jdbcType=INTEGER}");
        sql.SET("table_data = #{record.tableData,jdbcType=VARCHAR}");
        sql.SET("is_click = #{record.isClick,jdbcType=TINYINT}");
        sql.SET("is_visit = #{record.isVisit,jdbcType=TINYINT}");
        sql.SET("visit_time = #{record.visitTime,jdbcType=INTEGER}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        
        SystemNoticeAdminExample example = (SystemNoticeAdminExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemNoticeAdmin record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_notice_admin");
        
        if (record.getNoticeType() != null) {
            sql.SET("notice_type = #{noticeType,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminId() != null) {
            sql.SET("admin_id = #{adminId,jdbcType=SMALLINT}");
        }
        
        if (record.getLinkId() != null) {
            sql.SET("link_id = #{linkId,jdbcType=INTEGER}");
        }
        
        if (record.getTableData() != null) {
            sql.SET("table_data = #{tableData,jdbcType=VARCHAR}");
        }
        
        if (record.getIsClick() != null) {
            sql.SET("is_click = #{isClick,jdbcType=TINYINT}");
        }
        
        if (record.getIsVisit() != null) {
            sql.SET("is_visit = #{isVisit,jdbcType=TINYINT}");
        }
        
        if (record.getVisitTime() != null) {
            sql.SET("visit_time = #{visitTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemNoticeAdminExample example, boolean includeExamplePhrase) {
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