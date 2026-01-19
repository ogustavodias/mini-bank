package com.mini.bank.clients.transfer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "notifyClient", url = "https://util.devi.tools/api/v1", configuration = NotifyConfig.class)
public interface NotifyClient {

   @PostMapping("/notify")
   @Retry(name = "notifyClient")
   Object notifyTransfer();

}
