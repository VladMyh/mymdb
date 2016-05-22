package com.app.controller;

import com.app.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = {"/mymdb"}, method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("mymdb");
        model.addObject("user", getPrincipal());

        return model;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String indexRedirect(){
        return "redirect:/mymdb";
    }

    @RequestMapping(value = "/mymdb/movies/search", params = {"query"}, method = RequestMethod.GET)
    public @ResponseBody ModelAndView test(@RequestParam(value = "query") String query){
        ModelAndView model = new ModelAndView("showMovies");
        model.addObject("title","MyMDB - Search");
        model.addObject("movies", movieService.searchMovies(query));
        model.addObject("user", getPrincipal());
        return model;
    }

    @RequestMapping(value = "/mymdb/movies", method = RequestMethod.GET)
    public ModelAndView allMovie(){
        ModelAndView model = new ModelAndView("showMovies");
        model.addObject("title", "MyMDB - Movies");
        model.addObject("movies", movieService.getAllMovies());
        return model;
    }

    @RequestMapping(value = "/mymdb/movies/view", params = {"id"}, method = RequestMethod.GET)
    public @ResponseBody ModelAndView viewMovie(@RequestParam(value = "id") String id){
        ModelAndView model = new ModelAndView("viewMovie");
        model.addObject("movie", movieService.getMovieById(id));

        return model;
    }

    @RequestMapping(value = "/mymdb/admin**", method = RequestMethod.GET)
    public String adminPage(){
        return "admin";
    }

    @RequestMapping(value = "/mymdb/user**", method = RequestMethod.GET)
    public String userPage(){
        return "user";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "error";
    }

    @RequestMapping(value = "/mymdb/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/mymdb/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/mymdb/login?logout";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
