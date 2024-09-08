package me.melnek.FoodMenu.exception;

public class FoodNotFoundException extends RuntimeException{
    public FoodNotFoundException(Long id) {
        super("Prato com ID " + id + " não encontrado");
    }
}
