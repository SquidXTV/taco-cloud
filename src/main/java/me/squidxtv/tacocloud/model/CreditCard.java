package me.squidxtv.tacocloud.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class CreditCard {

    @CreditCardNumber(message = "Not a valid credit card number")
    private String number;
    // ToDo: properly validate expiration date to not be expired already
    @Pattern(regexp = "^(0[1-9]|1[0-2])/([2-9]\\d)$", message = "Must be formatted MM/YY")
    private String expiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String cvv;

}
