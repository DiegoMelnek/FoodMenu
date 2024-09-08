package me.melnek.FoodMenu.repository;

import me.melnek.FoodMenu.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    //Searcb by username
    Optional<Users> findByUsername(String username);

    //Search by Email
    Optional<Users> findByEmail(String email);

}
