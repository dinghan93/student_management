package com.kkb.xzk.hd.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:27
 * @Modified By:
 */
public class Student implements Serializable {
    private Integer stuid;
    private String stuname;
    private String stuno;
    private Integer sex;
    private String phone;
    private String email;
    private String registered;
    private String address;
    private String profession;
    private String idnumber;
    private String politics;
    private java.sql.Date regdate;
    private Integer state;
    private String introduction;
    private Integer gid;
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student() {
    }

    public Student(Integer stuid, String stuname, String stuno, Integer sex, String phone, String email, String registered, String address, String profession, String idnumber, String politics, Date regdate, Integer state, String introduction, Integer gid, Grade grade) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuno = stuno;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.registered = registered;
        this.address = address;
        this.profession = profession;
        this.idnumber = idnumber;
        this.politics = politics;
        this.regdate = regdate;
        this.state = state;
        this.introduction = introduction;
        this.gid = gid;
        this.grade = grade;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getStuid(), student.getStuid()) && Objects.equals(getStuname(), student.getStuname()) && Objects.equals(getStuno(), student.getStuno()) && Objects.equals(getSex(), student.getSex()) && Objects.equals(getPhone(), student.getPhone()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getRegistered(), student.getRegistered()) && Objects.equals(getAddress(), student.getAddress()) && Objects.equals(getProfession(), student.getProfession()) && Objects.equals(getIdnumber(), student.getIdnumber()) && Objects.equals(getPolitics(), student.getPolitics()) && Objects.equals(getRegdate(), student.getRegdate()) && Objects.equals(getState(), student.getState()) && Objects.equals(getIntroduction(), student.getIntroduction()) && Objects.equals(getGid(), student.getGid()) && Objects.equals(getGrade(), student.getGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStuid(), getStuname(), getStuno(), getSex(), getPhone(), getEmail(), getRegistered(), getAddress(), getProfession(), getIdnumber(), getPolitics(), getRegdate(), getState(), getIntroduction(), getGid(), getGrade());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuno='" + stuno + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", registered='" + registered + '\'' +
                ", address='" + address + '\'' +
                ", profession='" + profession + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", politics='" + politics + '\'' +
                ", regdate=" + regdate +
                ", state=" + state +
                ", introduction='" + introduction + '\'' +
                ", gid=" + gid +
                ", grade=" + grade +
                '}';
    }
}
