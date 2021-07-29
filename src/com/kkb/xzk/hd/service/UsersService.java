package com.kkb.xzk.hd.service;

import com.kkb.xzk.hd.bean.Users;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:53
 * @Modified By:
 */
public interface UsersService {
    Users getUsers(String username, String password);
}
