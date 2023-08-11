package com.abuzobaer_comp303_assignment01.controller;

import com.abuzobaer_comp303_assignment01.entity.Order;
import com.abuzobaer_comp303_assignment01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("")
    public String showAll(Model model)

    {
        List<Order> orderList=orderService.findAll();
        model.addAttribute("orders",orderList);


        return "index";
    }

    @GetMapping("order/new")
    public String addOrder(Model model)
    {
        Order order=new Order();
        model.addAttribute("order",order);
        return "create_order";
    }

    @PostMapping("order/save")
    public String saveOrder(@Valid Order order, BindingResult bindingResult )
    {
        if(bindingResult.hasErrors())
        {return "create_order";}

        orderService.addOrder(order);

        return "redirect:/";
    }

    @GetMapping("order/{id}")
    public String showOrder(Model model, @PathVariable int id)
    {

            Order order=orderService.findById(id);
            model.addAttribute("order",order);


        return "show_order";
    }

}
