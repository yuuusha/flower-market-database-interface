package com.yusha.flowermarket.dto;

import java.time.LocalDate;

public record Cashier(Integer Cashier_id, String Last_name, String First_name, String Middle_name,
                      LocalDate Date_of_birth, String Phone_number, Integer Experience, Boolean is_deleted) {
}
