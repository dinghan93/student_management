package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Menu;
import com.kkb.xzk.hd.dao.MenuDao;
import com.kkb.xzk.hd.util.DBUtils;
import com.kkb.xzk.hd.util.ResultSetUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 9:54
 * @Modified By:
 */
public class MenuDaoImpl extends DBUtils implements MenuDao {
    @Override
    public List<Menu> getMenuList() {
        try {
            String sql = "select * from menu";
            resultSet = query(sql, null);
            List<Menu> menuList = ResultSetUtil.getResults(resultSet, Menu.class);
            return menuList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }
    @Override
    public Menu getMenuById(int menuid) {
        try {
            String sql = "select * from menu where menuid=?";
            List params = new ArrayList();
            params.add(menuid);
            resultSet = query(sql, params);
            List<Menu> menuList = ResultSetUtil.getResults(resultSet, Menu.class);
            if(menuList.size()==0){
                return null;
            }
            return menuList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<Menu> getMenuList(int pageIndex, int pageSize) {
        try {
            String sql = "select * from menu limit ?,?";
            List params = new ArrayList();
            params.add((pageIndex-1)*pageSize);
            params.add(pageSize);
            resultSet = query(sql, params);
            List<Menu> menuList = ResultSetUtil.getResults(resultSet, Menu.class);
            return menuList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public int total() {
        int count = 0;
        try {
            String sql = "select count(*) from menu";
            resultSet = query(sql, null);
            if(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    @Override
    public List<Menu> getUpMenuList() {
        try {
            String sql = "select * from menu where upmenuid=0";
            resultSet = query(sql, null);
            List<Menu> menuList = ResultSetUtil.getResults(resultSet, Menu.class);
            return menuList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public boolean update(Menu menu) {
        try {
            String sql = "update menu set menuname=?, upmenuid=?, state=?, `desc`=?, url=? where menuid=?";
            List params = new ArrayList();
            params.add(menu.getMenuname());
            params.add(menu.getUpmenuid());
            params.add(menu.getState());
            params.add(menu.getDesc());
            params.add(menu.getUrl());
            params.add(menu.getMenuid());
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
    public boolean insert(Menu menu) {
        try {
            String sql = "insert into menu values(null, ?, ?, ?, ?, ?)";
            List params = new ArrayList();
            params.add(menu.getMenuname());
            params.add(menu.getUpmenuid());
            params.add(menu.getState());
            params.add(menu.getDesc());
            params.add(menu.getUrl());
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
    public boolean delete(Integer menuid) {
        try {
            String sql = "delete from menu where menuid=?";
            List params = new ArrayList();
            params.add(menuid);
            update(sql, params);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            String sql = "delete from menu where menuid=?";
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