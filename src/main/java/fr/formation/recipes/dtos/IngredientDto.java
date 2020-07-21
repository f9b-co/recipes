package fr.formation.recipes.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class IngredientDto {

    @NotBlank
    @Size(min = 1, max = 255)
    private String ingredientWording;

    public IngredientDto() {
        //
    }

    public String getIngredientWording() {
        return ingredientWording;
    }
}
