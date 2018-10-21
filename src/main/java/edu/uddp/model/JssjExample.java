package edu.uddp.model;

import java.util.ArrayList;
import java.util.List;

public class JssjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JssjExample() {
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

        public Criteria andJsbhIsNull() {
            addCriterion("jsbh is null");
            return (Criteria) this;
        }

        public Criteria andJsbhIsNotNull() {
            addCriterion("jsbh is not null");
            return (Criteria) this;
        }

        public Criteria andJsbhEqualTo(String value) {
            addCriterion("jsbh =", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhNotEqualTo(String value) {
            addCriterion("jsbh <>", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhGreaterThan(String value) {
            addCriterion("jsbh >", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhGreaterThanOrEqualTo(String value) {
            addCriterion("jsbh >=", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhLessThan(String value) {
            addCriterion("jsbh <", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhLessThanOrEqualTo(String value) {
            addCriterion("jsbh <=", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhLike(String value) {
            addCriterion("jsbh like", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhNotLike(String value) {
            addCriterion("jsbh not like", value, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhIn(List<String> values) {
            addCriterion("jsbh in", values, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhNotIn(List<String> values) {
            addCriterion("jsbh not in", values, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhBetween(String value1, String value2) {
            addCriterion("jsbh between", value1, value2, "jsbh");
            return (Criteria) this;
        }

        public Criteria andJsbhNotBetween(String value1, String value2) {
            addCriterion("jsbh not between", value1, value2, "jsbh");
            return (Criteria) this;
        }

        public Criteria andXmIsNull() {
            addCriterion("xm is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("xm is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("xm =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("xm <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("xm >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("xm >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("xm <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("xm <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("xm like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("xm not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("xm in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("xm not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("xm between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("xm not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andJysIsNull() {
            addCriterion("jys is null");
            return (Criteria) this;
        }

        public Criteria andJysIsNotNull() {
            addCriterion("jys is not null");
            return (Criteria) this;
        }

        public Criteria andJysEqualTo(String value) {
            addCriterion("jys =", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysNotEqualTo(String value) {
            addCriterion("jys <>", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysGreaterThan(String value) {
            addCriterion("jys >", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysGreaterThanOrEqualTo(String value) {
            addCriterion("jys >=", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysLessThan(String value) {
            addCriterion("jys <", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysLessThanOrEqualTo(String value) {
            addCriterion("jys <=", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysLike(String value) {
            addCriterion("jys like", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysNotLike(String value) {
            addCriterion("jys not like", value, "jys");
            return (Criteria) this;
        }

        public Criteria andJysIn(List<String> values) {
            addCriterion("jys in", values, "jys");
            return (Criteria) this;
        }

        public Criteria andJysNotIn(List<String> values) {
            addCriterion("jys not in", values, "jys");
            return (Criteria) this;
        }

        public Criteria andJysBetween(String value1, String value2) {
            addCriterion("jys between", value1, value2, "jys");
            return (Criteria) this;
        }

        public Criteria andJysNotBetween(String value1, String value2) {
            addCriterion("jys not between", value1, value2, "jys");
            return (Criteria) this;
        }

        public Criteria andXyIsNull() {
            addCriterion("xy is null");
            return (Criteria) this;
        }

        public Criteria andXyIsNotNull() {
            addCriterion("xy is not null");
            return (Criteria) this;
        }

        public Criteria andXyEqualTo(String value) {
            addCriterion("xy =", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotEqualTo(String value) {
            addCriterion("xy <>", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyGreaterThan(String value) {
            addCriterion("xy >", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyGreaterThanOrEqualTo(String value) {
            addCriterion("xy >=", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyLessThan(String value) {
            addCriterion("xy <", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyLessThanOrEqualTo(String value) {
            addCriterion("xy <=", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyLike(String value) {
            addCriterion("xy like", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotLike(String value) {
            addCriterion("xy not like", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyIn(List<String> values) {
            addCriterion("xy in", values, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotIn(List<String> values) {
            addCriterion("xy not in", values, "xy");
            return (Criteria) this;
        }

        public Criteria andXyBetween(String value1, String value2) {
            addCriterion("xy between", value1, value2, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotBetween(String value1, String value2) {
            addCriterion("xy not between", value1, value2, "xy");
            return (Criteria) this;
        }

        public Criteria andJsghIsNull() {
            addCriterion("jsgh is null");
            return (Criteria) this;
        }

        public Criteria andJsghIsNotNull() {
            addCriterion("jsgh is not null");
            return (Criteria) this;
        }

        public Criteria andJsghEqualTo(String value) {
            addCriterion("jsgh =", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghNotEqualTo(String value) {
            addCriterion("jsgh <>", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghGreaterThan(String value) {
            addCriterion("jsgh >", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghGreaterThanOrEqualTo(String value) {
            addCriterion("jsgh >=", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghLessThan(String value) {
            addCriterion("jsgh <", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghLessThanOrEqualTo(String value) {
            addCriterion("jsgh <=", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghLike(String value) {
            addCriterion("jsgh like", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghNotLike(String value) {
            addCriterion("jsgh not like", value, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghIn(List<String> values) {
            addCriterion("jsgh in", values, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghNotIn(List<String> values) {
            addCriterion("jsgh not in", values, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghBetween(String value1, String value2) {
            addCriterion("jsgh between", value1, value2, "jsgh");
            return (Criteria) this;
        }

        public Criteria andJsghNotBetween(String value1, String value2) {
            addCriterion("jsgh not between", value1, value2, "jsgh");
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