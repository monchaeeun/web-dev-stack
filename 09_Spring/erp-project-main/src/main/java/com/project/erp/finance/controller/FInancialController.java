package com.project.erp.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.erp.ErpProjectApplication;
import com.project.erp.finance.service.SaleService;
import com.project.erp.finance.vo.Sale;

@Controller
public class FInancialController {

    private final ErpProjectApplication erpProjectApplication;

	@Autowired
	private SaleService saleService;

    FInancialController(ErpProjectApplication erpProjectApplication) {
        this.erpProjectApplication = erpProjectApplication;
    }
	
	@PostMapping("/insert")
	public String insert(Sale sale)
	{
		saleService.addSale(sale);
		return "redirect:/";
	}
	@GetMapping("/list")
	public String list() {
		List<Sale> list = saleService.viewSale();
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/sale")
	public String list(Model model) {
		model.addAttribute("component", "../component/finance/sale.jsp");
		return "/common/layout";
	}
	
}
