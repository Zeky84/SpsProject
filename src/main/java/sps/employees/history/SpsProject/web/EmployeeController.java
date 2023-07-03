package sps.employees.history.SpsProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sps.employees.history.SpsProject.domain.Employee;
import sps.employees.history.SpsProject.service.EmployeeService;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/register") // Get for register
    public String employeeRegistration(ModelMap model){
        model.put("employee",new Employee());
        return "register";
    }
    @PostMapping("/register") // Post for register
    public String employeeRegistration(Employee employee){
        employeeService.saveEmployee(employee);
        System.out.println(employee);
        return "redirect:/register";
    }

    @GetMapping("/employees") // Get for employee. Employee list
    public String getAllEmployees(ModelMap model){
        List<Employee> allEmployees = employeeService.findAll();
        System.out.println(allEmployees);
        model.put("employees",allEmployees);
        return "employees";
    }

    @GetMapping("/updateEmployee/{employeeId}") // Get for employee. One employee
    public String getEmployeeById(ModelMap model, @PathVariable Long employeeId){
        Employee employee = employeeService.findById(employeeId);
        model.put("employee",employee);
        System.out.println(employee);
        return "updateEmployee";
    }
    @PostMapping("/updateEmployee/{employeeId}")
    public String postEmployeeById( @PathVariable Long employeeId, Employee employee){
        employeeService.saveEmployee(employee);
        System.out.println(employee.getEmployee_id());
        return "redirect:/updateEmployee/"+employee.getEmployee_id();
    }
}
