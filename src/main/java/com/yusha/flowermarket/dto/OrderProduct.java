package com.yusha.flowermarket.dto;

import java.time.LocalDate;

public record OrderProduct(LocalDate Order_date, Boolean Order_status, String Name, Integer Quantity, Double Price) {
}
