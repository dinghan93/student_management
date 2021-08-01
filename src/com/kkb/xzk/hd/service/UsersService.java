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
     *
     * @return
     * @author
     * @date 2021/7/29
     **/
    int getAllUsersCount();

    List<Role> getRoleList();


    int addUsers(Users u);

    /**
     * 根据用户id查找用户。这里一定还要给用户对象的role属性赋值
     *
     * @param userid
     * @return
     * @author
     * @date 2021/7/31
     **/
    Users getUsersById(int userid);

    boolean updateUsers(Users u);

    boolean delete(int userid);

    int deleteBatch(String[] userids);
}
