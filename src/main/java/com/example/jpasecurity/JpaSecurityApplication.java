package com.example.jpasecurity;

import com.example.jpasecurity.model.Post;
import com.example.jpasecurity.model.User;
import com.example.jpasecurity.repository.PostRepository;
import com.example.jpasecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class JpaSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, PasswordEncoder encoder) {
        return args -> {

            users.save(new User("user",encoder.encode("password"),"ROLE_USER"));
            users.save(new User("admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));

            posts.save(new Post("HELLO, WORLD!","hello-world","Welcome to my new blog!","Dan Vega"));
        };
    }

}
