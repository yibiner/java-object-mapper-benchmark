package com.javaetmoi.benchmark.mapping.mapper.apachebeanutils;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import org.apache.commons.beanutils.BeanUtils;

public class ApacheBeanUtilsMapper implements OrderMapper {

    public ApacheBeanUtilsMapper() {

    }

    @Override
    public OrderDTO map(Order source) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            BeanUtils.copyProperties(orderDTO, source);
        } catch (Exception e) {

        }
        return orderDTO;
    }
}
