package com.example.backend.controller;

import com.example.backend.model.dto.AddressDto;
import com.example.backend.service.AddressService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class AddressController {

    @EJB private AddressService addressService;

    public List<AddressDto> findAll() {
        return addressService.findAll();
    }
}
