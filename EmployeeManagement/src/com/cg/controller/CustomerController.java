package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.model.CustomerBean;
import com.cg.service.ICustomerService;



@Controller
public class CustomerController 
{
	@Autowired
	private ICustomerService service;
	

	public ICustomerService getService() {
		return service;
	}

	public void setService(ICustomerService service) {
		this.service = service;
	}

	@RequestMapping("/register")
	public String start(Model model)
	{
		model.addAttribute("cust", new CustomerBean());
		return "customerRegForm";
	}
	
	@RequestMapping("/resForm")
	public ModelAndView register(@ModelAttribute("cust") @Valid CustomerBean bean,BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("customerRegForm","k",bean);
		}
		else
		{
		service.add(bean);
		return new ModelAndView("success","k",bean);
		}
	}
	
	@RequestMapping("/retrieve")
	public ModelAndView retrieve(CustomerBean bean)
	{
		
		
		return new ModelAndView("Retrieve","id",service.getAllItems());
	}
	
	/*@RequestMapping("/retrieveById")
	public String startById(Model model)
	{
		
		return "getDd";
	}
	*/
	@RequestMapping("/retrieveById")
	public ModelAndView retrieveById()
	{
		
		return new ModelAndView("getDd","k",service.retrieveCustomerId());
	}
	
	@RequestMapping("/retrieveID")
	public ModelAndView retrieve(@RequestParam int customerId)
	{
		
		return new ModelAndView("Retrieve","key",service.getById(customerId));
	}
	
	

}
