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

    @Override
    public boolean deleteByRoleId(int roleid) {
        try {
            String sql = "delete from middle where roleid=?";
            List params = new ArrayList();
            params.add(roleid);
            update(sql, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    @Override
    public boolean deleteByMenuId(Integer menuid) {
        try {
            String sql = "delete from middle where menuid=?";
            List params = new ArrayList();
            params.add(menuid);
            update(sql, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    @Override
    public int deleteBatch(String[] menuids) {
        if(menuids==null || menuids.length==0){
            return 0;
        }
        int count = 0;
        try {
            String sql = "delete from middle where menuid=?";
            pps = getPps(sql);
            for (String menuid : menuids) {
                pps.setInt(1, Integer.parseInt(menuid));
                pps.addBatch();
            }
            int[] result = pps.executeBatch();
            for (int i : result) {
                count += i;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }
}
