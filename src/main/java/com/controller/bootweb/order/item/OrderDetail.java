package com.controller.bootweb.order.item;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 详细订单
 * @author admin
 *
 */
@Data
public class OrderDetail {
    private int id; //详细订单ID
    private int orderId;//主订单ID
    private Merchandise merchandise; //商品详情
    private BigDecimal payMoney; //支付单价
}