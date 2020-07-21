package fr.formation.recipes.dtos;

import javax.validation.constraints.*;

public class StepDto {

    @NotBlank
    @Size(min = 1, max = 255)
    private String stepWording;

    @NotNull
    @Min(1)
    @Max(20)
    private int stepOrder;

    public StepDto() {
        //
    }

    public String getStepWording() {
        return stepWording;
    }
    public int getStepOrder() {
        return stepOrder;
    }
}
