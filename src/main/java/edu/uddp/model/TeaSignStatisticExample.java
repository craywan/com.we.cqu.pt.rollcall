package edu.uddp.model;

import java.util.ArrayList;
import java.util.List;

public class TeaSignStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeaSignStatisticExample() {
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

        public Criteria andSignIdIsNull() {
            addCriterion("sign_id is null");
            return (Criteria) this;
        }

        public Criteria andSignIdIsNotNull() {
            addCriterion("sign_id is not null");
            return (Criteria) this;
        }

        public Criteria andSignIdEqualTo(String value) {
            addCriterion("sign_id =", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotEqualTo(String value) {
            addCriterion("sign_id <>", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdGreaterThan(String value) {
            addCriterion("sign_id >", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdGreaterThanOrEqualTo(String value) {
            addCriterion("sign_id >=", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdLessThan(String value) {
            addCriterion("sign_id <", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdLessThanOrEqualTo(String value) {
            addCriterion("sign_id <=", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdLike(String value) {
            addCriterion("sign_id like", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotLike(String value) {
            addCriterion("sign_id not like", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdIn(List<String> values) {
            addCriterion("sign_id in", values, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotIn(List<String> values) {
            addCriterion("sign_id not in", values, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdBetween(String value1, String value2) {
            addCriterion("sign_id between", value1, value2, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotBetween(String value1, String value2) {
            addCriterion("sign_id not between", value1, value2, "signId");
            return (Criteria) this;
        }

        public Criteria andLessonIdIsNull() {
            addCriterion("lesson_id is null");
            return (Criteria) this;
        }

        public Criteria andLessonIdIsNotNull() {
            addCriterion("lesson_id is not null");
            return (Criteria) this;
        }

        public Criteria andLessonIdEqualTo(String value) {
            addCriterion("lesson_id =", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdNotEqualTo(String value) {
            addCriterion("lesson_id <>", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdGreaterThan(String value) {
            addCriterion("lesson_id >", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdGreaterThanOrEqualTo(String value) {
            addCriterion("lesson_id >=", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdLessThan(String value) {
            addCriterion("lesson_id <", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdLessThanOrEqualTo(String value) {
            addCriterion("lesson_id <=", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdLike(String value) {
            addCriterion("lesson_id like", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdNotLike(String value) {
            addCriterion("lesson_id not like", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdIn(List<String> values) {
            addCriterion("lesson_id in", values, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdNotIn(List<String> values) {
            addCriterion("lesson_id not in", values, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdBetween(String value1, String value2) {
            addCriterion("lesson_id between", value1, value2, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdNotBetween(String value1, String value2) {
            addCriterion("lesson_id not between", value1, value2, "lessonId");
            return (Criteria) this;
        }

        public Criteria andTeaIdIsNull() {
            addCriterion("tea_id is null");
            return (Criteria) this;
        }

        public Criteria andTeaIdIsNotNull() {
            addCriterion("tea_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeaIdEqualTo(String value) {
            addCriterion("tea_id =", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotEqualTo(String value) {
            addCriterion("tea_id <>", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThan(String value) {
            addCriterion("tea_id >", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThanOrEqualTo(String value) {
            addCriterion("tea_id >=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThan(String value) {
            addCriterion("tea_id <", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThanOrEqualTo(String value) {
            addCriterion("tea_id <=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLike(String value) {
            addCriterion("tea_id like", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotLike(String value) {
            addCriterion("tea_id not like", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdIn(List<String> values) {
            addCriterion("tea_id in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotIn(List<String> values) {
            addCriterion("tea_id not in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdBetween(String value1, String value2) {
            addCriterion("tea_id between", value1, value2, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotBetween(String value1, String value2) {
            addCriterion("tea_id not between", value1, value2, "teaId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdIsNull() {
            addCriterion("unsign_id is null");
            return (Criteria) this;
        }

        public Criteria andUnsignIdIsNotNull() {
            addCriterion("unsign_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnsignIdEqualTo(String value) {
            addCriterion("unsign_id =", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdNotEqualTo(String value) {
            addCriterion("unsign_id <>", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdGreaterThan(String value) {
            addCriterion("unsign_id >", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdGreaterThanOrEqualTo(String value) {
            addCriterion("unsign_id >=", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdLessThan(String value) {
            addCriterion("unsign_id <", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdLessThanOrEqualTo(String value) {
            addCriterion("unsign_id <=", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdLike(String value) {
            addCriterion("unsign_id like", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdNotLike(String value) {
            addCriterion("unsign_id not like", value, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdIn(List<String> values) {
            addCriterion("unsign_id in", values, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdNotIn(List<String> values) {
            addCriterion("unsign_id not in", values, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdBetween(String value1, String value2) {
            addCriterion("unsign_id between", value1, value2, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignIdNotBetween(String value1, String value2) {
            addCriterion("unsign_id not between", value1, value2, "unsignId");
            return (Criteria) this;
        }

        public Criteria andUnsignNumIsNull() {
            addCriterion("unsign_num is null");
            return (Criteria) this;
        }

        public Criteria andUnsignNumIsNotNull() {
            addCriterion("unsign_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnsignNumEqualTo(Integer value) {
            addCriterion("unsign_num =", value, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumNotEqualTo(Integer value) {
            addCriterion("unsign_num <>", value, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumGreaterThan(Integer value) {
            addCriterion("unsign_num >", value, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unsign_num >=", value, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumLessThan(Integer value) {
            addCriterion("unsign_num <", value, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumLessThanOrEqualTo(Integer value) {
            addCriterion("unsign_num <=", value, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumIn(List<Integer> values) {
            addCriterion("unsign_num in", values, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumNotIn(List<Integer> values) {
            addCriterion("unsign_num not in", values, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumBetween(Integer value1, Integer value2) {
            addCriterion("unsign_num between", value1, value2, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andUnsignNumNotBetween(Integer value1, Integer value2) {
            addCriterion("unsign_num not between", value1, value2, "unsignNum");
            return (Criteria) this;
        }

        public Criteria andWeeksIsNull() {
            addCriterion("weeks is null");
            return (Criteria) this;
        }

        public Criteria andWeeksIsNotNull() {
            addCriterion("weeks is not null");
            return (Criteria) this;
        }

        public Criteria andWeeksEqualTo(String value) {
            addCriterion("weeks =", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotEqualTo(String value) {
            addCriterion("weeks <>", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksGreaterThan(String value) {
            addCriterion("weeks >", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksGreaterThanOrEqualTo(String value) {
            addCriterion("weeks >=", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLessThan(String value) {
            addCriterion("weeks <", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLessThanOrEqualTo(String value) {
            addCriterion("weeks <=", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLike(String value) {
            addCriterion("weeks like", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotLike(String value) {
            addCriterion("weeks not like", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksIn(List<String> values) {
            addCriterion("weeks in", values, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotIn(List<String> values) {
            addCriterion("weeks not in", values, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksBetween(String value1, String value2) {
            addCriterion("weeks between", value1, value2, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotBetween(String value1, String value2) {
            addCriterion("weeks not between", value1, value2, "weeks");
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