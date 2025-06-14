package com.yusha.flowermarket.repository;

import com.yusha.flowermarket.dto.Bouquet;
import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final JdbcClient client;

    public List<Product> findAll() {
        return client.sql("SELECT * FROM Product")
                .query(Product.class)
                .list();
    }

    public Product findById(int Product_id) {
        return client.sql("SELECT * FROM Product WHERE Product_id = :product_id")
                .param("product_id", Product_id)
                .query(Product.class)
                .single();
    }

    public List<Product> findFlowers() {
        return client.sql("SELECT * FROM Product WHERE Type_id = 1")
                .query(Product.class)
                .list();
    }

    public List<Product> findBouquets() {
        return client.sql("SELECT * FROM Product WHERE Type_id = 2")
                .query(Product.class)
                .list();
    }

    public List<Product> findAdditionals() {
        return client.sql("SELECT * FROM Product WHERE Type_id = 3")
                .query(Product.class)
                .list();
    }

    public void add(int Type_id, String Name, double Price) {
        client.sql("INSERT INTO Product(type_id, name, price) VALUES (:type_id, :name, :price)")
                .param("type_id", Type_id)
                .param("name", Name)
                .param("price", Price)
                .update();
    }

    public void delete(int Product_id) {
        client.sql("UPDATE Product SET is_deleted = 1 WHERE Product_id = :product_id")
                .param("product_id", Product_id)
                .update();
    }

    public void returnFromDelete(int Product_id) {
        client.sql("UPDATE Product SET is_deleted = 0 WHERE Product_id = :product_id")
                .param("product_id", Product_id)
                .update();
    }

    public void update(String Name, double Price, int Product_id) {
        client.sql("""
                    UPDATE Product
                    SET Name = :name, Price = :price
                    WHERE Product_id = :product_id
                    """)
                .param("name", Name)
                .param("price", Price)
                .param("product_id", Product_id)
                .update();
    }

    public List<Bouquet> getFlowersForBouquet(int Bouquet_id) {
        return client.sql("""
                          SELECT BouquetFlower.Flower_id AS Product_id, Flower.Name, BouquetFlower.Quantity, Flower.Price FROM BouquetFlower
                          INNER JOIN Flower ON Flower.Flower_id = BouquetFlower.Flower_id
                          WHERE BouquetFlower.Bouquet_id = :bouquet_id
                          """)
                .param("bouquet_id", Bouquet_id)
                .query(Bouquet.class)
                .list();
    }

    public List<Bouquet> getBouquetsForFlower(int Flower_id) {
        return client.sql("""
                          
                        SELECT BouquetFlower.Bouquet_id AS Product_id, Bouquet.Name, BouquetFlower.Quantity, Bouquet.Price FROM BouquetFlower
                        INNER JOIN Bouquet ON Bouquet.Bouquet_id = BouquetFlower.Bouquet_id
                        WHERE BouquetFlower.Flower_id = :flower_id
                          """)
                .param("flower_id", Flower_id)
                .query(Bouquet.class)
                .list();
    }


}
