package com.mini.bank.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini.bank.models.user.User;
import com.mini.bank.models.user.UserView;

public interface UserRepository extends JpaRepository<User, UUID> {

   @Query("SELECT u FROM User u")
   List<UserView> findAllViews();

}
