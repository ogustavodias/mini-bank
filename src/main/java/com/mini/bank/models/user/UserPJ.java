package com.mini.bank.models.user;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users_pj")
public class UserPJ extends User {

   @Column(nullable = false)
   String cnpj;

   @Override
   public boolean canTransfer(BigDecimal amount) {
      return false;
   }
}
