package com.movies.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.apache.commons.lang3.Validate;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Validation;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"id","runtime"})
public class Movie {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    private String language;
    private LocalDate year;
    private LocalDate releasedate;
    @NotBlank
    private String genre;
    private int runtime;

    private Movie(String title, String language) {
        this.title = title;
        this.language = language;
    }



    public static Movie of(String title, String language){
        Validate.notBlank(title);
        Validate.notNull(language);
        return new Movie(title,language);
    }

    public Movie(String title, String language, LocalDate releasedate) {
        Validate.notNull(title);
        validateReleaseDate(releasedate);
        this.title = title;
        this.language = language;
        this.releasedate = releasedate;
    }


    private void validateReleaseDate(LocalDate modifiedReleaseDate){
        LocalDate currentDate = LocalDate.now();
    }

    private void validateReleaseDate1(LocalDate modifiedReleaseDate){
        LocalDate currentDate = LocalDate.now();
    }


    private void validateReleaseDate2(LocalDate modifiedReleaseDate){
        LocalDate currentDate = LocalDate.now();
    }

    private void validateReleaseDat3(LocalDate modifiedReleaseDate){
        LocalDate currentDate = LocalDate.now();
    }
    @JsonIgnore
    public LocalDate getData(){
        return LocalDate.now();
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
