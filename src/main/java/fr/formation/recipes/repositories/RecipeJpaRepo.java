package fr.formation.recipes.repositories;

import fr.formation.recipes.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeJpaRepo extends JpaRepository<Recipe, Long> {

    Recipe findById(int id);

}
