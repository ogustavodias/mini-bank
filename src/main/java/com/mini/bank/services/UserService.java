package com.mini.bank.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mini.bank.models.user.User;
import com.mini.bank.models.user.UserPf;
import com.mini.bank.models.user.UserRequestDto;
import com.mini.bank.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository repository;

   public User registerUser(UserRequestDto dto) {
      User user = dto.toEntity();
      BigDecimal balance = BigDecimal.ZERO;

      if (user instanceof UserPf) {
         balance = BigDecimal.valueOf(500);
      }

      user.setBalance(balance);

      return repository.save(user);
   }

}
