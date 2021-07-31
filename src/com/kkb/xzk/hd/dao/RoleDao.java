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
    /**
     * 分页查询role表
     * @author
     * @date 2021/7/31
     * @param pageIndex 页码
     * @param pageSize 每页展示条数
     * @return 当前页的数据集合
     **/
    List<Role> getRoleList(int pageIndex, int pageSize);
    /**
     * 返回role表的数据条数
     * @author
     * @date 2021/7/31
     * @return
     **/
    int total();
    /**
     * 根据role对象向数据库添加用户
     * @author
     * @date 2021/7/30
     * @param role
     * @return 返回用户的id值
     **/
    int addRole(Role role);
    
    /**
     * 主键查询得到role对象。不仅设置了role对象的一般属性，同时通过多表查询设置了role的menuList，表示role可以操作的菜单集合
     * @author
     * @date 2021/7/31 
     * @param roleid
     * @return 设置了menuList的role对象
     **/
    Role getRoleById(int roleid);

    /**
     * 根据roleid删除role表中相应的数据以及middle表中与roleid相关联的数据
     * @author
     * @date 2021/7/31
     * @param roleid
     * @return 1 表示修改成功（即role表和middle表中至少有一个删除了一条数据） 0 表示修改失败（即两个表都没有数据删除）
     **/
    int deleteRowById(int roleid);

    boolean enableRole(int roleid);

    boolean deleteRole(int roleid);
}
