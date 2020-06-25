package fr.formation.recipes.repositories;

import fr.formation.recipes.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngredientJpaRepo extends JpaRepository<Ingredient, Long> {

    Ingredient findById(int id);

}