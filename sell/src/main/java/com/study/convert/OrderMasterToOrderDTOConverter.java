package com.study.convert;

import com.study.dataobject.OrderMaster;
import com.study.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMasterToOrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> covert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(
                e -> convert(e)  //这个调用的是上面的convert
        ).collect(Collectors.toList());
    }
}
