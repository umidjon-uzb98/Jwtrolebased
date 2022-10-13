package com.example.jwtrolebased.service;

import com.example.jwtrolebased.domain.RegistrationDto;
import com.example.jwtrolebased.domain.Role;
import com.example.jwtrolebased.domain.User;
import com.example.jwtrolebased.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails
                    .User(user.getUsername(), user.getPassword(),authorities);
        }
    }

    public User getByUserName(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public User save(User user){
        return userRepo.save(user);
    }

    public User create(RegistrationDto request){
        List<Role> roles = new ArrayList<>();
        try {
            Role byName = roleService.getByName(Role.ROLE_USER);
            System.out.println(byName);
            roles.add(byName);
        }catch (Exception ignored){

        }
        return create(request, roles);
    }

    public User create(RegistrationDto request, List<Role> roles){
        User user = new User(request.getName(), request.getUsername(), passwordEncoder.encode(request.getPassword()),roles);
        save(user);
        return user;
    }

}
