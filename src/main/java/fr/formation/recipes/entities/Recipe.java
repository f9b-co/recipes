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

    @Column(name = "cooking_time_minutes", nullable = true)
    private int cookingTimeMinutes;

    @Column(name = "servings", nullable = false)
    private int servings;

    @Column(name = "difficulty", nullable = false)
    private Difficulty difficulty;

    @Column(name = "dish_image_url", nullable = false, length = 255)
    private String dishImageUrl;


    public Recipe() {
        //
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPreparingTimeMinutes(int preparingTimeMinutes) {
        this.preparingTimeMinutes = preparingTimeMinutes;
    }
    public void setCookingTimeMinutes(int cookingTimeMinutes) {
        this.cookingTimeMinutes = cookingTimeMinutes;
    }
    public void setServings(int servings) {
        this.servings = servings;
    }
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }

}
