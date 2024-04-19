package com.cc.ccrpcprovider.demos.service;

import com.cc.ccrpccore.demos.annotion.RpcProvider;
import com.cc.ccrpcdemoapi.demos.web.Order;
import com.cc.ccrpcdemoapi.demos.web.OrderService;
import org.springframework.stereotype.Service;

@Service
@RpcProvider
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrder(Integer orderId) {
        return new Order(orderId,"order_"+System.currentTimeMillis());
    }
}
