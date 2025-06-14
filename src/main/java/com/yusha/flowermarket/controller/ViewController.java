package com.yusha.flowermarket.controller;

import com.yusha.flowermarket.dto.BouquetFlowerView;
import com.yusha.flowermarket.dto.Receipt;
import com.yusha.flowermarket.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ViewController {

    private final ViewService service;

    @GetMapping("/view/bouquetflower")
    public List<BouquetFlowerView> getBouquetFlower() {
        return service.getBouquetFlower();
    }

    @PostMapping("/view/bouquetflower")
    public void addBouquetFlower(@RequestParam("bouquet_name") String Bouquet,
                                 @RequestParam("flower_name") String Flower,
                                 @RequestParam("quantity") int Quantity,
                                 @RequestParam("bouquet_price") double BouquetPrice,
                                 @RequestParam("flower_price") double  FlowerPrice) {
        service.addBouquetFlower(Bouquet, Flower, Quantity, BouquetPrice, FlowerPrice);
    }

    @GetMapping("/view/receipt")
    public List<Receipt> getReceipt() {
        return service.getReceipts();
    }

    @PostMapping("/view/receipt")
    public void addReceipt(@RequestParam("order_id") int Order_id,
                           @RequestParam("cashier_id") int Cashier_id,
                           @RequestParam("issue_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate Issue_date) {
        service.addReceipt(Order_id, Cashier_id, Issue_date);
    }
}
