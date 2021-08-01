package com.kkb.xzk.hd.dao;

import com.kkb.xzk.hd.bean.Menu;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 9:54
 * @Modified By:
 */
public interface MenuDao {
    List<Menu> getMenuList();

    Menu getMenuById(int menuid);

    List<Menu> getMenuList(int pageIndex, int pageSize);

    int total();

    List<Menu> getUpMenuList();

    boolean update(Menu menu);

    boolean insert(Menu menu);

    boolean delete(Integer menuid);

    int deleteBatch(String[] menuids);

    /**
     * 把一个扁平的菜单集合变成一个分层的菜单集合
     *
     * @param menuList
     * @return
     * @author
     * @date 2021/8/1
     **/
    List<Menu> toHierarchical(List<Menu> menuList);
}
