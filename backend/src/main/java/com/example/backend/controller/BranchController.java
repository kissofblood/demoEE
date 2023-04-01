package com.example.backend.controller;

import com.example.backend.model.dto.BranchDto;
import com.example.backend.service.BranchService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class BranchController {

    @EJB private BranchService branchService;

    public List<BranchDto> findAll() {
        return branchService.findAll();
    }

    public List<BranchDto> findByCompanyId(Long companyId) {
        return branchService.findByCompanyId(companyId);
    }
}
