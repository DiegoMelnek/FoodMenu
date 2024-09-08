package me.melnek.FoodMenu.repository;

import me.melnek.FoodMenu.model.FoodMenu;
import me.melnek.FoodMenu.model.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodMenu, Long> {

    //Search by foodName
    Optional<FoodMenu> findByNameFood(String nameFood);

    //Search by foodType
    Optional<FoodMenu> findByFoodType(FoodType foodType);
}
