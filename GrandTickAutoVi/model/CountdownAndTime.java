package com.example.GrandTickAutoVi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Data
public class CountdownAndTime {
    private Countdown countdown;
    private ZonedDateTime rightTime;
}
