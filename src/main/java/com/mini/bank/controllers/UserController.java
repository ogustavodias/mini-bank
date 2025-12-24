package com.mini.bank.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class UserController {

   @PostMapping
   public ResponseEntity<Void> registerUser() {
      int mockId = 0;

      URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(mockId)
            .toUri();

      return ResponseEntity.created(location).build();
   }

}
