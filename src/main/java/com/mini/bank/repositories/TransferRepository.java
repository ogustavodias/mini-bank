package com.mini.bank.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.bank.models.transfer.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
