package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.bean.Users;
import com.kkb.xzk.hd.dao.RoleDao;
import com.kkb.xzk.hd.util.DBUtils;
import com.kkb.xzk.hd.util.ResultSetUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 0:13
 * @Modified By:
 */
public class RoleDaoImpl extends DBUtils implements RoleDao {
    @Override
    public List<Role> getRoleList(int pageIndex, int pageSize) {
        int start = (pageIndex-1)*pageSize;
        List<Role> roleList = new ArrayList<>();
        List params = new ArrayList();
        String sql = "select * from role limit ?,?";
        params.add(start);
        params.add(pageSize);
        try {
            resultSet = query(sql, params);
            roleList = ResultSetUtil.getResults(resultSet, Role.class);
//            while(resultSet.next()){
//                Role role = new Role();
//                role.setRolename(resultSet.getString("rolename"));
//                role.setRoleid(resultSet.getInt("roleid"));
//                role.setRolestate(resultSet.getInt("rolestate"));
//                roleList.add(role);
//            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return roleList;
    }

    @Override
    public int total() {
        String sql = "select count(*) from role";
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
    public int addRole(Role role) {
        int key = 0;;
        try {
            String sql = "insert into role(rolename, rolestate) values(?,?)";
            List params = new ArrayList();
            params.add(role.getRolename());
            params.add(role.getRolestate());
            int k = update(sql, params);
            ResultSet rs = pps.getGeneratedKeys();
            if(rs.next()){
                key = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return key;
    }
}
