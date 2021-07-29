package com.kkb.xzk.hd.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 19:34
 * @Modified By:
 */
public class ResultSetUtil {
    /**
     * 将resultSet转化为一个数组。
     * @author Han Ding
     * @date 2021/7/28
     * @param rs 通过sql得到的ResultSet对象
     * @param clazz List中保存的对象class
     * @return 如果rs为null，返回null；否则返回List集合。
     **/
    public static <T> List<T> getResults(ResultSet rs, Class<T> clazz){
        if(rs == null){
            return null;
        }
        List<T> result = new ArrayList<T>();

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                T obj = clazz.getDeclaredConstructor().newInstance();
                for(int i = 1; i <= columnCount; i++){
                    String columnClassName = rsmd.getColumnClassName(i);
                    String columnName = rsmd.getColumnName(i);
                    String setMethodName = "set" + StringUtil.title(columnName);
                    Method setMethod = clazz.getDeclaredMethod(setMethodName, Class.forName(columnClassName));
                    setMethod.invoke(obj, rs.getObject(i));
                }
                result.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
