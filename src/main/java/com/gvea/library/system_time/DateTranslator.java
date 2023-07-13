package com.gvea.library.system_time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTranslator {
    public static final String MONTH_NAME_SPACE_4_DIGIT_YEAR_PATTERN = "MMMM yyyy";
    public static final String MM_DD_YYYY_HH_MM_A = "MM/dd/yyyy hh:mm a";
    public static final String MMM_DD_YYYY_HH_MM_A = "MMM dd, yyyy hh:mm a";
    public static final String HH_MM_A = "hh:mm a";
    public static final String DD = "dd";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";

    public LocalDateTime truncateSeconds(LocalDateTime currentDate) {
        currentDate = LocalDateTime.of(currentDate.getYear(),
                currentDate.getMonth(),
                currentDate.getDayOfMonth(),
                currentDate.getHour(),
                currentDate.getMinute());
        return currentDate;
    }

    public String toYearString(Calendar calendar) {
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    public String toMonthYearString(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        Date time = calendar.getTime();
        return new SimpleDateFormat(MONTH_NAME_SPACE_4_DIGIT_YEAR_PATTERN).format(time);
    }

    public String formatTime(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(HH_MM_A);
        return localDateTime.format(dateTimeFormatter);
    }

    public String formatDayOfMonth(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DD);
        return localDateTime.format(dateTimeFormatter);
    }

    public String formatYear(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYY);
        return localDateTime.format(dateTimeFormatter);
    }

    public String formatMonth(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(MM);
        return localDateTime.format(dateTimeFormatter);
    }

    public String formatFull(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(MM_DD_YYYY_HH_MM_A);
        return localDateTime.format(dateTimeFormatter);
    }

    public String formatFullWithMonthAbbreviation(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(MMM_DD_YYYY_HH_MM_A);
        return localDateTime.format(dateTimeFormatter).toUpperCase();
    }
}
