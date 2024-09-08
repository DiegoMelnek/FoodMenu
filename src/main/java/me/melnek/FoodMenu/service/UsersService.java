package me.melnek.FoodMenu.service;

import me.melnek.FoodMenu.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users createUser(Users user);
    Optional<Users> getUserById(Long id);
    List<Users> getAllUsers();
    Users updateUser(Long id, Users user);
    void deleteUser(Long id);
}
