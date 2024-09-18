package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemCity;
import org.example.backend.common.primary.entity.SystemCityExample.Criteria;
import org.example.backend.common.primary.entity.SystemCityExample.Criterion;
import org.example.backend.common.primary.entity.SystemCityExample;

public class SystemCitySqlProvider {

    public String countByExample(SystemCityExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_city");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemCityExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_city");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemCity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_city");
        
        if (record.getCityId() != null) {
            sql.VALUES("city_id", "#{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("`level`", "#{level,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaCode() != null) {
            sql.VALUES("area_code", "#{areaCode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMergerName() != null) {
            sql.VALUES("merger_name", "#{mergerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            sql.VALUES("lng", "#{lng,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            sql.VALUES("lat", "#{lat,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            sql.VALUES("is_show", "#{isShow,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemCityExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("city_id");
        sql.SELECT("`level`");
        sql.SELECT("parent_id");
        sql.SELECT("area_code");
        sql.SELECT("`name`");
        sql.SELECT("merger_name");
        sql.SELECT("lng");
        sql.SELECT("lat");
        sql.SELECT("is_show");
        sql.FROM("eb_system_city");
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
        SystemCity record = (SystemCity) parameter.get("record");
        SystemCityExample example = (SystemCityExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_city");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{record.level,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaCode() != null) {
            sql.SET("area_code = #{record.areaCode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getMergerName() != null) {
            sql.SET("merger_name = #{record.mergerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            sql.SET("lng = #{record.lng,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            sql.SET("lat = #{record.lat,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{record.isShow,jdbcType=BIT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_city");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("city_id = #{record.cityId,jdbcType=INTEGER}");
        sql.SET("`level` = #{record.level,jdbcType=INTEGER}");
        sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        sql.SET("area_code = #{record.areaCode,jdbcType=VARCHAR}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("merger_name = #{record.mergerName,jdbcType=VARCHAR}");
        sql.SET("lng = #{record.lng,jdbcType=VARCHAR}");
        sql.SET("lat = #{record.lat,jdbcType=VARCHAR}");
        sql.SET("is_show = #{record.isShow,jdbcType=BIT}");
        
        SystemCityExample example = (SystemCityExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemCity record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_city");
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{level,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaCode() != null) {
            sql.SET("area_code = #{areaCode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMergerName() != null) {
            sql.SET("merger_name = #{mergerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            sql.SET("lng = #{lng,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            sql.SET("lat = #{lat,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{isShow,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemCityExample example, boolean includeExamplePhrase) {
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