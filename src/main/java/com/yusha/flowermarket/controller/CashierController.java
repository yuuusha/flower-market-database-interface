package com.yusha.flowermarket.controller;

import com.yusha.flowermarket.dto.Cashier;
import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.service.CashierService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CashierController {

    private final CashierService service;

    @GetMapping("/cashier")
    public List<Cashier> findAll() {
        return service.findAll();
    }

    @GetMapping("/cashier/{cashier_id}")
    public Cashier findById(@PathVariable("cashier_id") int cashierId) {
        return service.findById(cashierId);
    }

    @PostMapping("/cashier")
    public void add(@RequestParam("last_name") String Last_name,
                    @RequestParam("first_name") String First_name,
                    @RequestParam("middle_name") String Middle_name,
                    @RequestParam("date_of_birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate Date_of_birth,
                    @RequestParam("phone_number") String Phone_number,
                    @RequestParam("experience") int Experience) {
        service.add(Last_name, First_name, Middle_name,
                Date_of_birth, Phone_number, Experience);
    }

    @DeleteMapping("/cashier")
    public void delete(@RequestParam("cashier_id") int Cashier_id) {
        service.delete(Cashier_id);
    }

    @PatchMapping("/cashier")
    public void returnFromDelete(@RequestParam("cashier_id") int cashierId) {
        service.returnFromDelete(cashierId);
    }

    @PutMapping("/cashier")
    public void update(@RequestParam("last_name") String Last_name,
                       @RequestParam("first_name") String First_name,
                       @RequestParam("middle_name") String Middle_name,
                       @RequestParam("date_of_birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate Date_of_birth,
                       @RequestParam("phone_number") String Phone_number,
                       @RequestParam("experience") int Experience,
                       @RequestParam("cashier_id") int Cashier_id) {
        service.update(Last_name, First_name, Middle_name,
                Date_of_birth, Phone_number, Experience, Cashier_id);
    }

}
