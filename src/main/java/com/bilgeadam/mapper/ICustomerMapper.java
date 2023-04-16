package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.CustomerRegisterRequestDto;
import com.bilgeadam.dto.request.CustomerUpdateRequestDto;
import com.bilgeadam.dto.response.CustomerRegisterResponseDto;
import com.bilgeadam.entity.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICustomerMapper {

    ICustomerMapper INSTANCE= Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(final CustomerRegisterRequestDto dto);

    CustomerRegisterResponseDto toCustomerRegisterResponseDto(final Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void customerUpdateFromDto
            (CustomerUpdateRequestDto dto, @MappingTarget Customer customer);

}
