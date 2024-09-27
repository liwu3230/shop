package org.example.backend.common.primary.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAttachmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SysAttachmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAttIdIsNull() {
            addCriterion("att_id is null");
            return (Criteria) this;
        }

        public Criteria andAttIdIsNotNull() {
            addCriterion("att_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttIdEqualTo(Long value) {
            addCriterion("att_id =", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdNotEqualTo(Long value) {
            addCriterion("att_id <>", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdGreaterThan(Long value) {
            addCriterion("att_id >", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdGreaterThanOrEqualTo(Long value) {
            addCriterion("att_id >=", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdLessThan(Long value) {
            addCriterion("att_id <", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdLessThanOrEqualTo(Long value) {
            addCriterion("att_id <=", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdIn(List<Long> values) {
            addCriterion("att_id in", values, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdNotIn(List<Long> values) {
            addCriterion("att_id not in", values, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdBetween(Long value1, Long value2) {
            addCriterion("att_id between", value1, value2, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdNotBetween(Long value1, Long value2) {
            addCriterion("att_id not between", value1, value2, "attId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andAttDirIsNull() {
            addCriterion("att_dir is null");
            return (Criteria) this;
        }

        public Criteria andAttDirIsNotNull() {
            addCriterion("att_dir is not null");
            return (Criteria) this;
        }

        public Criteria andAttDirEqualTo(String value) {
            addCriterion("att_dir =", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirNotEqualTo(String value) {
            addCriterion("att_dir <>", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirGreaterThan(String value) {
            addCriterion("att_dir >", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirGreaterThanOrEqualTo(String value) {
            addCriterion("att_dir >=", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirLessThan(String value) {
            addCriterion("att_dir <", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirLessThanOrEqualTo(String value) {
            addCriterion("att_dir <=", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirLike(String value) {
            addCriterion("att_dir like", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirNotLike(String value) {
            addCriterion("att_dir not like", value, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirIn(List<String> values) {
            addCriterion("att_dir in", values, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirNotIn(List<String> values) {
            addCriterion("att_dir not in", values, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirBetween(String value1, String value2) {
            addCriterion("att_dir between", value1, value2, "attDir");
            return (Criteria) this;
        }

        public Criteria andAttDirNotBetween(String value1, String value2) {
            addCriterion("att_dir not between", value1, value2, "attDir");
            return (Criteria) this;
        }

        public Criteria andSattDirIsNull() {
            addCriterion("satt_dir is null");
            return (Criteria) this;
        }

        public Criteria andSattDirIsNotNull() {
            addCriterion("satt_dir is not null");
            return (Criteria) this;
        }

        public Criteria andSattDirEqualTo(String value) {
            addCriterion("satt_dir =", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirNotEqualTo(String value) {
            addCriterion("satt_dir <>", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirGreaterThan(String value) {
            addCriterion("satt_dir >", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirGreaterThanOrEqualTo(String value) {
            addCriterion("satt_dir >=", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirLessThan(String value) {
            addCriterion("satt_dir <", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirLessThanOrEqualTo(String value) {
            addCriterion("satt_dir <=", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirLike(String value) {
            addCriterion("satt_dir like", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirNotLike(String value) {
            addCriterion("satt_dir not like", value, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirIn(List<String> values) {
            addCriterion("satt_dir in", values, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirNotIn(List<String> values) {
            addCriterion("satt_dir not in", values, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirBetween(String value1, String value2) {
            addCriterion("satt_dir between", value1, value2, "sattDir");
            return (Criteria) this;
        }

        public Criteria andSattDirNotBetween(String value1, String value2) {
            addCriterion("satt_dir not between", value1, value2, "sattDir");
            return (Criteria) this;
        }

        public Criteria andAttSizeIsNull() {
            addCriterion("att_size is null");
            return (Criteria) this;
        }

        public Criteria andAttSizeIsNotNull() {
            addCriterion("att_size is not null");
            return (Criteria) this;
        }

        public Criteria andAttSizeEqualTo(Long value) {
            addCriterion("att_size =", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeNotEqualTo(Long value) {
            addCriterion("att_size <>", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeGreaterThan(Long value) {
            addCriterion("att_size >", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("att_size >=", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeLessThan(Long value) {
            addCriterion("att_size <", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeLessThanOrEqualTo(Long value) {
            addCriterion("att_size <=", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeIn(List<Long> values) {
            addCriterion("att_size in", values, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeNotIn(List<Long> values) {
            addCriterion("att_size not in", values, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeBetween(Long value1, Long value2) {
            addCriterion("att_size between", value1, value2, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeNotBetween(Long value1, Long value2) {
            addCriterion("att_size not between", value1, value2, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNull() {
            addCriterion("att_type is null");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNotNull() {
            addCriterion("att_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttTypeEqualTo(String value) {
            addCriterion("att_type =", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotEqualTo(String value) {
            addCriterion("att_type <>", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThan(String value) {
            addCriterion("att_type >", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThanOrEqualTo(String value) {
            addCriterion("att_type >=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThan(String value) {
            addCriterion("att_type <", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThanOrEqualTo(String value) {
            addCriterion("att_type <=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLike(String value) {
            addCriterion("att_type like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotLike(String value) {
            addCriterion("att_type not like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeIn(List<String> values) {
            addCriterion("att_type in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotIn(List<String> values) {
            addCriterion("att_type not in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeBetween(String value1, String value2) {
            addCriterion("att_type between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotBetween(String value1, String value2) {
            addCriterion("att_type not between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNull() {
            addCriterion("image_type is null");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNotNull() {
            addCriterion("image_type is not null");
            return (Criteria) this;
        }

        public Criteria andImageTypeEqualTo(Integer value) {
            addCriterion("image_type =", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotEqualTo(Integer value) {
            addCriterion("image_type <>", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThan(Integer value) {
            addCriterion("image_type >", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_type >=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThan(Integer value) {
            addCriterion("image_type <", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("image_type <=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeIn(List<Integer> values) {
            addCriterion("image_type in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotIn(List<Integer> values) {
            addCriterion("image_type not in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeBetween(Integer value1, Integer value2) {
            addCriterion("image_type between", value1, value2, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("image_type not between", value1, value2, "imageType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIsNull() {
            addCriterion("module_type is null");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIsNotNull() {
            addCriterion("module_type is not null");
            return (Criteria) this;
        }

        public Criteria andModuleTypeEqualTo(Integer value) {
            addCriterion("module_type =", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotEqualTo(Integer value) {
            addCriterion("module_type <>", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeGreaterThan(Integer value) {
            addCriterion("module_type >", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_type >=", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeLessThan(Integer value) {
            addCriterion("module_type <", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("module_type <=", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIn(List<Integer> values) {
            addCriterion("module_type in", values, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotIn(List<Integer> values) {
            addCriterion("module_type not in", values, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeBetween(Integer value1, Integer value2) {
            addCriterion("module_type between", value1, value2, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("module_type not between", value1, value2, "moduleType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andScanTokenIsNull() {
            addCriterion("scan_token is null");
            return (Criteria) this;
        }

        public Criteria andScanTokenIsNotNull() {
            addCriterion("scan_token is not null");
            return (Criteria) this;
        }

        public Criteria andScanTokenEqualTo(String value) {
            addCriterion("scan_token =", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenNotEqualTo(String value) {
            addCriterion("scan_token <>", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenGreaterThan(String value) {
            addCriterion("scan_token >", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenGreaterThanOrEqualTo(String value) {
            addCriterion("scan_token >=", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenLessThan(String value) {
            addCriterion("scan_token <", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenLessThanOrEqualTo(String value) {
            addCriterion("scan_token <=", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenLike(String value) {
            addCriterion("scan_token like", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenNotLike(String value) {
            addCriterion("scan_token not like", value, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenIn(List<String> values) {
            addCriterion("scan_token in", values, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenNotIn(List<String> values) {
            addCriterion("scan_token not in", values, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenBetween(String value1, String value2) {
            addCriterion("scan_token between", value1, value2, "scanToken");
            return (Criteria) this;
        }

        public Criteria andScanTokenNotBetween(String value1, String value2) {
            addCriterion("scan_token not between", value1, value2, "scanToken");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNull() {
            addCriterion("download_url is null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNotNull() {
            addCriterion("download_url is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlEqualTo(String value) {
            addCriterion("download_url =", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotEqualTo(String value) {
            addCriterion("download_url <>", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThan(String value) {
            addCriterion("download_url >", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("download_url >=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThan(String value) {
            addCriterion("download_url <", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("download_url <=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLike(String value) {
            addCriterion("download_url like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotLike(String value) {
            addCriterion("download_url not like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIn(List<String> values) {
            addCriterion("download_url in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotIn(List<String> values) {
            addCriterion("download_url not in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlBetween(String value1, String value2) {
            addCriterion("download_url between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("download_url not between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(`name`) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andRealNameLikeInsensitive(String value) {
            addCriterion("upper(real_name) like", value.toUpperCase(), "realName");
            return (Criteria) this;
        }

        public Criteria andAttDirLikeInsensitive(String value) {
            addCriterion("upper(att_dir) like", value.toUpperCase(), "attDir");
            return (Criteria) this;
        }

        public Criteria andSattDirLikeInsensitive(String value) {
            addCriterion("upper(satt_dir) like", value.toUpperCase(), "sattDir");
            return (Criteria) this;
        }

        public Criteria andAttTypeLikeInsensitive(String value) {
            addCriterion("upper(att_type) like", value.toUpperCase(), "attType");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andScanTokenLikeInsensitive(String value) {
            addCriterion("upper(scan_token) like", value.toUpperCase(), "scanToken");
            return (Criteria) this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(user_name) like", value.toUpperCase(), "userName");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLikeInsensitive(String value) {
            addCriterion("upper(download_url) like", value.toUpperCase(), "downloadUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}