package me.squidxtv.tacocloud.repositories;

import me.squidxtv.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
