package fr.formation.recipes.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes", uniqueConstraints = {
        @UniqueConstraint(name = "uk_recipe_name", columnNames = { "recipe_name" })
})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Long id;

    @Column(name = "recipe_name", nullable = false, length = 100)
    private String name;

    @Column(name = "preparing_time_minutes", nullable = false)
    private int preparingTimeMinutes;

    @Column(name = "cooking_time_minutes", nullable = true, columnDefinition = "NULL")
    private int cookingTimeMinutes;

    @Column(name = "servings", nullable = false)
    private int servings;

    @Column(name = "difficulty", nullable = false)
    private Difficulty difficulty;

    @Column(name = "dish_image_url", nullable = false, length = 255)
    private String dishImageUrl;


    private List<Ingredient> ingredients;


    private List<Step> steps;

    public Recipe() {
        //
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreparingTimeMinutes() {
        return preparingTimeMinutes;
    }

    public void setPreparingTimeMinutes(int preparingTimeMinutes) {
        this.preparingTimeMinutes = preparingTimeMinutes;
    }

    public int getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(int cookingTimeMinutes) {
        this.cookingTimeMinutes = cookingTimeMinutes;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getDishImageUrl() {
        return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
