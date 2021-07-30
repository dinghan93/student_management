package com.kkb.xzk.hd.service;

import com.kkb.xzk.hd.bean.Role;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 0:10
 * @Modified By:
 */
public interface RoleService {
    List<Role> getRoleList(int pageIndex, int pageSize);
    int total();

    int addRole(String rolename, int state, String[] menuids);

    Role getRoleById(int roleid);
}
