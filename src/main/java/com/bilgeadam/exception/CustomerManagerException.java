package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class CustomerManagerException extends RuntimeException {

    private final ErrorType errorType;

    //çift parametreli metodumuz
    public CustomerManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }
    //tek parametreli hata metodumuz
    public CustomerManagerException(ErrorType errorType){
        this.errorType = errorType;
    }
}
