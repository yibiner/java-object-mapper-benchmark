package com.javaetmoi.benchmark.mapping.mapper.beancopier;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import net.sf.cglib.beans.BeanCopier;

public class BeanCopierMapper implements OrderMapper {
    private final BeanCopier bc;

    public BeanCopierMapper() {
        bc = BeanCopier.create(Order.class, OrderDTO.class, false);
    }

    @Override
    public OrderDTO map(Order source) {
        OrderDTO orderDTO = new OrderDTO();
        bc.copy(source, orderDTO, null);
        return orderDTO;
    }
}
