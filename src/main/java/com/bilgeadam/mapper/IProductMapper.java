package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IProductMapper {

    IProductMapper INSTANCE= Mappers.getMapper(IProductMapper.class);

    Product toProduct(final ProductSaveRequestDto dto);
}
