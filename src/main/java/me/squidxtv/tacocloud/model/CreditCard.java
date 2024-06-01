package me.squidxtv.tacocloud.model;

import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import me.squidxtv.tacocloud.converter.YearMonthJpaConverter;
import me.squidxtv.tacocloud.validator.CreditCardExpiration;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.YearMonth;
import java.util.Objects;

@Embeddable
public class CreditCard {

    @NotNull
    @CreditCardNumber(message = "Not a valid credit card number.")
    private String number;

    @Convert(converter = YearMonthJpaConverter.class)
    @NotNull
    @CreditCardExpiration
    private YearMonth expiration;

    @NotNull
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV.")
    private String cvv;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public YearMonth getExpiration() {
        return expiration;
    }

    public void setExpiration(YearMonth expiration) {
        this.expiration = expiration;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;
        return Objects.equals(number, that.number) && Objects.equals(expiration, that.expiration) && Objects.equals(cvv, that.cvv);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(number);
        result = 31 * result + Objects.hashCode(expiration);
        result = 31 * result + Objects.hashCode(cvv);
        return result;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "number='" + number + '\'' +
                ", expiration=" + expiration +
                ", cvv='" + cvv + '\'' +
                '}';
    }

}
