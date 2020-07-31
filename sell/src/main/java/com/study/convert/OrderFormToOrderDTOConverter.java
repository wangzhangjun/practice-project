package com.study.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.dataobject.OrderDetail;
import com.study.dto.OrderDTO;
import com.study.enums.ResultEnum;
import com.study.exception.SellException;
import com.study.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderFormToOrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        Gson gson = new Gson();

        //这里为什么不用BeanUtils.copyProperties();
        //因为orderDTO和orderForm字段的名字不一样，只有当名字一样的时候才能够转
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception ex) {
            log.error("【格式转换错误】restl={}", orderForm.getItems());
            log.error(ex.getMessage());
            throw new SellException(ResultEnum.PARAM_ERROR);

        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
