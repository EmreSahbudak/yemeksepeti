package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateRequestDto {
    private Long id;
    private String customerName;
    private String surname;
    private String customerAddress;
    private String phone;
    private String cardDetails;
    private String balance;
}
