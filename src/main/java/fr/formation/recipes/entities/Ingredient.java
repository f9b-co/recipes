package fr.formation.recipes.entities;

import javax.persistence.*;

@Entity
@Table(name = "ingredients",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_recipe_ingredient", columnNames = { "id_recipe", "ingredient_wording" }) },
        indexes = {
                @Index(name = "fk_ingredients_recipes_idx", columnList = "id_recipe") })
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_recipe", foreignKey =  @ForeignKey(name = "fk_ingredients_recipes"))
    private Recipe recipe;

    @Column(name = "ingredient_wording", nullable = false, length = 255)
    private String ingredientWording;

}
