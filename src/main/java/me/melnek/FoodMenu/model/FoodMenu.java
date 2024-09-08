package me.melnek.FoodMenu.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class FoodMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nameFood;

    @Column(nullable = false)
    private String descriptionFood;

    @Column(nullable = false)
    private BigDecimal valueFood;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodStatusType statusFood;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodType foodType;

    // Constructor and Getters & Setters


    public FoodMenu(Long id, String nameFood, String descriptionFood, BigDecimal valueFood, FoodStatusType statusFood, FoodType foodType) {
        this.id = id;
        this.nameFood = nameFood;
        this.descriptionFood = descriptionFood;
        this.valueFood = valueFood;
        this.statusFood = statusFood;
        this.foodType = foodType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getDescriptionFood() {
        return descriptionFood;
    }

    public void setDescriptionFood(String descriptionFood) {
        this.descriptionFood = descriptionFood;
    }

    public BigDecimal getValueFood() {
        return valueFood;
    }

    public void setValueFood(BigDecimal valueFood) {
        this.valueFood = valueFood;
    }

    public FoodStatusType getStatusFood() {
        return statusFood;
    }

    public void setStatusFood(FoodStatusType statusFood) {
        this.statusFood = statusFood;
    }

    public FoodType getTypeFood() {
        return foodType;
    }

    public void setTypeFood(FoodType foodType) {
        this.foodType = foodType;
    }
}
