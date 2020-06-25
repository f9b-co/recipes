package fr.formation.recipes.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StepDto {

    @NotBlank
    @Size(max = 255)
    private String stepWording;

    @NotNull
    private int stepOrder;

}
