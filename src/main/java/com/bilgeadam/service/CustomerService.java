package com.bilgeadam.service;

import com.bilgeadam.dto.request.CustomerActiveRequestDto;
import com.bilgeadam.dto.request.CustomerRegisterRequestDto;
import com.bilgeadam.dto.request.CustomerLoginRequestDto;
import com.bilgeadam.dto.request.CustomerUpdateRequestDto;
import com.bilgeadam.dto.response.CustomerRegisterResponseDto;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.enums.Estatus;
import com.bilgeadam.exception.CustomerManagerException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.ICustomerMapper;
import com.bilgeadam.repository.ICustomerRepository;
import com.bilgeadam.utility.CodeGeneretor;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public CustomerRegisterResponseDto register(CustomerRegisterRequestDto dto) {
        Customer customer= ICustomerMapper.INSTANCE.toCustomer(dto);
        if (dto.getPassword().equals(dto.getRepassword())){
            customer.setActivationCode(CodeGeneretor.generateCode());
            save(customer);
        }else{
            throw new CustomerManagerException(ErrorType.PASSWORD_ERROR);
        }
        CustomerRegisterResponseDto responseDto=ICustomerMapper.INSTANCE.toCustomerRegisterResponseDto(customer);
        return responseDto;
    }
    public Boolean activeStatus(CustomerActiveRequestDto dto){
        Optional<Customer> customer=findById(dto.getCustomerId());
        if (customer.isEmpty()){
            throw new CustomerManagerException(ErrorType.USER_NOT_FOUND);
        } else if (customer.get().getActivationCode().equals(dto.getActivateCode())) {
            customer.get().setEstatus(Estatus.ACTIVE);
            update(customer.get());
            return true;
        }
        throw new CustomerManagerException(ErrorType.ACTIVATE_CODE_ERROR);
    }

    public Boolean login(CustomerLoginRequestDto dto){
        Optional<Customer> customer=customerRepository.findByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (customer.isEmpty()){
            throw new CustomerManagerException(ErrorType.LOGIN_ERROR);
        } else if (!customer.get().getEstatus().equals(Estatus.ACTIVE)) {
            throw new CustomerManagerException(ErrorType.ACTIVATE_CODE_ERROR);
        }
        return true;
    }
    public String update(CustomerUpdateRequestDto dto){
        Optional<Customer> customer=customerRepository.findById(dto.getId());
        ICustomerMapper.INSTANCE.customerUpdateFromDto(dto,customer.get());
        customerRepository.save(customer.get());
        return "Update Success";
    }


















}
