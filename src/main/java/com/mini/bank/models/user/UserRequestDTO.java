package com.mini.bank.models.user;

import java.math.BigDecimal;

public record UserRequestDTO(String name, String email, String password, String document, UserType userType) {

   public User toEntity() {
      User user = null;

/*       if (this.userType == UserType.PF) {
         user = new UserPF(document);
         user.setBalance(BigDecimal.valueOf(500.0));
      }

      if (this.userType == UserType.PJ) {
         user = new UserPJ(document);
         user.setBalance(BigDecimal.ZERO);
      } */

      user = new UserPF(document);
      user.setBalance(BigDecimal.valueOf(500.0));   
      user.setName(this.name);
      user.setEmail(this.email);
      user.setPassword(this.password);

      return user;
   }

}
