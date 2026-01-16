package com.mini.bank.clients.transfer;

import com.mini.bank.errors.NotifyException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class NotifyErrorDecoder implements ErrorDecoder {

   @Override
   public Exception decode(String methodKey, Response response) {
      return new NotifyException("Erro ao notificar a transferência.");
   }

}
