package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantSaveRequestDto {
    @NotBlank
    private String restaurantName;
    @NotBlank
    private String point;
    @NotBlank
    private String restaurantAddress;
}
