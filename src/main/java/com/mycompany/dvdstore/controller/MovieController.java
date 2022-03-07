package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }


    @PostMapping("/add")
    //en utilisant @ModelAttribut, spring va instancier Invoice et nous le fournir en entrée
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.registerMovie(movie);
        return "movie-added";
    }

        @GetMapping("/dvdstore-home")
        public String displayHome (Model model){
            System.out.println("Tentative d'affichage de l'a-propos");
            model.addAttribute("movies", movieService.getMovieList());
            return "dvdstore-home";
        }

        @GetMapping("/{id}")
        public String displayMovieCard ( @PathVariable("id") long id, Model model){
            System.out.println("La méthode displayMovieCard a été invoquée");
            model.addAttribute("movie", movieService.getMovieById(id));
            return "movie-details";

        }
    }

