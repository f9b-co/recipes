package fr.formation.recipes.dtos;

import fr.formation.recipes.entities.Difficulty;
import fr.formation.recipes.entities.Step;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class NewRecipeDto {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private int preparingTimeMinutes;

    private int cookingTimeMinutes;

    @NotNull
    private int servings;

    @Valid
    private Difficulty difficulty;

    @NotBlank
    @Size(max = 255)
    private String dishImageUrl;

    @Valid
    private List<IngredientDto> ingredients;

    @Valid
    private List<StepDto> steps;

    public NewRecipeDto() {
        //
    }

    public String getName() {
        return name;
    }
    public int getPreparingTimeMinutes() {
        return preparingTimeMinutes;
    }
    public int getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }
    public int getServings() {
        return servings;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public String getDishImageUrl() {
        return dishImageUrl;
    }
    public List<IngredientDto> getIngredients() {
        return ingredients;
    }
    public List<StepDto> getSteps() {
        return steps;
    }
}
