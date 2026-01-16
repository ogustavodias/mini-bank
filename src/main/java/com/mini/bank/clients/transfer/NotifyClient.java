package com.mini.bank.clients.transfer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notifyClient", url = "https://util.devi.tools/api/v1", configuration = NotifyConfig.class)
public interface NotifyClient {

   @PostMapping("/notify")
   Object notifyTransfer();

}
