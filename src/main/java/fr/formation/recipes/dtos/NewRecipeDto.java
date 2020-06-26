package fr.formation.recipes.dtos;

import fr.formation.recipes.entities.Difficulty;
import fr.formation.recipes.entities.Step;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class NewRecipeDto {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @Min(value = 1)
    @Max(value = 120)
    private int preparingTimeMinutes;

    @Min(value = 1)
    @Max(value = 240)
    private int cookingTimeMinutes;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private int servings;

    @Valid
    private Difficulty difficulty;

    @NotBlank
    @Size(min = 7, max = 2500)
    private String dishImageUrl;

    @Valid
    @Size(min = 1, max = 50)
    private List<IngredientDto> ingredients;

    @Valid
    @Size(min = 1, max = 20)
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
