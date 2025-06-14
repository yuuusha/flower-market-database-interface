package com.yusha.flowermarket.controller;

import com.yusha.flowermarket.dto.Bouquet;
import com.yusha.flowermarket.dto.Client;
import com.yusha.flowermarket.dto.Product;
import com.yusha.flowermarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ProductController {

    private final ProductService service;

    @GetMapping("/product")
    public List<Product> findAll() {
        return service.findAll();
    }

    @GetMapping("/product/{product_id}")
    public Product findById(@PathVariable("product_id") int productId) {
        return service.findById(productId);
    }

    @GetMapping("/product/flowers")
    public List<Product> findFlowers() {
        return service.findFlowers();
    }

    @GetMapping("/product/bouquets")
    public List<Product> findBouquets() {
        return service.findBouquets();
    }

    @GetMapping("/product/additionals")
    public List<Product> findAdditionals() {
        return service.findAdditionals();
    }

    @PostMapping("/product")
    public void add(@RequestParam("type_id") int Type_id,
                    @RequestParam("name") String Name,
                    @RequestParam("price") double Price) {
        service.add(Type_id, Name, Price);
    }

    @DeleteMapping("/product")
    public void delete(@RequestParam("product_id") int Product_id) {
        service.delete(Product_id);
    }

    @PatchMapping("/product")
    public void returnFromDelete(@RequestParam("product_id") int productId) {
        service.returnFromDelete(productId);
    }

    @PutMapping("/product")
    public void update(@RequestParam("name") String Name,
                    @RequestParam("price") double Price,
                    @RequestParam("product_id") int Product_id) {
        service.update(Name, Price, Product_id);
    }

    @GetMapping("/product/flowers/bouquets")
    public List<Bouquet> getBouquetsForFlower(@RequestParam("flower_id") int Flower_id) {
        return service.getBouquetsForFlower(Flower_id);
    }

    @GetMapping("/product/bouquets/flowers")
    public List<Bouquet> getFlowersForBouquet(@RequestParam("bouquet_id") int Bouquet_id) {
        return service.getFlowersForBouquet(Bouquet_id);
    }

}
