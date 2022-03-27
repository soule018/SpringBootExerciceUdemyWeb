package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results) {

        if (results.hasErrors()){
            return "add-movie-form";
        }
        Movie movie=new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";
    }

    @GetMapping("/dvdstore-home")
    //on retourne un string qui sera l'id de la page
    public String displayHome(Model model){
        System.out.println("Tentative d'affichage de l'a-propos");
        model.addAttribute("movies",movieService.getMovieList());
        return "dvdstore-home";
    }

    @GetMapping("/create-form")
    //méthode permettant l'affichage de mon formulaire
    public String displayInvoiceCreateForm(@ModelAttribute MovieForm movie){
        return "add-movie-form";
    }

}

    /*@GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") long id, Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "movie-details";
    }*/


