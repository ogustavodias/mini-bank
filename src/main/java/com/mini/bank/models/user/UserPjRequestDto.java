package com.mini.bank.models.user;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserPjRequestDto extends UserRequestDto {
      @NotEmpty
      String name;

      @NotEmpty
      String email;

      @NotEmpty
      String password;

      @NotEmpty
      @CNPJ
      String cnpj;

      @Override
      public User toEntity() {
            UserPj user = new UserPj(this.cnpj);

            user.setEmail(this.email);
            user.setName(this.name);
            user.setPassword(this.password);

            return user;
      }
}
