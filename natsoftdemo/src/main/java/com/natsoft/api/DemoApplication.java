package com.natsoft.api;

import com.natsoft.api.entity.User;
import com.natsoft.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "sambit", "password", "sam@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
