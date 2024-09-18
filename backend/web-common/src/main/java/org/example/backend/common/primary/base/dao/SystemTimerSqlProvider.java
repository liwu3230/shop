package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemTimer;
import org.example.backend.common.primary.entity.SystemTimerExample.Criteria;
import org.example.backend.common.primary.entity.SystemTimerExample.Criterion;
import org.example.backend.common.primary.entity.SystemTimerExample;

public class SystemTimerSqlProvider {

    public String countByExample(SystemTimerExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_timer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemTimerExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_timer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemTimer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_timer");
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMark() != null) {
            sql.VALUES("mark", "#{mark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=BIT}");
        }
        
        if (record.getMonth() != null) {
            sql.VALUES("`month`", "#{month,jdbcType=INTEGER}");
        }
        
        if (record.getWeek() != null) {
            sql.VALUES("week", "#{week,jdbcType=INTEGER}");
        }
        
        if (record.getDay() != null) {
            sql.VALUES("`day`", "#{day,jdbcType=INTEGER}");
        }
        
        if (record.getHour() != null) {
            sql.VALUES("`hour`", "#{hour,jdbcType=INTEGER}");
        }
        
        if (record.getMinute() != null) {
            sql.VALUES("`minute`", "#{minute,jdbcType=INTEGER}");
        }
        
        if (record.getSecond() != null) {
            sql.VALUES("`second`", "#{second,jdbcType=INTEGER}");
        }
        
        if (record.getLastExecutionTime() != null) {
            sql.VALUES("last_execution_time", "#{lastExecutionTime,jdbcType=INTEGER}");
        }
        
        if (record.getNextExecutionTime() != null) {
            sql.VALUES("next_execution_time", "#{nextExecutionTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=BIT}");
        }
        
        if (record.getIsOpen() != null) {
            sql.VALUES("is_open", "#{isOpen,jdbcType=BIT}");
        }
        
        if (record.getCustomcode() != null) {
            sql.VALUES("customCode", "#{customcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestr() != null) {
            sql.VALUES("timeStr", "#{timestr,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemTimerExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("`name`");
        sql.SELECT("mark");
        sql.SELECT("content");
        sql.SELECT("`type`");
        sql.SELECT("`month`");
        sql.SELECT("week");
        sql.SELECT("`day`");
        sql.SELECT("`hour`");
        sql.SELECT("`minute`");
        sql.SELECT("`second`");
        sql.SELECT("last_execution_time");
        sql.SELECT("next_execution_time");
        sql.SELECT("add_time");
        sql.SELECT("is_del");
        sql.SELECT("is_open");
        sql.SELECT("customCode");
        sql.SELECT("timeStr");
        sql.FROM("eb_system_timer");
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
        SystemTimer record = (SystemTimer) parameter.get("record");
        SystemTimerExample example = (SystemTimerExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_timer");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getMark() != null) {
            sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=BIT}");
        }
        
        if (record.getMonth() != null) {
            sql.SET("`month` = #{record.month,jdbcType=INTEGER}");
        }
        
        if (record.getWeek() != null) {
            sql.SET("week = #{record.week,jdbcType=INTEGER}");
        }
        
        if (record.getDay() != null) {
            sql.SET("`day` = #{record.day,jdbcType=INTEGER}");
        }
        
        if (record.getHour() != null) {
            sql.SET("`hour` = #{record.hour,jdbcType=INTEGER}");
        }
        
        if (record.getMinute() != null) {
            sql.SET("`minute` = #{record.minute,jdbcType=INTEGER}");
        }
        
        if (record.getSecond() != null) {
            sql.SET("`second` = #{record.second,jdbcType=INTEGER}");
        }
        
        if (record.getLastExecutionTime() != null) {
            sql.SET("last_execution_time = #{record.lastExecutionTime,jdbcType=INTEGER}");
        }
        
        if (record.getNextExecutionTime() != null) {
            sql.SET("next_execution_time = #{record.nextExecutionTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        }
        
        if (record.getIsOpen() != null) {
            sql.SET("is_open = #{record.isOpen,jdbcType=BIT}");
        }
        
        if (record.getCustomcode() != null) {
            sql.SET("customCode = #{record.customcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestr() != null) {
            sql.SET("timeStr = #{record.timestr,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_timer");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=BIT}");
        sql.SET("`month` = #{record.month,jdbcType=INTEGER}");
        sql.SET("week = #{record.week,jdbcType=INTEGER}");
        sql.SET("`day` = #{record.day,jdbcType=INTEGER}");
        sql.SET("`hour` = #{record.hour,jdbcType=INTEGER}");
        sql.SET("`minute` = #{record.minute,jdbcType=INTEGER}");
        sql.SET("`second` = #{record.second,jdbcType=INTEGER}");
        sql.SET("last_execution_time = #{record.lastExecutionTime,jdbcType=INTEGER}");
        sql.SET("next_execution_time = #{record.nextExecutionTime,jdbcType=INTEGER}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        sql.SET("is_open = #{record.isOpen,jdbcType=BIT}");
        sql.SET("customCode = #{record.customcode,jdbcType=VARCHAR}");
        sql.SET("timeStr = #{record.timestr,jdbcType=VARCHAR}");
        
        SystemTimerExample example = (SystemTimerExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemTimer record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_timer");
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMark() != null) {
            sql.SET("mark = #{mark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=BIT}");
        }
        
        if (record.getMonth() != null) {
            sql.SET("`month` = #{month,jdbcType=INTEGER}");
        }
        
        if (record.getWeek() != null) {
            sql.SET("week = #{week,jdbcType=INTEGER}");
        }
        
        if (record.getDay() != null) {
            sql.SET("`day` = #{day,jdbcType=INTEGER}");
        }
        
        if (record.getHour() != null) {
            sql.SET("`hour` = #{hour,jdbcType=INTEGER}");
        }
        
        if (record.getMinute() != null) {
            sql.SET("`minute` = #{minute,jdbcType=INTEGER}");
        }
        
        if (record.getSecond() != null) {
            sql.SET("`second` = #{second,jdbcType=INTEGER}");
        }
        
        if (record.getLastExecutionTime() != null) {
            sql.SET("last_execution_time = #{lastExecutionTime,jdbcType=INTEGER}");
        }
        
        if (record.getNextExecutionTime() != null) {
            sql.SET("next_execution_time = #{nextExecutionTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=BIT}");
        }
        
        if (record.getIsOpen() != null) {
            sql.SET("is_open = #{isOpen,jdbcType=BIT}");
        }
        
        if (record.getCustomcode() != null) {
            sql.SET("customCode = #{customcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestr() != null) {
            sql.SET("timeStr = #{timestr,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemTimerExample example, boolean includeExamplePhrase) {
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