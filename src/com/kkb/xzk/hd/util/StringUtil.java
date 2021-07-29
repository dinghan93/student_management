package com.kkb.xzk.hd.util;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 19:40
 * @Modified By:
 */
public class StringUtil {
    private StringUtil(){}
    public static String title(String s){
        if(s==null || "".equals(s)){
            return s;
        }
        if(s.length()==1){
            return s;
        }
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

}
