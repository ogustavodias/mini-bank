package com.mini.bank.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mini.bank.models.user.UserRequestDTO;
import com.mini.bank.services.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

   private final UserService service;

   @PostMapping
   public ResponseEntity<Void> registerUser(@RequestBody UserRequestDTO dto) {
      log.warn("Body recebido: {}", dto);

      UUID id = service.registerUser(dto).getId();

      URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri();

      return ResponseEntity.created(location).build();
   }

}
