package com.sumit.playjava.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumit.playjava.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
}
