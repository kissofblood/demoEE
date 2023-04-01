package com.example.backend.model.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String index;
    private String city;
    private String street;
    private String house;
    private String apartment;
}
