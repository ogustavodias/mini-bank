package com.mini.bank.clients.transfer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authorizeClient", url = "https://util.devi.tools/api/v2", configuration = AuthorizeConfig.class)
public interface AuthorizeClient {

   @GetMapping("/authorize")
   Object authorizeTransfer();
}
