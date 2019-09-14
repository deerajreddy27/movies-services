package com.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcTemplateMovieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<Movie> findById(Long id){
        return jdbcTemplate.queryForObject(
                "select * from movie where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Movie(
                                rs.getString("title"),
                                rs.getString("language")
                        ))
        );
    }

    public List<Movie> findAll(){

        return jdbcTemplate.query(
                "select * from movie",
                (rs, rowNum) ->
                        new Movie(
                                rs.getString("title"),
                                rs.getString("language")
                        )
        );

    }

    public void deleteById(Long id){
        jdbcTemplate.update("delete from movie where id = ?", id);
    }

    public int insert(Movie movie){
        return jdbcTemplate.update("insert into movie (title,runtime) values (?,?)", movie.getTitle(), movie.getRuntime());
    }

    public void update(Movie movie){
        jdbcTemplate.update("update movie set title= ? where id = ? ", movie.getTitle(), movie.getId());
    }

    public Movie findByTitleAndLanguage(String title, String language){
        return jdbcTemplate.queryForObject(
                "select * from movie where title = ? and language = ?",
                new Object[]{title, language},
                (rs, rowNum) ->
                       (new Movie(
                                rs.getString("title"),
                                rs.getString("language"),
                                rs.getObject("year", LocalDate.class)

                        ))
        );
    }
}
