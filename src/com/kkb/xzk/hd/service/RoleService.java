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
    /**
     * 根据相关属性向role表中添加一个数据，并且向middle表中添加相关数据
     * @author
     * @date 2021/7/31
     * @param roleid <=0的值：表示不指定roleid，由该列自增的性质自动生成；>0的值：表示指定roleid添加到表中
     * @param rolename
     * @param state
     * @param menuids 此role对象可操作的菜单id数组
     * @return 1：插入成功  <1的值：插入失败
     **/
    int addRole(int roleid, String rolename, int state, String[] menuids);

    Role getRoleById(int roleid);

    int updateRole(int roleid, String rolename, int state, String[] menuids);

    boolean enableRole(int roleid);

    boolean deleteRole(int roleid);
}
