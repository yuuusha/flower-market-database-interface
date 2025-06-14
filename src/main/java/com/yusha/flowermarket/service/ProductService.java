package com.yusha.flowermarket.service;

import com.yusha.flowermarket.dto.Bouquet;
import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.dto.Product;
import com.yusha.flowermarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Transactional
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Product findById(int Product_id) {
        return repository.findById(Product_id);
    }

    @Transactional
    public List<Product> findFlowers() {
        return repository.findFlowers();
    }

    @Transactional
    public List<Product> findBouquets() {
        return repository.findBouquets();
    }

    @Transactional
    public List<Product> findAdditionals() {
        return repository.findAdditionals();
    }

    @Transactional
    public void add(int Type_id, String Name, double Price) {
        repository.add(Type_id, Name, Price);
    }

    @Transactional
    public void delete(int Product_id) {
        repository.delete(Product_id);
    }

    @Transactional
    public void returnFromDelete(int Product_id) {
        repository.returnFromDelete(Product_id);
    }

    @Transactional
    public void update(String Name, double Price, int Product_id) {
        repository.update(Name, Price, Product_id);
    }

    @Transactional
    public List<Bouquet> getFlowersForBouquet(int Bouquet_id) {
        return repository.getFlowersForBouquet(Bouquet_id);
    }

    @Transactional
    public List<Bouquet> getBouquetsForFlower(int Flower_id) {
        return repository.getBouquetsForFlower(Flower_id);
    }
}
