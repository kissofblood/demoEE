package com.example.backend.controller;

import com.example.backend.model.dto.CompanyDto;
import com.example.backend.model.entity.AddressEntity;
import com.example.backend.model.entity.BranchEntity;
import com.example.backend.model.entity.CompanyEntity;
import com.example.backend.service.CompanyService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class CompanyController {

    @EJB private CompanyService companyService;

    public List<CompanyDto> findAll() {
        return companyService.findAll();
    }

    public void generateData() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int countCompany = random.nextInt(1, 10);
        int countBranch = random.nextInt(1, 5);
        for (int i = 0; i < countCompany; i++) {
            CompanyEntity company = new CompanyEntity();
            List<BranchEntity> branches = new ArrayList<>();
            for (int j = 0; j < countBranch; j++) {
                BranchEntity branch = new BranchEntity();
                branch.setName("name_" + random.nextInt());
                branch.setAddress(generateAddress());
                branch.setCompany(company);
                branches.add(branch);
            }
            company.setBranches(branches);
            company.setAddress(generateAddress());
            company.setName("name_" + random.nextInt());
            CompanyEntity.LegalFormType[] legalFormTypes = CompanyEntity.LegalFormType.values();
            company.setLegalForm(legalFormTypes[random.nextInt(0, legalFormTypes.length)]);
            companyService.save(company);
        }
    }

    private AddressEntity generateAddress() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (random.nextBoolean()) {
            AddressEntity address = new AddressEntity();
            address.setApartment("apartment_" + random.nextInt());
            address.setCity("city_" + random.nextInt());
            address.setIndex("index_" + random.nextInt());
            address.setHouse("house_" + random.nextInt());
            address.setStreet("street_" + random.nextInt());
            return address;
        }
        return null;
    }
}
