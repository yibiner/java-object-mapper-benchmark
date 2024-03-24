package com.javaetmoi.benchmark.mapping.mapper.jmapper;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.dto.ProductDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Address;
import com.javaetmoi.benchmark.mapping.model.entity.Customer;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

public class JMapperMapper implements OrderMapper {

    JMapper<OrderDTO, Order> mapper;

    public JMapperMapper() {

        JMapperAPI api = new JMapperAPI()
                .add(mappedClass(OrderDTO.class)
                    .add(attribute("shippingStreetAddress").value("${customer.shippingAddress.street}"))
                    .add(attribute("shippingCity").value("${customer.shippingAddress.city}"))
                    .add(attribute("billingStreetAddress").value("${customer.billingAddress.street}"))
                    .add(attribute("billingCity").value("${customer.billingAddress.city}"))
                    .add(attribute("products").value("products"))
                    .add(attribute("customerName").value("${customer.name}"))
                    .add(attribute("tag").value("${tag}"))
                    .add(attribute("status").value("${status}")))
                .add(mappedClass(ProductDTO.class)
                    .add(attribute("name").value("name")));
        
        mapper = new JMapper<OrderDTO, Order>(OrderDTO.class, Order.class, api);
    }

    @Override
    public OrderDTO map(Order source) {
        // Waiting https://github.com/jmapper-framework/jmapper-core/issues/43
        // By waiting: hand mapping with by practice 'cause we are changing the source object.
        if (source.getCustomer() == null) {
            source.setCustomer(new Customer());
        }
        if (source.getCustomer().getShippingAddress() == null) {
            source.getCustomer().setShippingAddress(new Address());
        }
        if (source.getCustomer().getBillingAddress() == null) {
            source.getCustomer().setBillingAddress(new Address());
        }
        return mapper.getDestination(source);
    }

}
