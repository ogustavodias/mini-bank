package com.mini.bank.models.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class UserPF extends User {

   @Column(nullable = false)
   String cpf;

   @Override
   public boolean canTransfer() {
      return true;
   }
}