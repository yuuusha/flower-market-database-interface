package com.yusha.flowermarket.dto;

import java.time.LocalDate;

public record Order(Integer Order_id, Integer Client_id, LocalDate Order_date, Boolean Order_status, Boolean is_deleted) {
}
