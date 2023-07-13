package com.gvea.library.system_time;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Class to provide access to objects based on the current time.
 * Default implementation returns the current system time.
 */
@Component
public class SystemTimeProvider {
    private final CurrentTimeInMillisProvider currentTimeInMillisProvider;

    public SystemTimeProvider(CurrentTimeInMillisProvider currentTimeInMillisProvider) {
        this.currentTimeInMillisProvider = currentTimeInMillisProvider;
    }

    protected long currentTimeInMillis() {
        return currentTimeInMillisProvider.currentTimeMillis();
    }

    public Date getCurrentDate() {
        return new Date(currentTimeInMillis());
    }

    public Calendar getCurrentCalendar() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(currentTimeInMillis());
        return instance;
    }

    public long getCurrentTimeMillis() {
        return currentTimeInMillis();
    }

    public LocalDateTime getCurrentLocalDateTime() {
        Instant current = Instant.ofEpochMilli(currentTimeInMillis());
        return LocalDateTime.ofInstant(current, ZoneId.systemDefault());
    }
}
