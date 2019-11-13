package com.mq.producer;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TestOrder
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/13 15:48
 * @Version 1.0.0
 **/
@Data
public class TestOrder  implements Serializable{
    private String orderNum;

    private String orderOwner;

    public TestOrder(String orderNum, String orderOwner) {
        this.orderNum = orderNum;
        this.orderOwner = orderOwner;
    }
}
