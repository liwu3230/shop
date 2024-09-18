package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemStore;
import org.example.backend.common.primary.entity.SystemStoreExample.Criteria;
import org.example.backend.common.primary.entity.SystemStoreExample.Criterion;
import org.example.backend.common.primary.entity.SystemStoreExample;

public class SystemStoreSqlProvider {

    public String countByExample(SystemStoreExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_store");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemStoreExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_store");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemStore record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_store");
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduction() != null) {
            sql.VALUES("introduction", "#{introduction,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailedAddress() != null) {
            sql.VALUES("detailed_address", "#{detailedAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getOblongImage() != null) {
            sql.VALUES("oblong_image", "#{oblongImage,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.VALUES("latitude", "#{latitude,jdbcType=CHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.VALUES("longitude", "#{longitude,jdbcType=CHAR}");
        }
        
        if (record.getValidTime() != null) {
            sql.VALUES("valid_time", "#{validTime,jdbcType=VARCHAR}");
        }
        
        if (record.getDayTime() != null) {
            sql.VALUES("day_time", "#{dayTime,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getIsShow() != null) {
            sql.VALUES("is_show", "#{isShow,jdbcType=BIT}");
        }
        
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemStoreExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("`name`");
        sql.SELECT("introduction");
        sql.SELECT("phone");
        sql.SELECT("address");
        sql.SELECT("detailed_address");
        sql.SELECT("image");
        sql.SELECT("oblong_image");
        sql.SELECT("latitude");
        sql.SELECT("longitude");
        sql.SELECT("valid_time");
        sql.SELECT("day_time");
        sql.SELECT("add_time");
        sql.SELECT("is_show");
        sql.SELECT("is_del");
        sql.FROM("eb_system_store");
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
        SystemStore record = (SystemStore) parameter.get("record");
        SystemStoreExample example = (SystemStoreExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_store");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduction() != null) {
            sql.SET("introduction = #{record.introduction,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailedAddress() != null) {
            sql.SET("detailed_address = #{record.detailedAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{record.image,jdbcType=VARCHAR}");
        }
        
        if (record.getOblongImage() != null) {
            sql.SET("oblong_image = #{record.oblongImage,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.SET("latitude = #{record.latitude,jdbcType=CHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.SET("longitude = #{record.longitude,jdbcType=CHAR}");
        }
        
        if (record.getValidTime() != null) {
            sql.SET("valid_time = #{record.validTime,jdbcType=VARCHAR}");
        }
        
        if (record.getDayTime() != null) {
            sql.SET("day_time = #{record.dayTime,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{record.isShow,jdbcType=BIT}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_store");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("introduction = #{record.introduction,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=CHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("detailed_address = #{record.detailedAddress,jdbcType=VARCHAR}");
        sql.SET("image = #{record.image,jdbcType=VARCHAR}");
        sql.SET("oblong_image = #{record.oblongImage,jdbcType=VARCHAR}");
        sql.SET("latitude = #{record.latitude,jdbcType=CHAR}");
        sql.SET("longitude = #{record.longitude,jdbcType=CHAR}");
        sql.SET("valid_time = #{record.validTime,jdbcType=VARCHAR}");
        sql.SET("day_time = #{record.dayTime,jdbcType=VARCHAR}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        sql.SET("is_show = #{record.isShow,jdbcType=BIT}");
        sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        
        SystemStoreExample example = (SystemStoreExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemStore record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_store");
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduction() != null) {
            sql.SET("introduction = #{introduction,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailedAddress() != null) {
            sql.SET("detailed_address = #{detailedAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getOblongImage() != null) {
            sql.SET("oblong_image = #{oblongImage,jdbcType=VARCHAR}");
        }
        
        if (record.getLatitude() != null) {
            sql.SET("latitude = #{latitude,jdbcType=CHAR}");
        }
        
        if (record.getLongitude() != null) {
            sql.SET("longitude = #{longitude,jdbcType=CHAR}");
        }
        
        if (record.getValidTime() != null) {
            sql.SET("valid_time = #{validTime,jdbcType=VARCHAR}");
        }
        
        if (record.getDayTime() != null) {
            sql.SET("day_time = #{dayTime,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{isShow,jdbcType=BIT}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemStoreExample example, boolean includeExamplePhrase) {
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