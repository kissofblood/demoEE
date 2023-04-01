package com.example.frontend.service;

import com.example.backend.controller.BranchController;
import com.example.backend.controller.CompanyController;
import com.example.frontend.mapper.ModelMapper;
import com.example.frontend.model.Branch;
import com.example.frontend.model.Company;
import org.zkoss.zul.ListModelList;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class IndexService {

    @EJB private CompanyController companyController;
    @EJB private BranchController branchController;

    public ListModelList<Company> findCompanyAll() {
        ListModelList<Company> listModel = new ListModelList<>();
        companyController.findAll().stream()
            .map(ModelMapper.INSTANCE::map)
            .forEach(listModel::add);
        return listModel;
    }

    public void generateCompanyData() {
        companyController.generateData();
    }

    public ListModelList<Branch> findBranchByCompanyId(long id) {
        ListModelList<Branch> listModel = new ListModelList<>();
        branchController.findByCompanyId(id).stream()
            .map(ModelMapper.INSTANCE::map)
            .forEach(listModel::add);
        return listModel;
    }
}
