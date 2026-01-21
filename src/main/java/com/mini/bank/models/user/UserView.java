package com.mini.bank.models.user;

import java.math.BigDecimal;

public interface UserView {
   String getName();

   String getEmail();

   BigDecimal getBalance();
}