package com.cg.customer.controller;










import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.customer.dto.Customer;
import com.cg.customer.service.CustomerService;






@Controller
@RequestMapping("/items")
public class MainController {
	
	@Autowired
	private CustomerService custService;
	
	

	public CustomerService getCustService() {
		return custService;
	}



	public void setCustService(CustomerService custService) {
		this.custService = custService;
	}



	@RequestMapping("/list")
	public ModelAndView getAllDetails()
	{
		List<Customer> cust= custService.getAll();
		
		System.out.println("in Customer Controller");
		for(Customer c:cust)
		{
			System.out.println(c);
		}
		return new ModelAndView("items/list","list",cust);
	}
	
	@RequestMapping("/insert")
	public String addDetails(Model model)
	{
		model.addAttribute("cus",new Customer());
		return "items/add";
	}
	Model setDataInModel(Model model){
		Customer cus = new Customer();
	Map<String,String> country = new LinkedHashMap<String,String>();
	country.put("US", "United Stated");
	country.put("CHINA", "China");
	country.put("SG", "Singapore");
	country.put("MY", "Malaysia");
	model.addAttribute("countrySet",country);
	System.out.println(model);
	
	model.addAttribute("cus",cus);
		return model;
	}
	
	@RequestMapping("/addDetails")
	public String addEmployeeDetails(@ModelAttribute("cus")@Valid Customer cus,BindingResult result,Model m){
		
		if(result.hasErrors()){
			return "items/add";
		}
		else{
			
			System.out.println("Before  "+cus);
			cus = custService.addCustomerDetails(cus);
			System.out.println("After  "+cus);	
			return "items/successInsert";
		}	
	}
	
	@RequestMapping("/getById")
	public String prepareEmpById(Model m){
		List<Integer> cusIds = new ArrayList<Integer>();
		cusIds = custService.getAllCustomerId();
		System.out.println(cusIds);
		m.addAttribute("empIdList",cusIds);
		return "items/getById";
	}
	
	@RequestMapping("/getCustById")
	public ModelAndView getEmpByID(@RequestParam("id") int custId){
		System.out.println("Employee Id is "+custId);
		Customer cus= new Customer();
		cus = custService.getCustById(custId);
		System.out.println(cus);
		return new ModelAndView("items/CusDetails","customer",cus);

	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView showEdit(@RequestParam("customerId") int custId){
		return new ModelAndView("items/edit","cus",custService.getCustById(custId));
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView doUpdate(@ModelAttribute("cus")@Valid Customer cus,BindingResult result){
		
		ModelAndView mv = new ModelAndView("items/successUpdate");
		if(result.getErrorCount()==0){
			Customer e = custService.updateCustomer(cus);
			System.out.println("in Controller"+e);
			
		}else{
			mv.addObject("cus",cus);
			mv.setViewName("items/edit");
		}
		return mv;
	}
}

