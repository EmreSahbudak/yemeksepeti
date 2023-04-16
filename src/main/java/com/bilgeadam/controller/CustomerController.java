package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CustomerActiveRequestDto;
import com.bilgeadam.dto.request.CustomerLoginRequestDto;
import com.bilgeadam.dto.request.CustomerRegisterRequestDto;
import com.bilgeadam.dto.request.CustomerUpdateRequestDto;
import com.bilgeadam.dto.response.CustomerRegisterResponseDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constants.EndpointList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping(REGISTER)
    public ResponseEntity<CustomerRegisterResponseDto> register
            (@RequestBody @Valid CustomerRegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody CustomerActiveRequestDto dto){
        return ResponseEntity.ok(customerService.activeStatus(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody CustomerLoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }
    @PostMapping(UPDATE)
    public ResponseEntity<String> update(@RequestBody CustomerUpdateRequestDto dto){
        return ResponseEntity.ok(customerService.update(dto));
    }























}
