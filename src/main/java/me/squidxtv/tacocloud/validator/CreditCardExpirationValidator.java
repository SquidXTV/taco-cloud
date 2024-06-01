package me.squidxtv.tacocloud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.YearMonth;

public class CreditCardExpirationValidator implements ConstraintValidator<CreditCardExpiration, YearMonth> {

    @Override
    public boolean isValid(YearMonth expiration, ConstraintValidatorContext ctx) {
        if (expiration == null) {
            return false;
        }

        YearMonth current = YearMonth.now();
        return expiration.isAfter(current);
    }

}
