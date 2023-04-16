package com.bilgeadam.entity;

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
@Table(name = "tblorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    //bir siparişin birden fazla ürünü olabilir, bir ürünün bir sipariş nosu olur.
    //lahmacun --> productId=1      orderId=1
    //Ayran ---> productId=5        orderId=1
    //salata ----> productId=10     orderId=1
    @ElementCollection
    private List<Integer> productsId;

    //---> bir sipariştin bir müşterisi vardır, bir müşterinini birden fazla sipariş numarası olabilir
    // ahmet Uslu ---> customerId=1   orderId=1
    private Integer customerId;

    //---> bir siparişin bir rest vardır, bir rest birden fazla sipariş numarası olabilr.
    // İsot Lahmacunevi ---> restaurantId=1 orderId=1
    private Integer restaurantId;
}
