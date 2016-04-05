package edu.mum.eselling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.Transaction;

@Repository
public interface TransactionRepository extends
		CrudRepository<Transaction, Long> {

}
