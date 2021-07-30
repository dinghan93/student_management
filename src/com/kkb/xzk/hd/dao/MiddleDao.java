package com.kkb.xzk.hd.dao;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-30 12:14
 * @Modified By:
 */
public interface MiddleDao {
    /**
     * 对middle表执行插入操作。
     * @author
     * @date 2021/7/30
     * @param roleid
     * @param menuids
     * @return 1：表示插入成功。0：表示插入失败
     **/
    int insertMiddle(int roleid, String[] menuids);
}
