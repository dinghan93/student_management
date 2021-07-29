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
    private Integer sex;
    private String email;
    private String address;
    private String phone;
    private String cardid;
    private String desc;
    private Integer roleid;
    private Role role; //每个用户对应一个角色

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



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
        return Objects.equals(getUserid(), users.getUserid()) && Objects.equals(getLoginname(), users.getLoginname()) && Objects.equals(getPassword(), users.getPassword()) && Objects.equals(getRealname(), users.getRealname()) && Objects.equals(getSex(), users.getSex()) && Objects.equals(getEmail(), users.getEmail()) && Objects.equals(getAddress(), users.getAddress()) && Objects.equals(getPhone(), users.getPhone()) && Objects.equals(getCardid(), users.getCardid()) && Objects.equals(getDesc(), users.getDesc()) && Objects.equals(getRoleid(), users.getRoleid()) && Objects.equals(getRole(), users.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getLoginname(), getPassword(), getRealname(), getSex(), getEmail(), getAddress(), getPhone(), getCardid(), getDesc(), getRoleid(), getRole());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", cardid='" + cardid + '\'' +
                ", desc='" + desc + '\'' +
                ", roleid=" + roleid +
                ", role=" + role +
                '}';
    }
}
