package de.bas.devcamp.jdbc.spring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringDataApplication {
    @Autowired
    private static CoffeeSpringRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }
}