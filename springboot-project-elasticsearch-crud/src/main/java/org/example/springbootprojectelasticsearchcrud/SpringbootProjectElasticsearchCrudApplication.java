package org.example.springbootprojectelasticsearchcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "org.example.springbootprojectelasticsearchcrud.repository.elastic")
@EnableMongoRepositories(basePackages = "org.example.springbootprojectelasticsearchcrud.repository.Mongo")

public class SpringbootProjectElasticsearchCrudApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectElasticsearchCrudApplication.class, args);
    }

}
