package com.mini.bank.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.bank.models.user.User;

public interface UserRepository extends JpaRepository<User, UUID> {
}
