package org.revature.springboot.dao;

import org.revature.springboot.model.Client;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@EntityScan(basePackages = "org.revature.springboot.model")
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);
}