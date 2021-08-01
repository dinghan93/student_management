package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.bean.Menu;
import com.kkb.xzk.hd.dao.MenuDao;
import com.kkb.xzk.hd.dao.MiddleDao;
import com.kkb.xzk.hd.dao.impl.MenuDaoImpl;
import com.kkb.xzk.hd.dao.impl.MiddleDaoImpl;
import com.kkb.xzk.hd.service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 9:54
 * @Modified By:
 */
public class MenuServiceImpl implements MenuService {
    MenuDao menuDao = new MenuDaoImpl();
    MiddleDao middleDao = new MiddleDaoImpl();
    @Override
    public List<Menu> getMenuList() {
        List<Menu> oriMenuList = menuDao.getMenuList();
        List<Menu> newMenuList = new ArrayList<>(); //分级后的菜单集合。该集合里只保存一级菜单
        for (Menu menu : oriMenuList) {
            if(menu.getUpmenuid()==0){ //说明是一级菜单
                List<Menu> subMenus = new ArrayList<>();
                for (Menu menu1 : oriMenuList) {
                    if(menu1.getUpmenuid()==menu.getMenuid()){
                        subMenus.add(menu1);
                    }
                }
                menu.setSubMenus(subMenus);
                newMenuList.add(menu);
            }
        }
        return newMenuList;
    }

    @Override
    public List<Menu> getMenuList(int pageIndex, int pageSize) {
        return menuDao.getMenuList(pageIndex, pageSize);
    }

    @Override
    public int total() {
        return menuDao.total();
    }

    @Override
    public List<Menu> getUpMenuList() {
        return menuDao.getUpMenuList();
    }

    @Override
    public Menu getMenuById(int menuid) {
        return menuDao.getMenuById(menuid);
    }

    @Override
    public boolean update(Menu menu) {
        return menuDao.update(menu);
    }

    @Override
    public boolean insert(Menu menu) {
        return menuDao.insert(menu);
    }

    @Override
    public boolean delete(Integer menuid) {
        boolean f1 = middleDao.deleteByMenuId(menuid);
        boolean f2 = menuDao.delete(menuid);
        return f1 && f2;
    }

    @Override
    public boolean deleteBatch(String[] menuids) {
        if(menuids==null || menuids.length==0){
            return false;
        }

        int i = middleDao.deleteBatch(menuids);
        int j = menuDao.deleteBatch(menuids);
        return (i!=0 || j!=0);
    }
}
