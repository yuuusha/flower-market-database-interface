package com.yusha.flowermarket.service;

import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Client findById(int Client_id) {
        return repository.findById(Client_id);
    }

    @Transactional
    public void add(String Last_name, String First_name, String Middle_name,
                    LocalDate Date_of_birth, String Client_address, String Phone_number,
                    String Email, double Discount) {
        repository.add(Last_name, First_name, Middle_name,
                Date_of_birth, Client_address, Phone_number,
                Email, Discount);
    }

    @Transactional
    public void delete(int Client_id) {
        repository.delete(Client_id);
    }

    @Transactional
    public void returnFromDelete(int Client_id) {
        repository.returnFromDelete(Client_id);
    }

    @Transactional
    public void update(String Last_name, String First_name, String Middle_name,
                       LocalDate Date_of_birth, String Client_address, String Phone_number,
                       String Email, double Discount, int clientId) {
        repository.update(Last_name, First_name, Middle_name,
                Date_of_birth, Client_address, Phone_number,
                Email, Discount, clientId);
    }

}
