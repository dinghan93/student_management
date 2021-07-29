package com.kkb.xzk.hd.test;

import com.kkb.xzk.hd.bean.Student;
import com.kkb.xzk.hd.dao.StudentDao;
import com.kkb.xzk.hd.dao.impl.StudentDaoImpl;
import com.kkb.xzk.hd.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 11:10
 * @Modified By:
 */
public class Test{
    public static void main(String[] args) {
        StudentDao sd = new StudentDaoImpl();
        List<Student> students = sd.getAllStudents(null, null, -1, 1,5);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}


