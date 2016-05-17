package com.app.controller;

import com.app.movie.Genre;
import com.app.movie.Movie;
import com.app.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

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

    @RequestMapping(value = "/mymdb/test", method = RequestMethod.GET)
    public String test(){
        return "test";
    }
}
