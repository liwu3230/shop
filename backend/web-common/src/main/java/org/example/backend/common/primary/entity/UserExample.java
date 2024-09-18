package org.example.backend.common.primary.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("`uid` is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("`uid` is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("`uid` =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("`uid` <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("`uid` >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("`uid` >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("`uid` <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("`uid` <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("`uid` in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("`uid` not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("`uid` between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("`uid` not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Integer value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Integer value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Integer value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Integer value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Integer value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Integer> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Integer> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Integer value1, Integer value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Integer value1, Integer value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
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

        public Criteria andPartnerIdIsNull() {
            addCriterion("partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNotNull() {
            addCriterion("partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdEqualTo(Integer value) {
            addCriterion("partner_id =", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotEqualTo(Integer value) {
            addCriterion("partner_id <>", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThan(Integer value) {
            addCriterion("partner_id >", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("partner_id >=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThan(Integer value) {
            addCriterion("partner_id <", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("partner_id <=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIn(List<Integer> values) {
            addCriterion("partner_id in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotIn(List<Integer> values) {
            addCriterion("partner_id not in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdBetween(Integer value1, Integer value2) {
            addCriterion("partner_id between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("partner_id not between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddIpIsNull() {
            addCriterion("add_ip is null");
            return (Criteria) this;
        }

        public Criteria andAddIpIsNotNull() {
            addCriterion("add_ip is not null");
            return (Criteria) this;
        }

        public Criteria andAddIpEqualTo(String value) {
            addCriterion("add_ip =", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotEqualTo(String value) {
            addCriterion("add_ip <>", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpGreaterThan(String value) {
            addCriterion("add_ip >", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpGreaterThanOrEqualTo(String value) {
            addCriterion("add_ip >=", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLessThan(String value) {
            addCriterion("add_ip <", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLessThanOrEqualTo(String value) {
            addCriterion("add_ip <=", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLike(String value) {
            addCriterion("add_ip like", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotLike(String value) {
            addCriterion("add_ip not like", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpIn(List<String> values) {
            addCriterion("add_ip in", values, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotIn(List<String> values) {
            addCriterion("add_ip not in", values, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpBetween(String value1, String value2) {
            addCriterion("add_ip between", value1, value2, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotBetween(String value1, String value2) {
            addCriterion("add_ip not between", value1, value2, "addIp");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNull() {
            addCriterion("last_time is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNotNull() {
            addCriterion("last_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeEqualTo(Date value) {
            addCriterion("last_time =", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotEqualTo(Date value) {
            addCriterion("last_time <>", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThan(Date value) {
            addCriterion("last_time >", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_time >=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThan(Date value) {
            addCriterion("last_time <", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_time <=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIn(List<Date> values) {
            addCriterion("last_time in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotIn(List<Date> values) {
            addCriterion("last_time not in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeBetween(Date value1, Date value2) {
            addCriterion("last_time between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_time not between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastIpIsNull() {
            addCriterion("last_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastIpIsNotNull() {
            addCriterion("last_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastIpEqualTo(String value) {
            addCriterion("last_ip =", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpNotEqualTo(String value) {
            addCriterion("last_ip <>", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpGreaterThan(String value) {
            addCriterion("last_ip >", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_ip >=", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpLessThan(String value) {
            addCriterion("last_ip <", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpLessThanOrEqualTo(String value) {
            addCriterion("last_ip <=", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpLike(String value) {
            addCriterion("last_ip like", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpNotLike(String value) {
            addCriterion("last_ip not like", value, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpIn(List<String> values) {
            addCriterion("last_ip in", values, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpNotIn(List<String> values) {
            addCriterion("last_ip not in", values, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpBetween(String value1, String value2) {
            addCriterion("last_ip between", value1, value2, "lastIp");
            return (Criteria) this;
        }

        public Criteria andLastIpNotBetween(String value1, String value2) {
            addCriterion("last_ip not between", value1, value2, "lastIp");
            return (Criteria) this;
        }

        public Criteria andNowMoneyIsNull() {
            addCriterion("now_money is null");
            return (Criteria) this;
        }

        public Criteria andNowMoneyIsNotNull() {
            addCriterion("now_money is not null");
            return (Criteria) this;
        }

        public Criteria andNowMoneyEqualTo(BigDecimal value) {
            addCriterion("now_money =", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyNotEqualTo(BigDecimal value) {
            addCriterion("now_money <>", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyGreaterThan(BigDecimal value) {
            addCriterion("now_money >", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("now_money >=", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyLessThan(BigDecimal value) {
            addCriterion("now_money <", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("now_money <=", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyIn(List<BigDecimal> values) {
            addCriterion("now_money in", values, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyNotIn(List<BigDecimal> values) {
            addCriterion("now_money not in", values, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("now_money between", value1, value2, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("now_money not between", value1, value2, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceIsNull() {
            addCriterion("brokerage_price is null");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceIsNotNull() {
            addCriterion("brokerage_price is not null");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceEqualTo(BigDecimal value) {
            addCriterion("brokerage_price =", value, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceNotEqualTo(BigDecimal value) {
            addCriterion("brokerage_price <>", value, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceGreaterThan(BigDecimal value) {
            addCriterion("brokerage_price >", value, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("brokerage_price >=", value, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceLessThan(BigDecimal value) {
            addCriterion("brokerage_price <", value, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("brokerage_price <=", value, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceIn(List<BigDecimal> values) {
            addCriterion("brokerage_price in", values, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceNotIn(List<BigDecimal> values) {
            addCriterion("brokerage_price not in", values, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brokerage_price between", value1, value2, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andBrokeragePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brokerage_price not between", value1, value2, "brokeragePrice");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andExpIsNull() {
            addCriterion("`exp` is null");
            return (Criteria) this;
        }

        public Criteria andExpIsNotNull() {
            addCriterion("`exp` is not null");
            return (Criteria) this;
        }

        public Criteria andExpEqualTo(BigDecimal value) {
            addCriterion("`exp` =", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotEqualTo(BigDecimal value) {
            addCriterion("`exp` <>", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpGreaterThan(BigDecimal value) {
            addCriterion("`exp` >", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`exp` >=", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpLessThan(BigDecimal value) {
            addCriterion("`exp` <", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`exp` <=", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpIn(List<BigDecimal> values) {
            addCriterion("`exp` in", values, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotIn(List<BigDecimal> values) {
            addCriterion("`exp` not in", values, "exp");
            return (Criteria) this;
        }

        public Criteria andExpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`exp` between", value1, value2, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`exp` not between", value1, value2, "exp");
            return (Criteria) this;
        }

        public Criteria andSignNumIsNull() {
            addCriterion("sign_num is null");
            return (Criteria) this;
        }

        public Criteria andSignNumIsNotNull() {
            addCriterion("sign_num is not null");
            return (Criteria) this;
        }

        public Criteria andSignNumEqualTo(Integer value) {
            addCriterion("sign_num =", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumNotEqualTo(Integer value) {
            addCriterion("sign_num <>", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumGreaterThan(Integer value) {
            addCriterion("sign_num >", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_num >=", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumLessThan(Integer value) {
            addCriterion("sign_num <", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumLessThanOrEqualTo(Integer value) {
            addCriterion("sign_num <=", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumIn(List<Integer> values) {
            addCriterion("sign_num in", values, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumNotIn(List<Integer> values) {
            addCriterion("sign_num not in", values, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumBetween(Integer value1, Integer value2) {
            addCriterion("sign_num between", value1, value2, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_num not between", value1, value2, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignRemindIsNull() {
            addCriterion("sign_remind is null");
            return (Criteria) this;
        }

        public Criteria andSignRemindIsNotNull() {
            addCriterion("sign_remind is not null");
            return (Criteria) this;
        }

        public Criteria andSignRemindEqualTo(Integer value) {
            addCriterion("sign_remind =", value, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindNotEqualTo(Integer value) {
            addCriterion("sign_remind <>", value, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindGreaterThan(Integer value) {
            addCriterion("sign_remind >", value, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_remind >=", value, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindLessThan(Integer value) {
            addCriterion("sign_remind <", value, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindLessThanOrEqualTo(Integer value) {
            addCriterion("sign_remind <=", value, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindIn(List<Integer> values) {
            addCriterion("sign_remind in", values, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindNotIn(List<Integer> values) {
            addCriterion("sign_remind not in", values, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindBetween(Integer value1, Integer value2) {
            addCriterion("sign_remind between", value1, value2, "signRemind");
            return (Criteria) this;
        }

        public Criteria andSignRemindNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_remind not between", value1, value2, "signRemind");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("`level` is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("`level` is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("`level` =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("`level` <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("`level` >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("`level` >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("`level` <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("`level` <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("`level` in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("`level` not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("`level` between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("`level` not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNull() {
            addCriterion("agent_level is null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNotNull() {
            addCriterion("agent_level is not null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelEqualTo(Integer value) {
            addCriterion("agent_level =", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotEqualTo(Integer value) {
            addCriterion("agent_level <>", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThan(Integer value) {
            addCriterion("agent_level >", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_level >=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThan(Integer value) {
            addCriterion("agent_level <", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("agent_level <=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIn(List<Integer> values) {
            addCriterion("agent_level in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotIn(List<Integer> values) {
            addCriterion("agent_level not in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelBetween(Integer value1, Integer value2) {
            addCriterion("agent_level between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_level not between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenIsNull() {
            addCriterion("spread_open is null");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenIsNotNull() {
            addCriterion("spread_open is not null");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenEqualTo(Integer value) {
            addCriterion("spread_open =", value, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenNotEqualTo(Integer value) {
            addCriterion("spread_open <>", value, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenGreaterThan(Integer value) {
            addCriterion("spread_open >", value, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("spread_open >=", value, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenLessThan(Integer value) {
            addCriterion("spread_open <", value, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenLessThanOrEqualTo(Integer value) {
            addCriterion("spread_open <=", value, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenIn(List<Integer> values) {
            addCriterion("spread_open in", values, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenNotIn(List<Integer> values) {
            addCriterion("spread_open not in", values, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenBetween(Integer value1, Integer value2) {
            addCriterion("spread_open between", value1, value2, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("spread_open not between", value1, value2, "spreadOpen");
            return (Criteria) this;
        }

        public Criteria andSpreadUidIsNull() {
            addCriterion("spread_uid is null");
            return (Criteria) this;
        }

        public Criteria andSpreadUidIsNotNull() {
            addCriterion("spread_uid is not null");
            return (Criteria) this;
        }

        public Criteria andSpreadUidEqualTo(Integer value) {
            addCriterion("spread_uid =", value, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidNotEqualTo(Integer value) {
            addCriterion("spread_uid <>", value, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidGreaterThan(Integer value) {
            addCriterion("spread_uid >", value, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("spread_uid >=", value, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidLessThan(Integer value) {
            addCriterion("spread_uid <", value, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidLessThanOrEqualTo(Integer value) {
            addCriterion("spread_uid <=", value, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidIn(List<Integer> values) {
            addCriterion("spread_uid in", values, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidNotIn(List<Integer> values) {
            addCriterion("spread_uid not in", values, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidBetween(Integer value1, Integer value2) {
            addCriterion("spread_uid between", value1, value2, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadUidNotBetween(Integer value1, Integer value2) {
            addCriterion("spread_uid not between", value1, value2, "spreadUid");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeIsNull() {
            addCriterion("spread_time is null");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeIsNotNull() {
            addCriterion("spread_time is not null");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeEqualTo(Date value) {
            addCriterion("spread_time =", value, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeNotEqualTo(Date value) {
            addCriterion("spread_time <>", value, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeGreaterThan(Date value) {
            addCriterion("spread_time >", value, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("spread_time >=", value, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeLessThan(Date value) {
            addCriterion("spread_time <", value, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeLessThanOrEqualTo(Date value) {
            addCriterion("spread_time <=", value, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeIn(List<Date> values) {
            addCriterion("spread_time in", values, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeNotIn(List<Date> values) {
            addCriterion("spread_time not in", values, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeBetween(Date value1, Date value2) {
            addCriterion("spread_time between", value1, value2, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andSpreadTimeNotBetween(Date value1, Date value2) {
            addCriterion("spread_time not between", value1, value2, "spreadTime");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andIsPromoterIsNull() {
            addCriterion("is_promoter is null");
            return (Criteria) this;
        }

        public Criteria andIsPromoterIsNotNull() {
            addCriterion("is_promoter is not null");
            return (Criteria) this;
        }

        public Criteria andIsPromoterEqualTo(Integer value) {
            addCriterion("is_promoter =", value, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterNotEqualTo(Integer value) {
            addCriterion("is_promoter <>", value, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterGreaterThan(Integer value) {
            addCriterion("is_promoter >", value, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_promoter >=", value, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterLessThan(Integer value) {
            addCriterion("is_promoter <", value, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterLessThanOrEqualTo(Integer value) {
            addCriterion("is_promoter <=", value, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterIn(List<Integer> values) {
            addCriterion("is_promoter in", values, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterNotIn(List<Integer> values) {
            addCriterion("is_promoter not in", values, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterBetween(Integer value1, Integer value2) {
            addCriterion("is_promoter between", value1, value2, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andIsPromoterNotBetween(Integer value1, Integer value2) {
            addCriterion("is_promoter not between", value1, value2, "isPromoter");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNull() {
            addCriterion("pay_count is null");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNotNull() {
            addCriterion("pay_count is not null");
            return (Criteria) this;
        }

        public Criteria andPayCountEqualTo(Integer value) {
            addCriterion("pay_count =", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotEqualTo(Integer value) {
            addCriterion("pay_count <>", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThan(Integer value) {
            addCriterion("pay_count >", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_count >=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThan(Integer value) {
            addCriterion("pay_count <", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThanOrEqualTo(Integer value) {
            addCriterion("pay_count <=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountIn(List<Integer> values) {
            addCriterion("pay_count in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotIn(List<Integer> values) {
            addCriterion("pay_count not in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountBetween(Integer value1, Integer value2) {
            addCriterion("pay_count between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_count not between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountIsNull() {
            addCriterion("spread_count is null");
            return (Criteria) this;
        }

        public Criteria andSpreadCountIsNotNull() {
            addCriterion("spread_count is not null");
            return (Criteria) this;
        }

        public Criteria andSpreadCountEqualTo(Integer value) {
            addCriterion("spread_count =", value, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountNotEqualTo(Integer value) {
            addCriterion("spread_count <>", value, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountGreaterThan(Integer value) {
            addCriterion("spread_count >", value, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("spread_count >=", value, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountLessThan(Integer value) {
            addCriterion("spread_count <", value, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountLessThanOrEqualTo(Integer value) {
            addCriterion("spread_count <=", value, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountIn(List<Integer> values) {
            addCriterion("spread_count in", values, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountNotIn(List<Integer> values) {
            addCriterion("spread_count not in", values, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountBetween(Integer value1, Integer value2) {
            addCriterion("spread_count between", value1, value2, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andSpreadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("spread_count not between", value1, value2, "spreadCount");
            return (Criteria) this;
        }

        public Criteria andCleanTimeIsNull() {
            addCriterion("clean_time is null");
            return (Criteria) this;
        }

        public Criteria andCleanTimeIsNotNull() {
            addCriterion("clean_time is not null");
            return (Criteria) this;
        }

        public Criteria andCleanTimeEqualTo(Date value) {
            addCriterion("clean_time =", value, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeNotEqualTo(Date value) {
            addCriterion("clean_time <>", value, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeGreaterThan(Date value) {
            addCriterion("clean_time >", value, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("clean_time >=", value, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeLessThan(Date value) {
            addCriterion("clean_time <", value, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeLessThanOrEqualTo(Date value) {
            addCriterion("clean_time <=", value, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeIn(List<Date> values) {
            addCriterion("clean_time in", values, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeNotIn(List<Date> values) {
            addCriterion("clean_time not in", values, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeBetween(Date value1, Date value2) {
            addCriterion("clean_time between", value1, value2, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andCleanTimeNotBetween(Date value1, Date value2) {
            addCriterion("clean_time not between", value1, value2, "cleanTime");
            return (Criteria) this;
        }

        public Criteria andAddresIsNull() {
            addCriterion("addres is null");
            return (Criteria) this;
        }

        public Criteria andAddresIsNotNull() {
            addCriterion("addres is not null");
            return (Criteria) this;
        }

        public Criteria andAddresEqualTo(String value) {
            addCriterion("addres =", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresNotEqualTo(String value) {
            addCriterion("addres <>", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresGreaterThan(String value) {
            addCriterion("addres >", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresGreaterThanOrEqualTo(String value) {
            addCriterion("addres >=", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresLessThan(String value) {
            addCriterion("addres <", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresLessThanOrEqualTo(String value) {
            addCriterion("addres <=", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresLike(String value) {
            addCriterion("addres like", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresNotLike(String value) {
            addCriterion("addres not like", value, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresIn(List<String> values) {
            addCriterion("addres in", values, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresNotIn(List<String> values) {
            addCriterion("addres not in", values, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresBetween(String value1, String value2) {
            addCriterion("addres between", value1, value2, "addres");
            return (Criteria) this;
        }

        public Criteria andAddresNotBetween(String value1, String value2) {
            addCriterion("addres not between", value1, value2, "addres");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNull() {
            addCriterion("adminid is null");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNotNull() {
            addCriterion("adminid is not null");
            return (Criteria) this;
        }

        public Criteria andAdminidEqualTo(Integer value) {
            addCriterion("adminid =", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotEqualTo(Integer value) {
            addCriterion("adminid <>", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThan(Integer value) {
            addCriterion("adminid >", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminid >=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThan(Integer value) {
            addCriterion("adminid <", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThanOrEqualTo(Integer value) {
            addCriterion("adminid <=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidIn(List<Integer> values) {
            addCriterion("adminid in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotIn(List<Integer> values) {
            addCriterion("adminid not in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidBetween(Integer value1, Integer value2) {
            addCriterion("adminid between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminid not between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNull() {
            addCriterion("login_type is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNotNull() {
            addCriterion("login_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeEqualTo(String value) {
            addCriterion("login_type =", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotEqualTo(String value) {
            addCriterion("login_type <>", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThan(String value) {
            addCriterion("login_type >", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThanOrEqualTo(String value) {
            addCriterion("login_type >=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThan(String value) {
            addCriterion("login_type <", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThanOrEqualTo(String value) {
            addCriterion("login_type <=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLike(String value) {
            addCriterion("login_type like", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotLike(String value) {
            addCriterion("login_type not like", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIn(List<String> values) {
            addCriterion("login_type in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotIn(List<String> values) {
            addCriterion("login_type not in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeBetween(String value1, String value2) {
            addCriterion("login_type between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotBetween(String value1, String value2) {
            addCriterion("login_type not between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneIsNull() {
            addCriterion("record_phone is null");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneIsNotNull() {
            addCriterion("record_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneEqualTo(String value) {
            addCriterion("record_phone =", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneNotEqualTo(String value) {
            addCriterion("record_phone <>", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneGreaterThan(String value) {
            addCriterion("record_phone >", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("record_phone >=", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneLessThan(String value) {
            addCriterion("record_phone <", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneLessThanOrEqualTo(String value) {
            addCriterion("record_phone <=", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneLike(String value) {
            addCriterion("record_phone like", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneNotLike(String value) {
            addCriterion("record_phone not like", value, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneIn(List<String> values) {
            addCriterion("record_phone in", values, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneNotIn(List<String> values) {
            addCriterion("record_phone not in", values, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneBetween(String value1, String value2) {
            addCriterion("record_phone between", value1, value2, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneNotBetween(String value1, String value2) {
            addCriterion("record_phone not between", value1, value2, "recordPhone");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelIsNull() {
            addCriterion("is_money_level is null");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelIsNotNull() {
            addCriterion("is_money_level is not null");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelEqualTo(Integer value) {
            addCriterion("is_money_level =", value, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelNotEqualTo(Integer value) {
            addCriterion("is_money_level <>", value, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelGreaterThan(Integer value) {
            addCriterion("is_money_level >", value, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_money_level >=", value, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelLessThan(Integer value) {
            addCriterion("is_money_level <", value, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelLessThanOrEqualTo(Integer value) {
            addCriterion("is_money_level <=", value, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelIn(List<Integer> values) {
            addCriterion("is_money_level in", values, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelNotIn(List<Integer> values) {
            addCriterion("is_money_level not in", values, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelBetween(Integer value1, Integer value2) {
            addCriterion("is_money_level between", value1, value2, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_money_level not between", value1, value2, "isMoneyLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelIsNull() {
            addCriterion("is_ever_level is null");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelIsNotNull() {
            addCriterion("is_ever_level is not null");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelEqualTo(Integer value) {
            addCriterion("is_ever_level =", value, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelNotEqualTo(Integer value) {
            addCriterion("is_ever_level <>", value, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelGreaterThan(Integer value) {
            addCriterion("is_ever_level >", value, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_ever_level >=", value, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelLessThan(Integer value) {
            addCriterion("is_ever_level <", value, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelLessThanOrEqualTo(Integer value) {
            addCriterion("is_ever_level <=", value, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelIn(List<Integer> values) {
            addCriterion("is_ever_level in", values, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelNotIn(List<Integer> values) {
            addCriterion("is_ever_level not in", values, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelBetween(Integer value1, Integer value2) {
            addCriterion("is_ever_level between", value1, value2, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andIsEverLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_ever_level not between", value1, value2, "isEverLevel");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeIsNull() {
            addCriterion("overdue_time is null");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeIsNotNull() {
            addCriterion("overdue_time is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeEqualTo(Date value) {
            addCriterion("overdue_time =", value, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeNotEqualTo(Date value) {
            addCriterion("overdue_time <>", value, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeGreaterThan(Date value) {
            addCriterion("overdue_time >", value, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("overdue_time >=", value, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeLessThan(Date value) {
            addCriterion("overdue_time <", value, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeLessThanOrEqualTo(Date value) {
            addCriterion("overdue_time <=", value, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeIn(List<Date> values) {
            addCriterion("overdue_time in", values, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeNotIn(List<Date> values) {
            addCriterion("overdue_time not in", values, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeBetween(Date value1, Date value2) {
            addCriterion("overdue_time between", value1, value2, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andOverdueTimeNotBetween(Date value1, Date value2) {
            addCriterion("overdue_time not between", value1, value2, "overdueTime");
            return (Criteria) this;
        }

        public Criteria andUniqidIsNull() {
            addCriterion("uniqid is null");
            return (Criteria) this;
        }

        public Criteria andUniqidIsNotNull() {
            addCriterion("uniqid is not null");
            return (Criteria) this;
        }

        public Criteria andUniqidEqualTo(String value) {
            addCriterion("uniqid =", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidNotEqualTo(String value) {
            addCriterion("uniqid <>", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidGreaterThan(String value) {
            addCriterion("uniqid >", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidGreaterThanOrEqualTo(String value) {
            addCriterion("uniqid >=", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidLessThan(String value) {
            addCriterion("uniqid <", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidLessThanOrEqualTo(String value) {
            addCriterion("uniqid <=", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidLike(String value) {
            addCriterion("uniqid like", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidNotLike(String value) {
            addCriterion("uniqid not like", value, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidIn(List<String> values) {
            addCriterion("uniqid in", values, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidNotIn(List<String> values) {
            addCriterion("uniqid not in", values, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidBetween(String value1, String value2) {
            addCriterion("uniqid between", value1, value2, "uniqid");
            return (Criteria) this;
        }

        public Criteria andUniqidNotBetween(String value1, String value2) {
            addCriterion("uniqid not between", value1, value2, "uniqid");
            return (Criteria) this;
        }

        public Criteria andDivisionNameIsNull() {
            addCriterion("division_name is null");
            return (Criteria) this;
        }

        public Criteria andDivisionNameIsNotNull() {
            addCriterion("division_name is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionNameEqualTo(String value) {
            addCriterion("division_name =", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameNotEqualTo(String value) {
            addCriterion("division_name <>", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameGreaterThan(String value) {
            addCriterion("division_name >", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameGreaterThanOrEqualTo(String value) {
            addCriterion("division_name >=", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameLessThan(String value) {
            addCriterion("division_name <", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameLessThanOrEqualTo(String value) {
            addCriterion("division_name <=", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameLike(String value) {
            addCriterion("division_name like", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameNotLike(String value) {
            addCriterion("division_name not like", value, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameIn(List<String> values) {
            addCriterion("division_name in", values, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameNotIn(List<String> values) {
            addCriterion("division_name not in", values, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameBetween(String value1, String value2) {
            addCriterion("division_name between", value1, value2, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionNameNotBetween(String value1, String value2) {
            addCriterion("division_name not between", value1, value2, "divisionName");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeIsNull() {
            addCriterion("division_type is null");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeIsNotNull() {
            addCriterion("division_type is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeEqualTo(Integer value) {
            addCriterion("division_type =", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeNotEqualTo(Integer value) {
            addCriterion("division_type <>", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeGreaterThan(Integer value) {
            addCriterion("division_type >", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_type >=", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeLessThan(Integer value) {
            addCriterion("division_type <", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("division_type <=", value, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeIn(List<Integer> values) {
            addCriterion("division_type in", values, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeNotIn(List<Integer> values) {
            addCriterion("division_type not in", values, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeBetween(Integer value1, Integer value2) {
            addCriterion("division_type between", value1, value2, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("division_type not between", value1, value2, "divisionType");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusIsNull() {
            addCriterion("division_status is null");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusIsNotNull() {
            addCriterion("division_status is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusEqualTo(Integer value) {
            addCriterion("division_status =", value, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusNotEqualTo(Integer value) {
            addCriterion("division_status <>", value, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusGreaterThan(Integer value) {
            addCriterion("division_status >", value, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_status >=", value, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusLessThan(Integer value) {
            addCriterion("division_status <", value, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("division_status <=", value, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusIn(List<Integer> values) {
            addCriterion("division_status in", values, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusNotIn(List<Integer> values) {
            addCriterion("division_status not in", values, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusBetween(Integer value1, Integer value2) {
            addCriterion("division_status between", value1, value2, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andDivisionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("division_status not between", value1, value2, "divisionStatus");
            return (Criteria) this;
        }

        public Criteria andIsDivisionIsNull() {
            addCriterion("is_division is null");
            return (Criteria) this;
        }

        public Criteria andIsDivisionIsNotNull() {
            addCriterion("is_division is not null");
            return (Criteria) this;
        }

        public Criteria andIsDivisionEqualTo(Integer value) {
            addCriterion("is_division =", value, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionNotEqualTo(Integer value) {
            addCriterion("is_division <>", value, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionGreaterThan(Integer value) {
            addCriterion("is_division >", value, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_division >=", value, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionLessThan(Integer value) {
            addCriterion("is_division <", value, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionLessThanOrEqualTo(Integer value) {
            addCriterion("is_division <=", value, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionIn(List<Integer> values) {
            addCriterion("is_division in", values, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionNotIn(List<Integer> values) {
            addCriterion("is_division not in", values, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionBetween(Integer value1, Integer value2) {
            addCriterion("is_division between", value1, value2, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsDivisionNotBetween(Integer value1, Integer value2) {
            addCriterion("is_division not between", value1, value2, "isDivision");
            return (Criteria) this;
        }

        public Criteria andIsAgentIsNull() {
            addCriterion("is_agent is null");
            return (Criteria) this;
        }

        public Criteria andIsAgentIsNotNull() {
            addCriterion("is_agent is not null");
            return (Criteria) this;
        }

        public Criteria andIsAgentEqualTo(Integer value) {
            addCriterion("is_agent =", value, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentNotEqualTo(Integer value) {
            addCriterion("is_agent <>", value, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentGreaterThan(Integer value) {
            addCriterion("is_agent >", value, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_agent >=", value, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentLessThan(Integer value) {
            addCriterion("is_agent <", value, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentLessThanOrEqualTo(Integer value) {
            addCriterion("is_agent <=", value, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentIn(List<Integer> values) {
            addCriterion("is_agent in", values, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentNotIn(List<Integer> values) {
            addCriterion("is_agent not in", values, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentBetween(Integer value1, Integer value2) {
            addCriterion("is_agent between", value1, value2, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsAgentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_agent not between", value1, value2, "isAgent");
            return (Criteria) this;
        }

        public Criteria andIsStaffIsNull() {
            addCriterion("is_staff is null");
            return (Criteria) this;
        }

        public Criteria andIsStaffIsNotNull() {
            addCriterion("is_staff is not null");
            return (Criteria) this;
        }

        public Criteria andIsStaffEqualTo(Integer value) {
            addCriterion("is_staff =", value, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffNotEqualTo(Integer value) {
            addCriterion("is_staff <>", value, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffGreaterThan(Integer value) {
            addCriterion("is_staff >", value, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_staff >=", value, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffLessThan(Integer value) {
            addCriterion("is_staff <", value, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffLessThanOrEqualTo(Integer value) {
            addCriterion("is_staff <=", value, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffIn(List<Integer> values) {
            addCriterion("is_staff in", values, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffNotIn(List<Integer> values) {
            addCriterion("is_staff not in", values, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffBetween(Integer value1, Integer value2) {
            addCriterion("is_staff between", value1, value2, "isStaff");
            return (Criteria) this;
        }

        public Criteria andIsStaffNotBetween(Integer value1, Integer value2) {
            addCriterion("is_staff not between", value1, value2, "isStaff");
            return (Criteria) this;
        }

        public Criteria andDivisionIdIsNull() {
            addCriterion("division_id is null");
            return (Criteria) this;
        }

        public Criteria andDivisionIdIsNotNull() {
            addCriterion("division_id is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionIdEqualTo(Integer value) {
            addCriterion("division_id =", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdNotEqualTo(Integer value) {
            addCriterion("division_id <>", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdGreaterThan(Integer value) {
            addCriterion("division_id >", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_id >=", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdLessThan(Integer value) {
            addCriterion("division_id <", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdLessThanOrEqualTo(Integer value) {
            addCriterion("division_id <=", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdIn(List<Integer> values) {
            addCriterion("division_id in", values, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdNotIn(List<Integer> values) {
            addCriterion("division_id not in", values, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdBetween(Integer value1, Integer value2) {
            addCriterion("division_id between", value1, value2, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("division_id not between", value1, value2, "divisionId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Integer value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Integer value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Integer value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Integer value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Integer> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Integer> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentIsNull() {
            addCriterion("division_percent is null");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentIsNotNull() {
            addCriterion("division_percent is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentEqualTo(Integer value) {
            addCriterion("division_percent =", value, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentNotEqualTo(Integer value) {
            addCriterion("division_percent <>", value, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentGreaterThan(Integer value) {
            addCriterion("division_percent >", value, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_percent >=", value, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentLessThan(Integer value) {
            addCriterion("division_percent <", value, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentLessThanOrEqualTo(Integer value) {
            addCriterion("division_percent <=", value, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentIn(List<Integer> values) {
            addCriterion("division_percent in", values, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentNotIn(List<Integer> values) {
            addCriterion("division_percent not in", values, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentBetween(Integer value1, Integer value2) {
            addCriterion("division_percent between", value1, value2, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionPercentNotBetween(Integer value1, Integer value2) {
            addCriterion("division_percent not between", value1, value2, "divisionPercent");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeIsNull() {
            addCriterion("division_change_time is null");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeIsNotNull() {
            addCriterion("division_change_time is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeEqualTo(Integer value) {
            addCriterion("division_change_time =", value, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeNotEqualTo(Integer value) {
            addCriterion("division_change_time <>", value, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeGreaterThan(Integer value) {
            addCriterion("division_change_time >", value, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_change_time >=", value, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeLessThan(Integer value) {
            addCriterion("division_change_time <", value, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("division_change_time <=", value, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeIn(List<Integer> values) {
            addCriterion("division_change_time in", values, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeNotIn(List<Integer> values) {
            addCriterion("division_change_time not in", values, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeBetween(Integer value1, Integer value2) {
            addCriterion("division_change_time between", value1, value2, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionChangeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("division_change_time not between", value1, value2, "divisionChangeTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeIsNull() {
            addCriterion("division_end_time is null");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeIsNotNull() {
            addCriterion("division_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeEqualTo(Integer value) {
            addCriterion("division_end_time =", value, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeNotEqualTo(Integer value) {
            addCriterion("division_end_time <>", value, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeGreaterThan(Integer value) {
            addCriterion("division_end_time >", value, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_end_time >=", value, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeLessThan(Integer value) {
            addCriterion("division_end_time <", value, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("division_end_time <=", value, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeIn(List<Integer> values) {
            addCriterion("division_end_time in", values, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeNotIn(List<Integer> values) {
            addCriterion("division_end_time not in", values, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("division_end_time between", value1, value2, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("division_end_time not between", value1, value2, "divisionEndTime");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteIsNull() {
            addCriterion("division_invite is null");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteIsNotNull() {
            addCriterion("division_invite is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteEqualTo(Integer value) {
            addCriterion("division_invite =", value, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteNotEqualTo(Integer value) {
            addCriterion("division_invite <>", value, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteGreaterThan(Integer value) {
            addCriterion("division_invite >", value, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_invite >=", value, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteLessThan(Integer value) {
            addCriterion("division_invite <", value, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteLessThanOrEqualTo(Integer value) {
            addCriterion("division_invite <=", value, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteIn(List<Integer> values) {
            addCriterion("division_invite in", values, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteNotIn(List<Integer> values) {
            addCriterion("division_invite not in", values, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteBetween(Integer value1, Integer value2) {
            addCriterion("division_invite between", value1, value2, "divisionInvite");
            return (Criteria) this;
        }

        public Criteria andDivisionInviteNotBetween(Integer value1, Integer value2) {
            addCriterion("division_invite not between", value1, value2, "divisionInvite");
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

        public Criteria andAccountLikeInsensitive(String value) {
            addCriterion("upper(account) like", value.toUpperCase(), "account");
            return (Criteria) this;
        }

        public Criteria andPwdLikeInsensitive(String value) {
            addCriterion("upper(pwd) like", value.toUpperCase(), "pwd");
            return (Criteria) this;
        }

        public Criteria andRealNameLikeInsensitive(String value) {
            addCriterion("upper(real_name) like", value.toUpperCase(), "realName");
            return (Criteria) this;
        }

        public Criteria andCardIdLikeInsensitive(String value) {
            addCriterion("upper(card_id) like", value.toUpperCase(), "cardId");
            return (Criteria) this;
        }

        public Criteria andMarkLikeInsensitive(String value) {
            addCriterion("upper(mark) like", value.toUpperCase(), "mark");
            return (Criteria) this;
        }

        public Criteria andNicknameLikeInsensitive(String value) {
            addCriterion("upper(nickname) like", value.toUpperCase(), "nickname");
            return (Criteria) this;
        }

        public Criteria andAvatarLikeInsensitive(String value) {
            addCriterion("upper(avatar) like", value.toUpperCase(), "avatar");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(phone) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andAddIpLikeInsensitive(String value) {
            addCriterion("upper(add_ip) like", value.toUpperCase(), "addIp");
            return (Criteria) this;
        }

        public Criteria andLastIpLikeInsensitive(String value) {
            addCriterion("upper(last_ip) like", value.toUpperCase(), "lastIp");
            return (Criteria) this;
        }

        public Criteria andUserTypeLikeInsensitive(String value) {
            addCriterion("upper(user_type) like", value.toUpperCase(), "userType");
            return (Criteria) this;
        }

        public Criteria andAddresLikeInsensitive(String value) {
            addCriterion("upper(addres) like", value.toUpperCase(), "addres");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLikeInsensitive(String value) {
            addCriterion("upper(login_type) like", value.toUpperCase(), "loginType");
            return (Criteria) this;
        }

        public Criteria andRecordPhoneLikeInsensitive(String value) {
            addCriterion("upper(record_phone) like", value.toUpperCase(), "recordPhone");
            return (Criteria) this;
        }

        public Criteria andUniqidLikeInsensitive(String value) {
            addCriterion("upper(uniqid) like", value.toUpperCase(), "uniqid");
            return (Criteria) this;
        }

        public Criteria andDivisionNameLikeInsensitive(String value) {
            addCriterion("upper(division_name) like", value.toUpperCase(), "divisionName");
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