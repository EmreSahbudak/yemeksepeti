package com.bilgeadam.entity;

import com.bilgeadam.entity.enums.Estatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String surname;
    private String email;
    private String customerAddress;
    private String phone;
    private String password;
    private String cardDetails;
    private String balance;
    private String activationCode;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Estatus estatus=Estatus.PENDING;

    @ElementCollection
    private List<Integer> ordersId;
}
