package com.mini.bank.clients.transfer;

import com.mini.bank.errors.TransferNotPermittedException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class AuthorizeErrorDecoder implements ErrorDecoder {

   @Override
   public Exception decode(String methodKey, Response response) {
      return new TransferNotPermittedException("Transferência não autorizada pela instituição.");
   }

}
