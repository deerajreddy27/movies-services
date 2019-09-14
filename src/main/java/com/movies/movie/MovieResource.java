package com.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
      jdbcTemplateMovieRepository.deleteById(id);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Movie movie) {
        return jdbcTemplateMovieRepository.insert(movie);
    }

    @PutMapping("/update")
    public void update(@RequestBody Movie movie) {
        jdbcTemplateMovieRepository.update(movie);
    }

    @GetMapping("/findByTitleAndLanguage")
    public Movie getByTitleAndLanguage(@RequestParam("title") String title, @RequestParam("language") String language){
       return jdbcTemplateMovieRepository.findByTitleAndLanguage(title, language);

    }
}
