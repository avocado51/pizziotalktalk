package com.avocado.pizziotalktalk.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.avocado.pizziotalktalk.domain.Users;
import com.avocado.pizziotalktalk.exception.DuplicatedUsersException;
import com.avocado.pizziotalktalk.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public Users createUsers(Users user) {
    Users savedUsers;

    try {
      String encodedPassword = passwordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);
      savedUsers = userRepository.save(user);
    } catch(Exception e) {
      throw new DuplicatedUsersException("중복된 이름이 존재합니다.");
    }
    return savedUsers;
  }

  public boolean checkPassword(String password, Users user) {
    return passwordEncoder.matches(password, user.getPassword());
  }
	public Users findUsers(String usersId) {
		return userRepository.findById(usersId);
	}
}
