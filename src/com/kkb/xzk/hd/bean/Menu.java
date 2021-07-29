package com.kkb.xzk.hd.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-29 17:17
 * @Modified By:
 */
public class Menu implements Serializable {
    private Integer menuid;
    private String menuname;
    private Integer upmenuid;
    private Integer state;
    private String desc;
    private String url;
    private List<Role> roleList; //每个菜单对应一组角色

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Integer getUpmenuid() {
        return upmenuid;
    }

    public void setUpmenuid(Integer upmenuid) {
        this.upmenuid = upmenuid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return Objects.equals(getMenuid(), menu.getMenuid()) && Objects.equals(getMenuname(), menu.getMenuname()) && Objects.equals(getUpmenuid(), menu.getUpmenuid()) && Objects.equals(getState(), menu.getState()) && Objects.equals(getDesc(), menu.getDesc()) && Objects.equals(getUrl(), menu.getUrl()) && Objects.equals(getRoleList(), menu.getRoleList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMenuid(), getMenuname(), getUpmenuid(), getState(), getDesc(), getUrl(), getRoleList());
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuid=" + menuid +
                ", menuname='" + menuname + '\'' +
                ", upmenuid=" + upmenuid +
                ", state=" + state +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
