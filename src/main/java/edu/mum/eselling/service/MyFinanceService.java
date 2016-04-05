package edu.mum.eselling.service;

import java.util.List;

import edu.mum.eselling.domain.MyFinance;

public interface MyFinanceService {

	public List<MyFinance> getAll();

	public MyFinance findMyFinanceByCreditCardNo(String creditCardNo);

	public MyFinance store(MyFinance myFinance);

}
