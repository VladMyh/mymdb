package com.app.controller;

import com.app.media.sevice.MediaService;
import com.app.movie.Genre;
import com.app.movie.Movie;
import com.app.movie.service.MovieService;
import com.app.person.JobTitle;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MediaService mediaService;

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

    @RequestMapping(value = "/mymdb/movies/add", method = RequestMethod.GET)
    public String add(){
        return "addMovie";
    }

    @RequestMapping(value = "/mymdb/movies/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam(value = "title") String title,
                            @RequestParam(value = "releaseDate", required = false) Date releaseDate,
                            @RequestParam(value = "runtime", required = false) Integer runtime,
                            @RequestParam(value = "synopsis", required = false) String synopsis,
                            @RequestParam(value = "crew", required = false) Map<String, JobTitle> crew,
                            @RequestParam(value = "genres", required = false) List<Genre> genres,
                            @RequestParam(value = "image", required = false) MultipartFile image,
                            @RequestParam(value = "imageTitle", required = false) String imageTitle){
        Movie movie = new Movie();
        if(title != null)
            movie.setTitle(title);
        if(releaseDate != null)
            movie.setReleaseDate(releaseDate);
        if(runtime != null)
            movie.setRuntimeMinutes(runtime);
        if(synopsis != null)
            movie.setSynopsis(synopsis);
        if(crew != null)
            movie.setCrew(crew);
        if(genres != null)
            movie.setGenres(genres);

        List<String> images = new ArrayList<>();

        if(image != null) {
            DBObject metadata = new BasicDBObject();
            metadata.put("title", title);

            try {
                images.add(mediaService.uploadImage(image, metadata));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(images.size() > 0)
            movie.setImagesObjectIds(images);

        movie = movieService.addOrUpdateMovie(movie);

        ModelAndView model = new ModelAndView("addMovie");
        model.addObject("id", movie.getId());

        return model;
    }

    @RequestMapping(value = "/mymdb/media/upload", method = RequestMethod.GET)
    public String uploadImage(){
        return "uploadImage";
    }

    @RequestMapping(value = "/mymdb/media/upload", method = RequestMethod.POST)
    public @ResponseBody ModelAndView uploadImage(@RequestParam("file") MultipartFile file,
                                            @RequestParam("title") String title){
        String imageId = "";
        if(file != null) {
            DBObject metadata = new BasicDBObject();
            metadata.put("title", title);

            try {
                imageId = mediaService.uploadImage(file, metadata);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ModelAndView model = new ModelAndView("uploadImage");
        model.addObject("id", imageId);

        return model;
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
