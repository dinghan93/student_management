package com.kkb.xzk.hd.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-29 17:44
 * @Modified By:
 */
public class Role implements Serializable {
    private Integer roleid;
    private String rolename;
    private Integer rolestate;

    private List<Menu> menuList; //每个角色对应一组菜单操作
    private List<Users> usersList; //每个角色对应一组用户

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getRolestate() {
        return rolestate;
    }

    public void setRolestate(Integer rolestate) {
        this.rolestate = rolestate;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", rolestate=" + rolestate +
                ", menuList=" + menuList +
                ", usersList=" + usersList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getRolestate() == role.getRolestate() && Objects.equals(getRoleid(), role.getRoleid()) && Objects.equals(getRolename(), role.getRolename()) && Objects.equals(getMenuList(), role.getMenuList()) && Objects.equals(getUsersList(), role.getUsersList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleid(), getRolename(), getRolestate(), getMenuList(), getUsersList());
    }
}
