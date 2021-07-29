package com.kkb.xzk.hd.dao;

import com.kkb.xzk.hd.bean.Users;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:52
 * @Modified By:
 */
public interface UsersDao {
    Users getUsers(String username, String password);
}
