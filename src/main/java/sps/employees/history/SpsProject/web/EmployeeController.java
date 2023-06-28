package sps.employees.history.SpsProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import sps.employees.history.SpsProject.domain.Employee;
import sps.employees.history.SpsProject.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("employees")
    public String getAllEmployees(ModelMap model){
        List<Employee> allEmployees = employeeService.findAll();
        model.put("employees",allEmployees);
        return "employees";
    }
}
