package org.revature.springboot.DAO;


import org.revature.springboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);
    User findByEmail(String email);
    User findByUsernameAndEmail(String username, String email);
}