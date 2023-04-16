package com.bilgeadam.controller;

import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.Restaurant;
import com.bilgeadam.entity.jointable.JoinRestaurantOrderProduct;
import com.bilgeadam.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constants.EndpointList.*;
@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }
    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody @Valid RestaurantSaveRequestDto dto){
        return ResponseEntity.ok(restaurantService.save(dto));
    }
    @GetMapping(FIND_RESTAURANT_ORDER_PRODUCT)
    public ResponseEntity<List<JoinRestaurantOrderProduct>> restaurantOrderProducts(){
        return ResponseEntity.ok(restaurantService.restaurantOrderProducts());
    }
}
