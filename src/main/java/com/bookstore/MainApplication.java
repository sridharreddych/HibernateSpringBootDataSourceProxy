package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }
}




/*
 * View Query Details Via DataSource-Proxy Library

Description: View the query details (query type, binding parameters, batch size, execution time, etc) via DataSource-Proxy

Key points:

for Maven, add in pom.xml the datasource-proxy dependency
create an bean post processor to intercept the DataSource bean
wrap the DataSource bean via ProxyFactory and an implementation of MethodInterceptor
Output example:
 * 
 */
