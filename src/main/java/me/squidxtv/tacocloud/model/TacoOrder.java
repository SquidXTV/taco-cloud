package me.squidxtv.tacocloud.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {

    @NotNull
    @Valid
    private DeliveryAddress address;
    @NotNull
    @Valid
    private CreditCard creditCard;
//    @Size(min = 1)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

}
