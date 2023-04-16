package com.bilgeadam.controller;

import com.bilgeadam.dto.request.OrderSaveRequestDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.Order;
import com.bilgeadam.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constants.EndpointList.*;
@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody @Valid OrderSaveRequestDto dto){
        return ResponseEntity.ok(orderService.save(dto));
    }
}
