package org.example.evangelhistory.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GetDateForAnnouncement {

    public String get(LocalDateTime dateTime) {
        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("Europe/Kaliningrad"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM',' HH:mm", new Locale("ru", "RU"));

        return zonedDateTime.format(dtf);
    }
}
