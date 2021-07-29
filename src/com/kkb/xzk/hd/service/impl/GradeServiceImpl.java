package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.bean.Grade;
import com.kkb.xzk.hd.dao.GradeDao;
import com.kkb.xzk.hd.dao.impl.GradeDaoImpl;
import com.kkb.xzk.hd.service.GradeService;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-28 17:33
 * @Modified By:
 */
public class GradeServiceImpl implements GradeService {
    private GradeDao dao = new GradeDaoImpl();
    @Override
    public List<Grade> getAllGrades() {
        return dao.getAllGrades();
    }
}
