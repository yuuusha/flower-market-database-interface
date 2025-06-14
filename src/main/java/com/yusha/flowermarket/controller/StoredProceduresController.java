package com.yusha.flowermarket.controller;

import com.yusha.flowermarket.dto.ClientSales;
import com.yusha.flowermarket.dto.Order;
import com.yusha.flowermarket.dto.OrderProduct;
import com.yusha.flowermarket.dto.TopCashierEarnings;
import com.yusha.flowermarket.service.StoredProceduresService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class StoredProceduresController {

    private final StoredProceduresService service;

    @GetMapping("/procedures/topcashier")
    public TopCashierEarnings getTopEarningCashier(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                   @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getTopEarningCashier(startDate, endDate, 1);
    }

    @GetMapping("/procedures/profit")
    public double getProfit(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getProfit(startDate, endDate);
    }

    @GetMapping("/procedures/ordercount")
    public double getOrderCount(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getOrderCount(startDate, endDate);
    }

    @GetMapping("/procedures/clientsales")
    public List<ClientSales> getClientSales(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getClientSales(startDate, endDate);
    }

    @GetMapping("/procedures/activeorders")
    public List<Order> getActiveOrders() {
        return service.getActiveOrders();
    }

    @GetMapping("/procedures/orderamount")
    public int getAmountByOrder(@RequestParam("order_id") int Order_id) {
        return service.getAmountByOrder(Order_id);
    }

    @GetMapping("/procedures/productorder")
    public List<OrderProduct> getListProductByOrder(@RequestParam("order_id") int Order_id) {
        return service.getListProductByOrder(Order_id);
    }

}
