package com.kkb.xzk.hd.service.impl;

import com.kkb.xzk.hd.bean.Menu;
import com.kkb.xzk.hd.dao.MenuDao;
import com.kkb.xzk.hd.dao.impl.MenuDaoImpl;
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
}
