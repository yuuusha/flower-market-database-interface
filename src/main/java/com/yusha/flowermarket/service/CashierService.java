package com.yusha.flowermarket.service;

import com.yusha.flowermarket.dto.Cashier;
import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.repository.CashierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CashierService {

    private final CashierRepository repository;

    @Transactional
    public List<Cashier> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Cashier findById(int Cashier_id) {
        return repository.findById(Cashier_id);
    }

    @Transactional
    public void add(String Last_name, String First_name, String Middle_name,
                    LocalDate Date_of_birth, String Phone_number, int Experience) {
        repository.add(Last_name, First_name, Middle_name,
                Date_of_birth, Phone_number, Experience);
    }

    @Transactional
    public void delete(int Cashier_id) {
        repository.delete(Cashier_id);
    }

    @Transactional
    public void returnFromDelete(int Cashier_id) {
        repository.returnFromDelete(Cashier_id);
    }

    @Transactional
    public void update(String Last_name, String First_name, String Middle_name,
                       LocalDate Date_of_birth, String Phone_number, int Experience, int Cashier_id) {
        repository.update(Last_name, First_name, Middle_name,
                Date_of_birth, Phone_number, Experience, Cashier_id);
    }
}
