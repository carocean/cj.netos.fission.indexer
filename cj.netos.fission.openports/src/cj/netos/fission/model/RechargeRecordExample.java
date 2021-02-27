package cj.netos.fission.model;

import java.util.ArrayList;
import java.util.List;

public class RechargeRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public RechargeRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
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

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andRechargerIsNull() {
            addCriterion("recharger is null");
            return (Criteria) this;
        }

        public Criteria andRechargerIsNotNull() {
            addCriterion("recharger is not null");
            return (Criteria) this;
        }

        public Criteria andRechargerEqualTo(String value) {
            addCriterion("recharger =", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerNotEqualTo(String value) {
            addCriterion("recharger <>", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerGreaterThan(String value) {
            addCriterion("recharger >", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerGreaterThanOrEqualTo(String value) {
            addCriterion("recharger >=", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerLessThan(String value) {
            addCriterion("recharger <", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerLessThanOrEqualTo(String value) {
            addCriterion("recharger <=", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerLike(String value) {
            addCriterion("recharger like", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerNotLike(String value) {
            addCriterion("recharger not like", value, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerIn(List<String> values) {
            addCriterion("recharger in", values, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerNotIn(List<String> values) {
            addCriterion("recharger not in", values, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerBetween(String value1, String value2) {
            addCriterion("recharger between", value1, value2, "recharger");
            return (Criteria) this;
        }

        public Criteria andRechargerNotBetween(String value1, String value2) {
            addCriterion("recharger not between", value1, value2, "recharger");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyIsNull() {
            addCriterion("recharge_strategy is null");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyIsNotNull() {
            addCriterion("recharge_strategy is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyEqualTo(Integer value) {
            addCriterion("recharge_strategy =", value, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyNotEqualTo(Integer value) {
            addCriterion("recharge_strategy <>", value, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyGreaterThan(Integer value) {
            addCriterion("recharge_strategy >", value, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyGreaterThanOrEqualTo(Integer value) {
            addCriterion("recharge_strategy >=", value, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyLessThan(Integer value) {
            addCriterion("recharge_strategy <", value, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyLessThanOrEqualTo(Integer value) {
            addCriterion("recharge_strategy <=", value, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyIn(List<Integer> values) {
            addCriterion("recharge_strategy in", values, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyNotIn(List<Integer> values) {
            addCriterion("recharge_strategy not in", values, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyBetween(Integer value1, Integer value2) {
            addCriterion("recharge_strategy between", value1, value2, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andRechargeStrategyNotBetween(Integer value1, Integer value2) {
            addCriterion("recharge_strategy not between", value1, value2, "rechargeStrategy");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountIsNull() {
            addCriterion("day_limit_amount is null");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountIsNotNull() {
            addCriterion("day_limit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountEqualTo(Long value) {
            addCriterion("day_limit_amount =", value, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountNotEqualTo(Long value) {
            addCriterion("day_limit_amount <>", value, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountGreaterThan(Long value) {
            addCriterion("day_limit_amount >", value, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("day_limit_amount >=", value, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountLessThan(Long value) {
            addCriterion("day_limit_amount <", value, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountLessThanOrEqualTo(Long value) {
            addCriterion("day_limit_amount <=", value, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountIn(List<Long> values) {
            addCriterion("day_limit_amount in", values, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountNotIn(List<Long> values) {
            addCriterion("day_limit_amount not in", values, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountBetween(Long value1, Long value2) {
            addCriterion("day_limit_amount between", value1, value2, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andDayLimitAmountNotBetween(Long value1, Long value2) {
            addCriterion("day_limit_amount not between", value1, value2, "dayLimitAmount");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(String value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(String value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(String value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(String value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(String value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLike(String value) {
            addCriterion("ctime like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotLike(String value) {
            addCriterion("ctime not like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<String> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<String> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(String value1, String value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(String value1, String value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnIsNull() {
            addCriterion("ref_order_sn is null");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnIsNotNull() {
            addCriterion("ref_order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnEqualTo(String value) {
            addCriterion("ref_order_sn =", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnNotEqualTo(String value) {
            addCriterion("ref_order_sn <>", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnGreaterThan(String value) {
            addCriterion("ref_order_sn >", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("ref_order_sn >=", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnLessThan(String value) {
            addCriterion("ref_order_sn <", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnLessThanOrEqualTo(String value) {
            addCriterion("ref_order_sn <=", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnLike(String value) {
            addCriterion("ref_order_sn like", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnNotLike(String value) {
            addCriterion("ref_order_sn not like", value, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnIn(List<String> values) {
            addCriterion("ref_order_sn in", values, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnNotIn(List<String> values) {
            addCriterion("ref_order_sn not in", values, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnBetween(String value1, String value2) {
            addCriterion("ref_order_sn between", value1, value2, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderSnNotBetween(String value1, String value2) {
            addCriterion("ref_order_sn not between", value1, value2, "refOrderSn");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleIsNull() {
            addCriterion("ref_order_title is null");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleIsNotNull() {
            addCriterion("ref_order_title is not null");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleEqualTo(String value) {
            addCriterion("ref_order_title =", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleNotEqualTo(String value) {
            addCriterion("ref_order_title <>", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleGreaterThan(String value) {
            addCriterion("ref_order_title >", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ref_order_title >=", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleLessThan(String value) {
            addCriterion("ref_order_title <", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleLessThanOrEqualTo(String value) {
            addCriterion("ref_order_title <=", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleLike(String value) {
            addCriterion("ref_order_title like", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleNotLike(String value) {
            addCriterion("ref_order_title not like", value, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleIn(List<String> values) {
            addCriterion("ref_order_title in", values, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleNotIn(List<String> values) {
            addCriterion("ref_order_title not in", values, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleBetween(String value1, String value2) {
            addCriterion("ref_order_title between", value1, value2, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefOrderTitleNotBetween(String value1, String value2) {
            addCriterion("ref_order_title not between", value1, value2, "refOrderTitle");
            return (Criteria) this;
        }

        public Criteria andRefPaySnIsNull() {
            addCriterion("ref_pay_sn is null");
            return (Criteria) this;
        }

        public Criteria andRefPaySnIsNotNull() {
            addCriterion("ref_pay_sn is not null");
            return (Criteria) this;
        }

        public Criteria andRefPaySnEqualTo(String value) {
            addCriterion("ref_pay_sn =", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnNotEqualTo(String value) {
            addCriterion("ref_pay_sn <>", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnGreaterThan(String value) {
            addCriterion("ref_pay_sn >", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnGreaterThanOrEqualTo(String value) {
            addCriterion("ref_pay_sn >=", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnLessThan(String value) {
            addCriterion("ref_pay_sn <", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnLessThanOrEqualTo(String value) {
            addCriterion("ref_pay_sn <=", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnLike(String value) {
            addCriterion("ref_pay_sn like", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnNotLike(String value) {
            addCriterion("ref_pay_sn not like", value, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnIn(List<String> values) {
            addCriterion("ref_pay_sn in", values, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnNotIn(List<String> values) {
            addCriterion("ref_pay_sn not in", values, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnBetween(String value1, String value2) {
            addCriterion("ref_pay_sn between", value1, value2, "refPaySn");
            return (Criteria) this;
        }

        public Criteria andRefPaySnNotBetween(String value1, String value2) {
            addCriterion("ref_pay_sn not between", value1, value2, "refPaySn");
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

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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