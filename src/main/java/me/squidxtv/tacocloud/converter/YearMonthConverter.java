package me.squidxtv.tacocloud.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

@Component
public class YearMonthConverter implements Converter<String, YearMonth> {

    private final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.MONTH_OF_YEAR)
            .appendLiteral('/')
            .appendValueReduced(ChronoField.YEAR, 2, 4, LocalDate.now())
            .toFormatter();

    @Override
    public YearMonth convert(@NonNull String source) {
        try {
            return YearMonth.parse(source, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid expiration date. Failed at index " + e.getErrorIndex() + ".");
        }
    }

}
