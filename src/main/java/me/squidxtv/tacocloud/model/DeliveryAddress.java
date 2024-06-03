package me.squidxtv.tacocloud.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DeliveryAddress implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotNull
    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotNull
    @NotBlank(message = "Street is required.")
    private String street;

    @NotNull
    @NotBlank(message = "City is required.")
    private String city;

    @NotNull
    @NotBlank(message = "State is required.")
    private String state;

    @NotNull
    @NotBlank(message = "Zip code is required.")
    private String zip;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryAddress that = (DeliveryAddress) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zip, that.zip);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(street);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(zip);
        return result;
    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    public void patch(DeliveryAddress other) {
        if (other == null) {
            return;
        }

        if (other.firstName != null) {
            this.firstName = other.firstName;
        }

        if (other.lastName != null) {
            this.lastName = other.lastName;
        }

        if (other.street != null) {
            this.street = other.street;
        }

        if (other.city != null) {
            this.city = other.city;
        }

        if (other.state != null) {
            this.state = other.state;
        }

        if (other.zip != null) {
            this.zip = other.zip;
        }
    }

}
