package com.bilgeadam.service;

import com.bilgeadam.dto.request.OrderSaveRequestDto;
import com.bilgeadam.entity.Order;
import com.bilgeadam.mapper.IOrderMapper;
import com.bilgeadam.repository.IOrderRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceManager<Order,Long> {

    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }
    public String save(OrderSaveRequestDto dto){
        orderRepository.save(IOrderMapper.INSTANCE.toOrder(dto));
        return "Order Save Success";
    }
}
