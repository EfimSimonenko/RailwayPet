package com.javaschool.SBB.hepler;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeParser {

    public LocalDateTime stringToLocalDateTime(String s) {
        LocalDateTime localDateTime = LocalDateTime.parse(s,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        return localDateTime;
    }

    public LocalDate stringToLocalDate(String s) {
        if (s.equals("")) return null;
        else {
            LocalDate localDate = LocalDate.parse(s,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return localDate;
        }
    }



}
