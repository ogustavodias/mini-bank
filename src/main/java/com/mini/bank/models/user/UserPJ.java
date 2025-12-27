package com.mini.bank.models.user;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_users_pj")
@AllArgsConstructor
@NoArgsConstructor
public class UserPJ extends User {

   @Column(nullable = false)
   String cnpj;

   @Override
   public boolean canTransfer(BigDecimal amount) {
      return false;
   }
}
