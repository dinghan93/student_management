package com.kkb.xzk.hd.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:31
 * @Modified By:
 */
public class Users implements Serializable {
    private Integer userid;
    private String loginname;
    private String password;
    private String realname;

    public Users() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return Objects.equals(getUserid(), users.getUserid()) && Objects.equals(getLoginname(), users.getLoginname()) && Objects.equals(getPassword(), users.getPassword()) && Objects.equals(getRealname(), users.getRealname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getLoginname(), getPassword(), getRealname());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
