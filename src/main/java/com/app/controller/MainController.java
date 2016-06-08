package com.app.controller;

import com.app.media.sevice.MediaService;
import com.app.movie.Genre;
import com.app.movie.GenreForm;
import com.app.movie.Movie;
import com.app.movie.service.MovieService;
import com.app.person.JobTitle;
import com.app.person.Person;
import com.app.person.service.PersonService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
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
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private PersonService personService;

    @Autowired
    private MediaService mediaService;

	private static int searchPageSize = 6;

	@ModelAttribute("genreList")
	public List<String> genres(){
		return Stream.of(Genre.values()).map(Genre::name).collect(Collectors.toList());
	}

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

    @RequestMapping(value = "/mymdb/search", params = {"query"}, method = RequestMethod.GET)
    public @ResponseBody ModelAndView search(@RequestParam(value = "query") String query){
        ModelAndView model = new ModelAndView("search");
        model.addObject("movies", movieService.searchMovies(query).stream().limit(9).collect(Collectors.toList()));
		model.addObject("people", personService.search(query).stream().limit(9).collect(Collectors.toList()));
        model.addObject("user", getPrincipal());
		model.addObject("query", query);
        return model;
    }

	@RequestMapping(value = "/mymdb/people/search", method = RequestMethod.GET)
	public @ResponseBody ModelAndView searchPeople(@RequestParam(value = "query") String query,
												   @RequestParam(value = "page") Integer pageNum){
		ModelAndView model = new ModelAndView("showPeople");
		model.addObject("title","MyMDB - Search");
		model.addObject("people", personService.getPage(pageNum, searchPageSize, query));
		model.addObject("user", getPrincipal());
		model.addObject("pageNum", pageNum);
		model.addObject("pageSize", searchPageSize);
		return model;
	}

	@RequestMapping(value = "/mymdb/movies/search", method = RequestMethod.GET)
	public @ResponseBody ModelAndView searchMovies(@RequestParam(value = "query") String query,
												   @RequestParam(value = "page") Integer pageNum){
		ModelAndView model = new ModelAndView("showMovies");
		model.addObject("title","MyMDB - Search");
		model.addObject("movies", movieService.getPage(pageNum, searchPageSize, query));
		model.addObject("user", getPrincipal());
		model.addObject("pageNum", pageNum);
		model.addObject("pageSize", searchPageSize);

		return model;
	}

    @RequestMapping(value = "/mymdb/movies", method = RequestMethod.GET)
    public ModelAndView allMovies(@RequestParam(value = "page") Integer pageNum){
        ModelAndView model = new ModelAndView("showMovies");
        model.addObject("title", "MyMDB - All movies");
        model.addObject("movies", movieService.getAllMovies(pageNum, searchPageSize));
		model.addObject("pageNum", pageNum);
		model.addObject("pageSize", searchPageSize);
        return model;
    }

    @RequestMapping(value = "/mymdb/movies/{id}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView viewMovie(@PathVariable String id){
        ModelAndView model = new ModelAndView("viewMovie");
        model.addObject("movie", movieService.getMovieById(id));

        return model;
    }

    @RequestMapping(value = "/mymdb/movies/{id}/delete", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable(value = "id") String id){
		movieService.deleteMovie(id);
		return "mymdb";
	}

	@RequestMapping(value = "/mymdb/movies/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editMovie(@PathVariable(value = "id") String id){
		ModelAndView model = new ModelAndView("editMovie");
		Movie movie = movieService.getMovieById(id);
		model.addObject("movie", movie);
		model.addObject("genreForm", new GenreForm());

		return model;
	}

    @RequestMapping(value = "/mymdb/movies/add", method = RequestMethod.GET)
    public ModelAndView addOrUpdateMovie(){
		ModelAndView model = new ModelAndView("addMovie");
		model.addObject("genreForm", new GenreForm());

        return model;
    }

    @RequestMapping(value = {"/mymdb/movies/add", "/mymdb/movies/update"}, method = RequestMethod.POST)
    public String addOrUpdateMovie(@RequestParam(value = "id", required = false) String id,
								   @RequestParam(value = "title") String title,
								   @RequestParam(value = "releaseDate", required = false)
									   @DateTimeFormat(pattern = "yyyy-MM-dd") Date releaseDate,
								   @RequestParam(value = "runtime", required = false) Integer runtime,
								   @RequestParam(value = "synopsis", required = false) String synopsis,
								   @RequestParam(value = "crew", required = false) Map<String, JobTitle> crew,
								   @RequestParam(value = "image", required = false) MultipartFile image,
								   @RequestParam(value = "imageTitle", required = false) String imageTitle,
								   @ModelAttribute("genreForm") GenreForm genreForm){
        Movie movie = new Movie();
		String result;
		if(id != null) {
			movie = movieService.getMovieById(id);
			result = "redirect:/mymdb/movies/" + id;
		}
		else
			result = "addMovie";
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
        if(genreForm.getGenres() != null) {
			List<Genre> genreSet = genreForm.getGenres().stream().map(Genre::valueOf).collect(Collectors.toList());
			movie.setGenres(genreSet);
		}
		if(!image.isEmpty())
        	movie.setImagesObjectIds(uploadImage(image, imageTitle));

        movieService.addOrUpdateMovie(movie);
        return result;
    }

    @RequestMapping(value = "/mymdb/people/add", method = RequestMethod.GET)
    public String addPerson(){
        return "addPerson";
    }

    @RequestMapping(value = {"/mymdb/people/add", "/mymdb/people/update"}, method = RequestMethod.POST)
    public String addPerson(@RequestParam(value = "id", required = false) String id,
							@RequestParam(value = "name") String name,
                            @RequestParam(value = "dateOfBirth", required = false)
								@DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                            @RequestParam(value = "description", required = false) String description,
                            @RequestParam(value = "image", required = false) MultipartFile image,
                            @RequestParam(value = "imageTitle", required = false) String imageTitle){
        Person person = new Person();
		String result;
		if(id != null) {
			person = personService.getPersonById(id);
			result = "redirect:/mymdb/people/" + id;
		}
		else
			result = "addPerson";
        if(name != null)
            person.setName(name);
        if(dateOfBirth != null)
            person.setDateOfBirth(dateOfBirth);
        if(description != null)
            person.setDescription(description);
		if(!image.isEmpty())
        	person.setImagesObjectIds(uploadImage(image, imageTitle));

        personService.addOrUpdatePerson(person);
        return result;
    }

	@RequestMapping(value = "/mymdb/people", method = RequestMethod.GET)
	public ModelAndView allPeople(@RequestParam(value = "page") Integer pageNum){
		ModelAndView model = new ModelAndView("showPeople");
		model.addObject("title", "MyMDB - All people");
		model.addObject("people", personService.getAllMovies(pageNum, searchPageSize));
		model.addObject("pageNum", pageNum);
		model.addObject("pageSize", searchPageSize);
		return model;
	}

	@RequestMapping(value = "/mymdb/people/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView viewPerson(@PathVariable String id){
		ModelAndView model = new ModelAndView("viewPerson");
		model.addObject("person", personService.getPersonById(id));

		return model;
	}

	@RequestMapping(value = "/mymdb/people/{id}/delete", method = RequestMethod.GET)
	public String deletePerson(@PathVariable(value = "id") String id){
		personService.deletePerson(id);
		return "mymdb";
	}

	@RequestMapping(value = "/mymdb/people/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPerson(@PathVariable(value = "id") String id){
		ModelAndView model = new ModelAndView("editPerson");
		model.addObject("person", personService.getPersonById(id));

		return model;
	}

    @RequestMapping(value = "/mymdb/media/get", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageById(@RequestParam("id") String id){
        try {
            return IOUtils.toByteArray(mediaService.getImageById(id).getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

	public String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

    private List<String> uploadImage(MultipartFile image, String imageTitle){
        if(!image.isEmpty()) {
            List<String> images = new ArrayList<>();
            DBObject metadata = new BasicDBObject();
            metadata.put("title", imageTitle);

            try {
                images.add(mediaService.uploadImage(image, metadata));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (images.size() > 0)
                return images;
        }
        return null;
    }
}