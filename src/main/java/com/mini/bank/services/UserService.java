package com.mini.bank.services;

import org.springframework.stereotype.Service;

import com.mini.bank.models.user.User;
import com.mini.bank.models.user.UserRequestDTO;
import com.mini.bank.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository repository;

   public User registerUser(UserRequestDTO dto) {
      return repository.save(dto.toEntity());
   }

}
