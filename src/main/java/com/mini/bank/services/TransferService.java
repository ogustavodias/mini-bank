package com.mini.bank.services;

import org.springframework.stereotype.Service;

import com.mini.bank.clients.transfer.AuthorizeClient;
import com.mini.bank.clients.transfer.NotifyClient;
import com.mini.bank.errors.TransferNotPermittedException;
import com.mini.bank.models.transfer.Transfer;
import com.mini.bank.models.transfer.TransferRequestDto;
import com.mini.bank.models.user.User;
import com.mini.bank.repositories.TransferRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {

   private final TransferRepository transferRepository;
   private final UserService userService;
   private final AuthorizeClient authorizeClient;
   private final NotifyClient notifyClient;

   @Transactional
   public Transfer registerTransfer(TransferRequestDto dto) {
      boolean isSameUser = dto.payerId() == dto.receiverId();

      if (isSameUser)
         throw new TransferNotPermittedException("Não é permitido transferir para si mesmo.");

      User payer = userService.searchUser(dto.payerId());
      User receiver = userService.searchUser(dto.receiverId());

      Transfer transfer = Transfer.builder()
            .payer(payer)
            .receiver(receiver)
            .amount(dto.amount())
            .build();

      authorizeClient.authorizeTransfer();
      userService.processUserTransfer(transfer);

      try {
         notifyClient.notifyTransfer();
      } catch (Exception e) {
         log.warn("Notificação não enviada.");
      }

      return transferRepository.save(transfer);
   }

}
