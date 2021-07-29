package com.kkb.xzk.hd.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:25
 * @Modified By:
 */
public class Grade implements Serializable {
    private Integer gradeid;
    private String gradename;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Grade() {
    }

    public Grade(Integer gradeid, String gradename) {
        this.gradeid = gradeid;
        this.gradename = gradename;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeid=" + gradeid +
                ", gradename='" + gradename + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade grade = (Grade) o;
        return getGradeid() == grade.getGradeid() && Objects.equals(getGradename(), grade.getGradename());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGradeid(), getGradename());
    }
}
