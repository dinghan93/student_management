package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.bean.Users;
import com.kkb.xzk.hd.dao.UsersDao;
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
    UsersDao ud = new UsersDaoImpl();
    @Override
    public Users getUsers(String username, String password) {
        return ud.getUsers(username, password);
    }

    @Override
    public List<Users> getAllUsers(int pageIndex, int pageSize) {
        return ud.getAllUsers(pageIndex, pageSize);
    }

    @Override
    public int getAllUsersCount() {
        return ud.getAllUsersCount();
    }

    @Override
    public List<Role> getRoleList() {
        return ud.getRoleList();
    }

    @Override
    public int addUsers(Users u) {
        return ud.addUsers(u);
    }
}
