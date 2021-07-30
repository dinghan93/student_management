package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.dao.MiddleDao;
import com.kkb.xzk.hd.util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 12:14
 * @Modified By:
 */
public class MiddleDaoImpl extends DBUtils implements MiddleDao {
    @Override
    public int insertMiddle(int roleid, String[] menuids) {
        int count = 0;
        String sql = "insert into middle(roleid, menuid) values(?, ?)";
        try {
            pps = getConnection().prepareStatement(sql);
            if(menuids != null && menuids.length>0) {
                for (String menuid : menuids) {
                    pps.setInt(1, roleid);
                    pps.setString(2, menuid);
                    pps.addBatch();
                }
            }
            pps.executeBatch();
            count = 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }
}
