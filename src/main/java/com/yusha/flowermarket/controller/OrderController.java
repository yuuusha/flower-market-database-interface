package com.yusha.flowermarket.controller;

import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.dto.Order;
import com.yusha.flowermarket.dto.ProductsForOrder;
import com.yusha.flowermarket.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class OrderController {

    private final OrderService service;

    @GetMapping("/order")
    public List<Order> findAll() {
        return service.findAll();
    }

    @GetMapping("/order/{order_id}")
    public Order findById(@PathVariable("order_id") int orderId) {
        return service.findById(orderId);
    }

    @PostMapping("/order")
    public int add(@RequestParam("client_id") int Client_id,
                    @RequestParam("order_date") LocalDate Order_date) {
        return service.add(Client_id, Order_date);
    }

    @DeleteMapping("/order")
    public void delete(@RequestParam("order_id") int Order_id) {
        service.delete(Order_id);
    }

    @PostMapping("/order/product")
    public void addProduct(int Order_id, int Product_id, int Quantity) {
        service.addProduct(Order_id, Product_id, Quantity);
    }

    @PostMapping("/orderproduct")
    public void addOrderAndProduct(int Client_id, LocalDate Order_date, int Product_id, int Quantity) {
        service.addOrderAndProduct(Client_id, Order_date, Product_id, Quantity);
    }

    @GetMapping("/order/product/{order_id}")
    public List<ProductsForOrder> getProductForOrder(@PathVariable("order_id") int orderId) {
        return service.getProductForOrder(orderId);
    }
}
