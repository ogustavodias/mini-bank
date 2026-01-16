package com.mini.bank.errors;

public class TransferNotPermittedException extends RuntimeException {
   public TransferNotPermittedException(String message) {
      super(message);
   }
}
