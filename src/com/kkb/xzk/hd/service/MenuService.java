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
     * @author HanDing
     * @date 2021/7/30
     * @return
     **/
    List<Menu> getMenuList();
}
