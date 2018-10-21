package edu.uddp.model;

import java.util.ArrayList;
import java.util.List;

public class LessonsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LessonsExample() {
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

        public Criteria andXqIsNull() {
            addCriterion("xq is null");
            return (Criteria) this;
        }

        public Criteria andXqIsNotNull() {
            addCriterion("xq is not null");
            return (Criteria) this;
        }

        public Criteria andXqEqualTo(String value) {
            addCriterion("xq =", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotEqualTo(String value) {
            addCriterion("xq <>", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqGreaterThan(String value) {
            addCriterion("xq >", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqGreaterThanOrEqualTo(String value) {
            addCriterion("xq >=", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqLessThan(String value) {
            addCriterion("xq <", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqLessThanOrEqualTo(String value) {
            addCriterion("xq <=", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqLike(String value) {
            addCriterion("xq like", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotLike(String value) {
            addCriterion("xq not like", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqIn(List<String> values) {
            addCriterion("xq in", values, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotIn(List<String> values) {
            addCriterion("xq not in", values, "xq");
            return (Criteria) this;
        }

        public Criteria andXqBetween(String value1, String value2) {
            addCriterion("xq between", value1, value2, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotBetween(String value1, String value2) {
            addCriterion("xq not between", value1, value2, "xq");
            return (Criteria) this;
        }

        public Criteria andBjIsNull() {
            addCriterion("bj is null");
            return (Criteria) this;
        }

        public Criteria andBjIsNotNull() {
            addCriterion("bj is not null");
            return (Criteria) this;
        }

        public Criteria andBjEqualTo(String value) {
            addCriterion("bj =", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotEqualTo(String value) {
            addCriterion("bj <>", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjGreaterThan(String value) {
            addCriterion("bj >", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjGreaterThanOrEqualTo(String value) {
            addCriterion("bj >=", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjLessThan(String value) {
            addCriterion("bj <", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjLessThanOrEqualTo(String value) {
            addCriterion("bj <=", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjLike(String value) {
            addCriterion("bj like", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotLike(String value) {
            addCriterion("bj not like", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjIn(List<String> values) {
            addCriterion("bj in", values, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotIn(List<String> values) {
            addCriterion("bj not in", values, "bj");
            return (Criteria) this;
        }

        public Criteria andBjBetween(String value1, String value2) {
            addCriterion("bj between", value1, value2, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotBetween(String value1, String value2) {
            addCriterion("bj not between", value1, value2, "bj");
            return (Criteria) this;
        }

        public Criteria andKcbhIsNull() {
            addCriterion("kcbh is null");
            return (Criteria) this;
        }

        public Criteria andKcbhIsNotNull() {
            addCriterion("kcbh is not null");
            return (Criteria) this;
        }

        public Criteria andKcbhEqualTo(String value) {
            addCriterion("kcbh =", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhNotEqualTo(String value) {
            addCriterion("kcbh <>", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhGreaterThan(String value) {
            addCriterion("kcbh >", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhGreaterThanOrEqualTo(String value) {
            addCriterion("kcbh >=", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhLessThan(String value) {
            addCriterion("kcbh <", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhLessThanOrEqualTo(String value) {
            addCriterion("kcbh <=", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhLike(String value) {
            addCriterion("kcbh like", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhNotLike(String value) {
            addCriterion("kcbh not like", value, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhIn(List<String> values) {
            addCriterion("kcbh in", values, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhNotIn(List<String> values) {
            addCriterion("kcbh not in", values, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhBetween(String value1, String value2) {
            addCriterion("kcbh between", value1, value2, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcbhNotBetween(String value1, String value2) {
            addCriterion("kcbh not between", value1, value2, "kcbh");
            return (Criteria) this;
        }

        public Criteria andKcmcIsNull() {
            addCriterion("kcmc is null");
            return (Criteria) this;
        }

        public Criteria andKcmcIsNotNull() {
            addCriterion("kcmc is not null");
            return (Criteria) this;
        }

        public Criteria andKcmcEqualTo(String value) {
            addCriterion("kcmc =", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotEqualTo(String value) {
            addCriterion("kcmc <>", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcGreaterThan(String value) {
            addCriterion("kcmc >", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcGreaterThanOrEqualTo(String value) {
            addCriterion("kcmc >=", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcLessThan(String value) {
            addCriterion("kcmc <", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcLessThanOrEqualTo(String value) {
            addCriterion("kcmc <=", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcLike(String value) {
            addCriterion("kcmc like", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotLike(String value) {
            addCriterion("kcmc not like", value, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcIn(List<String> values) {
            addCriterion("kcmc in", values, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotIn(List<String> values) {
            addCriterion("kcmc not in", values, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcBetween(String value1, String value2) {
            addCriterion("kcmc between", value1, value2, "kcmc");
            return (Criteria) this;
        }

        public Criteria andKcmcNotBetween(String value1, String value2) {
            addCriterion("kcmc not between", value1, value2, "kcmc");
            return (Criteria) this;
        }

        public Criteria andJsIsNull() {
            addCriterion("js is null");
            return (Criteria) this;
        }

        public Criteria andJsIsNotNull() {
            addCriterion("js is not null");
            return (Criteria) this;
        }

        public Criteria andJsEqualTo(String value) {
            addCriterion("js =", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotEqualTo(String value) {
            addCriterion("js <>", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsGreaterThan(String value) {
            addCriterion("js >", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsGreaterThanOrEqualTo(String value) {
            addCriterion("js >=", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLessThan(String value) {
            addCriterion("js <", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLessThanOrEqualTo(String value) {
            addCriterion("js <=", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLike(String value) {
            addCriterion("js like", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotLike(String value) {
            addCriterion("js not like", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsIn(List<String> values) {
            addCriterion("js in", values, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotIn(List<String> values) {
            addCriterion("js not in", values, "js");
            return (Criteria) this;
        }

        public Criteria andJsBetween(String value1, String value2) {
            addCriterion("js between", value1, value2, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotBetween(String value1, String value2) {
            addCriterion("js not between", value1, value2, "js");
            return (Criteria) this;
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

        public Criteria andJiaosIsNull() {
            addCriterion("jiaos is null");
            return (Criteria) this;
        }

        public Criteria andJiaosIsNotNull() {
            addCriterion("jiaos is not null");
            return (Criteria) this;
        }

        public Criteria andJiaosEqualTo(String value) {
            addCriterion("jiaos =", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosNotEqualTo(String value) {
            addCriterion("jiaos <>", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosGreaterThan(String value) {
            addCriterion("jiaos >", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosGreaterThanOrEqualTo(String value) {
            addCriterion("jiaos >=", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosLessThan(String value) {
            addCriterion("jiaos <", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosLessThanOrEqualTo(String value) {
            addCriterion("jiaos <=", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosLike(String value) {
            addCriterion("jiaos like", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosNotLike(String value) {
            addCriterion("jiaos not like", value, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosIn(List<String> values) {
            addCriterion("jiaos in", values, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosNotIn(List<String> values) {
            addCriterion("jiaos not in", values, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosBetween(String value1, String value2) {
            addCriterion("jiaos between", value1, value2, "jiaos");
            return (Criteria) this;
        }

        public Criteria andJiaosNotBetween(String value1, String value2) {
            addCriterion("jiaos not between", value1, value2, "jiaos");
            return (Criteria) this;
        }

        public Criteria andSdIsNull() {
            addCriterion("sd is null");
            return (Criteria) this;
        }

        public Criteria andSdIsNotNull() {
            addCriterion("sd is not null");
            return (Criteria) this;
        }

        public Criteria andSdEqualTo(String value) {
            addCriterion("sd =", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotEqualTo(String value) {
            addCriterion("sd <>", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdGreaterThan(String value) {
            addCriterion("sd >", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdGreaterThanOrEqualTo(String value) {
            addCriterion("sd >=", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdLessThan(String value) {
            addCriterion("sd <", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdLessThanOrEqualTo(String value) {
            addCriterion("sd <=", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdLike(String value) {
            addCriterion("sd like", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotLike(String value) {
            addCriterion("sd not like", value, "sd");
            return (Criteria) this;
        }

        public Criteria andSdIn(List<String> values) {
            addCriterion("sd in", values, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotIn(List<String> values) {
            addCriterion("sd not in", values, "sd");
            return (Criteria) this;
        }

        public Criteria andSdBetween(String value1, String value2) {
            addCriterion("sd between", value1, value2, "sd");
            return (Criteria) this;
        }

        public Criteria andSdNotBetween(String value1, String value2) {
            addCriterion("sd not between", value1, value2, "sd");
            return (Criteria) this;
        }

        public Criteria andJxbIsNull() {
            addCriterion("jxb is null");
            return (Criteria) this;
        }

        public Criteria andJxbIsNotNull() {
            addCriterion("jxb is not null");
            return (Criteria) this;
        }

        public Criteria andJxbEqualTo(String value) {
            addCriterion("jxb =", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbNotEqualTo(String value) {
            addCriterion("jxb <>", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbGreaterThan(String value) {
            addCriterion("jxb >", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbGreaterThanOrEqualTo(String value) {
            addCriterion("jxb >=", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbLessThan(String value) {
            addCriterion("jxb <", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbLessThanOrEqualTo(String value) {
            addCriterion("jxb <=", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbLike(String value) {
            addCriterion("jxb like", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbNotLike(String value) {
            addCriterion("jxb not like", value, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbIn(List<String> values) {
            addCriterion("jxb in", values, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbNotIn(List<String> values) {
            addCriterion("jxb not in", values, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbBetween(String value1, String value2) {
            addCriterion("jxb between", value1, value2, "jxb");
            return (Criteria) this;
        }

        public Criteria andJxbNotBetween(String value1, String value2) {
            addCriterion("jxb not between", value1, value2, "jxb");
            return (Criteria) this;
        }

        public Criteria andKclbIsNull() {
            addCriterion("kclb is null");
            return (Criteria) this;
        }

        public Criteria andKclbIsNotNull() {
            addCriterion("kclb is not null");
            return (Criteria) this;
        }

        public Criteria andKclbEqualTo(String value) {
            addCriterion("kclb =", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbNotEqualTo(String value) {
            addCriterion("kclb <>", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbGreaterThan(String value) {
            addCriterion("kclb >", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbGreaterThanOrEqualTo(String value) {
            addCriterion("kclb >=", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbLessThan(String value) {
            addCriterion("kclb <", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbLessThanOrEqualTo(String value) {
            addCriterion("kclb <=", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbLike(String value) {
            addCriterion("kclb like", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbNotLike(String value) {
            addCriterion("kclb not like", value, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbIn(List<String> values) {
            addCriterion("kclb in", values, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbNotIn(List<String> values) {
            addCriterion("kclb not in", values, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbBetween(String value1, String value2) {
            addCriterion("kclb between", value1, value2, "kclb");
            return (Criteria) this;
        }

        public Criteria andKclbNotBetween(String value1, String value2) {
            addCriterion("kclb not between", value1, value2, "kclb");
            return (Criteria) this;
        }

        public Criteria andZymIsNull() {
            addCriterion("zym is null");
            return (Criteria) this;
        }

        public Criteria andZymIsNotNull() {
            addCriterion("zym is not null");
            return (Criteria) this;
        }

        public Criteria andZymEqualTo(String value) {
            addCriterion("zym =", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymNotEqualTo(String value) {
            addCriterion("zym <>", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymGreaterThan(String value) {
            addCriterion("zym >", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymGreaterThanOrEqualTo(String value) {
            addCriterion("zym >=", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymLessThan(String value) {
            addCriterion("zym <", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymLessThanOrEqualTo(String value) {
            addCriterion("zym <=", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymLike(String value) {
            addCriterion("zym like", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymNotLike(String value) {
            addCriterion("zym not like", value, "zym");
            return (Criteria) this;
        }

        public Criteria andZymIn(List<String> values) {
            addCriterion("zym in", values, "zym");
            return (Criteria) this;
        }

        public Criteria andZymNotIn(List<String> values) {
            addCriterion("zym not in", values, "zym");
            return (Criteria) this;
        }

        public Criteria andZymBetween(String value1, String value2) {
            addCriterion("zym between", value1, value2, "zym");
            return (Criteria) this;
        }

        public Criteria andZymNotBetween(String value1, String value2) {
            addCriterion("zym not between", value1, value2, "zym");
            return (Criteria) this;
        }

        public Criteria andYxmIsNull() {
            addCriterion("yxm is null");
            return (Criteria) this;
        }

        public Criteria andYxmIsNotNull() {
            addCriterion("yxm is not null");
            return (Criteria) this;
        }

        public Criteria andYxmEqualTo(String value) {
            addCriterion("yxm =", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmNotEqualTo(String value) {
            addCriterion("yxm <>", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmGreaterThan(String value) {
            addCriterion("yxm >", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmGreaterThanOrEqualTo(String value) {
            addCriterion("yxm >=", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmLessThan(String value) {
            addCriterion("yxm <", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmLessThanOrEqualTo(String value) {
            addCriterion("yxm <=", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmLike(String value) {
            addCriterion("yxm like", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmNotLike(String value) {
            addCriterion("yxm not like", value, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmIn(List<String> values) {
            addCriterion("yxm in", values, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmNotIn(List<String> values) {
            addCriterion("yxm not in", values, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmBetween(String value1, String value2) {
            addCriterion("yxm between", value1, value2, "yxm");
            return (Criteria) this;
        }

        public Criteria andYxmNotBetween(String value1, String value2) {
            addCriterion("yxm not between", value1, value2, "yxm");
            return (Criteria) this;
        }

        public Criteria andNjIsNull() {
            addCriterion("nj is null");
            return (Criteria) this;
        }

        public Criteria andNjIsNotNull() {
            addCriterion("nj is not null");
            return (Criteria) this;
        }

        public Criteria andNjEqualTo(String value) {
            addCriterion("nj =", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotEqualTo(String value) {
            addCriterion("nj <>", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjGreaterThan(String value) {
            addCriterion("nj >", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjGreaterThanOrEqualTo(String value) {
            addCriterion("nj >=", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLessThan(String value) {
            addCriterion("nj <", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLessThanOrEqualTo(String value) {
            addCriterion("nj <=", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLike(String value) {
            addCriterion("nj like", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotLike(String value) {
            addCriterion("nj not like", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjIn(List<String> values) {
            addCriterion("nj in", values, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotIn(List<String> values) {
            addCriterion("nj not in", values, "nj");
            return (Criteria) this;
        }

        public Criteria andNjBetween(String value1, String value2) {
            addCriterion("nj between", value1, value2, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotBetween(String value1, String value2) {
            addCriterion("nj not between", value1, value2, "nj");
            return (Criteria) this;
        }

        public Criteria andXsIsNull() {
            addCriterion("xs is null");
            return (Criteria) this;
        }

        public Criteria andXsIsNotNull() {
            addCriterion("xs is not null");
            return (Criteria) this;
        }

        public Criteria andXsEqualTo(Integer value) {
            addCriterion("xs =", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsNotEqualTo(Integer value) {
            addCriterion("xs <>", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsGreaterThan(Integer value) {
            addCriterion("xs >", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsGreaterThanOrEqualTo(Integer value) {
            addCriterion("xs >=", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsLessThan(Integer value) {
            addCriterion("xs <", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsLessThanOrEqualTo(Integer value) {
            addCriterion("xs <=", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsIn(List<Integer> values) {
            addCriterion("xs in", values, "xs");
            return (Criteria) this;
        }

        public Criteria andXsNotIn(List<Integer> values) {
            addCriterion("xs not in", values, "xs");
            return (Criteria) this;
        }

        public Criteria andXsBetween(Integer value1, Integer value2) {
            addCriterion("xs between", value1, value2, "xs");
            return (Criteria) this;
        }

        public Criteria andXsNotBetween(Integer value1, Integer value2) {
            addCriterion("xs not between", value1, value2, "xs");
            return (Criteria) this;
        }

        public Criteria andLlxsIsNull() {
            addCriterion("llxs is null");
            return (Criteria) this;
        }

        public Criteria andLlxsIsNotNull() {
            addCriterion("llxs is not null");
            return (Criteria) this;
        }

        public Criteria andLlxsEqualTo(Integer value) {
            addCriterion("llxs =", value, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsNotEqualTo(Integer value) {
            addCriterion("llxs <>", value, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsGreaterThan(Integer value) {
            addCriterion("llxs >", value, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("llxs >=", value, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsLessThan(Integer value) {
            addCriterion("llxs <", value, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsLessThanOrEqualTo(Integer value) {
            addCriterion("llxs <=", value, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsIn(List<Integer> values) {
            addCriterion("llxs in", values, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsNotIn(List<Integer> values) {
            addCriterion("llxs not in", values, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsBetween(Integer value1, Integer value2) {
            addCriterion("llxs between", value1, value2, "llxs");
            return (Criteria) this;
        }

        public Criteria andLlxsNotBetween(Integer value1, Integer value2) {
            addCriterion("llxs not between", value1, value2, "llxs");
            return (Criteria) this;
        }

        public Criteria andXyxsIsNull() {
            addCriterion("xyxs is null");
            return (Criteria) this;
        }

        public Criteria andXyxsIsNotNull() {
            addCriterion("xyxs is not null");
            return (Criteria) this;
        }

        public Criteria andXyxsEqualTo(Integer value) {
            addCriterion("xyxs =", value, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsNotEqualTo(Integer value) {
            addCriterion("xyxs <>", value, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsGreaterThan(Integer value) {
            addCriterion("xyxs >", value, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("xyxs >=", value, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsLessThan(Integer value) {
            addCriterion("xyxs <", value, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsLessThanOrEqualTo(Integer value) {
            addCriterion("xyxs <=", value, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsIn(List<Integer> values) {
            addCriterion("xyxs in", values, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsNotIn(List<Integer> values) {
            addCriterion("xyxs not in", values, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsBetween(Integer value1, Integer value2) {
            addCriterion("xyxs between", value1, value2, "xyxs");
            return (Criteria) this;
        }

        public Criteria andXyxsNotBetween(Integer value1, Integer value2) {
            addCriterion("xyxs not between", value1, value2, "xyxs");
            return (Criteria) this;
        }

        public Criteria andEzIsNull() {
            addCriterion("ez is null");
            return (Criteria) this;
        }

        public Criteria andEzIsNotNull() {
            addCriterion("ez is not null");
            return (Criteria) this;
        }

        public Criteria andEzEqualTo(Boolean value) {
            addCriterion("ez =", value, "ez");
            return (Criteria) this;
        }

        public Criteria andEzNotEqualTo(Boolean value) {
            addCriterion("ez <>", value, "ez");
            return (Criteria) this;
        }

        public Criteria andEzGreaterThan(Boolean value) {
            addCriterion("ez >", value, "ez");
            return (Criteria) this;
        }

        public Criteria andEzGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ez >=", value, "ez");
            return (Criteria) this;
        }

        public Criteria andEzLessThan(Boolean value) {
            addCriterion("ez <", value, "ez");
            return (Criteria) this;
        }

        public Criteria andEzLessThanOrEqualTo(Boolean value) {
            addCriterion("ez <=", value, "ez");
            return (Criteria) this;
        }

        public Criteria andEzIn(List<Boolean> values) {
            addCriterion("ez in", values, "ez");
            return (Criteria) this;
        }

        public Criteria andEzNotIn(List<Boolean> values) {
            addCriterion("ez not in", values, "ez");
            return (Criteria) this;
        }

        public Criteria andEzBetween(Boolean value1, Boolean value2) {
            addCriterion("ez between", value1, value2, "ez");
            return (Criteria) this;
        }

        public Criteria andEzNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ez not between", value1, value2, "ez");
            return (Criteria) this;
        }

        public Criteria andSjlpIsNull() {
            addCriterion("sjlp is null");
            return (Criteria) this;
        }

        public Criteria andSjlpIsNotNull() {
            addCriterion("sjlp is not null");
            return (Criteria) this;
        }

        public Criteria andSjlpEqualTo(Boolean value) {
            addCriterion("sjlp =", value, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpNotEqualTo(Boolean value) {
            addCriterion("sjlp <>", value, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpGreaterThan(Boolean value) {
            addCriterion("sjlp >", value, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sjlp >=", value, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpLessThan(Boolean value) {
            addCriterion("sjlp <", value, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpLessThanOrEqualTo(Boolean value) {
            addCriterion("sjlp <=", value, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpIn(List<Boolean> values) {
            addCriterion("sjlp in", values, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpNotIn(List<Boolean> values) {
            addCriterion("sjlp not in", values, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpBetween(Boolean value1, Boolean value2) {
            addCriterion("sjlp between", value1, value2, "sjlp");
            return (Criteria) this;
        }

        public Criteria andSjlpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sjlp not between", value1, value2, "sjlp");
            return (Criteria) this;
        }

        public Criteria andZcIsNull() {
            addCriterion("zc is null");
            return (Criteria) this;
        }

        public Criteria andZcIsNotNull() {
            addCriterion("zc is not null");
            return (Criteria) this;
        }

        public Criteria andZcEqualTo(String value) {
            addCriterion("zc =", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotEqualTo(String value) {
            addCriterion("zc <>", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcGreaterThan(String value) {
            addCriterion("zc >", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcGreaterThanOrEqualTo(String value) {
            addCriterion("zc >=", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcLessThan(String value) {
            addCriterion("zc <", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcLessThanOrEqualTo(String value) {
            addCriterion("zc <=", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcLike(String value) {
            addCriterion("zc like", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotLike(String value) {
            addCriterion("zc not like", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcIn(List<String> values) {
            addCriterion("zc in", values, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotIn(List<String> values) {
            addCriterion("zc not in", values, "zc");
            return (Criteria) this;
        }

        public Criteria andZcBetween(String value1, String value2) {
            addCriterion("zc between", value1, value2, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotBetween(String value1, String value2) {
            addCriterion("zc not between", value1, value2, "zc");
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