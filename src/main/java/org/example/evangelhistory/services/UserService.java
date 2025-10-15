package org.example.evangelhistory.services;

import org.example.evangelhistory.entities.Role;
import org.example.evangelhistory.entities.User;
import org.example.evangelhistory.repositories.RoleRepository;
import org.example.evangelhistory.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository uRepo;
    private final RoleRepository rRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository uRepo, RoleRepository rRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.uRepo = uRepo;
        this.rRepo = rRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = uRepo.findByName(username);

        if(user == null) {
            throw new UsernameNotFoundException("{exception.no_user}");
        }

        return user;
    }
    public User findUserById(Long id) {
        Optional<User> optional = uRepo.findById(id);

        if (optional.isPresent()){
            return optional.get();
        } else {
            throw new UsernameNotFoundException("{exception.no_user}");
        }
    }
    public User saveUser(User user) {
        User userFromDB = uRepo.findByName(user.getName());

        if(userFromDB == null){
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            uRepo.save(user);
            return user;
        }
        return null;
    }
    public boolean deleteUser(Long userId) {

        if (uRepo.findById(userId).isPresent()) {
            uRepo.deleteById(userId);
            return true;
        }
        return false;
    }
}
