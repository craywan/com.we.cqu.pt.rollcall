package edu.uddp.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;


public class CommonUtil {

    private static Logger logger = Logger.getLogger(CommonUtil.class);
    /**
     * 定义编码格式 UTF-8
     */
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";

    /**
     * 定义编码格式 GBK
     */
    public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";

    private static final String URL_PARAM_CONNECT_FLAG = "&";

    private static final String EMPTY = "";

    private static MultiThreadedHttpConnectionManager connectionManager = null;

    private static int connectionTimeOut = 25000;

    private static int socketTimeOut = 25000;

    private static int maxConnectionPerHost = 20;

    private static int maxTotalConnections = 20;

    private static HttpClient client;

    static {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        client = new HttpClient(connectionManager);
    }


    /**
     * 发起get请求
     *
     * @param url
     * @return
     */
    public static Map<String, Object> doGet(String url, String enc) {

        Map<String, Object> resultMap = new HashMap<>();
        String responseStirng = EMPTY;
        GetMethod getMethod;
        getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
        try {
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                responseStirng = getMethod.getResponseBodyAsString();
            } else {
                logger.error("请求错误======" + statusCode);
            }
        } catch (HttpException e) {
            logger.error("协议异常================");
        } catch (IOException e) {
            logger.error("网络异常没有获取到数据==========");
            e.printStackTrace();
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
            }
        }
        resultMap= JSON.parseObject(responseStirng);
        return resultMap;
    }

    /**
     * 获取小程序序的accessToken
     * @return
     */
    public static Map<String,Object>  getAccessToken(){
        String  result = null;
        String Url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String accessTokenUrl =Url.replace("APPID",ConfigUtil.APPID).replace("APPSECRET",ConfigUtil.APPSERCRET);
        try {
            result =HttpClientUtils.get(accessTokenUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return JSON.parseObject(result);

    }

    /**
     * 根据code获取openId
     * @param code
     * @return
     */
    public Map<String,Object> getOpenId(String code){
        String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code".replace("APPID",ConfigUtil.APPID).replace("SECRET",ConfigUtil.APPSERCRET).replace("JSCODE",code);
        String result=null;
        try {
            result=HttpClientUtils.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> resultMap = JSON.parseObject(result);
        return resultMap;
    }
}
