package me.melnek.FoodMenu.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Usuário com ID " + id + " não encontrado");
    }
}
