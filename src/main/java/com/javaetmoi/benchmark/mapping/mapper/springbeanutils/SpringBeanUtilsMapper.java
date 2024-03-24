package com.javaetmoi.benchmark.mapping.mapper.springbeanutils;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;


public class SpringBeanUtilsMapper implements OrderMapper {
    public SpringBeanUtilsMapper() {

    }
    @Override
    public OrderDTO map(Order source) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            org.springframework.beans.BeanUtils.copyProperties(source, orderDTO);
        } catch (Exception e) {

        }
        return orderDTO;
    }
}
