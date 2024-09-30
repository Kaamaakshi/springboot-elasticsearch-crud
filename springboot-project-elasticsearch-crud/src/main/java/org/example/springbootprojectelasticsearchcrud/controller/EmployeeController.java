package org.example.springbootprojectelasticsearchcrud.controller;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.example.springbootprojectelasticsearchcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public String saveEmployee(@RequestBody Employee employee) {
       return employeeService.saveEmployee(employee);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
       return employeeService.deleteEmployeeById(id);
    }
    @DeleteMapping
    public String deleteAllEmployee() {
        return employeeService.deleteAllEmployees();
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
    @GetMapping("/search")
    public Iterable<Employee> searchEmployee(@RequestParam String name) {
      return  employeeService.searchByName(name);
    }
    @GetMapping("/range")
    public Iterable<Employee> findBySalaryBetween(@RequestParam double min,@RequestParam double max){
        return employeeService.findBySalaryBetween(min,max);
    }



}

