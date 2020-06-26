package fr.formation.recipes.controllers;

import fr.formation.recipes.dtos.NewRecipeDto;
import fr.formation.recipes.services.NewRecipeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/recipes")
public class NewRecipe {

    private final NewRecipeService service;
    private NewRecipeDto dto;

    protected NewRecipe(NewRecipeService service) {
        this.service = service;
    }

    @PostMapping
    protected void create(@Valid @RequestBody NewRecipeDto dto) {
        this.dto = dto;
        service.create(dto);
    }

}