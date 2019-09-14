package com.movies.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie  findByTitleAndLanguage(@Param("title") String title, @Param("language") String language);
}
