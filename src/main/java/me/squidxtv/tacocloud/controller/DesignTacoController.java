package me.squidxtv.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import me.squidxtv.tacocloud.data.IngredientRepository;
import me.squidxtv.tacocloud.model.Ingredient;
import me.squidxtv.tacocloud.model.Ingredient.Type;
import me.squidxtv.tacocloud.model.Taco;
import me.squidxtv.tacocloud.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute("ingredients")
    public Map<Type, List<Ingredient>> ingredients() {
        return StreamSupport.stream(ingredientRepo.findAll().spliterator(), false)
                .collect(Collectors.groupingBy(
                        Ingredient::getType,
                        () -> new TreeMap<>(Comparator.naturalOrder()),
                        Collectors.toList()
                ));
    }

    @ModelAttribute("order")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String view() {
        return "design";
    }

    @PostMapping
    public String processTaco(@ModelAttribute("taco") @Valid Taco taco, Errors errors, @ModelAttribute("order") TacoOrder order) {
        if (errors.hasErrors()) {
            return "design";
        }

        order.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders";
    }

}

