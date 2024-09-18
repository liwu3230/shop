package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemConfig;
import org.example.backend.common.primary.entity.SystemConfigExample.Criteria;
import org.example.backend.common.primary.entity.SystemConfigExample.Criterion;
import org.example.backend.common.primary.entity.SystemConfigExample;

public class SystemConfigSqlProvider {

    public String countByExample(SystemConfigExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_config");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemConfigExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_config");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemConfig record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_config");
        
        if (record.getMenuName() != null) {
            sql.VALUES("menu_name", "#{menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getInputType() != null) {
            sql.VALUES("input_type", "#{inputType,jdbcType=VARCHAR}");
        }
        
        if (record.getConfigTabId() != null) {
            sql.VALUES("config_tab_id", "#{configTabId,jdbcType=INTEGER}");
        }
        
        if (record.getParameter() != null) {
            sql.VALUES("`parameter`", "#{parameter,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadType() != null) {
            sql.VALUES("upload_type", "#{uploadType,jdbcType=TINYINT}");
        }
        
        if (record.getRequired() != null) {
            sql.VALUES("required", "#{required,jdbcType=VARCHAR}");
        }
        
        if (record.getWidth() != null) {
            sql.VALUES("width", "#{width,jdbcType=INTEGER}");
        }
        
        if (record.getHigh() != null) {
            sql.VALUES("high", "#{high,jdbcType=INTEGER}");
        }
        
        if (record.getValue() != null) {
            sql.VALUES("`value`", "#{value,jdbcType=VARCHAR}");
        }
        
        if (record.getInfo() != null) {
            sql.VALUES("info", "#{info,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.VALUES("`desc`", "#{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("`status`", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("`level`", "#{level,jdbcType=INTEGER}");
        }
        
        if (record.getLinkId() != null) {
            sql.VALUES("link_id", "#{linkId,jdbcType=INTEGER}");
        }
        
        if (record.getLinkValue() != null) {
            sql.VALUES("link_value", "#{linkValue,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemConfigExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("menu_name");
        sql.SELECT("`type`");
        sql.SELECT("input_type");
        sql.SELECT("config_tab_id");
        sql.SELECT("`parameter`");
        sql.SELECT("upload_type");
        sql.SELECT("required");
        sql.SELECT("width");
        sql.SELECT("high");
        sql.SELECT("`value`");
        sql.SELECT("info");
        sql.SELECT("`desc`");
        sql.SELECT("sort");
        sql.SELECT("`status`");
        sql.SELECT("`level`");
        sql.SELECT("link_id");
        sql.SELECT("link_value");
        sql.FROM("eb_system_config");
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
        SystemConfig record = (SystemConfig) parameter.get("record");
        SystemConfigExample example = (SystemConfigExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_config");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getInputType() != null) {
            sql.SET("input_type = #{record.inputType,jdbcType=VARCHAR}");
        }
        
        if (record.getConfigTabId() != null) {
            sql.SET("config_tab_id = #{record.configTabId,jdbcType=INTEGER}");
        }
        
        if (record.getParameter() != null) {
            sql.SET("`parameter` = #{record.parameter,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadType() != null) {
            sql.SET("upload_type = #{record.uploadType,jdbcType=TINYINT}");
        }
        
        if (record.getRequired() != null) {
            sql.SET("required = #{record.required,jdbcType=VARCHAR}");
        }
        
        if (record.getWidth() != null) {
            sql.SET("width = #{record.width,jdbcType=INTEGER}");
        }
        
        if (record.getHigh() != null) {
            sql.SET("high = #{record.high,jdbcType=INTEGER}");
        }
        
        if (record.getValue() != null) {
            sql.SET("`value` = #{record.value,jdbcType=VARCHAR}");
        }
        
        if (record.getInfo() != null) {
            sql.SET("info = #{record.info,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("`desc` = #{record.desc,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{record.level,jdbcType=INTEGER}");
        }
        
        if (record.getLinkId() != null) {
            sql.SET("link_id = #{record.linkId,jdbcType=INTEGER}");
        }
        
        if (record.getLinkValue() != null) {
            sql.SET("link_value = #{record.linkValue,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_config");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        sql.SET("input_type = #{record.inputType,jdbcType=VARCHAR}");
        sql.SET("config_tab_id = #{record.configTabId,jdbcType=INTEGER}");
        sql.SET("`parameter` = #{record.parameter,jdbcType=VARCHAR}");
        sql.SET("upload_type = #{record.uploadType,jdbcType=TINYINT}");
        sql.SET("required = #{record.required,jdbcType=VARCHAR}");
        sql.SET("width = #{record.width,jdbcType=INTEGER}");
        sql.SET("high = #{record.high,jdbcType=INTEGER}");
        sql.SET("`value` = #{record.value,jdbcType=VARCHAR}");
        sql.SET("info = #{record.info,jdbcType=VARCHAR}");
        sql.SET("`desc` = #{record.desc,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("`status` = #{record.status,jdbcType=TINYINT}");
        sql.SET("`level` = #{record.level,jdbcType=INTEGER}");
        sql.SET("link_id = #{record.linkId,jdbcType=INTEGER}");
        sql.SET("link_value = #{record.linkValue,jdbcType=INTEGER}");
        
        SystemConfigExample example = (SystemConfigExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemConfig record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_config");
        
        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getInputType() != null) {
            sql.SET("input_type = #{inputType,jdbcType=VARCHAR}");
        }
        
        if (record.getConfigTabId() != null) {
            sql.SET("config_tab_id = #{configTabId,jdbcType=INTEGER}");
        }
        
        if (record.getParameter() != null) {
            sql.SET("`parameter` = #{parameter,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadType() != null) {
            sql.SET("upload_type = #{uploadType,jdbcType=TINYINT}");
        }
        
        if (record.getRequired() != null) {
            sql.SET("required = #{required,jdbcType=VARCHAR}");
        }
        
        if (record.getWidth() != null) {
            sql.SET("width = #{width,jdbcType=INTEGER}");
        }
        
        if (record.getHigh() != null) {
            sql.SET("high = #{high,jdbcType=INTEGER}");
        }
        
        if (record.getValue() != null) {
            sql.SET("`value` = #{value,jdbcType=VARCHAR}");
        }
        
        if (record.getInfo() != null) {
            sql.SET("info = #{info,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("`desc` = #{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{level,jdbcType=INTEGER}");
        }
        
        if (record.getLinkId() != null) {
            sql.SET("link_id = #{linkId,jdbcType=INTEGER}");
        }
        
        if (record.getLinkValue() != null) {
            sql.SET("link_value = #{linkValue,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemConfigExample example, boolean includeExamplePhrase) {
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