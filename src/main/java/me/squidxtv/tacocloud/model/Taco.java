package me.squidxtv.tacocloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt = new Date();

    @Size(min = 3, message = "Name must be at least 3 characters long.")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient.")
    @ManyToMany
    private List<Ingredient> ingredients;

}
