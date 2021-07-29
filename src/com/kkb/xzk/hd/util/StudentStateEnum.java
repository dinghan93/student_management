package com.kkb.xzk.hd.util;

import com.kkb.xzk.hd.bean.Student;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-28 22:37
 * @Modified By:
 */
public enum StudentStateEnum {
    READING(1,"在读"),
    SUSPENSION(2,"休学"),
    DROPOUT(3,"退学"),
    DELETED(4,"删除");

    public final Integer type;
    public final String value;
    StudentStateEnum(Integer type, String value){
        this.type = type;
        this.value = value;
    }
}
