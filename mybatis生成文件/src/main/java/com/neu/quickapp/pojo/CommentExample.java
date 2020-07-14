package com.neu.quickapp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNull() {
            addCriterion("commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNotNull() {
            addCriterion("commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdEqualTo(Integer value) {
            addCriterion("commodity_id =", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotEqualTo(Integer value) {
            addCriterion("commodity_id <>", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThan(Integer value) {
            addCriterion("commodity_id >", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_id >=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThan(Integer value) {
            addCriterion("commodity_id <", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_id <=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIn(List<Integer> values) {
            addCriterion("commodity_id in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotIn(List<Integer> values) {
            addCriterion("commodity_id not in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdBetween(Integer value1, Integer value2) {
            addCriterion("commodity_id between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_id not between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIsNull() {
            addCriterion("comment_level is null");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIsNotNull() {
            addCriterion("comment_level is not null");
            return (Criteria) this;
        }

        public Criteria andCommentLevelEqualTo(Integer value) {
            addCriterion("comment_level =", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotEqualTo(Integer value) {
            addCriterion("comment_level <>", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelGreaterThan(Integer value) {
            addCriterion("comment_level >", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_level >=", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelLessThan(Integer value) {
            addCriterion("comment_level <", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("comment_level <=", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIn(List<Integer> values) {
            addCriterion("comment_level in", values, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotIn(List<Integer> values) {
            addCriterion("comment_level not in", values, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelBetween(Integer value1, Integer value2) {
            addCriterion("comment_level between", value1, value2, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_level not between", value1, value2, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentImageIsNull() {
            addCriterion("comment_image is null");
            return (Criteria) this;
        }

        public Criteria andCommentImageIsNotNull() {
            addCriterion("comment_image is not null");
            return (Criteria) this;
        }

        public Criteria andCommentImageEqualTo(String value) {
            addCriterion("comment_image =", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotEqualTo(String value) {
            addCriterion("comment_image <>", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageGreaterThan(String value) {
            addCriterion("comment_image >", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageGreaterThanOrEqualTo(String value) {
            addCriterion("comment_image >=", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageLessThan(String value) {
            addCriterion("comment_image <", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageLessThanOrEqualTo(String value) {
            addCriterion("comment_image <=", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageLike(String value) {
            addCriterion("comment_image like", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotLike(String value) {
            addCriterion("comment_image not like", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageIn(List<String> values) {
            addCriterion("comment_image in", values, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotIn(List<String> values) {
            addCriterion("comment_image not in", values, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageBetween(String value1, String value2) {
            addCriterion("comment_image between", value1, value2, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotBetween(String value1, String value2) {
            addCriterion("comment_image not between", value1, value2, "commentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentIsNull() {
            addCriterion("additional_comment_content is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentIsNotNull() {
            addCriterion("additional_comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentEqualTo(String value) {
            addCriterion("additional_comment_content =", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentNotEqualTo(String value) {
            addCriterion("additional_comment_content <>", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentGreaterThan(String value) {
            addCriterion("additional_comment_content >", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("additional_comment_content >=", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentLessThan(String value) {
            addCriterion("additional_comment_content <", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentLessThanOrEqualTo(String value) {
            addCriterion("additional_comment_content <=", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentLike(String value) {
            addCriterion("additional_comment_content like", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentNotLike(String value) {
            addCriterion("additional_comment_content not like", value, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentIn(List<String> values) {
            addCriterion("additional_comment_content in", values, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentNotIn(List<String> values) {
            addCriterion("additional_comment_content not in", values, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentBetween(String value1, String value2) {
            addCriterion("additional_comment_content between", value1, value2, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentContentNotBetween(String value1, String value2) {
            addCriterion("additional_comment_content not between", value1, value2, "additionalCommentContent");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeIsNull() {
            addCriterion("additional_comment_time is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeIsNotNull() {
            addCriterion("additional_comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeEqualTo(Date value) {
            addCriterion("additional_comment_time =", value, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeNotEqualTo(Date value) {
            addCriterion("additional_comment_time <>", value, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeGreaterThan(Date value) {
            addCriterion("additional_comment_time >", value, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("additional_comment_time >=", value, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeLessThan(Date value) {
            addCriterion("additional_comment_time <", value, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("additional_comment_time <=", value, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeIn(List<Date> values) {
            addCriterion("additional_comment_time in", values, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeNotIn(List<Date> values) {
            addCriterion("additional_comment_time not in", values, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeBetween(Date value1, Date value2) {
            addCriterion("additional_comment_time between", value1, value2, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("additional_comment_time not between", value1, value2, "additionalCommentTime");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageIsNull() {
            addCriterion("additional_comment_image is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageIsNotNull() {
            addCriterion("additional_comment_image is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageEqualTo(String value) {
            addCriterion("additional_comment_image =", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageNotEqualTo(String value) {
            addCriterion("additional_comment_image <>", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageGreaterThan(String value) {
            addCriterion("additional_comment_image >", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageGreaterThanOrEqualTo(String value) {
            addCriterion("additional_comment_image >=", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageLessThan(String value) {
            addCriterion("additional_comment_image <", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageLessThanOrEqualTo(String value) {
            addCriterion("additional_comment_image <=", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageLike(String value) {
            addCriterion("additional_comment_image like", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageNotLike(String value) {
            addCriterion("additional_comment_image not like", value, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageIn(List<String> values) {
            addCriterion("additional_comment_image in", values, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageNotIn(List<String> values) {
            addCriterion("additional_comment_image not in", values, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageBetween(String value1, String value2) {
            addCriterion("additional_comment_image between", value1, value2, "additionalCommentImage");
            return (Criteria) this;
        }

        public Criteria andAdditionalCommentImageNotBetween(String value1, String value2) {
            addCriterion("additional_comment_image not between", value1, value2, "additionalCommentImage");
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