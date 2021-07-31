package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Student;
import com.kkb.xzk.hd.dao.StudentDao;
import com.kkb.xzk.hd.util.DBUtils;
import com.kkb.xzk.hd.util.ResultSetUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kkb.xzk.hd.util.StudentStateEnum.DELETED;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 19:18
 * @Modified By:
 */
public class StudentDaoImpl extends DBUtils implements StudentDao {
    @Override
    public List<Student> getAllStudents(String stuno, String stuname, int sex, int pageIndex, int pageSize) {
        try {
            List<Student> students = new ArrayList<Student>();
            String sql = "select * from student where 1=1 and state!=" + DELETED.type + " ";
            List<Object> params = new ArrayList<>();
            if(stuno != null && ! "".equals(stuno)){
                sql += " and stuno=? ";
                params.add(stuno);
            }
            if(stuname != null && ! "".equals(stuname)){
                sql += " and stuname like ? ";
                params.add("%"+stuname+"%");
            }
            if(sex != -1){
                sql += " and sex=? ";
                params.add(sex);
            }
            sql += " limit ?, ?";
            params.add((pageIndex-1) * pageSize);
            params.add(pageSize);

            System.out.println(sql);
            resultSet = query(sql, params);
            students = ResultSetUtil.getResults(resultSet, Student.class);
            return students;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public int getNum(String stuno, String stuname, int sex) {
        int result = 0;
        try {
            String sql = "select count(*) from student where 1=1 and state!=" + DELETED.type + " ";
            List<Object> params = new ArrayList<>();
            if(stuno != null && ! "".equals(stuno)){
                sql += " and stuno=? ";
                params.add(stuno);
            }
            if(stuname != null && ! "".equals(stuname)){
                sql += " and stuname like ? ";
                params.add("%"+stuname+"%");
            }
            if(sex != -1){
                sql += " and sex=? ";
                params.add(sex);
            }
            System.out.println(sql);
            resultSet = query(sql, params);

            while(resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return result;
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "insert into student values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int i = 0;
        try {
            List<Object> params = new ArrayList<>();
            params.add(student.getStuname());
            params.add(student.getStuno());
            params.add(student.getSex());
            params.add(student.getPhone());
            params.add(student.getEmail());
            params.add(student.getRegistered());
            params.add(student.getAddress());
            params.add(student.getProfession());
            params.add(student.getIdnumber());
            params.add(student.getPolitics());
            params.add(student.getRegdate());
            params.add(student.getState());
            params.add(student.getIntroduction());
            params.add(student.getGid());
            i = update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return i;
    }

    @Override
    public Student getStudentById(int stuid) {
        String sql = "select * from student where stuid = ?";
        List<Student> students = null;
        try {
            List<Object> params = new ArrayList<>();
            params.add(stuid);
            resultSet = query(sql, params);
            students = ResultSetUtil.getResults(resultSet, Student.class);
            return students.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();
        }

    }

    @Override
    public int modifyStudent(Student s) {
        String sql = "update student set stuname=?, stuno=?, sex=?, phone=?, email=?, " +
                "registered=?, address=?, profession=?, idnumber=?," +
                "politics=?, regdate=?, state=?, introduction=?, gid=? where stuid=?";
        int i = 0;
        try {
            List<Object> params = new ArrayList<>();
            params.add(s.getStuname());
            params.add(s.getStuno());
            params.add(s.getSex());
            params.add(s.getPhone());
            params.add(s.getEmail());
            params.add(s.getRegistered());
            params.add(s.getAddress());
            params.add(s.getProfession());
            params.add(s.getIdnumber());
            params.add(s.getPolitics());
            params.add(s.getRegdate());
            params.add(s.getState());
            params.add(s.getIntroduction());
            params.add(s.getGid());
            params.add(s.getStuid());
            i = update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return i;
    }

    @Override
    public int delStudentById(int stuid) {
        String sql = "update student set state=? where stuid=?";
        int i = 0;
        try {
            List<Object> params = new ArrayList<>();
            params.add(DELETED.type);
            params.add(stuid);
            i = update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return i;
    }

    @Override
    public boolean stuNoExisted(String stuno) {
        String sql = "select count(*) from student where stuno=?";
        List<Object> params = new ArrayList<>();
        params.add(stuno);
        int result = 0;
        try {
            resultSet = query(sql, params);
            result = 0;
            while(resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        if(result > 0){
            return true;
        }else{
            return false;
        }

    }
}
