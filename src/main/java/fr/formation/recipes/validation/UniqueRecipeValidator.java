package fr.formation.recipes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.recipes.services.NewRecipeService;
import org.springframework.beans.factory.annotation.Autowired;


public class UniqueRecipeValidator
	implements ConstraintValidator<UniqueRecipe, String> {

    // Comment implementation choice
    /*
     * Multi-line
     */
    @Autowired
    private NewRecipeService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	return service.uniqueName(value); // call service
    }
}
