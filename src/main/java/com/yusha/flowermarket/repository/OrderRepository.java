package com.yusha.flowermarket.repository;

import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.dto.Order;
import com.yusha.flowermarket.dto.ProductsForOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final JdbcClient client;

    public List<Order> findAll() {
        return client.sql("SELECT * FROM Orders")
                .query(Order.class)
                .list();
    }

    public Order findById(int Order_id) {
        return client.sql("SELECT * FROM Orders WHERE Order_id = :order_id")
                .param("order_id", Order_id)
                .query(Order.class)
                .single();
    }

    public int add(int Client_id, LocalDate Order_date) {
        return client.sql("EXEC AddOrderAndGetId :client_id, :order_date")
                .param("client_id", Client_id)
                .param("order_date", Order_date)
                .query(Integer.class)
                .single();
    }

    public void delete(int Order_id) {
        client.sql("UPDATE Orders SET is_deleted = 1 WHERE Order_id = :order_id")
                .param("order_id", Order_id)
                .update();
    }

    public void addProduct(int Order_id, int Product_id, int Quantity) {
        client.sql("INSERT INTO ProductsInOrder(order_id, product_id, quantity) VALUES (:order_id, :product_id, :quantity)")
                    .param("order_id", Order_id)
                    .param("product_id", Product_id)
                    .param("quantity", Quantity)
                    .update();
    }

    public List<ProductsForOrder> getProductForOrder(int Order_id) {
        return client.sql("select Product.Product_id, Product.Type_id, Product.Name, ProductsInOrder.Quantity, Product.Price from Orders\n" +
                "INNER JOIN ProductsInOrder ON ProductsInOrder.Order_id = Orders.Order_id\n" +
                "INNER JOIN Product ON Product.Product_id = ProductsInOrder.Product_id\n" +
                "WHERE Orders.Order_id = :order_id")
                .param("order_id", Order_id)
                .query(ProductsForOrder.class)
                .list();
    }


}
