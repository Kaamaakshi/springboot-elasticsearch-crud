package org.example.springbootprojectelasticsearchcrud.service;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.example.springbootprojectelasticsearchcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "employeedata saved successfully";
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    public Iterable<Employee> getAllEmployees() {
        Iterable<Employee> list=employeeRepository.findAll();
        if(list!=null) {
            return list;
        }else{
            return null;
        }
    }

    public String deleteEmployeeById(int id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return "employee data deleted successfully";
        }else{
            return "employee data not found with this id "+ " "+ id;
        }
    }
    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "all data deleted";
    }

    public String updateEmployee(int id,Employee employee) {
        Optional<Employee> employee1=employeeRepository.findById(id);
        if (employee1.isPresent()) {
             Employee employee2 = employee1.get();
             employee2.setId(employee.getId());
             employee2.setName(employee.getName());
             employee2.setDepartment(employee.getDepartment());
             employee2.setSalary(employee.getSalary());
             employeeRepository.save(employee2);
             return "employee data updated successfully";
        }else{
            return "data not found with the id " +" "+id;
        }

    }
    public List<Employee>  searchByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findBySalaryBetween(double min, double max) {
         return employeeRepository.findBySalaryBetween(min, max);
    }
}




