package com.hsenid.spring_security.repository;

import com.hsenid.spring_security.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <Users, Integer> {

    Optional<Users> findByEmail(String email);
}
