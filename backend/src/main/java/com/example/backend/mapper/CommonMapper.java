package com.example.backend.mapper;

import com.example.backend.model.dto.AddressDto;
import com.example.backend.model.dto.BranchDto;
import com.example.backend.model.dto.CompanyDto;
import com.example.backend.model.entity.AddressEntity;
import com.example.backend.model.entity.BranchEntity;
import com.example.backend.model.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommonMapper {

    CommonMapper INSTANCE = Mappers.getMapper(CommonMapper.class);

    AddressDto mapAddress(AddressEntity address);
    List<AddressDto> mapAddress(List<AddressEntity> address);

    BranchDto mapBranch(BranchEntity branch);
    List<BranchDto> mapBranch(List<BranchEntity> branches);

    CompanyDto mapCompany(CompanyEntity company);
    List<CompanyDto> mapCompany(List<CompanyEntity> companies);

    default String mapLegalFormType(CompanyEntity.LegalFormType legalFormType) {
        if (legalFormType == null) {
            return null;
        }
        switch (legalFormType) {
        case AO: return "AO";
        case IP: return "ИП";
        case OOO: return "ООО";
        }
        return null;
    }
}
