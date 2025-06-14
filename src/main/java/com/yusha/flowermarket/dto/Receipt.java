package com.yusha.flowermarket.dto;

import java.time.LocalDate;

public record Receipt(Integer Order_id, Integer Cashier_id, String Cashier, String Client, LocalDate Order_date, LocalDate Issue_date, String Product, Double Price, Integer Quantity, Double Amount) {
}
