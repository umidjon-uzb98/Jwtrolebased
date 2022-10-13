package com.example.jwtrolebased;

import com.example.jwtrolebased.domain.RegistrationDto;
import com.example.jwtrolebased.domain.Role;
import com.example.jwtrolebased.service.RoleService;
import com.example.jwtrolebased.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JwtrolebasedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtrolebasedApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    CommandLineRunner run(UserService userService, RoleService roleService){
//            return args -> {
//                Role roleAdmin = roleService.save(new Role(Role.ROLE_ADMIN));
//                Role roleUser = roleService.save(new Role(Role.ROLE_USER));
//
//                List<Role> roles1 = new ArrayList<>();
//                roles1.add(roleAdmin);
//
//                List<Role> roles2 = new ArrayList<>();
//                roles1.add(roleUser);
//
//                userService.create(new RegistrationDto("Umidjon Maxmudov", "umidjonmaxmudov", "1234"), roles1);
//                userService.create(new RegistrationDto("User Userov", "useruserov", "1234"), roles2);
//
//            };
//    }
}
