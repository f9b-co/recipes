package fr.formation.recipes.repositories;

import fr.formation.recipes.entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StepJpaRepo extends JpaRepository<Step, Long> {

    Step findById(int id);

}
