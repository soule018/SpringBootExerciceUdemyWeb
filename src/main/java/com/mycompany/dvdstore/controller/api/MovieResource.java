package com.mycompany.dvdstore.controller.api;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie")
public class MovieResource {
    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }


    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieService.registerMovie(movie);

    }


    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id){
        return movieService.getMovieById(id);
    }

    @GetMapping
    public List<Movie> list(){
        return movieService.getMovieList();

    }
    }

