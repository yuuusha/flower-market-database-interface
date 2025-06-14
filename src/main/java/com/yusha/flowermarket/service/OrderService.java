package com.yusha.flowermarket.service;

import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.dto.Order;
import com.yusha.flowermarket.dto.ProductsForOrder;
import com.yusha.flowermarket.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    @Transactional
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Order findById(int Order_id) {
        return repository.findById(Order_id);
    }

    @Transactional
    public int add(int Client_id, LocalDate Order_date) {
        return repository.add(Client_id, Order_date);
    }

    @Transactional
    public void delete(int Order_id) {
        repository.delete(Order_id);
    }

    @Transactional
    public void addProduct(int Order_id, int Product_id, int Quantity) {
        repository.addProduct(Order_id, Product_id, Quantity);
    }

    @Transactional
    public void addOrderAndProduct(int Client_id, LocalDate Order_date, int Product_id, int Quantity) {
        int Order_id = repository.add(Client_id, Order_date);
        repository.addProduct(Order_id, Product_id, Quantity);
    }

    @Transactional
    public List<ProductsForOrder> getProductForOrder(int Order_id) {
        return repository.getProductForOrder(Order_id);
    }
}
