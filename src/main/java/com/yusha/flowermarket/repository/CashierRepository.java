package com.yusha.flowermarket.repository;


import com.yusha.flowermarket.dto.Cashier;
import com.yusha.flowermarket.dto.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CashierRepository {

    private final JdbcClient client;

    public List<Cashier> findAll() {
        return client.sql("SELECT * FROM Cashier")
                .query(Cashier.class)
                .list();
    }

    public Cashier findById(int Cashier_id) {
        return client.sql("SELECT * FROM Cashier WHERE Cashier_id = :cashier_id")
                .param("cashier_id", Cashier_id)
                .query(Cashier.class)
                .single();
    }

    public void add(String Last_name, String First_name, String Middle_name,
                    LocalDate Date_of_birth, String Phone_number, int Experience) {
        client.sql("INSERT INTO Cashier(last_name, first_name, middle_name, date_of_birth, phone_number, experience) VALUES(:last_name, :first_name, :middle_name, :date_of_birth, :phone_number, :experience)")
                .param("last_name", Last_name)
                .param("first_name", First_name)
                .param("middle_name", Middle_name)
                .param("date_of_birth", Date_of_birth)
                .param("phone_number", Phone_number)
                .param("experience", Experience)
                .update();
    }

    public void delete(int Cashier_id) {
        client.sql("UPDATE Cashier SET is_deleted = 1 WHERE Cashier_id = :cashier_id")
                .param("cashier_id", Cashier_id)
                .update();
    }

    public void returnFromDelete(int Cashier_id) {
        client.sql("UPDATE Cashier SET is_deleted = 0 WHERE Cashier_id = :cashier_id")
                .param("cashier_id", Cashier_id)
                .update();
    }

    public void update(String Last_name, String First_name, String Middle_name,
                       LocalDate Date_of_birth, String Phone_number,
                       int Experience, int Cashier_id) {
        client.sql("""
                    UPDATE Cashier
                    SET Last_name = :last_name, First_name = :first_name, Middle_name = :middle_name, Date_of_birth = :date_of_birth, Phone_number = :phone_number, Experience = :experience
                    WHERE Cashier_id = :cashier_id
                    """)
                .param("last_name", Last_name)
                .param("first_name", First_name)
                .param("middle_name", Middle_name)
                .param("date_of_birth", Date_of_birth)
                .param("phone_number", Phone_number)
                .param("experience", Experience)
                .param("cashier_id", Cashier_id)
                .update();
    }
}
