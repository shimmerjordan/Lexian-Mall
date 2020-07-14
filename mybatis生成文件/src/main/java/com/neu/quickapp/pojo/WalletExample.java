package com.neu.quickapp.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletExample() {
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

        public Criteria andMoneyAmountIsNull() {
            addCriterion("money_amount is null");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIsNotNull() {
            addCriterion("money_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountEqualTo(BigDecimal value) {
            addCriterion("money_amount =", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotEqualTo(BigDecimal value) {
            addCriterion("money_amount <>", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountGreaterThan(BigDecimal value) {
            addCriterion("money_amount >", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_amount >=", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountLessThan(BigDecimal value) {
            addCriterion("money_amount <", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_amount <=", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIn(List<BigDecimal> values) {
            addCriterion("money_amount in", values, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotIn(List<BigDecimal> values) {
            addCriterion("money_amount not in", values, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_amount between", value1, value2, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_amount not between", value1, value2, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andWalletPwdIsNull() {
            addCriterion("wallet_pwd is null");
            return (Criteria) this;
        }

        public Criteria andWalletPwdIsNotNull() {
            addCriterion("wallet_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andWalletPwdEqualTo(String value) {
            addCriterion("wallet_pwd =", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdNotEqualTo(String value) {
            addCriterion("wallet_pwd <>", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdGreaterThan(String value) {
            addCriterion("wallet_pwd >", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_pwd >=", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdLessThan(String value) {
            addCriterion("wallet_pwd <", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdLessThanOrEqualTo(String value) {
            addCriterion("wallet_pwd <=", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdLike(String value) {
            addCriterion("wallet_pwd like", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdNotLike(String value) {
            addCriterion("wallet_pwd not like", value, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdIn(List<String> values) {
            addCriterion("wallet_pwd in", values, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdNotIn(List<String> values) {
            addCriterion("wallet_pwd not in", values, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdBetween(String value1, String value2) {
            addCriterion("wallet_pwd between", value1, value2, "walletPwd");
            return (Criteria) this;
        }

        public Criteria andWalletPwdNotBetween(String value1, String value2) {
            addCriterion("wallet_pwd not between", value1, value2, "walletPwd");
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