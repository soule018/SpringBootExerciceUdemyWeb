package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Scanner;

//@Controller
//@RequestMapping("/movie")
public class HomeController {
    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

   /*
    public void addUsingConsole(){
        Scanner sc=new Scanner(System.in);
        System.out.println( "what is the title of the movie ?" );
        String title=sc.nextLine();
        System.out.println("what is the genre of the movie to be added ?");
        String genre=sc.nextLine();
        Movie movie=new Movie();
        movie.setGenre(genre);
        movie.setTitle(title);
        movieService.registerMovie(movie);
    }*/

    @GetMapping("/dvdstore-home")
    public @ModelAttribute("movies") List<Movie> displayHome(){
        return movieService.getMovieList();
    }



    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute Movie movie){

    }

}



