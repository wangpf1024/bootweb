package com.controller.bootweb.order.decorator;

import com.controller.bootweb.order.item.PromotionType;
import com.controller.bootweb.order.item.UserCoupon;
import com.controller.bootweb.order.item.UserRedPacket;
import lombok.Data;

/**
 * 促销类型
 * @author admin
 *
 */
@Data
public class SupportPromotions implements Cloneable{

    private int id;//该商品促销的ID
    private PromotionType promotionType;//促销类型 1\优惠券 2\红包
    private int priority; //优先级
    private UserCoupon userCoupon; //用户领取该商品的优惠券
    private UserRedPacket userRedPacket; //用户领取该商品的红包

    //重写clone方法
    public SupportPromotions clone(){
        SupportPromotions supportPromotions = null;
        try{
            supportPromotions = (SupportPromotions)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return supportPromotions;
    }
}