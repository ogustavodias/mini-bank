package com.mini.bank.models.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
            @NotEmpty String name,
            @NotEmpty String email,
            @NotEmpty String password,
            @NotEmpty String document,
            @NotNull UserType userType) {

      public UserPF toUserPF() {
            UserPF user = new UserPF(this.document);

            user.setEmail(this.email);
            user.setName(this.name);
            user.setPassword(this.password);

            return user;
      }

      public UserPJ toUserPJ() {
            UserPJ user = new UserPJ(this.document);

            user.setEmail(this.email);
            user.setName(this.name);
            user.setPassword(this.password);

            return user;
      }

}
