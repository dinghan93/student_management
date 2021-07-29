package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Users;
import com.kkb.xzk.hd.dao.UsersDao;
import com.kkb.xzk.hd.util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 15:05
 * @Modified By:
 */
public class UsersDaoImpl extends DBUtils implements UsersDao {

    @Override
    public Users getUsers(String username, String password) {
        String sql = "select * from users where loginname=? and password=?";
        List<String> params = new ArrayList<String>();
        params.add(username);
        params.add(password);
        query(sql, params);
        Users u = null;
        if(resultSet == null){
            return null;
        }
        try {
            while(resultSet.next()){
                u = new Users();
                u.setLoginname(username);
                u.setUserid(resultSet.getInt("userid"));
                u.setRealname(resultSet.getString("realname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return u;
    }
}
