package cj.netos.fission.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CashierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public CashierExample() {
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

        public Criteria andPersonIsNull() {
            addCriterion("person is null");
            return (Criteria) this;
        }

        public Criteria andPersonIsNotNull() {
            addCriterion("person is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEqualTo(String value) {
            addCriterion("person =", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotEqualTo(String value) {
            addCriterion("person <>", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThan(String value) {
            addCriterion("person >", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThanOrEqualTo(String value) {
            addCriterion("person >=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThan(String value) {
            addCriterion("person <", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThanOrEqualTo(String value) {
            addCriterion("person <=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLike(String value) {
            addCriterion("person like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotLike(String value) {
            addCriterion("person not like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonIn(List<String> values) {
            addCriterion("person in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotIn(List<String> values) {
            addCriterion("person not in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonBetween(String value1, String value2) {
            addCriterion("person between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotBetween(String value1, String value2) {
            addCriterion("person not between", value1, value2, "person");
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

        public Criteria andDayAmountIsNull() {
            addCriterion("day_amount is null");
            return (Criteria) this;
        }

        public Criteria andDayAmountIsNotNull() {
            addCriterion("day_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDayAmountEqualTo(Long value) {
            addCriterion("day_amount =", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountNotEqualTo(Long value) {
            addCriterion("day_amount <>", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountGreaterThan(Long value) {
            addCriterion("day_amount >", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("day_amount >=", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountLessThan(Long value) {
            addCriterion("day_amount <", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountLessThanOrEqualTo(Long value) {
            addCriterion("day_amount <=", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountIn(List<Long> values) {
            addCriterion("day_amount in", values, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountNotIn(List<Long> values) {
            addCriterion("day_amount not in", values, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountBetween(Long value1, Long value2) {
            addCriterion("day_amount between", value1, value2, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountNotBetween(Long value1, Long value2) {
            addCriterion("day_amount not between", value1, value2, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andCacAverageIsNull() {
            addCriterion("cac_average is null");
            return (Criteria) this;
        }

        public Criteria andCacAverageIsNotNull() {
            addCriterion("cac_average is not null");
            return (Criteria) this;
        }

        public Criteria andCacAverageEqualTo(Long value) {
            addCriterion("cac_average =", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageNotEqualTo(Long value) {
            addCriterion("cac_average <>", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageGreaterThan(Long value) {
            addCriterion("cac_average >", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageGreaterThanOrEqualTo(Long value) {
            addCriterion("cac_average >=", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageLessThan(Long value) {
            addCriterion("cac_average <", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageLessThanOrEqualTo(Long value) {
            addCriterion("cac_average <=", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageIn(List<Long> values) {
            addCriterion("cac_average in", values, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageNotIn(List<Long> values) {
            addCriterion("cac_average not in", values, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageBetween(Long value1, Long value2) {
            addCriterion("cac_average between", value1, value2, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageNotBetween(Long value1, Long value2) {
            addCriterion("cac_average not between", value1, value2, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorIsNull() {
            addCriterion("amplitude_factor is null");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorIsNotNull() {
            addCriterion("amplitude_factor is not null");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor =", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorNotEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor <>", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorGreaterThan(BigDecimal value) {
            addCriterion("amplitude_factor >", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor >=", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorLessThan(BigDecimal value) {
            addCriterion("amplitude_factor <", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor <=", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorIn(List<BigDecimal> values) {
            addCriterion("amplitude_factor in", values, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorNotIn(List<BigDecimal> values) {
            addCriterion("amplitude_factor not in", values, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amplitude_factor between", value1, value2, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amplitude_factor not between", value1, value2, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andClosedCauseIsNull() {
            addCriterion("closed_cause is null");
            return (Criteria) this;
        }

        public Criteria andClosedCauseIsNotNull() {
            addCriterion("closed_cause is not null");
            return (Criteria) this;
        }

        public Criteria andClosedCauseEqualTo(String value) {
            addCriterion("closed_cause =", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotEqualTo(String value) {
            addCriterion("closed_cause <>", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseGreaterThan(String value) {
            addCriterion("closed_cause >", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseGreaterThanOrEqualTo(String value) {
            addCriterion("closed_cause >=", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseLessThan(String value) {
            addCriterion("closed_cause <", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseLessThanOrEqualTo(String value) {
            addCriterion("closed_cause <=", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseLike(String value) {
            addCriterion("closed_cause like", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotLike(String value) {
            addCriterion("closed_cause not like", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseIn(List<String> values) {
            addCriterion("closed_cause in", values, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotIn(List<String> values) {
            addCriterion("closed_cause not in", values, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseBetween(String value1, String value2) {
            addCriterion("closed_cause between", value1, value2, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotBetween(String value1, String value2) {
            addCriterion("closed_cause not between", value1, value2, "closedCause");
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