package com.mini.bank.services;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mini.bank.errors.ResourceNotFoundException;
import com.mini.bank.errors.TransferNotPermittedException;
import com.mini.bank.models.transfer.Transfer;
import com.mini.bank.models.user.User;
import com.mini.bank.models.user.UserPf;
import com.mini.bank.models.user.UserRequestDto;
import com.mini.bank.repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository repository;

   public User searchUser(UUID id) {
      return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
   }

   @Transactional
   public User registerUser(UserRequestDto dto) {
      User user = dto.toEntity();
      BigDecimal balance = BigDecimal.ZERO;

      if (user instanceof UserPf) {
         balance = BigDecimal.valueOf(500);
      }

      user.setBalance(balance);

      return repository.save(user);
   }

   @Transactional
   public void processUserTransfer(Transfer transfer) {
      User payer = transfer.getPayer();
      User receiver = transfer.getReceiver();
      BigDecimal amount = transfer.getAmount();

      boolean canTransfer = payer.canTransfer(amount);
      if (canTransfer) {
         BigDecimal payerRemainingBalance = payer.getBalance().subtract(amount);
         BigDecimal receiverCurrentBalance = receiver.getBalance().add(amount);

         payer.setBalance(payerRemainingBalance);
         receiver.setBalance(receiverCurrentBalance);

         repository.save(payer);
         repository.save(receiver);
         return;
      }

      throw new TransferNotPermittedException(
            "Transferência não concluída, verifique se há saldo ou se a fonte trata-se de uma pessoa física.");
   }

}
