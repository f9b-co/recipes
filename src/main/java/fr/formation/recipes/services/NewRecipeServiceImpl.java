package fr.formation.recipes.services;

import fr.formation.recipes.dtos.IngredientDto;
import fr.formation.recipes.dtos.NewRecipeDto;
import fr.formation.recipes.dtos.StepDto;
import fr.formation.recipes.entities.Ingredient;
import fr.formation.recipes.entities.Recipe;
import fr.formation.recipes.entities.Step;
import fr.formation.recipes.repositories.IngredientJpaRepo;
import fr.formation.recipes.repositories.RecipeJpaRepo;
import fr.formation.recipes.repositories.StepJpaRepo;
import org.springframework.stereotype.Service;


@Service
public class NewRecipeServiceImpl implements NewRecipeService {

    private final RecipeJpaRepo recipeRepo;
    private final IngredientJpaRepo ingredientRepo;
    private final StepJpaRepo stepRepo;

    protected NewRecipeServiceImpl(RecipeJpaRepo recipeRepo, IngredientJpaRepo ingredientRepo, StepJpaRepo stepRepo) {
        this.recipeRepo = recipeRepo;
        this.ingredientRepo = ingredientRepo;
        this.stepRepo = stepRepo;
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
        recipeRepo.save(recipeNew);
        //loop List<IngredientDto> ingredients to populate ingredients table for recipeNew
        for( IngredientDto i : dto.getIngredients()) {
            Ingredient ingredientNew = new Ingredient();
            ingredientNew.setIngredientWording(i.getIngredientWording());
            ingredientNew.setRecipe(recipeNew);
            ingredientRepo.save(ingredientNew);
        };
        ///loop List<StepDto> steps to populate steps table for recipeNew
        for( StepDto s : dto.getSteps()) {
            Step stepNew = new Step();
            stepNew.setStepWording(s.getStepWording());
            stepNew.setStepOrder(s.getStepOrder());
            stepNew.setRecipe(recipeNew);
            stepRepo.save(stepNew);
        };
    }
}
