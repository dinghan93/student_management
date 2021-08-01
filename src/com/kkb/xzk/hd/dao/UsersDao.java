package com.kkb.xzk.hd.dao;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.bean.Users;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:52
 * @Modified By:
 */
public interface UsersDao {
    Users getUsers(String username, String password);

    /**
     * 分页查询用户
     *
     * @param pageIndex 页面下标（从1计数）
     * @param pageSize  页面大小（每页存放数据）
     * @return
     * @author HanDing
     * @date 2021/7/29
     **/
    List<Users> getAllUsers(int pageIndex, int pageSize);

    /**
     * 得到总查询数量
     *
     * @return
     * @author
     * @date 2021/7/29
     **/
    int getAllUsersCount();

    List<Role> getRoleList();


    int addUsers(Users u);

    Users getUsersById(int userid);

    boolean updateUsers(Users u);

    boolean delete(int userid);

    int deleteBatches(String[] userids);
}
