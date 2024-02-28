package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Movie;
import com.mycompany.spring_mvc_project_final.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/movie")
public class ViewController {
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showMovies(Model model){
        List<Movie> movieList = (List<Movie>) movieRepository.findAll();
        System.out.println(movieList.size());
        model.addAttribute("movieList", movieList);
        return "movie/MovieList";
    }
}
