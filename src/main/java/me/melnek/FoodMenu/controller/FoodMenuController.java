package me.melnek.FoodMenu.controller;

import me.melnek.FoodMenu.model.FoodMenu;
import me.melnek.FoodMenu.service.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/foodmenu")
public class FoodMenuController {

    @Autowired
    private FoodMenuService foodMenuService;

// CREATE - criar prato
    @PostMapping
    public ResponseEntity<FoodMenu> createFoodMenu(@RequestBody FoodMenu foodMenu) {
        FoodMenu createdFoodMenu = foodMenuService.saveFood(foodMenu);
        return ResponseEntity.ok(createdFoodMenu);
    }

// READ - Buscar todos itens
    @GetMapping("{id}")
    public ResponseEntity<FoodMenu> getFoodMenuById(@PathVariable Long id) {
        Optional<FoodMenu> foodMenu = foodMenuService.getFoodById(id);
        return foodMenu.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

// UPDATE - Atualizar item do menu
    @PutMapping("{id}")
    public ResponseEntity<FoodMenu> updateFoodMenu(@PathVariable Long id, @RequestBody FoodMenu foodMenu) {
        FoodMenu updatedFoodMenu = foodMenuService.updateFood(id, foodMenu);
        return ResponseEntity.ok(updatedFoodMenu);
    }

// DELETE - deletar item do menu
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFoodMenu(@PathVariable Long id) {
        foodMenuService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
