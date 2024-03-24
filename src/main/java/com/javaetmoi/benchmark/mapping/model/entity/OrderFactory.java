package com.javaetmoi.benchmark.mapping.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderFactory {

    public static Order buildOrder() {
        Order order = new Order();
        Customer customer = new Customer();
        order.setCustomer(customer);
        customer.setName("Joe Smith");
        Address billingAddress = new Address();
        customer.setBillingAddress(billingAddress);
        billingAddress.setStreet("1234 Market Street");
        billingAddress.setCity("San Fran");
        Address shippingAddress = new Address();
        customer.setShippingAddress(shippingAddress);
        shippingAddress.setStreet("1234 West Townsend");
        shippingAddress.setCity("Boston");
        List<Product> products = new ArrayList<Product>(2);
        order.setProducts(products);
        products.add(new Product("socks"));
        products.add(new Product("shoes"));
        return order;
    }

    public static Order buildPartialOrder() {
        Order order = new Order();
        Customer customer = new Customer();
        order.setCustomer(customer);
        customer.setName("John Doe");
        Address billingAddress = new Address();
        customer.setBillingAddress(billingAddress);
        billingAddress.setStreet("93 Newcastle Dr.");
        order.setProducts(Collections.emptyList());
        return order;
    }

    public static Order buildSameNameOrder() {
        Order order = new Order();
        order.setTag("Ordinary consumption");
        order.setStatus("Finish");
        return order;
    }
}
