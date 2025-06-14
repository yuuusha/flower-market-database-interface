package com.yusha.flowermarket.service;

import com.yusha.flowermarket.dto.BouquetFlowerView;
import com.yusha.flowermarket.dto.Receipt;
import com.yusha.flowermarket.repository.ViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewService {

    private final ViewRepository repository;

    @Transactional
    public List<BouquetFlowerView> getBouquetFlower() {
        return repository.getBouquetFlower();
    }

    @Transactional
    public void addBouquetFlower(String Bouquet, String Flower, int Quantity, double BouquetPrice, double FlowerPrice) {
        repository.addBouquetFlower(Bouquet, Flower, Quantity, BouquetPrice, FlowerPrice);
    }

    @Transactional
    public List<Receipt> getReceipts() {
        return repository.getReceipts();
    }

    @Transactional
    public void addReceipt(int Order_id, int Cashier_id, LocalDate Issue_date) {
        repository.addReceipt(Order_id, Cashier_id, Issue_date);
    }
}
