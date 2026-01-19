package com.mini.bank.clients.transfer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "authorizeClient", url = "https://util.devi.tools/api/v2", configuration = AuthorizeConfig.class)
public interface AuthorizeClient {

   @GetMapping("/authorize")
   @Retry(name = "authorizeClient")
   Object authorizeTransfer();
}
