package com.kkb.xzk.hd.util;

import java.util.List;

/**
 * @Author: HanDing
 * @Description: 封装关于分页显示的信息
 * @Date Created in 2021-07-29 10:24
 * @Modified By:
 */
public class PageUtil {
    private int total; //总条数
    private int totalPages; //总页数
    private int pageIndex; //当前页码
    private int pageSize = 5; //每页显示的数据个数
    private List dataList;

    public PageUtil() {
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public List getDataList() {
        return dataList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        totalPages = total%pageSize==0 ? total/pageSize : total/pageSize+1;
        return totalPages;
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }


}
