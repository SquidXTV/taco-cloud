package me.squidxtv.tacocloud.repositories;

import me.squidxtv.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
