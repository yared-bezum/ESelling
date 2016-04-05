package edu.mum.eselling.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.MyFinance;
import edu.mum.eselling.repository.MyFinanceRepository;
import edu.mum.eselling.service.MyFinanceService;

@Service
@Transactional
public class MyFinanceServiceImpl implements MyFinanceService {

	@Autowired
	MyFinanceRepository myFinanceRepository;

//	@Autowired
//	TransactionRepository transactionRepository;

	public List<MyFinance> getAll() {

		return (List<MyFinance>) myFinanceRepository.findAll();
	}

	@Override
	public MyFinance findMyFinanceByCreditCardNo(String creditCardNo) {
		return myFinanceRepository.findMyFinanceByCreditCardNo(creditCardNo);
	}

	@Override
	public MyFinance store(MyFinance myFinance) {
		return myFinanceRepository.save(myFinance);
	}

//	@Override
//	public Transaction store(Transaction myTransaction) {
//		return transactionRepository.save(myTransaction);
//	}

}
