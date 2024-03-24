package com.javaetmoi.benchmark.mapping.mapper.orika;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

public class OrikaSimpleMapper implements OrderMapper {
    @Override
    public OrderDTO map(Order source) {
        return OrikaSimpleMapperUtils.map(source, OrderDTO.class);
    }
}
