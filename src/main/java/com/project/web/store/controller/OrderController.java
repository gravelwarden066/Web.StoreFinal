package com.project.web.store.controller;

import com.project.web.store.models.Order;
import com.project.web.store.services.OrderServiceImp;
import com.project.web.store.services.ProductServiceImp;
import com.project.web.store.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @Autowired
    OrderServiceImp orderServiceImp;
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    ProductServiceImp productServiceImp;

    @GetMapping(value = "/order/all")
    public ModelAndView getAllOrders(Order order) {
        ModelAndView mav = new ModelAndView("order-list");
        mav.addObject("orders", orderServiceImp.getAllOrders());
        mav.addObject("orderId", order.getId());
        return mav;
    }

    @GetMapping("/order/{id}")
    public ModelAndView getById(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("order-page");
        mav.addObject("order", orderServiceImp.getBy(id));
        return mav;
    }

    @GetMapping("/order/add")
    public ModelAndView createOrderForm(Model model) {
        ModelAndView mav = new ModelAndView("order-add");
        mav.addObject("userList", userServiceImp.getAllUsers());
        mav.addObject("productList", productServiceImp.getAllProducts());
        model.addAttribute("order", new Order());
        return mav;
    }

    @PostMapping("/order/add")
    public ModelAndView createOrder(@ModelAttribute Order order) {
        ModelAndView mav = new ModelAndView("order-add");
        mav.addObject("order", orderServiceImp.createOrder(order));
        mav.setViewName("redirect:/order/all");
        return mav;
    }

    @GetMapping("/order/edit/{id}")
    public ModelAndView updateOrderForm(@PathVariable("id") Long id, Order order) {
        ModelAndView mav = new ModelAndView("order-edit");
        mav.addObject("order", orderServiceImp.getBy(id));
        return mav;
    }

    @PatchMapping("/order/edit/{id}")
    public Order updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        ModelAndView mav = new ModelAndView("order-edit");
        orderServiceImp.updateOrder(id, order);
        mav.setViewName("redirect:/order/all");
        return order;
    }

    @DeleteMapping("/order/delete/{id}")
    void deleteOrder(@PathVariable Long id) {
        orderServiceImp.deleteOrder(id);
    }
}
