package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.bean.Users;
import com.kkb.xzk.hd.dao.UsersDao;
import com.kkb.xzk.hd.util.DBUtils;
import com.kkb.xzk.hd.util.ResultSetUtil;

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

    @Override
    public List<Users> getAllUsers(int pageIndex, int pageSize) {
        int start = (pageIndex-1)*pageSize;
        List<Users> userList = new ArrayList<>();
        List params = new ArrayList();
        String sql = "select loginname, realname, rolename from users LEFT JOIN role ON users.roleid=role.roleid limit ?,?";
        params.add(start);
        params.add(pageSize);
        try {
            resultSet = query(sql, params);
            while(resultSet.next()){
                Users u = new Users();
                u.setLoginname(resultSet.getString("loginname"));
                u.setRealname(resultSet.getString("realname"));
                Role role = new Role();
                role.setRolename(resultSet.getString("rolename"));
                u.setRole(role);
                userList.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return userList;
    }

    @Override
    public int getAllUsersCount() {
        String sql = "select count(*) from users LEFT JOIN role ON users.roleid=role.roleid";
        int count = 0;
        try {
            resultSet = query(sql, null);
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    @Override
    public List<Role> getRoleList() {
        String sql = "select * from role";
        List<Role> roleList = null;
        try {
            resultSet = query(sql, null);
            roleList = ResultSetUtil.getResults(resultSet, Role.class);
            return roleList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return roleList;
    }

    @Override
    public int addUsers(Users u) {
        String sql = "insert into users " +
                " values(?,?,?,?,?,?,?,?,?,?,?)";
        // 'loginname', 'password', 'realname', 'sex', 'roleid', 'email', 'address', 'phone', 'cardid', 'desc'
        List<Object> params = new ArrayList<>();
        System.out.println(u);
        params.add(null);
        params.add(u.getLoginname());
        params.add(u.getPassword());
        params.add(u.getRealname());
        params.add(u.getSex());
        params.add(u.getEmail());
        params.add(u.getAddress());
        params.add(u.getPhone());
        params.add(u.getCardid());
        params.add(u.getDesc());
        params.add(u.getRoleid());

        int i = 0;
        try {
            i = update(sql, params);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeAll();
        }
        return i;
    }
}
