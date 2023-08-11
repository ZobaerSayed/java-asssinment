package com.abuzobaer_comp303_assignment01.service;

import com.abuzobaer_comp303_assignment01.dao.OrderRepository;
import com.abuzobaer_comp303_assignment01.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll()
    {
        return repository.findAll();
    }



    public Order findById(int id)
    {
        return repository.findById(id).get();
    }

    public void addOrder(Order order)
    {
        if(order.getModel().equals("Iphone X"))
        {
            order.setPrice(200);
        }
        if(order.getModel().equals("Iphone 11"))
        {
            order.setPrice(300);
        }
        if(order.getModel().equals("Iphone 11 Pro"))
        {
            order.setPrice(400);
        }
        if(order.getModel().equals("Samsung S21"))
        {
            order.setPrice(200);
        }
        if(order.getModel().equals("Samsung S21"))
        {
            order.setPrice(300);
        }
        if(order.getModel().equals("Samsung S21"))
        {
            order.setPrice(400);
        }
        repository.save(order);
    }
}
