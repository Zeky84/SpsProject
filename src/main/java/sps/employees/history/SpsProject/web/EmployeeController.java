package sps.employees.history.SpsProject.web;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//        List<Employee> allEmployeesByName = employeeService.findByName("Ezequiel");
//        List<Employee> allEmployeesByCurrentPosition = employeeService.findByCurrentPosition("Helper");
        System.out.println(allEmployees);
        model.put("employees",allEmployees);
        return "employees";
    }
    @PostMapping("/employees")
    public String removeAllEmployees(){
        employeeService.removeAll();
        return "redirect:/employees";
    }
    //The below method is to implements a QUERY METHOD WITH SPRING DATA JPA
    @PostMapping("/employees/employeePosition")
    public String getEmployeeByPosition(@RequestParam("employeePosition") String inputEmployeePosition, ModelMap model){
        List<Employee> getAllEmployeesBySpecificPosition = employeeService.findByCurrentPosition(inputEmployeePosition);
        model.put("employees",getAllEmployeesBySpecificPosition);
        return "/employeePosition";
    }

    @GetMapping("/updateEmployee/{employee_id}") // Get for employee. One employee
    public String getEmployeeById(ModelMap model, @PathVariable Long employee_id){
        Employee employee = employeeService.findById(employee_id);
        model.put("employee",employee);
        return "updateEmployee";
    }
    @PostMapping("/updateEmployee/{employee_id}")
    public String postEmployeeById( @PathVariable Long employee_id, Employee employee){ //make sure the @PathVariable name is the same in the domain object
        employeeService.saveEmployee(employee);
        return "redirect:/updateEmployee/"+employee.getEmployee_id();
    }
    @PostMapping("updateEmployee/{employee_id}/delete")
    public String deleteEmployee(@PathVariable Long employee_id){
        employeeService.delete(employee_id);
        return "redirect:/register";
    }
}
