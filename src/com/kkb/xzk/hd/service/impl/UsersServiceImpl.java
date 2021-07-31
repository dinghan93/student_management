package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.bean.Users;
import com.kkb.xzk.hd.dao.RoleDao;
import com.kkb.xzk.hd.dao.UsersDao;
import com.kkb.xzk.hd.dao.impl.RoleDaoImpl;
import com.kkb.xzk.hd.dao.impl.UsersDaoImpl;
import com.kkb.xzk.hd.service.UsersService;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 15:13
 * @Modified By:
 */
public class UsersServiceImpl implements UsersService {
    UsersDao usersDao = new UsersDaoImpl();
    RoleDao roleDao = new RoleDaoImpl();
    @Override
    public Users getUsers(String username, String password) {
        return usersDao.getUsers(username, password);
    }

    @Override
    public List<Users> getAllUsers(int pageIndex, int pageSize) {
        return usersDao.getAllUsers(pageIndex, pageSize);
    }

    @Override
    public int getAllUsersCount() {
        return usersDao.getAllUsersCount();
    }

    @Override
    public List<Role> getRoleList() {
        return usersDao.getRoleList();
    }

    @Override
    public int addUsers(Users u) {
        return usersDao.addUsers(u);
    }

    @Override
    public Users getUsersById(int userid) {
        Users u = usersDao.getUsersById(userid);
        if(u != null){
            u.setRole(roleDao.getRoleById(u.getRoleid()));
        }
        return u;
    }

    @Override
    public boolean updateUsers(Users u) {
        return usersDao.updateUsers(u);
    }

    @Override
    public boolean delete(int userid) {
        return usersDao.delete(userid);
    }

    @Override
    public int deleteBatch(String[] userids) {
        return usersDao.deleteBatches(userids);
    }
}
