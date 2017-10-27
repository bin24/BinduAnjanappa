package com.cg.emplm.controller;

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

import com.cg.emplm.dtos.Department;
import com.cg.emplm.dtos.Employee;
import com.cg.emplm.service.EmplService;

@Controller
@RequestMapping("/empl")
public class MyController {

	
	@Autowired
	private EmplService empService;


	

	public EmplService getEmpService() {
		return empService;
	}


	public void setEmpService(EmplService empService) {
		this.empService = empService;
	}


	@RequestMapping("/list")
	public ModelAndView getAll(){
		
	List<Employee> empList = empService.getAllItems();
		
	for(Employee emp : empList){
		System.out.println(emp);
	}
		return new ModelAndView("pages/AllItems","eList",empList);
	}
	
	
	@RequestMapping("/insert")
	public String prepareAddDetails(Model model){
		// Before Going to addpage make employee object NULL 

		model = setDataInModel(model);
		
		return "pages/addEmployee";
	}
	
	
	
	Model setDataInModel(Model model){
		
		Employee emp = new Employee();

		List<Department> deptList= empService.getAllDeptId();
		
		Map<Department,Integer> department = new LinkedHashMap<Department,Integer>();
		for(Department d : deptList){
			System.out.println("in map"+d);
			department.put(d, d.getId());			
		}
		
		List<Integer> dIds = new ArrayList<Integer>();
		
		for(Department dd : deptList){
			dIds.add(dd.getId());
		}
		
		System.out.println(dIds);
		
		
		model.addAttribute("departmentSet",department);
		
		model.addAttribute("dIds",dIds);
		
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countrySet",country);
		
		
		model.addAttribute("emp",emp);
 		return model;
	}
	
	//name in ModeAttribute and commandName must match "emp" 
	
	@RequestMapping("/addDetails")
	public String addEmployeeDetails(@ModelAttribute("emp")@Valid Employee emp,BindingResult result,Model m){
		
		System.out.println("deptId is "+emp.getId());
		Department d = empService.getDepartmentById(emp.getId());
		emp.setDepartment(d);
		
		System.out.println(emp.getDepartment());
		
		System.out.println("All Setter with department"+emp);
		
		if(result.hasErrors()){	
			
			System.out.println("in error function"+emp);			
			return "pages/addEmployee";
		}
		
		
		else{
			
			System.out.println("in success function function"+emp);
			
			System.out.println("Before  "+emp);
			emp = empService.addEmployeeDetails(emp);
			System.out.println("After  "+emp);	
			return "pages/successInsert";
		}	
	}
	
	
	@RequestMapping("/getById")
	public String prepareEmpById(Model m){
		
		List<Integer> empIds = new ArrayList<Integer>();
		empIds = empService.getAllEmployeeId();
		System.out.println(empIds);
		m.addAttribute("empIdList",empIds);
		return "pages/getById";
	}
	
	@RequestMapping("/getEmplById")
	public ModelAndView getEmpByID(@RequestParam("id") long employeeId){
		System.out.println("Employee Id is "+employeeId);
		Employee emp = new Employee();
		emp = empService.getEmpById(employeeId);
		return new ModelAndView("pages/EmpDetails","employee",emp);

	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView showEdit(@RequestParam int employeeId){
		
		Employee em = empService.getEmpById(employeeId);
		System.out.println("in controller"+em);
		return new ModelAndView("pages/edit","emp",em);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView doUpdate(@ModelAttribute("emp")@Valid Employee emp,BindingResult result){
		
		ModelAndView mv = new ModelAndView("pages/SuccessUpdate");
		if(result.getErrorCount()==0){
			Employee e = empService.updateEmployee(emp);
			System.out.println("in Controller"+e);
			
		}else{
			mv.addObject("emp",emp);
			mv.setViewName("pages/edit");
		}
		return mv;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String doDelete(@RequestParam int employeeId){
		if(empService.delete(employeeId))
			System.out.println("Data Deleted Successfully");
		else
			System.out.println("Not Deleted");
		
		return "redirect:list.obj";
	}
	
	
}
