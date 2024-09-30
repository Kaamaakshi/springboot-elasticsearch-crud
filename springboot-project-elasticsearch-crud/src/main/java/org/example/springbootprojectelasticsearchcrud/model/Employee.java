package org.example.springbootprojectelasticsearchcrud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "employees")
@Data
public class Employee {
    @Id
    private String id;
    private String name;
    private String department;
    private double salary;
}
