package com.app.controller;

import com.app.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = {"/mymdb"}, method = RequestMethod.GET)
    public String index(){



        return "index";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String indexRedirect(){
        return "redirect:mymdb";
    }

    @RequestMapping(value = "/mymdb/error", method = RequestMethod.GET)
    public String error(){
        return "error";
    }

    @RequestMapping(value = "/mymdb/test", params = {"query"}, method = RequestMethod.GET)
    public @ResponseBody ModelAndView test(@RequestParam(value = "query") String query){
        ModelAndView model = new ModelAndView("index");
        model.addObject("movies", movieService.searchMovies(query));
        return model;
    }
}
