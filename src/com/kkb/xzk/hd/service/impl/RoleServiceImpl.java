package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.dao.MiddleDao;
import com.kkb.xzk.hd.dao.RoleDao;
import com.kkb.xzk.hd.dao.impl.MiddleDaoImpl;
import com.kkb.xzk.hd.dao.impl.RoleDaoImpl;
import com.kkb.xzk.hd.service.RoleService;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 0:12
 * @Modified By:
 */
public class RoleServiceImpl implements RoleService {
    RoleDao roleDao = new RoleDaoImpl();
    MiddleDao middleDao = new MiddleDaoImpl();
    @Override
    public List<Role> getRoleList(int pageIndex, int pageSize) {
        return roleDao.getRoleList(pageIndex, pageSize);
    }

    @Override
    public int total() {
        return roleDao.total();
    }

    @Override
    public int addRole(int roleid, String rolename, int state, String[] menuids) {
        Role role = new Role();
        role.setRolename(rolename);
        role.setRolestate(state);
        if(roleid > 0){
            role.setRoleid(roleid);
        }
        roleid = roleDao.addRole(role);

        int i = middleDao.insertMiddle(roleid, menuids);
        return i;
    }

    @Override
    public Role getRoleById(int roleid) {
        return roleDao.getRoleById(roleid);
    }



    @Override
    public int updateRole(int roleid, String rolename, int state, String[] menuids) {
        int i = roleDao.deleteRowById(roleid);
        //System.out.println("删除成功");
        if(i == 0){
            return 0;
        }
        return addRole(roleid, rolename, state, menuids);
    }

    @Override
    public boolean enableRole(int roleid) {
        return roleDao.enableRole(roleid);
    }

    @Override
    public boolean deleteRole(int roleid) {
        // 删除users表中的数据
        boolean f1 = middleDao.deleteByRoleId(roleid);
        // 删除middle表中的数据
        boolean f2 = roleDao.deleteRole(roleid);
        return f1&&f2;
    }
}
