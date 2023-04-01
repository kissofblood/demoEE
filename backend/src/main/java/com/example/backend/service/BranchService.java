package com.example.backend.service;

import com.example.backend.mapper.CommonMapper;
import com.example.backend.model.dto.BranchDto;
import com.example.backend.model.entity.BranchEntity;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class BranchService {

    @PersistenceContext(name = "default")
    private EntityManager entityManager;

    @Transactional
    public List<BranchDto> findAll() {
        return CommonMapper.INSTANCE.mapBranch(
            entityManager.createQuery("FROM BranchEntity", BranchEntity.class)
                .getResultList()
        );
    }

    @Transactional
    public List<BranchDto> findByCompanyId(Long companyId) {
        return CommonMapper.INSTANCE.mapBranch(
            entityManager.createQuery("FROM BranchEntity WHERE company.id=:companyId", BranchEntity.class)
                .setParameter("companyId", companyId)
                .getResultList()
        );

    }
}
