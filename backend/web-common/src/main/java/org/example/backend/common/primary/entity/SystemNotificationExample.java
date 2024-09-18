package org.example.backend.common.primary.entity;

import java.util.ArrayList;
import java.util.List;

public class SystemNotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SystemNotificationExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNull() {
            addCriterion("is_system is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNotNull() {
            addCriterion("is_system is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemEqualTo(Integer value) {
            addCriterion("is_system =", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotEqualTo(Integer value) {
            addCriterion("is_system <>", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThan(Integer value) {
            addCriterion("is_system >", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_system >=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThan(Integer value) {
            addCriterion("is_system <", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThanOrEqualTo(Integer value) {
            addCriterion("is_system <=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemIn(List<Integer> values) {
            addCriterion("is_system in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotIn(List<Integer> values) {
            addCriterion("is_system not in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemBetween(Integer value1, Integer value2) {
            addCriterion("is_system between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotBetween(Integer value1, Integer value2) {
            addCriterion("is_system not between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andSystemTitleIsNull() {
            addCriterion("system_title is null");
            return (Criteria) this;
        }

        public Criteria andSystemTitleIsNotNull() {
            addCriterion("system_title is not null");
            return (Criteria) this;
        }

        public Criteria andSystemTitleEqualTo(String value) {
            addCriterion("system_title =", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleNotEqualTo(String value) {
            addCriterion("system_title <>", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleGreaterThan(String value) {
            addCriterion("system_title >", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleGreaterThanOrEqualTo(String value) {
            addCriterion("system_title >=", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleLessThan(String value) {
            addCriterion("system_title <", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleLessThanOrEqualTo(String value) {
            addCriterion("system_title <=", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleLike(String value) {
            addCriterion("system_title like", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleNotLike(String value) {
            addCriterion("system_title not like", value, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleIn(List<String> values) {
            addCriterion("system_title in", values, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleNotIn(List<String> values) {
            addCriterion("system_title not in", values, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleBetween(String value1, String value2) {
            addCriterion("system_title between", value1, value2, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTitleNotBetween(String value1, String value2) {
            addCriterion("system_title not between", value1, value2, "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTextIsNull() {
            addCriterion("system_text is null");
            return (Criteria) this;
        }

        public Criteria andSystemTextIsNotNull() {
            addCriterion("system_text is not null");
            return (Criteria) this;
        }

        public Criteria andSystemTextEqualTo(String value) {
            addCriterion("system_text =", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextNotEqualTo(String value) {
            addCriterion("system_text <>", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextGreaterThan(String value) {
            addCriterion("system_text >", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextGreaterThanOrEqualTo(String value) {
            addCriterion("system_text >=", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextLessThan(String value) {
            addCriterion("system_text <", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextLessThanOrEqualTo(String value) {
            addCriterion("system_text <=", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextLike(String value) {
            addCriterion("system_text like", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextNotLike(String value) {
            addCriterion("system_text not like", value, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextIn(List<String> values) {
            addCriterion("system_text in", values, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextNotIn(List<String> values) {
            addCriterion("system_text not in", values, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextBetween(String value1, String value2) {
            addCriterion("system_text between", value1, value2, "systemText");
            return (Criteria) this;
        }

        public Criteria andSystemTextNotBetween(String value1, String value2) {
            addCriterion("system_text not between", value1, value2, "systemText");
            return (Criteria) this;
        }

        public Criteria andIsWechatIsNull() {
            addCriterion("is_wechat is null");
            return (Criteria) this;
        }

        public Criteria andIsWechatIsNotNull() {
            addCriterion("is_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andIsWechatEqualTo(Integer value) {
            addCriterion("is_wechat =", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatNotEqualTo(Integer value) {
            addCriterion("is_wechat <>", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatGreaterThan(Integer value) {
            addCriterion("is_wechat >", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_wechat >=", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatLessThan(Integer value) {
            addCriterion("is_wechat <", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatLessThanOrEqualTo(Integer value) {
            addCriterion("is_wechat <=", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatIn(List<Integer> values) {
            addCriterion("is_wechat in", values, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatNotIn(List<Integer> values) {
            addCriterion("is_wechat not in", values, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatBetween(Integer value1, Integer value2) {
            addCriterion("is_wechat between", value1, value2, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatNotBetween(Integer value1, Integer value2) {
            addCriterion("is_wechat not between", value1, value2, "isWechat");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyIsNull() {
            addCriterion("wechat_tempkey is null");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyIsNotNull() {
            addCriterion("wechat_tempkey is not null");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyEqualTo(String value) {
            addCriterion("wechat_tempkey =", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyNotEqualTo(String value) {
            addCriterion("wechat_tempkey <>", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyGreaterThan(String value) {
            addCriterion("wechat_tempkey >", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_tempkey >=", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyLessThan(String value) {
            addCriterion("wechat_tempkey <", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyLessThanOrEqualTo(String value) {
            addCriterion("wechat_tempkey <=", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyLike(String value) {
            addCriterion("wechat_tempkey like", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyNotLike(String value) {
            addCriterion("wechat_tempkey not like", value, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyIn(List<String> values) {
            addCriterion("wechat_tempkey in", values, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyNotIn(List<String> values) {
            addCriterion("wechat_tempkey not in", values, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyBetween(String value1, String value2) {
            addCriterion("wechat_tempkey between", value1, value2, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyNotBetween(String value1, String value2) {
            addCriterion("wechat_tempkey not between", value1, value2, "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatContentIsNull() {
            addCriterion("wechat_content is null");
            return (Criteria) this;
        }

        public Criteria andWechatContentIsNotNull() {
            addCriterion("wechat_content is not null");
            return (Criteria) this;
        }

        public Criteria andWechatContentEqualTo(String value) {
            addCriterion("wechat_content =", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentNotEqualTo(String value) {
            addCriterion("wechat_content <>", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentGreaterThan(String value) {
            addCriterion("wechat_content >", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_content >=", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentLessThan(String value) {
            addCriterion("wechat_content <", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentLessThanOrEqualTo(String value) {
            addCriterion("wechat_content <=", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentLike(String value) {
            addCriterion("wechat_content like", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentNotLike(String value) {
            addCriterion("wechat_content not like", value, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentIn(List<String> values) {
            addCriterion("wechat_content in", values, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentNotIn(List<String> values) {
            addCriterion("wechat_content not in", values, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentBetween(String value1, String value2) {
            addCriterion("wechat_content between", value1, value2, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatContentNotBetween(String value1, String value2) {
            addCriterion("wechat_content not between", value1, value2, "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatKidIsNull() {
            addCriterion("wechat_kid is null");
            return (Criteria) this;
        }

        public Criteria andWechatKidIsNotNull() {
            addCriterion("wechat_kid is not null");
            return (Criteria) this;
        }

        public Criteria andWechatKidEqualTo(String value) {
            addCriterion("wechat_kid =", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidNotEqualTo(String value) {
            addCriterion("wechat_kid <>", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidGreaterThan(String value) {
            addCriterion("wechat_kid >", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_kid >=", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidLessThan(String value) {
            addCriterion("wechat_kid <", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidLessThanOrEqualTo(String value) {
            addCriterion("wechat_kid <=", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidLike(String value) {
            addCriterion("wechat_kid like", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidNotLike(String value) {
            addCriterion("wechat_kid not like", value, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidIn(List<String> values) {
            addCriterion("wechat_kid in", values, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidNotIn(List<String> values) {
            addCriterion("wechat_kid not in", values, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidBetween(String value1, String value2) {
            addCriterion("wechat_kid between", value1, value2, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatKidNotBetween(String value1, String value2) {
            addCriterion("wechat_kid not between", value1, value2, "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidIsNull() {
            addCriterion("wechat_tempid is null");
            return (Criteria) this;
        }

        public Criteria andWechatTempidIsNotNull() {
            addCriterion("wechat_tempid is not null");
            return (Criteria) this;
        }

        public Criteria andWechatTempidEqualTo(String value) {
            addCriterion("wechat_tempid =", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidNotEqualTo(String value) {
            addCriterion("wechat_tempid <>", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidGreaterThan(String value) {
            addCriterion("wechat_tempid >", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_tempid >=", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidLessThan(String value) {
            addCriterion("wechat_tempid <", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidLessThanOrEqualTo(String value) {
            addCriterion("wechat_tempid <=", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidLike(String value) {
            addCriterion("wechat_tempid like", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidNotLike(String value) {
            addCriterion("wechat_tempid not like", value, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidIn(List<String> values) {
            addCriterion("wechat_tempid in", values, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidNotIn(List<String> values) {
            addCriterion("wechat_tempid not in", values, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidBetween(String value1, String value2) {
            addCriterion("wechat_tempid between", value1, value2, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidNotBetween(String value1, String value2) {
            addCriterion("wechat_tempid not between", value1, value2, "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatDataIsNull() {
            addCriterion("wechat_data is null");
            return (Criteria) this;
        }

        public Criteria andWechatDataIsNotNull() {
            addCriterion("wechat_data is not null");
            return (Criteria) this;
        }

        public Criteria andWechatDataEqualTo(String value) {
            addCriterion("wechat_data =", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataNotEqualTo(String value) {
            addCriterion("wechat_data <>", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataGreaterThan(String value) {
            addCriterion("wechat_data >", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_data >=", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataLessThan(String value) {
            addCriterion("wechat_data <", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataLessThanOrEqualTo(String value) {
            addCriterion("wechat_data <=", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataLike(String value) {
            addCriterion("wechat_data like", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataNotLike(String value) {
            addCriterion("wechat_data not like", value, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataIn(List<String> values) {
            addCriterion("wechat_data in", values, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataNotIn(List<String> values) {
            addCriterion("wechat_data not in", values, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataBetween(String value1, String value2) {
            addCriterion("wechat_data between", value1, value2, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatDataNotBetween(String value1, String value2) {
            addCriterion("wechat_data not between", value1, value2, "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatLinkIsNull() {
            addCriterion("wechat_link is null");
            return (Criteria) this;
        }

        public Criteria andWechatLinkIsNotNull() {
            addCriterion("wechat_link is not null");
            return (Criteria) this;
        }

        public Criteria andWechatLinkEqualTo(String value) {
            addCriterion("wechat_link =", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkNotEqualTo(String value) {
            addCriterion("wechat_link <>", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkGreaterThan(String value) {
            addCriterion("wechat_link >", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_link >=", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkLessThan(String value) {
            addCriterion("wechat_link <", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkLessThanOrEqualTo(String value) {
            addCriterion("wechat_link <=", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkLike(String value) {
            addCriterion("wechat_link like", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkNotLike(String value) {
            addCriterion("wechat_link not like", value, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkIn(List<String> values) {
            addCriterion("wechat_link in", values, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkNotIn(List<String> values) {
            addCriterion("wechat_link not in", values, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkBetween(String value1, String value2) {
            addCriterion("wechat_link between", value1, value2, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatLinkNotBetween(String value1, String value2) {
            addCriterion("wechat_link not between", value1, value2, "wechatLink");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineIsNull() {
            addCriterion("wechat_to_routine is null");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineIsNotNull() {
            addCriterion("wechat_to_routine is not null");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineEqualTo(Integer value) {
            addCriterion("wechat_to_routine =", value, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineNotEqualTo(Integer value) {
            addCriterion("wechat_to_routine <>", value, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineGreaterThan(Integer value) {
            addCriterion("wechat_to_routine >", value, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineGreaterThanOrEqualTo(Integer value) {
            addCriterion("wechat_to_routine >=", value, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineLessThan(Integer value) {
            addCriterion("wechat_to_routine <", value, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineLessThanOrEqualTo(Integer value) {
            addCriterion("wechat_to_routine <=", value, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineIn(List<Integer> values) {
            addCriterion("wechat_to_routine in", values, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineNotIn(List<Integer> values) {
            addCriterion("wechat_to_routine not in", values, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineBetween(Integer value1, Integer value2) {
            addCriterion("wechat_to_routine between", value1, value2, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andWechatToRoutineNotBetween(Integer value1, Integer value2) {
            addCriterion("wechat_to_routine not between", value1, value2, "wechatToRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineIsNull() {
            addCriterion("is_routine is null");
            return (Criteria) this;
        }

        public Criteria andIsRoutineIsNotNull() {
            addCriterion("is_routine is not null");
            return (Criteria) this;
        }

        public Criteria andIsRoutineEqualTo(Integer value) {
            addCriterion("is_routine =", value, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineNotEqualTo(Integer value) {
            addCriterion("is_routine <>", value, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineGreaterThan(Integer value) {
            addCriterion("is_routine >", value, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_routine >=", value, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineLessThan(Integer value) {
            addCriterion("is_routine <", value, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineLessThanOrEqualTo(Integer value) {
            addCriterion("is_routine <=", value, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineIn(List<Integer> values) {
            addCriterion("is_routine in", values, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineNotIn(List<Integer> values) {
            addCriterion("is_routine not in", values, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineBetween(Integer value1, Integer value2) {
            addCriterion("is_routine between", value1, value2, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andIsRoutineNotBetween(Integer value1, Integer value2) {
            addCriterion("is_routine not between", value1, value2, "isRoutine");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyIsNull() {
            addCriterion("routine_tempkey is null");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyIsNotNull() {
            addCriterion("routine_tempkey is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyEqualTo(String value) {
            addCriterion("routine_tempkey =", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyNotEqualTo(String value) {
            addCriterion("routine_tempkey <>", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyGreaterThan(String value) {
            addCriterion("routine_tempkey >", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyGreaterThanOrEqualTo(String value) {
            addCriterion("routine_tempkey >=", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyLessThan(String value) {
            addCriterion("routine_tempkey <", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyLessThanOrEqualTo(String value) {
            addCriterion("routine_tempkey <=", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyLike(String value) {
            addCriterion("routine_tempkey like", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyNotLike(String value) {
            addCriterion("routine_tempkey not like", value, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyIn(List<String> values) {
            addCriterion("routine_tempkey in", values, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyNotIn(List<String> values) {
            addCriterion("routine_tempkey not in", values, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyBetween(String value1, String value2) {
            addCriterion("routine_tempkey between", value1, value2, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyNotBetween(String value1, String value2) {
            addCriterion("routine_tempkey not between", value1, value2, "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineContentIsNull() {
            addCriterion("routine_content is null");
            return (Criteria) this;
        }

        public Criteria andRoutineContentIsNotNull() {
            addCriterion("routine_content is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineContentEqualTo(String value) {
            addCriterion("routine_content =", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentNotEqualTo(String value) {
            addCriterion("routine_content <>", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentGreaterThan(String value) {
            addCriterion("routine_content >", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentGreaterThanOrEqualTo(String value) {
            addCriterion("routine_content >=", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentLessThan(String value) {
            addCriterion("routine_content <", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentLessThanOrEqualTo(String value) {
            addCriterion("routine_content <=", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentLike(String value) {
            addCriterion("routine_content like", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentNotLike(String value) {
            addCriterion("routine_content not like", value, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentIn(List<String> values) {
            addCriterion("routine_content in", values, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentNotIn(List<String> values) {
            addCriterion("routine_content not in", values, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentBetween(String value1, String value2) {
            addCriterion("routine_content between", value1, value2, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineContentNotBetween(String value1, String value2) {
            addCriterion("routine_content not between", value1, value2, "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineKidIsNull() {
            addCriterion("routine_kid is null");
            return (Criteria) this;
        }

        public Criteria andRoutineKidIsNotNull() {
            addCriterion("routine_kid is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineKidEqualTo(String value) {
            addCriterion("routine_kid =", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidNotEqualTo(String value) {
            addCriterion("routine_kid <>", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidGreaterThan(String value) {
            addCriterion("routine_kid >", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidGreaterThanOrEqualTo(String value) {
            addCriterion("routine_kid >=", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidLessThan(String value) {
            addCriterion("routine_kid <", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidLessThanOrEqualTo(String value) {
            addCriterion("routine_kid <=", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidLike(String value) {
            addCriterion("routine_kid like", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidNotLike(String value) {
            addCriterion("routine_kid not like", value, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidIn(List<String> values) {
            addCriterion("routine_kid in", values, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidNotIn(List<String> values) {
            addCriterion("routine_kid not in", values, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidBetween(String value1, String value2) {
            addCriterion("routine_kid between", value1, value2, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineKidNotBetween(String value1, String value2) {
            addCriterion("routine_kid not between", value1, value2, "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidIsNull() {
            addCriterion("routine_tempid is null");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidIsNotNull() {
            addCriterion("routine_tempid is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidEqualTo(String value) {
            addCriterion("routine_tempid =", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidNotEqualTo(String value) {
            addCriterion("routine_tempid <>", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidGreaterThan(String value) {
            addCriterion("routine_tempid >", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidGreaterThanOrEqualTo(String value) {
            addCriterion("routine_tempid >=", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidLessThan(String value) {
            addCriterion("routine_tempid <", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidLessThanOrEqualTo(String value) {
            addCriterion("routine_tempid <=", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidLike(String value) {
            addCriterion("routine_tempid like", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidNotLike(String value) {
            addCriterion("routine_tempid not like", value, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidIn(List<String> values) {
            addCriterion("routine_tempid in", values, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidNotIn(List<String> values) {
            addCriterion("routine_tempid not in", values, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidBetween(String value1, String value2) {
            addCriterion("routine_tempid between", value1, value2, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidNotBetween(String value1, String value2) {
            addCriterion("routine_tempid not between", value1, value2, "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineDataIsNull() {
            addCriterion("routine_data is null");
            return (Criteria) this;
        }

        public Criteria andRoutineDataIsNotNull() {
            addCriterion("routine_data is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineDataEqualTo(String value) {
            addCriterion("routine_data =", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataNotEqualTo(String value) {
            addCriterion("routine_data <>", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataGreaterThan(String value) {
            addCriterion("routine_data >", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataGreaterThanOrEqualTo(String value) {
            addCriterion("routine_data >=", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataLessThan(String value) {
            addCriterion("routine_data <", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataLessThanOrEqualTo(String value) {
            addCriterion("routine_data <=", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataLike(String value) {
            addCriterion("routine_data like", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataNotLike(String value) {
            addCriterion("routine_data not like", value, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataIn(List<String> values) {
            addCriterion("routine_data in", values, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataNotIn(List<String> values) {
            addCriterion("routine_data not in", values, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataBetween(String value1, String value2) {
            addCriterion("routine_data between", value1, value2, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineDataNotBetween(String value1, String value2) {
            addCriterion("routine_data not between", value1, value2, "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkIsNull() {
            addCriterion("routine_link is null");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkIsNotNull() {
            addCriterion("routine_link is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkEqualTo(String value) {
            addCriterion("routine_link =", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkNotEqualTo(String value) {
            addCriterion("routine_link <>", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkGreaterThan(String value) {
            addCriterion("routine_link >", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkGreaterThanOrEqualTo(String value) {
            addCriterion("routine_link >=", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkLessThan(String value) {
            addCriterion("routine_link <", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkLessThanOrEqualTo(String value) {
            addCriterion("routine_link <=", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkLike(String value) {
            addCriterion("routine_link like", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkNotLike(String value) {
            addCriterion("routine_link not like", value, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkIn(List<String> values) {
            addCriterion("routine_link in", values, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkNotIn(List<String> values) {
            addCriterion("routine_link not in", values, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkBetween(String value1, String value2) {
            addCriterion("routine_link between", value1, value2, "routineLink");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkNotBetween(String value1, String value2) {
            addCriterion("routine_link not between", value1, value2, "routineLink");
            return (Criteria) this;
        }

        public Criteria andIsSmsIsNull() {
            addCriterion("is_sms is null");
            return (Criteria) this;
        }

        public Criteria andIsSmsIsNotNull() {
            addCriterion("is_sms is not null");
            return (Criteria) this;
        }

        public Criteria andIsSmsEqualTo(Integer value) {
            addCriterion("is_sms =", value, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsNotEqualTo(Integer value) {
            addCriterion("is_sms <>", value, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsGreaterThan(Integer value) {
            addCriterion("is_sms >", value, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sms >=", value, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsLessThan(Integer value) {
            addCriterion("is_sms <", value, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsLessThanOrEqualTo(Integer value) {
            addCriterion("is_sms <=", value, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsIn(List<Integer> values) {
            addCriterion("is_sms in", values, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsNotIn(List<Integer> values) {
            addCriterion("is_sms not in", values, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsBetween(Integer value1, Integer value2) {
            addCriterion("is_sms between", value1, value2, "isSms");
            return (Criteria) this;
        }

        public Criteria andIsSmsNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sms not between", value1, value2, "isSms");
            return (Criteria) this;
        }

        public Criteria andSmsIdIsNull() {
            addCriterion("sms_id is null");
            return (Criteria) this;
        }

        public Criteria andSmsIdIsNotNull() {
            addCriterion("sms_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmsIdEqualTo(String value) {
            addCriterion("sms_id =", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotEqualTo(String value) {
            addCriterion("sms_id <>", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdGreaterThan(String value) {
            addCriterion("sms_id >", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdGreaterThanOrEqualTo(String value) {
            addCriterion("sms_id >=", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdLessThan(String value) {
            addCriterion("sms_id <", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdLessThanOrEqualTo(String value) {
            addCriterion("sms_id <=", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdLike(String value) {
            addCriterion("sms_id like", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotLike(String value) {
            addCriterion("sms_id not like", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdIn(List<String> values) {
            addCriterion("sms_id in", values, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotIn(List<String> values) {
            addCriterion("sms_id not in", values, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdBetween(String value1, String value2) {
            addCriterion("sms_id between", value1, value2, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotBetween(String value1, String value2) {
            addCriterion("sms_id not between", value1, value2, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsTextIsNull() {
            addCriterion("sms_text is null");
            return (Criteria) this;
        }

        public Criteria andSmsTextIsNotNull() {
            addCriterion("sms_text is not null");
            return (Criteria) this;
        }

        public Criteria andSmsTextEqualTo(String value) {
            addCriterion("sms_text =", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextNotEqualTo(String value) {
            addCriterion("sms_text <>", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextGreaterThan(String value) {
            addCriterion("sms_text >", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextGreaterThanOrEqualTo(String value) {
            addCriterion("sms_text >=", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextLessThan(String value) {
            addCriterion("sms_text <", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextLessThanOrEqualTo(String value) {
            addCriterion("sms_text <=", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextLike(String value) {
            addCriterion("sms_text like", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextNotLike(String value) {
            addCriterion("sms_text not like", value, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextIn(List<String> values) {
            addCriterion("sms_text in", values, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextNotIn(List<String> values) {
            addCriterion("sms_text not in", values, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextBetween(String value1, String value2) {
            addCriterion("sms_text between", value1, value2, "smsText");
            return (Criteria) this;
        }

        public Criteria andSmsTextNotBetween(String value1, String value2) {
            addCriterion("sms_text not between", value1, value2, "smsText");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatIsNull() {
            addCriterion("is_ent_wechat is null");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatIsNotNull() {
            addCriterion("is_ent_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatEqualTo(Integer value) {
            addCriterion("is_ent_wechat =", value, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatNotEqualTo(Integer value) {
            addCriterion("is_ent_wechat <>", value, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatGreaterThan(Integer value) {
            addCriterion("is_ent_wechat >", value, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_ent_wechat >=", value, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatLessThan(Integer value) {
            addCriterion("is_ent_wechat <", value, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatLessThanOrEqualTo(Integer value) {
            addCriterion("is_ent_wechat <=", value, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatIn(List<Integer> values) {
            addCriterion("is_ent_wechat in", values, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatNotIn(List<Integer> values) {
            addCriterion("is_ent_wechat not in", values, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatBetween(Integer value1, Integer value2) {
            addCriterion("is_ent_wechat between", value1, value2, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andIsEntWechatNotBetween(Integer value1, Integer value2) {
            addCriterion("is_ent_wechat not between", value1, value2, "isEntWechat");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextIsNull() {
            addCriterion("ent_wechat_text is null");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextIsNotNull() {
            addCriterion("ent_wechat_text is not null");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextEqualTo(String value) {
            addCriterion("ent_wechat_text =", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextNotEqualTo(String value) {
            addCriterion("ent_wechat_text <>", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextGreaterThan(String value) {
            addCriterion("ent_wechat_text >", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextGreaterThanOrEqualTo(String value) {
            addCriterion("ent_wechat_text >=", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextLessThan(String value) {
            addCriterion("ent_wechat_text <", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextLessThanOrEqualTo(String value) {
            addCriterion("ent_wechat_text <=", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextLike(String value) {
            addCriterion("ent_wechat_text like", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextNotLike(String value) {
            addCriterion("ent_wechat_text not like", value, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextIn(List<String> values) {
            addCriterion("ent_wechat_text in", values, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextNotIn(List<String> values) {
            addCriterion("ent_wechat_text not in", values, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextBetween(String value1, String value2) {
            addCriterion("ent_wechat_text between", value1, value2, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextNotBetween(String value1, String value2) {
            addCriterion("ent_wechat_text not between", value1, value2, "entWechatText");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsAppIsNull() {
            addCriterion("is_app is null");
            return (Criteria) this;
        }

        public Criteria andIsAppIsNotNull() {
            addCriterion("is_app is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppEqualTo(Integer value) {
            addCriterion("is_app =", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppNotEqualTo(Integer value) {
            addCriterion("is_app <>", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppGreaterThan(Integer value) {
            addCriterion("is_app >", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_app >=", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppLessThan(Integer value) {
            addCriterion("is_app <", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppLessThanOrEqualTo(Integer value) {
            addCriterion("is_app <=", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppIn(List<Integer> values) {
            addCriterion("is_app in", values, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppNotIn(List<Integer> values) {
            addCriterion("is_app not in", values, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppBetween(Integer value1, Integer value2) {
            addCriterion("is_app between", value1, value2, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppNotBetween(Integer value1, Integer value2) {
            addCriterion("is_app not between", value1, value2, "isApp");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andVariableIsNull() {
            addCriterion("`variable` is null");
            return (Criteria) this;
        }

        public Criteria andVariableIsNotNull() {
            addCriterion("`variable` is not null");
            return (Criteria) this;
        }

        public Criteria andVariableEqualTo(String value) {
            addCriterion("`variable` =", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotEqualTo(String value) {
            addCriterion("`variable` <>", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableGreaterThan(String value) {
            addCriterion("`variable` >", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableGreaterThanOrEqualTo(String value) {
            addCriterion("`variable` >=", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLessThan(String value) {
            addCriterion("`variable` <", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLessThanOrEqualTo(String value) {
            addCriterion("`variable` <=", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLike(String value) {
            addCriterion("`variable` like", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotLike(String value) {
            addCriterion("`variable` not like", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableIn(List<String> values) {
            addCriterion("`variable` in", values, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotIn(List<String> values) {
            addCriterion("`variable` not in", values, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableBetween(String value1, String value2) {
            addCriterion("`variable` between", value1, value2, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotBetween(String value1, String value2) {
            addCriterion("`variable` not between", value1, value2, "variable");
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

        public Criteria andCustomTriggerIsNull() {
            addCriterion("custom_trigger is null");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerIsNotNull() {
            addCriterion("custom_trigger is not null");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerEqualTo(String value) {
            addCriterion("custom_trigger =", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerNotEqualTo(String value) {
            addCriterion("custom_trigger <>", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerGreaterThan(String value) {
            addCriterion("custom_trigger >", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerGreaterThanOrEqualTo(String value) {
            addCriterion("custom_trigger >=", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerLessThan(String value) {
            addCriterion("custom_trigger <", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerLessThanOrEqualTo(String value) {
            addCriterion("custom_trigger <=", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerLike(String value) {
            addCriterion("custom_trigger like", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerNotLike(String value) {
            addCriterion("custom_trigger not like", value, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerIn(List<String> values) {
            addCriterion("custom_trigger in", values, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerNotIn(List<String> values) {
            addCriterion("custom_trigger not in", values, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerBetween(String value1, String value2) {
            addCriterion("custom_trigger between", value1, value2, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerNotBetween(String value1, String value2) {
            addCriterion("custom_trigger not between", value1, value2, "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomVariableIsNull() {
            addCriterion("custom_variable is null");
            return (Criteria) this;
        }

        public Criteria andCustomVariableIsNotNull() {
            addCriterion("custom_variable is not null");
            return (Criteria) this;
        }

        public Criteria andCustomVariableEqualTo(String value) {
            addCriterion("custom_variable =", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableNotEqualTo(String value) {
            addCriterion("custom_variable <>", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableGreaterThan(String value) {
            addCriterion("custom_variable >", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableGreaterThanOrEqualTo(String value) {
            addCriterion("custom_variable >=", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableLessThan(String value) {
            addCriterion("custom_variable <", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableLessThanOrEqualTo(String value) {
            addCriterion("custom_variable <=", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableLike(String value) {
            addCriterion("custom_variable like", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableNotLike(String value) {
            addCriterion("custom_variable not like", value, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableIn(List<String> values) {
            addCriterion("custom_variable in", values, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableNotIn(List<String> values) {
            addCriterion("custom_variable not in", values, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableBetween(String value1, String value2) {
            addCriterion("custom_variable between", value1, value2, "customVariable");
            return (Criteria) this;
        }

        public Criteria andCustomVariableNotBetween(String value1, String value2) {
            addCriterion("custom_variable not between", value1, value2, "customVariable");
            return (Criteria) this;
        }

        public Criteria andMarkLikeInsensitive(String value) {
            addCriterion("upper(mark) like", value.toUpperCase(), "mark");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(`name`) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andSystemTitleLikeInsensitive(String value) {
            addCriterion("upper(system_title) like", value.toUpperCase(), "systemTitle");
            return (Criteria) this;
        }

        public Criteria andSystemTextLikeInsensitive(String value) {
            addCriterion("upper(system_text) like", value.toUpperCase(), "systemText");
            return (Criteria) this;
        }

        public Criteria andWechatTempkeyLikeInsensitive(String value) {
            addCriterion("upper(wechat_tempkey) like", value.toUpperCase(), "wechatTempkey");
            return (Criteria) this;
        }

        public Criteria andWechatContentLikeInsensitive(String value) {
            addCriterion("upper(wechat_content) like", value.toUpperCase(), "wechatContent");
            return (Criteria) this;
        }

        public Criteria andWechatKidLikeInsensitive(String value) {
            addCriterion("upper(wechat_kid) like", value.toUpperCase(), "wechatKid");
            return (Criteria) this;
        }

        public Criteria andWechatTempidLikeInsensitive(String value) {
            addCriterion("upper(wechat_tempid) like", value.toUpperCase(), "wechatTempid");
            return (Criteria) this;
        }

        public Criteria andWechatDataLikeInsensitive(String value) {
            addCriterion("upper(wechat_data) like", value.toUpperCase(), "wechatData");
            return (Criteria) this;
        }

        public Criteria andWechatLinkLikeInsensitive(String value) {
            addCriterion("upper(wechat_link) like", value.toUpperCase(), "wechatLink");
            return (Criteria) this;
        }

        public Criteria andRoutineTempkeyLikeInsensitive(String value) {
            addCriterion("upper(routine_tempkey) like", value.toUpperCase(), "routineTempkey");
            return (Criteria) this;
        }

        public Criteria andRoutineContentLikeInsensitive(String value) {
            addCriterion("upper(routine_content) like", value.toUpperCase(), "routineContent");
            return (Criteria) this;
        }

        public Criteria andRoutineKidLikeInsensitive(String value) {
            addCriterion("upper(routine_kid) like", value.toUpperCase(), "routineKid");
            return (Criteria) this;
        }

        public Criteria andRoutineTempidLikeInsensitive(String value) {
            addCriterion("upper(routine_tempid) like", value.toUpperCase(), "routineTempid");
            return (Criteria) this;
        }

        public Criteria andRoutineDataLikeInsensitive(String value) {
            addCriterion("upper(routine_data) like", value.toUpperCase(), "routineData");
            return (Criteria) this;
        }

        public Criteria andRoutineLinkLikeInsensitive(String value) {
            addCriterion("upper(routine_link) like", value.toUpperCase(), "routineLink");
            return (Criteria) this;
        }

        public Criteria andSmsIdLikeInsensitive(String value) {
            addCriterion("upper(sms_id) like", value.toUpperCase(), "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsTextLikeInsensitive(String value) {
            addCriterion("upper(sms_text) like", value.toUpperCase(), "smsText");
            return (Criteria) this;
        }

        public Criteria andEntWechatTextLikeInsensitive(String value) {
            addCriterion("upper(ent_wechat_text) like", value.toUpperCase(), "entWechatText");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(url) like", value.toUpperCase(), "url");
            return (Criteria) this;
        }

        public Criteria andVariableLikeInsensitive(String value) {
            addCriterion("upper(`variable`) like", value.toUpperCase(), "variable");
            return (Criteria) this;
        }

        public Criteria andCustomTriggerLikeInsensitive(String value) {
            addCriterion("upper(custom_trigger) like", value.toUpperCase(), "customTrigger");
            return (Criteria) this;
        }

        public Criteria andCustomVariableLikeInsensitive(String value) {
            addCriterion("upper(custom_variable) like", value.toUpperCase(), "customVariable");
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