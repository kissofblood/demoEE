package com.example.backend.service;

import com.example.backend.mapper.CommonMapper;
import com.example.backend.model.dto.AddressDto;
import com.example.backend.model.entity.AddressEntity;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class AddressService {

    @PersistenceContext(name = "default")
    private EntityManager entityManager;

    @Transactional
    public List<AddressDto> findAll() {
        return CommonMapper.INSTANCE.mapAddress(entityManager.createQuery("FROM AddressEntity", AddressEntity.class)
            .getResultList()
        );
    }
}
