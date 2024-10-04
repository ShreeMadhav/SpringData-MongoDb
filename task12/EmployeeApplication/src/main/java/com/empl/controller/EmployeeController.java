package com.empl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.empl.model.Employee;
import com.empl.service.EmployeeService;

@Controller
public class EmployeeController {
	 @Autowired
	    private EmployeeService employeeService;

	    @GetMapping("/")
	    public String showForm(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "index"; // Return the index.html view
	    }

	    @PostMapping("/saveEmployee")
	    public String saveEmployee(@ModelAttribute Employee employee) {
	        employeeService.saveEmployee(employee);
	        return "redirect:/displayAll"; // Redirect to the display all page
	    }

	    @GetMapping("/displayAll")
	    public String displayAllEmployees(Model model) {
	        List<Employee> employees = employeeService.getAllEmployees();
	        model.addAttribute("employees", employees);
	        return "displayAll"; // Return the displayAll.html view
	    }

	    @GetMapping("/display/{employeeId}")
	    public String displayEmployee(@PathVariable String employeeId, Model model) {
	        Employee employee = employeeService.getEmployeeById(employeeId);
	        model.addAttribute("employee", employee);
	        return "displayEmployee"; // Return the displayEmployee.html view
	    }

}
