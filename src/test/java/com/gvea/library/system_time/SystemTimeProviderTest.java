package com.gvea.library.system_time;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SystemTimeProviderTest {
    CurrentTimeInMillisProvider currentTImeinMillisProvider;
    SystemTimeProvider instanceUnderTest;

    private CurrentTimeInMillisProvider createCurrentTimeInMillisProviderSetTo(int year, int month, int dayOfMonth) {
        return new CurrentTimeInMillisProvider() {
            @Override
            public long currentTimeMillis() {
                return new GregorianCalendar(year, month, dayOfMonth).getTimeInMillis();
            }
        };
    }

    @Nested
    class For_July_23_2019 {
        @BeforeEach
        void setUp() {
            currentTImeinMillisProvider = createCurrentTimeInMillisProviderSetTo(2019, Calendar.JULY, 23);
            instanceUnderTest = new SystemTimeProvider(currentTImeinMillisProvider);
        }


        @Test
        void getCurrentDate() {
            //noinspection deprecation
            assertThat(instanceUnderTest.getCurrentDate()).isEqualTo(new Date(2019 - 1900, Calendar.JULY, 23));
        }

        @Test
        void getCurrentCalendar() {
            assertThat(instanceUnderTest.getCurrentCalendar()).isEqualTo(new GregorianCalendar(2019,
                    Calendar.JULY,
                    23));
        }

        @Test
        void getCurrentTimeMillis() {
            assertThat(instanceUnderTest.getCurrentTimeMillis()).isEqualTo(new GregorianCalendar(2019,
                    Calendar.JULY,
                    23).getTimeInMillis());
        }

        @Test
        void getCurrentLocalDateTime() {
            assertThat(instanceUnderTest.getCurrentLocalDateTime()).isEqualTo(LocalDateTime.of(2019, 7, 23, 0, 0));
        }
    }

    @Nested
    class For_Feb_29_2020 {
        @BeforeEach
        void setUp() {
            currentTImeinMillisProvider = createCurrentTimeInMillisProviderSetTo(2020, Calendar.FEBRUARY, 29);
            instanceUnderTest = new SystemTimeProvider(currentTImeinMillisProvider);
        }


        @Test
        void getCurrentDate() {
            //noinspection deprecation
            assertThat(instanceUnderTest.getCurrentDate()).isEqualTo(new Date(2020 - 1900, Calendar.FEBRUARY, 29));
        }

        @Test
        void getCurrentCalendar() {
            assertThat(instanceUnderTest.getCurrentCalendar()).isEqualTo(new GregorianCalendar(2020,
                    Calendar.FEBRUARY,
                    29));
        }

        @Test
        void getCurrentTimeMillis() {
            assertThat(instanceUnderTest.getCurrentTimeMillis()).isEqualTo(new GregorianCalendar(2020,
                    Calendar.FEBRUARY,
                    29).getTimeInMillis());
        }

        @Test
        void getCurrentLocalDateTime() {
            assertThat(instanceUnderTest.getCurrentLocalDateTime()).isEqualTo(LocalDateTime.of(2020, 2, 29, 0, 0));
        }
    }
}