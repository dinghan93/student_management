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
    public int addRole(String rolename, int state, String[] menuids) {
        Role role = new Role();
        role.setRolename(rolename);
        role.setRolestate(state);
        int roleid = roleDao.addRole(role);
        int i = middleDao.insertMiddle(roleid, menuids);
        return i;
    }

    @Override
    public Role getRoleById(int roleid) {
        return roleDao.getRoleById(roleid);
    }
}
