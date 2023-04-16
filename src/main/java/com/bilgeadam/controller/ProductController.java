package com.bilgeadam.controller;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.Product;
import com.bilgeadam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constants.EndpointList.*;
@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody @Valid ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }
}
