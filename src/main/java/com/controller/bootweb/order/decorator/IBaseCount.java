package com.controller.bootweb.order.decorator;

import com.controller.bootweb.order.item.OrderDetail;

import java.math.BigDecimal;

/**
 * 计算支付金额接口类
 * @author admin
 *
 */
public interface IBaseCount {

    BigDecimal countPayMoney(OrderDetail orderDetail);

}