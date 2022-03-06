package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Scanner;

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


    @RequestMapping("/dvdstore-home")
    public String displayHome(Model model){
        System.out.println("Tentative d'affichage de l'a-propos");
        model.addAttribute("movies",movieService.getMovieList());
        return "dvdstore-home";
    }

    @RequestMapping("/{id}")
    public String displayMovieCard(@PathVariable("/id") long id, Model model){
        System.out.println("La méthode displayMovieCard a été invoquée");
        model.addAttribute("movie",movieService.getMovieById(id));
        return "movie-details";

    }
}
