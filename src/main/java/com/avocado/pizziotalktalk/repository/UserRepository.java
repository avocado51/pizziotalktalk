package com.avocado.pizziotalktalk.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avocado.pizziotalktalk.domain.Users;

public interface UserRepository extends JpaRepository<Users, BigInteger>{
	Users findById(String usersId);
}
