package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemAttachment;
import org.example.backend.common.primary.entity.SystemAttachmentExample.Criteria;
import org.example.backend.common.primary.entity.SystemAttachmentExample.Criterion;
import org.example.backend.common.primary.entity.SystemAttachmentExample;

public class SystemAttachmentSqlProvider {

    public String countByExample(SystemAttachmentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_attachment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemAttachmentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_attachment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemAttachment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_attachment");
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAttDir() != null) {
            sql.VALUES("att_dir", "#{attDir,jdbcType=VARCHAR}");
        }
        
        if (record.getSattDir() != null) {
            sql.VALUES("satt_dir", "#{sattDir,jdbcType=VARCHAR}");
        }
        
        if (record.getAttSize() != null) {
            sql.VALUES("att_size", "#{attSize,jdbcType=CHAR}");
        }
        
        if (record.getAttType() != null) {
            sql.VALUES("att_type", "#{attType,jdbcType=CHAR}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("`time`", "#{time,jdbcType=INTEGER}");
        }
        
        if (record.getImageType() != null) {
            sql.VALUES("image_type", "#{imageType,jdbcType=TINYINT}");
        }
        
        if (record.getModuleType() != null) {
            sql.VALUES("module_type", "#{moduleType,jdbcType=TINYINT}");
        }
        
        if (record.getRealName() != null) {
            sql.VALUES("real_name", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getScanToken() != null) {
            sql.VALUES("scan_token", "#{scanToken,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemAttachmentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("att_id");
        } else {
            sql.SELECT("att_id");
        }
        sql.SELECT("`name`");
        sql.SELECT("att_dir");
        sql.SELECT("satt_dir");
        sql.SELECT("att_size");
        sql.SELECT("att_type");
        sql.SELECT("pid");
        sql.SELECT("`time`");
        sql.SELECT("image_type");
        sql.SELECT("module_type");
        sql.SELECT("real_name");
        sql.SELECT("scan_token");
        sql.FROM("eb_system_attachment");
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
        SystemAttachment record = (SystemAttachment) parameter.get("record");
        SystemAttachmentExample example = (SystemAttachmentExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_attachment");
        
        if (record.getAttId() != null) {
            sql.SET("att_id = #{record.attId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getAttDir() != null) {
            sql.SET("att_dir = #{record.attDir,jdbcType=VARCHAR}");
        }
        
        if (record.getSattDir() != null) {
            sql.SET("satt_dir = #{record.sattDir,jdbcType=VARCHAR}");
        }
        
        if (record.getAttSize() != null) {
            sql.SET("att_size = #{record.attSize,jdbcType=CHAR}");
        }
        
        if (record.getAttType() != null) {
            sql.SET("att_type = #{record.attType,jdbcType=CHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.SET("`time` = #{record.time,jdbcType=INTEGER}");
        }
        
        if (record.getImageType() != null) {
            sql.SET("image_type = #{record.imageType,jdbcType=TINYINT}");
        }
        
        if (record.getModuleType() != null) {
            sql.SET("module_type = #{record.moduleType,jdbcType=TINYINT}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        }
        
        if (record.getScanToken() != null) {
            sql.SET("scan_token = #{record.scanToken,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_attachment");
        
        sql.SET("att_id = #{record.attId,jdbcType=INTEGER}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("att_dir = #{record.attDir,jdbcType=VARCHAR}");
        sql.SET("satt_dir = #{record.sattDir,jdbcType=VARCHAR}");
        sql.SET("att_size = #{record.attSize,jdbcType=CHAR}");
        sql.SET("att_type = #{record.attType,jdbcType=CHAR}");
        sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        sql.SET("`time` = #{record.time,jdbcType=INTEGER}");
        sql.SET("image_type = #{record.imageType,jdbcType=TINYINT}");
        sql.SET("module_type = #{record.moduleType,jdbcType=TINYINT}");
        sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        sql.SET("scan_token = #{record.scanToken,jdbcType=VARCHAR}");
        
        SystemAttachmentExample example = (SystemAttachmentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemAttachment record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_attachment");
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAttDir() != null) {
            sql.SET("att_dir = #{attDir,jdbcType=VARCHAR}");
        }
        
        if (record.getSattDir() != null) {
            sql.SET("satt_dir = #{sattDir,jdbcType=VARCHAR}");
        }
        
        if (record.getAttSize() != null) {
            sql.SET("att_size = #{attSize,jdbcType=CHAR}");
        }
        
        if (record.getAttType() != null) {
            sql.SET("att_type = #{attType,jdbcType=CHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.SET("`time` = #{time,jdbcType=INTEGER}");
        }
        
        if (record.getImageType() != null) {
            sql.SET("image_type = #{imageType,jdbcType=TINYINT}");
        }
        
        if (record.getModuleType() != null) {
            sql.SET("module_type = #{moduleType,jdbcType=TINYINT}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getScanToken() != null) {
            sql.SET("scan_token = #{scanToken,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("att_id = #{attId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemAttachmentExample example, boolean includeExamplePhrase) {
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