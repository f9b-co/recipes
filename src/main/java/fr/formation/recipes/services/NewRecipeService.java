package fr.formation.recipes.services;

import fr.formation.recipes.dtos.NewRecipeDto;

public interface NewRecipeService {

    boolean uniqueName(String value);

    void create(NewRecipeDto dto);

}
