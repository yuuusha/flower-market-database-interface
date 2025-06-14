package com.yusha.flowermarket.dto;

public record Product(Integer Product_id, Integer Type_id, String Name, Double Price, Boolean is_deleted) {
}
