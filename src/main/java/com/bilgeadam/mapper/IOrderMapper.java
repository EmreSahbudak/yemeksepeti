package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.OrderSaveRequestDto;
import com.bilgeadam.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IOrderMapper {

    IOrderMapper INSTANCE= Mappers.getMapper(IOrderMapper.class);

    Order toOrder(final OrderSaveRequestDto dto);
}

