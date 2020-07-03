package com.neu.quickapp.pojo;

import java.util.ArrayList;
import java.util.List;

public class SettingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingsExample() {
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

        public Criteria andBackgroundColorIsNull() {
            addCriterion("background_color is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorIsNotNull() {
            addCriterion("background_color is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorEqualTo(String value) {
            addCriterion("background_color =", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotEqualTo(String value) {
            addCriterion("background_color <>", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorGreaterThan(String value) {
            addCriterion("background_color >", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorGreaterThanOrEqualTo(String value) {
            addCriterion("background_color >=", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorLessThan(String value) {
            addCriterion("background_color <", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorLessThanOrEqualTo(String value) {
            addCriterion("background_color <=", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorLike(String value) {
            addCriterion("background_color like", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotLike(String value) {
            addCriterion("background_color not like", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorIn(List<String> values) {
            addCriterion("background_color in", values, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotIn(List<String> values) {
            addCriterion("background_color not in", values, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorBetween(String value1, String value2) {
            addCriterion("background_color between", value1, value2, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotBetween(String value1, String value2) {
            addCriterion("background_color not between", value1, value2, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIsNull() {
            addCriterion("message_remind is null");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIsNotNull() {
            addCriterion("message_remind is not null");
            return (Criteria) this;
        }

        public Criteria andMessageRemindEqualTo(Integer value) {
            addCriterion("message_remind =", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotEqualTo(Integer value) {
            addCriterion("message_remind <>", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindGreaterThan(Integer value) {
            addCriterion("message_remind >", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_remind >=", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLessThan(Integer value) {
            addCriterion("message_remind <", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLessThanOrEqualTo(Integer value) {
            addCriterion("message_remind <=", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIn(List<Integer> values) {
            addCriterion("message_remind in", values, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotIn(List<Integer> values) {
            addCriterion("message_remind not in", values, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindBetween(Integer value1, Integer value2) {
            addCriterion("message_remind between", value1, value2, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotBetween(Integer value1, Integer value2) {
            addCriterion("message_remind not between", value1, value2, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindIsNull() {
            addCriterion("music_remind is null");
            return (Criteria) this;
        }

        public Criteria andMusicRemindIsNotNull() {
            addCriterion("music_remind is not null");
            return (Criteria) this;
        }

        public Criteria andMusicRemindEqualTo(Integer value) {
            addCriterion("music_remind =", value, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindNotEqualTo(Integer value) {
            addCriterion("music_remind <>", value, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindGreaterThan(Integer value) {
            addCriterion("music_remind >", value, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindGreaterThanOrEqualTo(Integer value) {
            addCriterion("music_remind >=", value, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindLessThan(Integer value) {
            addCriterion("music_remind <", value, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindLessThanOrEqualTo(Integer value) {
            addCriterion("music_remind <=", value, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindIn(List<Integer> values) {
            addCriterion("music_remind in", values, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindNotIn(List<Integer> values) {
            addCriterion("music_remind not in", values, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindBetween(Integer value1, Integer value2) {
            addCriterion("music_remind between", value1, value2, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andMusicRemindNotBetween(Integer value1, Integer value2) {
            addCriterion("music_remind not between", value1, value2, "musicRemind");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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