package me.melnek.FoodMenu.service.impl;

import me.melnek.FoodMenu.exception.FoodNotFoundException;
import me.melnek.FoodMenu.model.FoodMenu;
import me.melnek.FoodMenu.repository.FoodRepository;
import me.melnek.FoodMenu.service.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodMenuImpl implements FoodMenuService {

    @Autowired
    private FoodRepository foodRepository;

    //Methods implements

    @Override
    public FoodMenu saveFood(FoodMenu food) {
        return foodRepository.save(food);
    }

    @Override
    public List<FoodMenu> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<FoodMenu> getFoodById(Long id) {
        return foodRepository.findById(id);

    }

    @Override
    public FoodMenu updateFood(Long id, FoodMenu food) {
        FoodMenu existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new FoodNotFoundException(id));
        existingFood.setNameFood(food.getNameFood());
        existingFood.setDescriptionFood(food.getDescriptionFood());
        existingFood.setValueFood(food.getValueFood());
        existingFood.setStatusFood(food.getStatusFood());
        existingFood.setTypeFood(food.getTypeFood());

        return foodRepository.save(existingFood);
    }

    @Override
    public void deleteFood(Long id) {
        if (!foodRepository.existsById(id)) {
            throw new FoodNotFoundException(id);
        }
        foodRepository.deleteById(id);
    }
}
