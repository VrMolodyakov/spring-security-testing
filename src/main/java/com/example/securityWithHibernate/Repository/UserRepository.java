package com.example.securityWithHibernate.Repository;

import com.example.securityWithHibernate.Model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository {
    Optional<Users> findByUserName(String name);
    Users findByUserEmail(String email);
    boolean deleteUserById(Long id);
    Optional<Users> findById(Long id);
    List<Users> findAllUsers();
    boolean saveUser(Users user);
    void deleteByUserName(String name);
}
