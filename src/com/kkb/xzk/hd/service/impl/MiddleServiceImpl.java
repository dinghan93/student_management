package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.dao.MiddleDao;
import com.kkb.xzk.hd.dao.impl.MiddleDaoImpl;
import com.kkb.xzk.hd.service.MiddleService;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 12:14
 * @Modified By:
 */
public class MiddleServiceImpl implements MiddleService {
    MiddleDao middleDao = new MiddleDaoImpl();
    @Override
    public int insertMiddle(int roleid, String[] menuids) {
        return middleDao.insertMiddle(roleid, menuids);
    }
}
