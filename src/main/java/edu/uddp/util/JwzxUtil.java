package edu.uddp.util;


import com.alibaba.druid.util.HttpClientUtils;
import edu.uddp.model.StuInfo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static edu.uddp.util.UrlUtil.*;

/**
 * @program: ssm
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-05
 **/
public class JwzxUtil {


    /**
     * @Description: 根据班级/课程编号获取学生名单(获取班级成员的接口已经失效)
     * @Param: [key, type]
     * @return: java.util.List
     * @Date: 2018/8/8
     */
    public static List classStuList(String key, String type) {
        String url = null;
        String typeClass = "class";
        String typeLesson = "lesson";
        List result = null;

        if (typeClass.equals(type)) {
            url = "http://jwzx.cqu.pt/dataCenter/bjStu.php?bj=" + key;
        } else if (typeLesson.equals(type)) {
            url = "http://jwzx.cqupt.edu.cn/kebiao/kb_stuList.php?jxb=" + key;
        }
        String content = match("<table", "</tbody></table>", resetContent(getHtmlSource(url)));
        result = studentTableToList(content);
        return result;
    }

    /**
     * @Description: 学生表格的转化
     * @Param: [content]
     * @return: java.util.List
     * @Date: 2018/8/9
     */
    public static List<StuInfo> studentTableToList(String content) {
        String[] table = null;
        String[] td = null;
        List list = new ArrayList<ArrayList>();
        content = content.replace("<table[^>]*?>", "");
        content = content.replaceAll("<tr[^>]*?>", "");
        content = content.replaceAll("<td[^>]*?>", "");
        content = content.replaceAll("</tr>", "{tr}");
        content = content.replaceAll("</td>", "{td}");
        //去掉HTML标记
        content = content.replaceAll("<[/!]*?[^<>]*?>", "");
        //去掉空白字符
        content = content.replaceAll("([rn])[s]+", "");
        content = content.replaceAll(" ", "");
        content = content.replaceAll(" ", "");
        table = content.split("\\{tr\\}");
        table = SimpleUtil.arrayPopS(table);
        for (int i = 0; i < table.length; i++) {
            td = table[i].split("\\{td\\}");
            StuInfo stuInfo = new StuInfo(td[1], td[2], td[3], td[4], td[5], td[6], td[7], td[8], td[9]);
            list.add(stuInfo);
        }
        return list;
    }

    /**
     * 获取课程号和周次
     *
     * @return
     */
    public static Set<String> getkbHtml(String key,String flag) {
        String kbUrl = "http://jwzx.cqupt.edu.cn/kebiao/kb_stu.php?xh="+key+"#kbStuTabs-list";
        String resultHtml = null;
        try {
            resultHtml = edu.uddp.util.HttpClientUtils.get(kbUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if("lesson".equals(flag)) {
            Set<String> lessonSet = getHtmlContent(resultHtml);
            return lessonSet;
        }else{
            Set<String> weekSet = getWeek(resultHtml);
            return weekSet;
        }
    }

    /**
     * 获取当前周数的方法
     * @param html
     * @return
     */
    public static Set<String> getWeek(String html){
        Set<String> resultSet = new HashSet<>();
        String regex = "今天是第 [0-9]{1,2} 周";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        while(matcher.find()){
            String result = matcher.group().substring(4,matcher.group().length()-1).trim();
            resultSet.add(result);
        }
        return resultSet;
    }

    /**
     * 正则匹配出教学班数据
     * @param urlHtml
     * @return
     */
    public static Set<String> getHtmlContent(String urlHtml){
        Set<String> set = new HashSet<>();
        String regex=">[A-Z][A-Z0-9]{16,17}<";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(urlHtml);
        while(matcher.find()){
            System.out.println(matcher.group());
            String lessonId = matcher.group();
            set.add(lessonId.substring(1,lessonId.length()-1));
        }
    return set;
    }
}