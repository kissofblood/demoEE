package com.example.backend.service;

import com.example.backend.mapper.CommonMapper;
import com.example.backend.model.dto.CompanyDto;
import com.example.backend.model.entity.CompanyEntity;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class CompanyService {

    @PersistenceContext(name = "default")
    private EntityManager entityManager;

    @Transactional
    public List<CompanyDto> findAll() {
        return CommonMapper.INSTANCE.mapCompany(entityManager.createQuery("FROM CompanyEntity", CompanyEntity.class)
            .getResultList()
        );
    }

    @Transactional
    public void save(CompanyEntity company) {
        entityManager.persist(company);
    }
}
