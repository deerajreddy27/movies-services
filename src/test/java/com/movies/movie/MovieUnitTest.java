package com.movies.movie;

import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.*;

public class MovieUnitTest {

    @Test(expected = NullPointerException.class)
    public void whenTitleIsNull_ThenThrowNullPointerException(){
        Movie.of(null,"EN");
    }

    @Test(expected = NullPointerException.class)
    public void whenLanguageIsNull_ThenThrowNullPointerException(){
        Movie.of("XYZ",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTitleIsBlank_ThenThrowIllegalArgumentException(){
        Movie.of(" ","EN");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTitleIsEmplty_ThenThrowIllegalArgumentException(){
        Movie.of("","EN");
    }

    @Test
    public void testLocalDateTime(){
        LocalDate localDate = LocalDate.of(2019,9,18);
        LocalDateTime startOfTheDay= localDate.atStartOfDay();
        LocalDateTime startOfTheDay1= LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime endOfTheDay =startOfTheDay.plusDays(1).plusSeconds(-1);


        System.out.println(startOfTheDay1);
        System.out.println(endOfTheDay);
    }

    @Test
    public void whenTitleIsNotNull_ThenReturnTheSame() {
       Movie movie= Movie.of("title", "EN");
        assertThat(movie.getTitle()).isEqualTo("title");
    }

    @Test
    public void whenLanguageIsNotNull_ThenReturnTheSame(){
        Movie movie = Movie.of("title","EN");
        assertThat(movie.getLanguage()).isEqualTo("EN");

    }
}
