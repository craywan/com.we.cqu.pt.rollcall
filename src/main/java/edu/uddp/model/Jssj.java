package edu.uddp.model;

public class Jssj {
    private String jsbh;

    private String xm;

    private String jys;

    private String xy;

    private String jsgh;

    public String getJsbh() {
        return jsbh;
    }

    public void setJsbh(String jsbh) {
        this.jsbh = jsbh == null ? null : jsbh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getJys() {
        return jys;
    }

    public void setJys(String jys) {
        this.jys = jys == null ? null : jys.trim();
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy == null ? null : xy.trim();
    }

    public String getJsgh() {
        return jsgh;
    }

    public void setJsgh(String jsgh) {
        this.jsgh = jsgh == null ? null : jsgh.trim();
    }
}