package com.mini.bank.models.user;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_users_pf")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPf extends User {

   @Column(nullable = false)
   private String cpf;

   @Override
   public boolean canTransfer(BigDecimal amount) {
      if (amount == null || this.getBalance() == null) {
         return false;
      }

      boolean isValidAmount = amount.compareTo(BigDecimal.ZERO) > 0;
      boolean sufficientBalance = this.getBalance().compareTo(amount) >= 0;

      return isValidAmount && sufficientBalance;
   }

   @Override
   public BigDecimal initialBalance() {
      return BigDecimal.valueOf(500.0);
   }

}