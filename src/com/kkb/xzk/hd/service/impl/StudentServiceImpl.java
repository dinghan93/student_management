package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.bean.Student;
import com.kkb.xzk.hd.dao.StudentDao;
import com.kkb.xzk.hd.dao.UsersDao;
import com.kkb.xzk.hd.dao.impl.StudentDaoImpl;
import com.kkb.xzk.hd.service.StudentService;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 19:18
 * @Modified By:
 */
public class StudentServiceImpl implements StudentService {
    StudentDao sd = new StudentDaoImpl();


    @Override
    public List<Student> getAllStudents(String stuno, String stuname, int sex, int pageIndex, int pageSize) {
        return sd.getAllStudents(stuno, stuname, sex, pageIndex, pageSize);
    }

    @Override
    public int getNum(String stuno, String stuname, int sex) {
        return sd.getNum(stuno, stuname, sex);
    }

    @Override
    public int insertStudent(Student student) {
        return sd.insertStudent(student);
    }

    @Override
    public Student getStudentById(int stuid) {
        return sd.getStudentById(stuid);
    }

    @Override
    public int modifyStudent(Student s) {
        return sd.modifyStudent(s);
    }

    @Override
    public int delStudentById(int stuid) {
        return sd.delStudentById(stuid);
    }
}
