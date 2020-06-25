package fr.formation.recipes.services;

import fr.formation.recipes.dtos.NewRecipeDto;
import fr.formation.recipes.entities.Recipe;
import fr.formation.recipes.repositories.IngredientJpaRepo;
import fr.formation.recipes.repositories.RecipeJpaRepo;
import fr.formation.recipes.repositories.StepJpaRepo;
import org.springframework.stereotype.Service;

@Service
public class NewRecipeServiceImpl implements NewRecipeService{

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
        Recipe recipe = new Recipe();
        populateAndSave(dto, recipe);
    }

    private void populateAndSave(NewRecipeDto dto, Recipe recipe) {
        recipe.setName(dto.getName());
        recipe.setPreparingTimeMinutes(dto.getPreparingTimeMinutes());
        recipe.setCookingTimeMinutes(dto.getCookingTimeMinutes());
        recipe.setServings(dto.getServings());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setDishImageUrl(dto.getDishImageUrl());
        //loops to populate
        //recipe.setIngredients(dto.getIngredients());
        //recipe.setSteps(dto.getSteps());
        recipeRepo.save(recipe);
    }
}
