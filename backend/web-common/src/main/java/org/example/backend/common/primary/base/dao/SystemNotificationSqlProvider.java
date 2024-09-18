package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemNotification;
import org.example.backend.common.primary.entity.SystemNotificationExample.Criteria;
import org.example.backend.common.primary.entity.SystemNotificationExample.Criterion;
import org.example.backend.common.primary.entity.SystemNotificationExample;

public class SystemNotificationSqlProvider {

    public String countByExample(SystemNotificationExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_notification");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemNotificationExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_notification");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemNotification record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_notification");
        
        if (record.getMark() != null) {
            sql.VALUES("mark", "#{mark,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSystem() != null) {
            sql.VALUES("is_system", "#{isSystem,jdbcType=BIT}");
        }
        
        if (record.getSystemTitle() != null) {
            sql.VALUES("system_title", "#{systemTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getSystemText() != null) {
            sql.VALUES("system_text", "#{systemText,jdbcType=VARCHAR}");
        }
        
        if (record.getIsWechat() != null) {
            sql.VALUES("is_wechat", "#{isWechat,jdbcType=BIT}");
        }
        
        if (record.getWechatTempkey() != null) {
            sql.VALUES("wechat_tempkey", "#{wechatTempkey,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatContent() != null) {
            sql.VALUES("wechat_content", "#{wechatContent,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatKid() != null) {
            sql.VALUES("wechat_kid", "#{wechatKid,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatTempid() != null) {
            sql.VALUES("wechat_tempid", "#{wechatTempid,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatData() != null) {
            sql.VALUES("wechat_data", "#{wechatData,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatLink() != null) {
            sql.VALUES("wechat_link", "#{wechatLink,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatToRoutine() != null) {
            sql.VALUES("wechat_to_routine", "#{wechatToRoutine,jdbcType=INTEGER}");
        }
        
        if (record.getIsRoutine() != null) {
            sql.VALUES("is_routine", "#{isRoutine,jdbcType=BIT}");
        }
        
        if (record.getRoutineTempkey() != null) {
            sql.VALUES("routine_tempkey", "#{routineTempkey,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineContent() != null) {
            sql.VALUES("routine_content", "#{routineContent,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineKid() != null) {
            sql.VALUES("routine_kid", "#{routineKid,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineTempid() != null) {
            sql.VALUES("routine_tempid", "#{routineTempid,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineData() != null) {
            sql.VALUES("routine_data", "#{routineData,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineLink() != null) {
            sql.VALUES("routine_link", "#{routineLink,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSms() != null) {
            sql.VALUES("is_sms", "#{isSms,jdbcType=BIT}");
        }
        
        if (record.getSmsId() != null) {
            sql.VALUES("sms_id", "#{smsId,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsText() != null) {
            sql.VALUES("sms_text", "#{smsText,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEntWechat() != null) {
            sql.VALUES("is_ent_wechat", "#{isEntWechat,jdbcType=BIT}");
        }
        
        if (record.getEntWechatText() != null) {
            sql.VALUES("ent_wechat_text", "#{entWechatText,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getIsApp() != null) {
            sql.VALUES("is_app", "#{isApp,jdbcType=BIT}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=INTEGER}");
        }
        
        if (record.getVariable() != null) {
            sql.VALUES("`variable`", "#{variable,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=BIT}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getCustomTrigger() != null) {
            sql.VALUES("custom_trigger", "#{customTrigger,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomVariable() != null) {
            sql.VALUES("custom_variable", "#{customVariable,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemNotificationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("mark");
        sql.SELECT("`name`");
        sql.SELECT("title");
        sql.SELECT("is_system");
        sql.SELECT("system_title");
        sql.SELECT("system_text");
        sql.SELECT("is_wechat");
        sql.SELECT("wechat_tempkey");
        sql.SELECT("wechat_content");
        sql.SELECT("wechat_kid");
        sql.SELECT("wechat_tempid");
        sql.SELECT("wechat_data");
        sql.SELECT("wechat_link");
        sql.SELECT("wechat_to_routine");
        sql.SELECT("is_routine");
        sql.SELECT("routine_tempkey");
        sql.SELECT("routine_content");
        sql.SELECT("routine_kid");
        sql.SELECT("routine_tempid");
        sql.SELECT("routine_data");
        sql.SELECT("routine_link");
        sql.SELECT("is_sms");
        sql.SELECT("sms_id");
        sql.SELECT("sms_text");
        sql.SELECT("is_ent_wechat");
        sql.SELECT("ent_wechat_text");
        sql.SELECT("url");
        sql.SELECT("is_app");
        sql.SELECT("app_id");
        sql.SELECT("`variable`");
        sql.SELECT("`type`");
        sql.SELECT("add_time");
        sql.SELECT("custom_trigger");
        sql.SELECT("custom_variable");
        sql.FROM("eb_system_notification");
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
        SystemNotification record = (SystemNotification) parameter.get("record");
        SystemNotificationExample example = (SystemNotificationExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_notification");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getMark() != null) {
            sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSystem() != null) {
            sql.SET("is_system = #{record.isSystem,jdbcType=BIT}");
        }
        
        if (record.getSystemTitle() != null) {
            sql.SET("system_title = #{record.systemTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getSystemText() != null) {
            sql.SET("system_text = #{record.systemText,jdbcType=VARCHAR}");
        }
        
        if (record.getIsWechat() != null) {
            sql.SET("is_wechat = #{record.isWechat,jdbcType=BIT}");
        }
        
        if (record.getWechatTempkey() != null) {
            sql.SET("wechat_tempkey = #{record.wechatTempkey,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatContent() != null) {
            sql.SET("wechat_content = #{record.wechatContent,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatKid() != null) {
            sql.SET("wechat_kid = #{record.wechatKid,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatTempid() != null) {
            sql.SET("wechat_tempid = #{record.wechatTempid,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatData() != null) {
            sql.SET("wechat_data = #{record.wechatData,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatLink() != null) {
            sql.SET("wechat_link = #{record.wechatLink,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatToRoutine() != null) {
            sql.SET("wechat_to_routine = #{record.wechatToRoutine,jdbcType=INTEGER}");
        }
        
        if (record.getIsRoutine() != null) {
            sql.SET("is_routine = #{record.isRoutine,jdbcType=BIT}");
        }
        
        if (record.getRoutineTempkey() != null) {
            sql.SET("routine_tempkey = #{record.routineTempkey,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineContent() != null) {
            sql.SET("routine_content = #{record.routineContent,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineKid() != null) {
            sql.SET("routine_kid = #{record.routineKid,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineTempid() != null) {
            sql.SET("routine_tempid = #{record.routineTempid,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineData() != null) {
            sql.SET("routine_data = #{record.routineData,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineLink() != null) {
            sql.SET("routine_link = #{record.routineLink,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSms() != null) {
            sql.SET("is_sms = #{record.isSms,jdbcType=BIT}");
        }
        
        if (record.getSmsId() != null) {
            sql.SET("sms_id = #{record.smsId,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsText() != null) {
            sql.SET("sms_text = #{record.smsText,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEntWechat() != null) {
            sql.SET("is_ent_wechat = #{record.isEntWechat,jdbcType=BIT}");
        }
        
        if (record.getEntWechatText() != null) {
            sql.SET("ent_wechat_text = #{record.entWechatText,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getIsApp() != null) {
            sql.SET("is_app = #{record.isApp,jdbcType=BIT}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=INTEGER}");
        }
        
        if (record.getVariable() != null) {
            sql.SET("`variable` = #{record.variable,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=BIT}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        if (record.getCustomTrigger() != null) {
            sql.SET("custom_trigger = #{record.customTrigger,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomVariable() != null) {
            sql.SET("custom_variable = #{record.customVariable,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_notification");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("is_system = #{record.isSystem,jdbcType=BIT}");
        sql.SET("system_title = #{record.systemTitle,jdbcType=VARCHAR}");
        sql.SET("system_text = #{record.systemText,jdbcType=VARCHAR}");
        sql.SET("is_wechat = #{record.isWechat,jdbcType=BIT}");
        sql.SET("wechat_tempkey = #{record.wechatTempkey,jdbcType=VARCHAR}");
        sql.SET("wechat_content = #{record.wechatContent,jdbcType=VARCHAR}");
        sql.SET("wechat_kid = #{record.wechatKid,jdbcType=VARCHAR}");
        sql.SET("wechat_tempid = #{record.wechatTempid,jdbcType=VARCHAR}");
        sql.SET("wechat_data = #{record.wechatData,jdbcType=VARCHAR}");
        sql.SET("wechat_link = #{record.wechatLink,jdbcType=VARCHAR}");
        sql.SET("wechat_to_routine = #{record.wechatToRoutine,jdbcType=INTEGER}");
        sql.SET("is_routine = #{record.isRoutine,jdbcType=BIT}");
        sql.SET("routine_tempkey = #{record.routineTempkey,jdbcType=VARCHAR}");
        sql.SET("routine_content = #{record.routineContent,jdbcType=VARCHAR}");
        sql.SET("routine_kid = #{record.routineKid,jdbcType=VARCHAR}");
        sql.SET("routine_tempid = #{record.routineTempid,jdbcType=VARCHAR}");
        sql.SET("routine_data = #{record.routineData,jdbcType=VARCHAR}");
        sql.SET("routine_link = #{record.routineLink,jdbcType=VARCHAR}");
        sql.SET("is_sms = #{record.isSms,jdbcType=BIT}");
        sql.SET("sms_id = #{record.smsId,jdbcType=VARCHAR}");
        sql.SET("sms_text = #{record.smsText,jdbcType=VARCHAR}");
        sql.SET("is_ent_wechat = #{record.isEntWechat,jdbcType=BIT}");
        sql.SET("ent_wechat_text = #{record.entWechatText,jdbcType=VARCHAR}");
        sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        sql.SET("is_app = #{record.isApp,jdbcType=BIT}");
        sql.SET("app_id = #{record.appId,jdbcType=INTEGER}");
        sql.SET("`variable` = #{record.variable,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=BIT}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        sql.SET("custom_trigger = #{record.customTrigger,jdbcType=VARCHAR}");
        sql.SET("custom_variable = #{record.customVariable,jdbcType=VARCHAR}");
        
        SystemNotificationExample example = (SystemNotificationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemNotification record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_notification");
        
        if (record.getMark() != null) {
            sql.SET("mark = #{mark,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSystem() != null) {
            sql.SET("is_system = #{isSystem,jdbcType=BIT}");
        }
        
        if (record.getSystemTitle() != null) {
            sql.SET("system_title = #{systemTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getSystemText() != null) {
            sql.SET("system_text = #{systemText,jdbcType=VARCHAR}");
        }
        
        if (record.getIsWechat() != null) {
            sql.SET("is_wechat = #{isWechat,jdbcType=BIT}");
        }
        
        if (record.getWechatTempkey() != null) {
            sql.SET("wechat_tempkey = #{wechatTempkey,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatContent() != null) {
            sql.SET("wechat_content = #{wechatContent,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatKid() != null) {
            sql.SET("wechat_kid = #{wechatKid,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatTempid() != null) {
            sql.SET("wechat_tempid = #{wechatTempid,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatData() != null) {
            sql.SET("wechat_data = #{wechatData,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatLink() != null) {
            sql.SET("wechat_link = #{wechatLink,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatToRoutine() != null) {
            sql.SET("wechat_to_routine = #{wechatToRoutine,jdbcType=INTEGER}");
        }
        
        if (record.getIsRoutine() != null) {
            sql.SET("is_routine = #{isRoutine,jdbcType=BIT}");
        }
        
        if (record.getRoutineTempkey() != null) {
            sql.SET("routine_tempkey = #{routineTempkey,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineContent() != null) {
            sql.SET("routine_content = #{routineContent,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineKid() != null) {
            sql.SET("routine_kid = #{routineKid,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineTempid() != null) {
            sql.SET("routine_tempid = #{routineTempid,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineData() != null) {
            sql.SET("routine_data = #{routineData,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutineLink() != null) {
            sql.SET("routine_link = #{routineLink,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSms() != null) {
            sql.SET("is_sms = #{isSms,jdbcType=BIT}");
        }
        
        if (record.getSmsId() != null) {
            sql.SET("sms_id = #{smsId,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsText() != null) {
            sql.SET("sms_text = #{smsText,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEntWechat() != null) {
            sql.SET("is_ent_wechat = #{isEntWechat,jdbcType=BIT}");
        }
        
        if (record.getEntWechatText() != null) {
            sql.SET("ent_wechat_text = #{entWechatText,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getIsApp() != null) {
            sql.SET("is_app = #{isApp,jdbcType=BIT}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=INTEGER}");
        }
        
        if (record.getVariable() != null) {
            sql.SET("`variable` = #{variable,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=BIT}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getCustomTrigger() != null) {
            sql.SET("custom_trigger = #{customTrigger,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomVariable() != null) {
            sql.SET("custom_variable = #{customVariable,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemNotificationExample example, boolean includeExamplePhrase) {
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