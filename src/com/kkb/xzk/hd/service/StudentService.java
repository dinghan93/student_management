package com.kkb.xzk.hd.service;

import com.kkb.xzk.hd.bean.Student;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:53
 * @Modified By:
 */
public interface StudentService {
    List<Student> getAllStudents(String stuno, String stuname, int sex, int pageIndex, int pageSize) ;

    int getNum(String stuno, String stuname, int sex);

    int insertStudent(Student student);

    Student getStudentById(int stuid);

    int modifyStudent(Student s);

    int delStudentById(int stuid);

    boolean stuNoExisted(String stuno);
}
