package edu.uddp.util;

import edu.uddp.model.StuInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: ssm
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-06
 **/
public class UrlUtil {
    public static String getHtmlSource(String htmlUrl) {
        URL url;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(htmlUrl);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String temp;
            while ((temp = in.readLine()) != null) {
                sb.append(temp);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("你输入的URL格式有问题！请仔细输入");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * @Description: 重新设置内容, 配合跨行正则匹配使用
     * @Param: [content]
     * @return: java.lang.String
     * @Date: 2018/8/6
     */
    public static String resetContent(String content) {
        String[] result = content.split("\r\n");
        String str = null;
        for (int i = 0; i < result.length; i++) {
            str += result[i];
        }
        return str;
    }

    /**
     * @Description: 选取数据所在的区域
     * @Param: [start, end, content]
     * @return: java.lang.String
     * @Date: 2018/8/6
     */
    public static String match(String start, String end, String content) {
        String pattern = start + "(.*?)" + end;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        String result = null;
        if (m.find()) {
            result = m.group(0);
        }
        return result;
    }
}
