package me.squidxtv.tacocloud.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt = new Date();

    @NotNull
    @Valid
    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "delivery_name"))
    @AttributeOverride(name = "street", column = @Column(name = "delivery_street"))
    @AttributeOverride(name = "city", column = @Column(name = "delivery_city"))
    @AttributeOverride(name = "state", column = @Column(name = "delivery_state"))
    @AttributeOverride(name = "zip", column = @Column(name = "delivery_zip"))
    private DeliveryAddress address;

    @NotNull
    @Valid
    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "cc_number"))
    @AttributeOverride(name = "expiration", column = @Column(name = "cc_expiration"))
    @AttributeOverride(name = "cvv", column = @Column(name = "cc_cvv"))
    private CreditCard creditCard;

    @Size(min = 1)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

}
