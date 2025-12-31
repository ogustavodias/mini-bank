package com.mini.bank.models.user;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserPfRequestDto extends UserRequestDto {
      @NotEmpty
      String name;

      @NotEmpty
      String email;

      @NotEmpty
      String password;

      @NotEmpty
      @CPF
      String cpf;

      @Override
      public User toEntity() {
            UserPf user = new UserPf(this.cpf);

            user.setEmail(this.email);
            user.setName(this.name);
            user.setPassword(this.password);

            return user;
      }
}