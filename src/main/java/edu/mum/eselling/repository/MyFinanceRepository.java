package edu.mum.eselling.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.MyFinance;

@Repository
public interface MyFinanceRepository extends CrudRepository<MyFinance, Long> {

	@Query("SELECT f FROM MyFinance f WHERE f.creditCardNo = :creditCardNo")
	public MyFinance findMyFinanceByCreditCardNo(
			@Param(value = "creditCardNo") String creditCardNo);

}
