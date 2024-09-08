package me.melnek.FoodMenu.service.impl;

import me.melnek.FoodMenu.exception.UserNotFoundException;
import me.melnek.FoodMenu.model.Users;
import me.melnek.FoodMenu.repository.UsersRepository;
import me.melnek.FoodMenu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    //Methods implements

    @Override
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users updateUser(Long id, Users user) {
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        existingUser.setPassword(user.getPassword());
        existingUser.setAddress(user.getAddress());

        return usersRepository.save(existingUser);

    }

    @Override
    public void deleteUser(Long id) {
        if (!usersRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        usersRepository.deleteById(id);
    }
}
