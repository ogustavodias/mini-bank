package com.mini.bank.services;

import org.springframework.stereotype.Service;

import com.mini.bank.models.transfer.Transfer;
import com.mini.bank.models.transfer.TransferRequestDto;
import com.mini.bank.models.user.User;
import com.mini.bank.repositories.TransferRepository;
import com.mini.bank.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {

   private final UserRepository userRepository;
   private final TransferRepository transferRepository;

   public Transfer registerTransfer(TransferRequestDto dto) {
      boolean toSameUser = dto.payerId() == dto.receiverId();

      if (toSameUser)
         throw new RuntimeException("Não é permitido transferir para o mesmo usuário de origem.");

      User payer = userRepository.findById(dto.payerId())
            .orElseThrow(() -> new EntityNotFoundException("Pagador não encontrado."));
      User receiver = userRepository.findById(dto.receiverId())
            .orElseThrow(() -> new EntityNotFoundException("Recebedor não encontrado."));

      boolean transferNotAllowed = !payer.canTransfer(dto.amount());

      if (transferNotAllowed)
         throw new RuntimeException(
               "Transferência não concluída, verifique se há saldo ou se a fonte trata-se de uma pessoa física.");

      Transfer transfer = new Transfer(null, payer, receiver, dto.amount(), null);

      payer.setBalance(payer.getBalance().subtract(dto.amount()));
      receiver.setBalance(receiver.getBalance().add(dto.amount()));

      userRepository.save(payer);
      userRepository.save(receiver);

      return transferRepository.save(transfer);
   }

}
