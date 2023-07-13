package com.gvea.library.system_time;

import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DateTranslatorTest {

    private DateTranslator instanceUnderTest;
    private GregorianCalendar targetDate;

    @BeforeEach
    void setUp() {
        instanceUnderTest = new DateTranslator();
    }

    @Nested
    class For_July_23_2019 {
        @BeforeEach
        void setUp() {
            targetDate = new GregorianCalendar(2019, Calendar.JULY, 23);
        }

        @Test
        void yearString_should_be_2019() {
            String actualYearString = instanceUnderTest.toYearString(targetDate);
            assertThat(actualYearString).isEqualTo("2019");
        }

        @Test
        void monthYearString_should_be_July_2019() {
            String actualMonthYearString = instanceUnderTest.toMonthYearString(targetDate);
            assertThat(actualMonthYearString).isEqualTo("July 2019");
        }
    }

    @Nested
    class For_Feb_29_2020 {
        @BeforeEach
        void setUp() {
            targetDate = new GregorianCalendar(2020, Calendar.FEBRUARY, 29);
        }

        @Test
        void yearString_should_be_2019() {
            String actualYearString = instanceUnderTest.toYearString(targetDate);
            assertThat(actualYearString).isEqualTo("2020");
        }

        @Test
        void monthYearString_should_be_July_2019() {
            String actualMonthYearString = instanceUnderTest.toMonthYearString(targetDate);
            assertThat(actualMonthYearString).isEqualTo("February 2020");
        }
    }
}