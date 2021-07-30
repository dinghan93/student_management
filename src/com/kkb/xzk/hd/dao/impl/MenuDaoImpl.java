package com.kkb.xzk.hd.dao.impl;

import com.kkb.xzk.hd.bean.Menu;
import com.kkb.xzk.hd.dao.MenuDao;
import com.kkb.xzk.hd.util.DBUtils;
import com.kkb.xzk.hd.util.ResultSetUtil;

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
        String sql = "select * from menu";
        resultSet = query(sql, null);
        List<Menu> menuList = ResultSetUtil.getResults(resultSet, Menu.class);
        return menuList;
    }
}
