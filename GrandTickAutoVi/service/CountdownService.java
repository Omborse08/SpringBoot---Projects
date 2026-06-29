package com.example.GrandTickAutoVi.service;

import com.example.GrandTickAutoVi.model.Countdown;
import com.example.GrandTickAutoVi.model.CountdownAndTime;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class CountdownService {
    public CountdownAndTime countdownAndTime(@RequestParam(defaultValue = "utc") String location) {
        ZoneId zoneId;
        String message;

        if (location.equalsIgnoreCase("mumbai")) {
            zoneId = ZoneId.of("Asia/Kolkata");
            message = "Mumbai Gamers, Let's Begin!";
        } else if (location.equalsIgnoreCase("new_york")) {
            zoneId = ZoneId.of("America/New_York");
            message = "New York hyped up!";
        } else if (location.equalsIgnoreCase("london")) {
            zoneId = ZoneId.of("Europe/London");
            message = "London is ready!";
        } else {
            zoneId = ZoneId.of("UTC");
            message = "Global Countdown Active!";
        }

        ZonedDateTime target = ZonedDateTime.of(
                2026,11,19,0,0,0,0,zoneId
        );

        ZonedDateTime nowInLocation = ZonedDateTime.now(zoneId);

        Duration duration = Duration.between(nowInLocation, target);

        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        return new CountdownAndTime(new Countdown(days,hours,minutes,seconds,message),nowInLocation);
    }
}
