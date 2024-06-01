package me.squidxtv.tacocloud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Instant createdAt;

    @NotNull
    @Size(min = 3, message = "Name must be at least 3 characters long.")
    @Column(nullable = false)
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient.")
    @ManyToMany
    private List<@NotNull Ingredient> ingredients = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Taco taco = (Taco) o;
        return Objects.equals(id, taco.id) && Objects.equals(createdAt, taco.createdAt) && Objects.equals(name, taco.name) && ingredients.equals(taco.ingredients);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(createdAt);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + ingredients.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Taco{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

}
