package fr.formation.recipes.validation;

import fr.formation.recipes.dtos.StepDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IncrementalStepOrdersValidator implements
	ConstraintValidator<IncrementalStepOrders, List<StepDto>> {

    private int from;

    @Override
    public void initialize(IncrementalStepOrders annotation) {
	from = annotation.from(); // annotation param instead of 1 (default)
	if (from < 1) {
	    throw new IllegalArgumentException(
		    "from parameter must not be less than 1: " + from);
	}
    }

    @Override
    public boolean isValid(List<StepDto> values,
	    ConstraintValidatorContext context) {
	if (values == null || values.isEmpty()) {
	    return true;
	}
	//
	boolean valid = true;
	int previous = from;
	for (StepDto stepCreateDto : values) {
	    int current = stepCreateDto.getStepOrder();
	    if (current != previous++) {
		valid = false;
		break;
	    }
	}
	return valid;
    }
}
