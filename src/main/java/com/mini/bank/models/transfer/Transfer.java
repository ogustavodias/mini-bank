package com.mini.bank.models.transfer;

import java.math.BigDecimal;
import java.util.UUID;

import com.mini.bank.models.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transfers")
public class Transfer {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @ManyToOne
   @JoinColumn(name = "payer_id")
   private User payer;

   @ManyToOne
   @JoinColumn(name = "receiver_id")
   private User receiver;

   @Column(nullable = false)
   private BigDecimal amount;
}
