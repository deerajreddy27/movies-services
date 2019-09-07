package com.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
