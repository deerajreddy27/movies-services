package com.movies.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor
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
