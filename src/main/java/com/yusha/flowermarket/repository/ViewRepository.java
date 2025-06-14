package com.yusha.flowermarket.repository;

import com.yusha.flowermarket.dto.BouquetFlowerView;
import com.yusha.flowermarket.dto.Receipt;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ViewRepository {

    private final JdbcClient client;

    public List<BouquetFlowerView> getBouquetFlower() {
        return client.sql("SELECT * FROM v_BouquetFlower")
                .query(BouquetFlowerView.class)
                .list();
    }

    public void addBouquetFlower(String Bouquet, String Flower, int Quantity, double BouquetPrice, double FlowerPrice) {
        client.sql("INSERT INTO v_BouquetFlower VALUES(:bouquet, :flower, :quantity, :bouquet_price, :flower_price)")
                .param("bouquet", Bouquet)
                .param("flower", Flower)
                .param("quantity", Quantity)
                .param("bouquet_price", BouquetPrice)
                .param("flower_price", FlowerPrice)
                .update();
    }

    public List<Receipt> getReceipts() {
        return client.sql("SELECT * FROM v_Receipt")
                .query(Receipt.class)
                .list();
    }

    public void addReceipt(int Order_id, int Cashier_id, LocalDate Issue_date) {
        client.sql("INSERT INTO v_Receipt(Order_id, Cashier_id, Issue_date) VALUES (:order_id, :cashier_id, :issue_date)")
                .param("order_id", Order_id)
                .param("cashier_id", Cashier_id)
                .param("issue_date", Issue_date)
                .update();
    }
}
