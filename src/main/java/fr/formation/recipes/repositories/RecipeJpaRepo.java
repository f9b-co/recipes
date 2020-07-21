package fr.formation.recipes.repositories;

import fr.formation.recipes.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeJpaRepo extends JpaRepository<Recipe, Long> {
    // @Query("select count(r.id) from Recipe r where r.name = :value")
    // long uniqueName(String value);

    boolean existsByName(String value);

    Recipe findById(int id);

}
