package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Menu;
import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.dao.MenuDao;
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
        int start = (pageIndex - 1) * pageSize;
        List<Role> roleList = new ArrayList<>();
        List params = new ArrayList();
        String sql = "select * from role limit ?,?";
        params.add(start);
        params.add(pageSize);
        try {
            resultSet = query(sql, params);
            roleList = ResultSetUtil.getResults(resultSet, Role.class);
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
            while (resultSet.next()) {
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
        int key = 0;
        ;
        try {
            String sql = "insert into role(roleid, rolename, rolestate) values(?,?,?)";
            List params = new ArrayList();
            params.add(role.getRoleid());
            params.add(role.getRolename());
            params.add(role.getRolestate());
            int k = update(sql, params);
            ResultSet rs = pps.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return key;
    }

    @Override
    public Role getRoleById(int roleid) {
        Role role = new Role();
        try {
            String sql = "select rolename, rolestate, menuid from role left join middle on role.roleid=middle.roleid where role.roleid=?";
            List params = new ArrayList();
            params.add(roleid);
            resultSet = query(sql, params);
            MenuDao menuDao = new MenuDaoImpl();
            List<Menu> menuList = new ArrayList<>();
            while (resultSet.next()) {
                if (role.getRoleid() == null) {
                    role.setRoleid(roleid);
                    role.setRolename(resultSet.getString("rolename"));
                    role.setRolestate(resultSet.getInt("rolestate"));
                }
                int menuid = resultSet.getInt("menuid");
                menuList.add(menuDao.getMenuById(menuid));
            }
            role.setMenuList(menuList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return role;
    }

    @Override
    public int deleteRowById(int roleid) {
        try {
            String sql = "delete from role where roleid=?";
            List params = new ArrayList();
            params.add(roleid);
            int i = update(sql, params);

            sql = "delete from middle where roleid=?";
            int k = update(sql, params);
            if (i > 0 || k > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return 0;
    }

    @Override
    public boolean enableRole(int roleid) {
        try {
            String sql = "update role set rolestate=1 where roleid=?";
            List params = new ArrayList();
            params.add(roleid);
            update(sql, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    @Override
    public boolean deleteRole(int roleid) {
        try {
            String sql = "delete from role where roleid=?";
            List params = new ArrayList();
            params.add(roleid);
            update(sql, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }
}
