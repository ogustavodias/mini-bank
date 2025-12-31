package com.mini.bank.models.user;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class User {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false)
   private String email;

   @Column(nullable = false)
   private String password;

   @Column(nullable = false)
   private BigDecimal balance;

   public abstract boolean canTransfer(BigDecimal amount);

   public abstract BigDecimal initialBalance();
}
