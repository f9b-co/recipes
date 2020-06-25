package fr.formation.recipes.controllers;

import fr.formation.recipes.dtos.NewRecipeDto;
import fr.formation.recipes.services.NewRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/recipes")
public class NewRecipe {

    @Autowired
    private NewRecipeService service;

    @PostMapping
    protected void create(@Valid @RequestBody NewRecipeDto dto) {
        service.create(dto);
    }

}