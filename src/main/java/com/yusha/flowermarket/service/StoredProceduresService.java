package com.yusha.flowermarket.service;

import com.yusha.flowermarket.dto.ClientSales;
import com.yusha.flowermarket.dto.Order;
import com.yusha.flowermarket.dto.OrderProduct;
import com.yusha.flowermarket.dto.TopCashierEarnings;
import com.yusha.flowermarket.repository.StoredProceduresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoredProceduresService {

    private final StoredProceduresRepository repository;

    public TopCashierEarnings getTopEarningCashier(LocalDate startDate, LocalDate endDate, int mode) {
        return repository.getTopEarningCashier(startDate, endDate, mode);
    }

    public double getProfit(LocalDate startDate, LocalDate endDate) {
        return repository.getProfit(startDate, endDate);
    }

    public int getOrderCount(LocalDate startDate, LocalDate endDate) {
        return repository.getOrderCount(startDate, endDate);
    }

    public List<ClientSales> getClientSales(LocalDate startDate, LocalDate endDate) {
        return repository.getClientSales(startDate, endDate);
    }

    public List<Order> getActiveOrders() {
        return repository.getActiveOrders();
    }

    public int getAmountByOrder(int Order_id) {
        return repository.getAmountByOrder(Order_id);
    }

    public List<OrderProduct> getListProductByOrder(int Order_id) {
        return repository.getListProductByOrder(Order_id);
    }
}
