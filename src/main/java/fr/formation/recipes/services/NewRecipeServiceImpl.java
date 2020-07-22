package fr.formation.recipes.services;

import fr.formation.recipes.dtos.IngredientDto;
import fr.formation.recipes.dtos.NewRecipeDto;
import fr.formation.recipes.dtos.StepDto;
import fr.formation.recipes.entities.Ingredient;
import fr.formation.recipes.entities.Recipe;
import fr.formation.recipes.entities.Step;
import fr.formation.recipes.repositories.RecipeJpaRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NewRecipeServiceImpl implements NewRecipeService {

    private final RecipeJpaRepo recipeRepo;

    protected NewRecipeServiceImpl(RecipeJpaRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public void create(NewRecipeDto dto) {
        Recipe recipeNew = new Recipe();
        populateAndSave(dto, recipeNew);
    }

    private void populateAndSave(NewRecipeDto dto, Recipe recipeNew) {
        //Recipe Dto>Entity mapping
        recipeNew.setName(dto.getName());
        recipeNew.setPreparingTimeMinutes(dto.getPreparingTimeMinutes());
        recipeNew.setCookingTimeMinutes(dto.getCookingTimeMinutes());
        recipeNew.setServings(dto.getServings());
        recipeNew.setDifficulty(dto.getDifficulty());
        recipeNew.setDishImageUrl(dto.getDishImageUrl());
        //loop List<IngredientDto> ingredients to populate ingredients list for recipeNew
        List<Ingredient> ingredients = new ArrayList<>();
        for (IngredientDto i : dto.getIngredients()) {
            Ingredient ingredientNew = new Ingredient();
            ingredientNew.setIngredientWording(i.getIngredientWording());
            ingredients.add(ingredientNew);
        }
        recipeNew.setIngredients(ingredients);
        //loop List<StepDto> steps to populate steps List for recipeNew
        List<Step> steps = new ArrayList<>();
        for (StepDto s : dto.getSteps()) {
            Step stepNew = new Step();
            stepNew.setStepWording(s.getStepWording());
            stepNew.setStepOrder(s.getStepOrder());
            steps.add(stepNew);
        }
        recipeNew.setSteps(steps);
        //save entity
        recipeRepo.save(recipeNew);
    }
    /**
     * Returns true if value does not exists.
     */
    @Override
    public boolean uniqueName(String value) {
        // select recipe where name = value
        // long count = repo.uniqueName(value);
        // return count == 0; //
        return !recipeRepo.existsByName(value);
    }
}
