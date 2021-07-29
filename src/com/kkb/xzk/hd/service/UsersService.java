package com.kkb.xzk.hd.service;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.bean.Users;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:53
 * @Modified By:
 */
public interface UsersService {
    Users getUsers(String username, String password);
    List<Users> getAllUsers(int pageIndex, int pageSize);
    /**
     * 得到总查询数量
     * @author
     * @date 2021/7/29
     * @return
     **/
    int getAllUsersCount();

    List<Role> getRoleList();

    int addUsers(Users u);
}
