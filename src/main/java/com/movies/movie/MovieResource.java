package com.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/v2")
public class MovieResource {

    @Autowired
    private JdbcTemplateMovieRepository jdbcTemplateMovieRepository;

    @GetMapping("/findAll")
    public List<Movie> getMoviesList(){
        return jdbcTemplateMovieRepository.findAll();

    }

    @GetMapping("/findById/{id}")
    public Movie getById(@PathVariable("id") long id){
        Optional<Movie> movie= jdbcTemplateMovieRepository.findById(id);
        if(movie.isPresent()){
            return movie.get();
        }
        else{
            throw new IllegalArgumentException();
        }

    }
}
