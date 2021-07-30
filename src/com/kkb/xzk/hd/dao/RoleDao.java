package com.kkb.xzk.hd.dao;

import com.kkb.xzk.hd.bean.Role;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 0:12
 * @Modified By:
 */
public interface RoleDao {
    List<Role> getRoleList(int pageIndex, int pageSize);
    int total();
    /**
     * 添加用户
     * @author
     * @date 2021/7/30
     * @param role
     * @return 返回用户的id值
     **/
    int addRole(Role role);

    Role getRoleById(int roleid);

    /**
     * 根据roleid删除role表中相应的数据以及middle表中与roleid相关联的数据
     * @author
     * @date 2021/7/31
     * @param roleid
     * @return 1 表示修改成功 0 表示修改失败
     **/
    int deleteRowById(int roleid);
}
