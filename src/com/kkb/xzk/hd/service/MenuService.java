package com.kkb.xzk.hd.service;

import com.kkb.xzk.hd.bean.Menu;

import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 9:53
 * @Modified By:
 */
public interface MenuService {
    /**
     * 得到一个分级的菜单集合
     *
     * @return
     * @author HanDing
     * @date 2021/7/30
     **/
    List<Menu> getMenuList();

    /**
     * 得到一个普通的（扁平的）菜单集合（用于进行菜单管理的首页展示）
     *
     * @param pageIndex
     * @param pageSize
     * @return
     * @author
     * @date 2021/7/31
     **/
    List<Menu> getMenuList(int pageIndex, int pageSize);

    int total();

    List<Menu> getUpMenuList();

    Menu getMenuById(int menuid);

    boolean update(Menu menu);

    boolean insert(Menu menu);

    boolean delete(Integer menuid);

    boolean deleteBatch(String[] menuids);
}
