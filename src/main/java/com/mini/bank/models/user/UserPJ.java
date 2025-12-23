package com.mini.bank.models.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class UserPJ extends User {

   @Column(nullable = false)
   String cnpj;

   @Override
   public boolean canTransfer() {
      return false;
   }
}
