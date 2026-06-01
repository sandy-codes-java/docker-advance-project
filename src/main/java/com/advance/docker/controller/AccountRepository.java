package com.advance.docker.controller;

import com.advance.docker.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
    Accounts findByAccountNo(String accountNo);
}
