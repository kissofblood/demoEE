package com.example.backend.model.dto;

import lombok.Data;

@Data
public class CompanyDto {

    private Long id;
    private String name;
    private String legalForm;
    private AddressDto address;
}
