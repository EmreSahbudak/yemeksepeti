package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IRestaurantMapper {

    IRestaurantMapper INSTANCE= Mappers.getMapper(IRestaurantMapper.class);

    Restaurant toRestaurant(final RestaurantSaveRequestDto dto);
}
