package com.mini.bank.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mini.bank.models.user.User;
import com.mini.bank.models.user.UserRequestDTO;
import com.mini.bank.models.user.UserType;
import com.mini.bank.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository repository;

   public User registerUser(UserRequestDTO dto) {
      User user = null;

      if (dto.userType() == UserType.PF) {
         user = dto.toUserPF();
         user.setBalance(BigDecimal.valueOf(500));
      }

      if (dto.userType() == UserType.PJ) {
         user = dto.toUserPJ();
         user.setBalance(BigDecimal.ZERO);
      }

      return repository.save(user);
   }

}
