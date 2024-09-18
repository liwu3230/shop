package org.example.backend.common.primary.entity;

import java.util.ArrayList;
import java.util.List;

public class SystemTimerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SystemTimerExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("`month` is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("`month` is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("`month` =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("`month` <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("`month` >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("`month` >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("`month` <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("`month` <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("`month` in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("`month` not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("`month` between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("`month` not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(Integer value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(Integer value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(Integer value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(Integer value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(Integer value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<Integer> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<Integer> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(Integer value1, Integer value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("`day` is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("`day` is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("`day` =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("`day` <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("`day` >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("`day` >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("`day` <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("`day` <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("`day` in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("`day` not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("`day` between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("`day` not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andHourIsNull() {
            addCriterion("`hour` is null");
            return (Criteria) this;
        }

        public Criteria andHourIsNotNull() {
            addCriterion("`hour` is not null");
            return (Criteria) this;
        }

        public Criteria andHourEqualTo(Integer value) {
            addCriterion("`hour` =", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotEqualTo(Integer value) {
            addCriterion("`hour` <>", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThan(Integer value) {
            addCriterion("`hour` >", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("`hour` >=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThan(Integer value) {
            addCriterion("`hour` <", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThanOrEqualTo(Integer value) {
            addCriterion("`hour` <=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourIn(List<Integer> values) {
            addCriterion("`hour` in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotIn(List<Integer> values) {
            addCriterion("`hour` not in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourBetween(Integer value1, Integer value2) {
            addCriterion("`hour` between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotBetween(Integer value1, Integer value2) {
            addCriterion("`hour` not between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andMinuteIsNull() {
            addCriterion("`minute` is null");
            return (Criteria) this;
        }

        public Criteria andMinuteIsNotNull() {
            addCriterion("`minute` is not null");
            return (Criteria) this;
        }

        public Criteria andMinuteEqualTo(Integer value) {
            addCriterion("`minute` =", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteNotEqualTo(Integer value) {
            addCriterion("`minute` <>", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteGreaterThan(Integer value) {
            addCriterion("`minute` >", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("`minute` >=", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteLessThan(Integer value) {
            addCriterion("`minute` <", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteLessThanOrEqualTo(Integer value) {
            addCriterion("`minute` <=", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteIn(List<Integer> values) {
            addCriterion("`minute` in", values, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteNotIn(List<Integer> values) {
            addCriterion("`minute` not in", values, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteBetween(Integer value1, Integer value2) {
            addCriterion("`minute` between", value1, value2, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteNotBetween(Integer value1, Integer value2) {
            addCriterion("`minute` not between", value1, value2, "minute");
            return (Criteria) this;
        }

        public Criteria andSecondIsNull() {
            addCriterion("`second` is null");
            return (Criteria) this;
        }

        public Criteria andSecondIsNotNull() {
            addCriterion("`second` is not null");
            return (Criteria) this;
        }

        public Criteria andSecondEqualTo(Integer value) {
            addCriterion("`second` =", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotEqualTo(Integer value) {
            addCriterion("`second` <>", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThan(Integer value) {
            addCriterion("`second` >", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThanOrEqualTo(Integer value) {
            addCriterion("`second` >=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThan(Integer value) {
            addCriterion("`second` <", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThanOrEqualTo(Integer value) {
            addCriterion("`second` <=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondIn(List<Integer> values) {
            addCriterion("`second` in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotIn(List<Integer> values) {
            addCriterion("`second` not in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondBetween(Integer value1, Integer value2) {
            addCriterion("`second` between", value1, value2, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotBetween(Integer value1, Integer value2) {
            addCriterion("`second` not between", value1, value2, "second");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeIsNull() {
            addCriterion("last_execution_time is null");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeIsNotNull() {
            addCriterion("last_execution_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeEqualTo(Integer value) {
            addCriterion("last_execution_time =", value, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeNotEqualTo(Integer value) {
            addCriterion("last_execution_time <>", value, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeGreaterThan(Integer value) {
            addCriterion("last_execution_time >", value, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_execution_time >=", value, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeLessThan(Integer value) {
            addCriterion("last_execution_time <", value, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeLessThanOrEqualTo(Integer value) {
            addCriterion("last_execution_time <=", value, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeIn(List<Integer> values) {
            addCriterion("last_execution_time in", values, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeNotIn(List<Integer> values) {
            addCriterion("last_execution_time not in", values, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeBetween(Integer value1, Integer value2) {
            addCriterion("last_execution_time between", value1, value2, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("last_execution_time not between", value1, value2, "lastExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeIsNull() {
            addCriterion("next_execution_time is null");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeIsNotNull() {
            addCriterion("next_execution_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeEqualTo(Integer value) {
            addCriterion("next_execution_time =", value, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeNotEqualTo(Integer value) {
            addCriterion("next_execution_time <>", value, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeGreaterThan(Integer value) {
            addCriterion("next_execution_time >", value, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_execution_time >=", value, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeLessThan(Integer value) {
            addCriterion("next_execution_time <", value, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeLessThanOrEqualTo(Integer value) {
            addCriterion("next_execution_time <=", value, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeIn(List<Integer> values) {
            addCriterion("next_execution_time in", values, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeNotIn(List<Integer> values) {
            addCriterion("next_execution_time not in", values, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeBetween(Integer value1, Integer value2) {
            addCriterion("next_execution_time between", value1, value2, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andNextExecutionTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("next_execution_time not between", value1, value2, "nextExecutionTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Integer value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Integer value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Integer value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Integer value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Integer value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Integer> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Integer> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Integer value1, Integer value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(Integer value) {
            addCriterion("is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(Integer value) {
            addCriterion("is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(Integer value) {
            addCriterion("is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(Integer value) {
            addCriterion("is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(Integer value) {
            addCriterion("is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<Integer> values) {
            addCriterion("is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<Integer> values) {
            addCriterion("is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(Integer value1, Integer value2) {
            addCriterion("is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("is_open not between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andCustomcodeIsNull() {
            addCriterion("customCode is null");
            return (Criteria) this;
        }

        public Criteria andCustomcodeIsNotNull() {
            addCriterion("customCode is not null");
            return (Criteria) this;
        }

        public Criteria andCustomcodeEqualTo(String value) {
            addCriterion("customCode =", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeNotEqualTo(String value) {
            addCriterion("customCode <>", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeGreaterThan(String value) {
            addCriterion("customCode >", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeGreaterThanOrEqualTo(String value) {
            addCriterion("customCode >=", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeLessThan(String value) {
            addCriterion("customCode <", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeLessThanOrEqualTo(String value) {
            addCriterion("customCode <=", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeLike(String value) {
            addCriterion("customCode like", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeNotLike(String value) {
            addCriterion("customCode not like", value, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeIn(List<String> values) {
            addCriterion("customCode in", values, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeNotIn(List<String> values) {
            addCriterion("customCode not in", values, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeBetween(String value1, String value2) {
            addCriterion("customCode between", value1, value2, "customcode");
            return (Criteria) this;
        }

        public Criteria andCustomcodeNotBetween(String value1, String value2) {
            addCriterion("customCode not between", value1, value2, "customcode");
            return (Criteria) this;
        }

        public Criteria andTimestrIsNull() {
            addCriterion("timeStr is null");
            return (Criteria) this;
        }

        public Criteria andTimestrIsNotNull() {
            addCriterion("timeStr is not null");
            return (Criteria) this;
        }

        public Criteria andTimestrEqualTo(String value) {
            addCriterion("timeStr =", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrNotEqualTo(String value) {
            addCriterion("timeStr <>", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrGreaterThan(String value) {
            addCriterion("timeStr >", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrGreaterThanOrEqualTo(String value) {
            addCriterion("timeStr >=", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrLessThan(String value) {
            addCriterion("timeStr <", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrLessThanOrEqualTo(String value) {
            addCriterion("timeStr <=", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrLike(String value) {
            addCriterion("timeStr like", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrNotLike(String value) {
            addCriterion("timeStr not like", value, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrIn(List<String> values) {
            addCriterion("timeStr in", values, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrNotIn(List<String> values) {
            addCriterion("timeStr not in", values, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrBetween(String value1, String value2) {
            addCriterion("timeStr between", value1, value2, "timestr");
            return (Criteria) this;
        }

        public Criteria andTimestrNotBetween(String value1, String value2) {
            addCriterion("timeStr not between", value1, value2, "timestr");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(`name`) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andMarkLikeInsensitive(String value) {
            addCriterion("upper(mark) like", value.toUpperCase(), "mark");
            return (Criteria) this;
        }

        public Criteria andContentLikeInsensitive(String value) {
            addCriterion("upper(content) like", value.toUpperCase(), "content");
            return (Criteria) this;
        }

        public Criteria andCustomcodeLikeInsensitive(String value) {
            addCriterion("upper(customCode) like", value.toUpperCase(), "customcode");
            return (Criteria) this;
        }

        public Criteria andTimestrLikeInsensitive(String value) {
            addCriterion("upper(timeStr) like", value.toUpperCase(), "timestr");
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