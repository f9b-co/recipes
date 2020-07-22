package fr.formation.recipes.validation;

import fr.formation.recipes.dtos.NewRecipeDto;
import fr.formation.recipes.services.NewRecipeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class TimeFieldsNotEqualValidator
	implements ConstraintValidator<TimeFieldsNotEqual, NewRecipeDto> {

    /*
     * @Autowired injection implementetion to preserve default constructor availability
     */

    @Override
    public boolean isValid(NewRecipeDto value, ConstraintValidatorContext context) {
        int preparingTime = value.getPreparingTimeMinutes();
        Integer cookingTime = value.getCookingTimeMinutes();
        if (cookingTime == null) {
            return true;
        }
        return preparingTime != cookingTime;
    }
}
