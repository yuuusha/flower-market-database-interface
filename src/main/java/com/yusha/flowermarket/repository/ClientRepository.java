package com.yusha.flowermarket.repository;

import com.yusha.flowermarket.dto.Client;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepository {

    private final JdbcClient client;

    public List<Client> findAll() {
        return client.sql("SELECT * FROM Client")
                .query(Client.class)
                .list();
    }

    public Client findById(int Client_id) {
        return client.sql("SELECT * FROM Client WHERE Client_id = :client_id")
                .param("client_id", Client_id)
                .query(Client.class)
                .single();
    }

    public void add(String Last_name, String First_name, String Middle_name,
                    LocalDate Date_of_birth, String Client_address, String Phone_number,
                    String Email, double Discount) {
        client.sql("INSERT INTO Client(last_name, first_name, middle_name, date_of_birth, client_address, phone_number, email, discount) VALUES(:last_name, :first_name, :middle_name, :date_of_birth, :client_address, :phone_number, :email, :discount)")
                .param("last_name", Last_name)
                .param("first_name", First_name)
                .param("middle_name", Middle_name)
                .param("date_of_birth", Date_of_birth)
                .param("client_address", Client_address)
                .param("phone_number", Phone_number)
                .param("email", Email)
                .param("discount", Discount)
                .update();
    }

    public void delete(int Client_id) {
        client.sql("UPDATE Client SET is_deleted = 1 WHERE Client_id = :client_id")
                .param("client_id", Client_id)
                .update();
    }

    public void returnFromDelete(int Client_id) {
        client.sql("UPDATE Client SET is_deleted = 0 WHERE Client_id = :client_id")
                .param("client_id", Client_id)
                .update();
    }

    public void update(String Last_name, String First_name, String Middle_name,
                       LocalDate Date_of_birth, String Client_address, String Phone_number,
                       String Email, double Discount, int Client_id) {
        client.sql("""
                    UPDATE Client 
                    SET Last_name = :last_name, First_name = :first_name, Middle_name = :middle_name, Date_of_birth = :date_of_birth, Client_address = :client_address, Phone_number = :phone_number, Email = :email, Discount = :discount
                    WHERE Client_id = :client_id
                    """)
                .param("last_name", Last_name)
                .param("first_name", First_name)
                .param("middle_name", Middle_name)
                .param("date_of_birth", Date_of_birth)
                .param("client_address", Client_address)
                .param("phone_number", Phone_number)
                .param("email", Email)
                .param("discount", Discount)
                .param("client_id", Client_id)
                .update();
    }

}
