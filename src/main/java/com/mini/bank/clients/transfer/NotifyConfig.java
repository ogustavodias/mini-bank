package com.mini.bank.clients.transfer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifyConfig {

   @Bean
   NotifyErrorDecoder notifyErrorDecoder() {
      return new NotifyErrorDecoder();
   }

}
