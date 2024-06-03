package me.squidxtv.tacocloud.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@RestResource(rel = "orders", path = "orders")
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Instant placedAt;

    @Valid
    @Embedded
    @AttributeOverride(name = "firstName", column = @Column(name = "delivery_first_name", nullable = false))
    @AttributeOverride(name = "lastName", column = @Column(name = "delivery_last_name", nullable = false))
    @AttributeOverride(name = "street", column = @Column(name = "delivery_street", nullable = false))
    @AttributeOverride(name = "city", column = @Column(name = "delivery_city", nullable = false))
    @AttributeOverride(name = "state", column = @Column(name = "delivery_state", nullable = false))
    @AttributeOverride(name = "zip", column = @Column(name = "delivery_zip", nullable = false))
    private DeliveryAddress address;

    @Valid
    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "cc_number", nullable = false))
    @AttributeOverride(name = "expiration", column = @Column(name = "cc_expiration", nullable = false))
    @AttributeOverride(name = "cvv", column = @Column(name = "cc_cvv", nullable = false))
    private CreditCard creditCard;

    @Size(min = 1, message = "Order must contain at least a single taco.")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos;

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    public Long getId() {
        return id;
    }

    public Instant getPlacedAt() {
        return placedAt;
    }

    public DeliveryAddress getAddress() {
        return address;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlacedAt(Instant placedAt) {
        this.placedAt = placedAt;
    }

    public void setAddress(DeliveryAddress address) {
        this.address = address;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setTacos(List<Taco> tacos) {
        this.tacos = tacos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TacoOrder tacoOrder = (TacoOrder) o;
        return Objects.equals(id, tacoOrder.id) && Objects.equals(placedAt, tacoOrder.placedAt) && Objects.equals(address, tacoOrder.address) && Objects.equals(creditCard, tacoOrder.creditCard) && tacos.equals(tacoOrder.tacos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(placedAt);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(creditCard);
        result = 31 * result + tacos.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TacoOrder{" +
                "id=" + id +
                ", placedAt=" + placedAt +
                ", address=" + address +
                ", creditCard=" + creditCard +
                ", tacos=" + tacos +
                '}';
    }

}
