package com.yusha.flowermarket.repository;

import com.yusha.flowermarket.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoredProceduresRepository {

    private final JdbcClient client;

    public TopCashierEarnings getTopEarningCashier(LocalDate startDate, LocalDate endDate, int mode) {
        return client.sql("EXEC GetTopEarningCashier :start_date, :end_date, :mode")
                .param("start_date", startDate)
                .param("end_date", endDate)
                .param("mode", mode)
                .query(TopCashierEarnings.class)
                .single();
    }

    public double getProfit(LocalDate startDate, LocalDate endDate) {
        return client.sql("EXEC CalculateProfit :start_date, :end_date")
                .param("start_date", startDate)
                .param("end_date", endDate)
                .query(Double.class)
                .single();
    }

    public int getOrderCount(LocalDate startDate, LocalDate endDate) {
        return client.sql("EXEC GetOrderCountByPeriod :start_date, :end_date")
                .param("start_date", startDate)
                .param("end_date", endDate)
                .query(Integer.class)
                .single();
    }

    public List<ClientSales> getClientSales(LocalDate startDate, LocalDate endDate) {
        return client.sql("EXEC CalculateTotalSalesByClient :start_date, :end_date")
                .param("start_date", startDate)
                .param("end_date", endDate)
                .query(ClientSales.class)
                .list();
    }

    public List<Order> getActiveOrders() {
        return client.sql("EXEC GetActiveOrders")
                .query(Order.class)
                .list();
    }

    public int getAmountByOrder(int Order_id) {
        return client.sql("EXEC GetAmountByOrder :order_id")
                .param("order_id", Order_id)
                .query(Integer.class)
                .single();
    }

    public List<OrderProduct> getListProductByOrder(int Order_id) {
        return client.sql("EXEC GetListProductByOrder :order_id")
                .param("order_id", Order_id)
                .query(OrderProduct.class)
                .list();
    }

}
