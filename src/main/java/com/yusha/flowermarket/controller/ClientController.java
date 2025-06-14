package com.yusha.flowermarket.controller;

import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ClientController {

    private final ClientService service;

    @GetMapping("/client")
    public List<Client> findAll() {
        return service.findAll();
    }

    @GetMapping("/client/{client_id}")
    public Client findById(@PathVariable("client_id") int clientId) {
        return service.findById(clientId);
    }

    @PostMapping("/client")
    public void add(@RequestParam("last_name") String lastName,
                    @RequestParam("first_name") String firstName,
                    @RequestParam("middle_name") String middleName,
                    @RequestParam("date_of_birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                    @RequestParam("client_address") String clientAddress,
                    @RequestParam("phone_number") String phoneNumber,
                    @RequestParam("email") String email,
                    @RequestParam("discount") double discount) {
        service.add(lastName, firstName, middleName,
                dateOfBirth, clientAddress, phoneNumber,
                email, discount);
    }

    @DeleteMapping("/client")
    public void delete(@RequestParam("client_id") int clientId) {
        service.delete(clientId);
    }

    @PatchMapping("/client")
    public void returnFromDelete(@RequestParam("client_id") int clientId) {
        service.returnFromDelete(clientId);
    }

    @PutMapping("/client")
    public void update(@RequestParam("last_name") String lastName,
                       @RequestParam("first_name") String firstName,
                       @RequestParam("middle_name") String middleName,
                       @RequestParam("date_of_birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                       @RequestParam("client_address") String clientAddress,
                       @RequestParam("phone_number") String phoneNumber,
                       @RequestParam("email") String email,
                       @RequestParam("discount") double discount,
                       @RequestParam("client_id") int clientId) {
        service.update(lastName, firstName, middleName,
                dateOfBirth, clientAddress, phoneNumber,
                email, discount, clientId);
    }
}
