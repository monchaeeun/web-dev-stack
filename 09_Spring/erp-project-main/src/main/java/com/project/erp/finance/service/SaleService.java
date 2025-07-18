package com.project.erp.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.finance.mapper.SaleMapper;
import com.project.erp.finance.vo.Sale;

@Service
public class SaleService {

	@Autowired
	private SaleMapper saleMapper;
	
	public void addSale(Sale sale) {
		saleMapper.addSale(sale);
	}

	
	public List<Sale> viewSale() {
		return saleMapper.viewSale();
	}

}