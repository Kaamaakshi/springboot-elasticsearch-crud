package org.example.springbootprojectelasticsearchcrud.repository;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findBySalaryBetween(double min,double max);
}
