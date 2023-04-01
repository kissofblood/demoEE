package com.example.backend.model.dto;

import lombok.Data;

@Data
public class BranchDto {

    private Long id;
    private String name;
    private AddressDto address;
}
