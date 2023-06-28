package sps.employees.history.SpsProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sps.employees.history.SpsProject.domain.Employee;
import sps.employees.history.SpsProject.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee findById(Long employee_id){
        Optional<Employee> employeeOpt = employeeRepo.findById(employee_id);
        return employeeOpt.orElse(new Employee());
    }

}
