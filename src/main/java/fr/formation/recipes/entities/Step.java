package fr.formation.recipes.entities;

import javax.persistence.*;

@Entity
@Table(name = "steps",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_recipe_order", columnNames = { "id_recipe", "step_order" }) },
        indexes = {
                @Index(name = "fk_steps_recipes_idx", columnList = "id_recipe") })
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_step")
    private Long id;

    @Column(name = "step_wording", nullable = false, length = 255)
    private String stepWording;

    @Column(name = "step_order", nullable = false)
    private int stepOrder;

    public Step() {
        //
    }

    public void setStepWording(String stepWording) {
        this.stepWording = stepWording;
    }
    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }
}
