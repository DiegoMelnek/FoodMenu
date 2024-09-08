package me.melnek.FoodMenu.service;

import me.melnek.FoodMenu.model.FoodMenu;

import java.util.List;
import java.util.Optional;

public interface FoodMenuService {
    FoodMenu saveFood(FoodMenu food);
    List<FoodMenu> getAllFoods();
    Optional<FoodMenu> getFoodById(Long id);
    FoodMenu updateFood(Long id, FoodMenu foodDetails);
    void deleteFood(Long id);
}
