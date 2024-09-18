package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.SystemAdmin;
import org.example.backend.common.primary.entity.SystemAdminExample.Criteria;
import org.example.backend.common.primary.entity.SystemAdminExample.Criterion;
import org.example.backend.common.primary.entity.SystemAdminExample;

public class SystemAdminSqlProvider {

    public String countByExample(SystemAdminExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_system_admin");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemAdminExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_system_admin");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemAdmin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_system_admin");
        
        if (record.getAccount() != null) {
            sql.VALUES("account", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadPic() != null) {
            sql.VALUES("head_pic", "#{headPic,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.VALUES("real_name", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoles() != null) {
            sql.VALUES("roles", "#{roles,jdbcType=VARCHAR}");
        }
        
        if (record.getLastIp() != null) {
            sql.VALUES("last_ip", "#{lastIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastTime() != null) {
            sql.VALUES("last_time", "#{lastTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getLoginCount() != null) {
            sql.VALUES("login_count", "#{loginCount,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("`level`", "#{level,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("`status`", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getDivisionId() != null) {
            sql.VALUES("division_id", "#{divisionId,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemAdminExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("account");
        sql.SELECT("head_pic");
        sql.SELECT("pwd");
        sql.SELECT("real_name");
        sql.SELECT("roles");
        sql.SELECT("last_ip");
        sql.SELECT("last_time");
        sql.SELECT("add_time");
        sql.SELECT("login_count");
        sql.SELECT("`level`");
        sql.SELECT("`status`");
        sql.SELECT("division_id");
        sql.SELECT("is_del");
        sql.FROM("eb_system_admin");
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
        SystemAdmin record = (SystemAdmin) parameter.get("record");
        SystemAdminExample example = (SystemAdminExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_system_admin");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAccount() != null) {
            sql.SET("account = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadPic() != null) {
            sql.SET("head_pic = #{record.headPic,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{record.pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoles() != null) {
            sql.SET("roles = #{record.roles,jdbcType=VARCHAR}");
        }
        
        if (record.getLastIp() != null) {
            sql.SET("last_ip = #{record.lastIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastTime() != null) {
            sql.SET("last_time = #{record.lastTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        }
        
        if (record.getLoginCount() != null) {
            sql.SET("login_count = #{record.loginCount,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{record.level,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getDivisionId() != null) {
            sql.SET("division_id = #{record.divisionId,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{record.isDel,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_admin");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("account = #{record.account,jdbcType=VARCHAR}");
        sql.SET("head_pic = #{record.headPic,jdbcType=VARCHAR}");
        sql.SET("pwd = #{record.pwd,jdbcType=VARCHAR}");
        sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        sql.SET("roles = #{record.roles,jdbcType=VARCHAR}");
        sql.SET("last_ip = #{record.lastIp,jdbcType=VARCHAR}");
        sql.SET("last_time = #{record.lastTime,jdbcType=INTEGER}");
        sql.SET("add_time = #{record.addTime,jdbcType=INTEGER}");
        sql.SET("login_count = #{record.loginCount,jdbcType=INTEGER}");
        sql.SET("`level` = #{record.level,jdbcType=TINYINT}");
        sql.SET("`status` = #{record.status,jdbcType=TINYINT}");
        sql.SET("division_id = #{record.divisionId,jdbcType=INTEGER}");
        sql.SET("is_del = #{record.isDel,jdbcType=TINYINT}");
        
        SystemAdminExample example = (SystemAdminExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemAdmin record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_system_admin");
        
        if (record.getAccount() != null) {
            sql.SET("account = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadPic() != null) {
            sql.SET("head_pic = #{headPic,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoles() != null) {
            sql.SET("roles = #{roles,jdbcType=VARCHAR}");
        }
        
        if (record.getLastIp() != null) {
            sql.SET("last_ip = #{lastIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastTime() != null) {
            sql.SET("last_time = #{lastTime,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=INTEGER}");
        }
        
        if (record.getLoginCount() != null) {
            sql.SET("login_count = #{loginCount,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{level,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getDivisionId() != null) {
            sql.SET("division_id = #{divisionId,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemAdminExample example, boolean includeExamplePhrase) {
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