package me.squidxtv.tacocloud.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Date;
import java.time.YearMonth;
import java.util.Calendar;

@Converter
public class YearMonthJpaConverter implements AttributeConverter<YearMonth, Date> {

    @Override
    public Date convertToDatabaseColumn(YearMonth yearMonth) {
        if (yearMonth == null) {
            return null;
        }

        return Date.valueOf(yearMonth.atDay(1));
    }

    @Override
    public YearMonth convertToEntityAttribute(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return YearMonth.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
    }

}
