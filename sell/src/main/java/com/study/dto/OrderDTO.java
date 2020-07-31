package com.study.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.study.dataobject.OrderDetail;
import com.study.enums.OrderStatusEnum;
import com.study.enums.PayStatusEnum;
import com.study.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//DTO一般表示传输数据，因为如果放在dataobject中，就表示是和数据库映射的，这样有点乱。所以一般放在一个DTO的包中
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    // 订单状态, 默认为0新下单.
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    @JsonSerialize(using = Date2LongSerializer.class) //会使用这个类进行格式化，小技巧
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
