package com.example.frontend.mapper;

import com.example.backend.model.dto.AddressDto;
import com.example.backend.model.dto.BranchDto;
import com.example.backend.model.dto.CompanyDto;
import com.example.frontend.model.Branch;
import com.example.frontend.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    Company map(CompanyDto company);
    Branch map(BranchDto branch);

    default String concatAddress(AddressDto address) {
        if (address == null) {
            return "";
        }
        return String.format("%s %s, %s, %s (%s)",
            address.getIndex(),
            address.getCity(),
            address.getStreet(),
            address.getHouse(),
            address.getApartment()
        );
    }
}
