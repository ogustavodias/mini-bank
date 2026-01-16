package com.mini.bank.clients.transfer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizeConfig {

   @Bean
   AuthorizeErrorDecoder authorizeErrorDecoder() {
      return new AuthorizeErrorDecoder();
   }

}
