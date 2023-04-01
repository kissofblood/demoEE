package com.example.frontend.model;

import lombok.Data;

@Data
public class Company {

    private Long id;
    private String name;
    private String legalForm;
    private String address;
}
