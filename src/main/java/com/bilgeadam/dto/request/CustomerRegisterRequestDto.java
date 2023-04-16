package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequestDto {
    @NotBlank(message = "Email boş geçilemez")
    @Email(message = "Email formatına uymanız gerekmektedir.")
    private String email;

    @NotBlank(message = "Password boş geçilemez")
    @Column(length = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre en az bir büyük, bir küçük, harff,rakam ve özel karakterlerden oluşmalı")
    private String password;

    private String repassword;
}
