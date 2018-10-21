package edu.uddp.util;

public class ConfigUtil {
    //小程序的APPid
    public static final String APPID="wx8227f55dc4490f45";
    //public static final String APPID="wx770c5bdd56cbbd99";
    //小程序的APPSERCRET
   public static final String APPSERCRET="5eb0947d41b140887b94eff59ff031bc";
    //public static final String APPSERCRET="aee4ff7cf2e784b92f9431def1c39934";
    //二维码地址
    //public  static final String ERWEI_URL="https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
    public  static final String ERWEI_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
    //获取openid的url
    public static final String AUTH_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
}
