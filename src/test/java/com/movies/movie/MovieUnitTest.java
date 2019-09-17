package com.movies.movie;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class MovieUnitTest {

    @Test(expected = NullPointerException.class)
    public void whenTitleIsNull_ThenThrowNullPointerException(){
        Movie movie = new Movie(null,"EN");

    }

    @Test(expected = NullPointerException.class)
    public void whenLanguageIsNull_ThenThrowNullPointerException(){
        Movie movie = new Movie("XYZ",null);

    }

    @Test
    public void whenTitleIsNotNull_ThenReturnTheSame() {
        Movie movie = new Movie("title", "EN");
        assertThat(movie.getTitle()).isEqualTo("title");
    }

    @Test
    public void whenLanguageIsNotNull_ThenReturnTheSame(){
        Movie movie = new Movie("title","EN");
        assertThat(movie.getLanguage()).isEqualTo("EN");

    }
}
