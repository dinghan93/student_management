package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Grade;
import com.kkb.xzk.hd.dao.GradeDao;
import com.kkb.xzk.hd.util.DBUtils;
import com.kkb.xzk.hd.util.ResultSetUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-28 17:27
 * @Modified By:
 */
public class GradeDaoImpl extends DBUtils implements GradeDao {
    @Override
    public List<Grade> getAllGrades() {
        List<Grade> grades = null;
        try {
            String sql = "select * from grade";
            resultSet = query(sql, null);
            grades = ResultSetUtil.getResults(resultSet, Grade.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return grades;
    }
}
