package com.yusha.flowermarket.dto;

import java.time.LocalDate;

public record Client(Integer Client_id, String Last_name, String First_name, String Middle_name,
                     LocalDate Date_of_birth, String Client_address, String Phone_number,
                     String Email, Double Discount, Boolean is_deleted) {}
