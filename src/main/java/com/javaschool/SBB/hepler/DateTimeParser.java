package com.javaschool.SBB.hepler;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeParser {

    public LocalDateTime stringToLocalDateTime(String s) {
        LocalDateTime localDateTime = LocalDateTime.parse(s,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        return localDateTime;
    }



}
