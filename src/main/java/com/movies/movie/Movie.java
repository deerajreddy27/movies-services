package com.movies.movie;

import lombok.*;
import org.apache.commons.lang3.Validate;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Validation;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String language;
    private LocalDate year;
    private LocalDate releasedate;
    private String genre;
    private int runtime;

    public Movie(String title, String language) {
        Validate.notBlank(title);
        Validate.notNull(title);
        Validate.notEmpty(title);
        Validate.notNull(language);
        this.title = title;
        this.language = language;
        //this.year = year;
    }

    public Movie(String title, String language, LocalDate year) {
        Validate.notNull(title);
        this.title = title;
        this.language = language;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", year=" + year +
                ", releasedate=" + releasedate +
                ", genre='" + genre + '\'' +
                ", runtime=" + runtime +
                '}';
    }
}
