package edu.uddp.util;

import java.util.Arrays;

/**
 * @program: ssm
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-07
 **/
public class SimpleUtil {
    /**
     * @Description: 删除数组最后一个元素
     * @Param: [array]
     * @return: java.lang.String[]
     * @Date: 2018/8/7
     */
    public static String[] arrayPop(String[] array) {
        return Arrays.copyOf(array, array.length - 1);
    }

    /**
     * @Description: 数组去第一个元素
     * @Param: [array]
     * @return: java.lang.String[]
     * @Date: 2018/8/7
     */
    public static String[] arrayPopS(String[] array) {
        return Arrays.copyOfRange(array, 1, array.length);
    }

    /**
     * @Description: 数组去头去尾
     * @Param: [array]
     * @return: java.lang.String[]
     * @Date: 2018/8/7
     */
    public static String[] arrayPopSe(String[] array) {
        return Arrays.copyOfRange(array, 1, array.length - 1);
    }

    /**
    * @Description: 班级学生列表处理
    * @Param: [array]
    * @return: java.lang.String[]
    * @Date: 2018/8/7
    */
    public static String[] arrayPopClassStu(String[] array){
        return Arrays.copyOfRange(array, 1, array.length - 6);
    }
}
