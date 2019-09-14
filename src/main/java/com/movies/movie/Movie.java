package com.movies.movie;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String language;
    private LocalDate year;
    private LocalDate releasedate;
    private String genre;
    private int runtime;

    public Movie(String title, String language) {
        this.title = title;
        this.language = language;
        //this.year = year;
    }

    public Movie(String title, String language, LocalDate year) {
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
