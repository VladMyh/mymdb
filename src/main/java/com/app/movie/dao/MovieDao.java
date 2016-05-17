package com.app.movie.dao;

import com.app.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public interface MovieDao {
    ArrayList<Movie> getAllMovies();
    Movie addOrUpdateMovie(Movie movie);
    void deleteMovie(String id);
    long getNumberOfFilms();
    Movie getMovieById(String id);
    List<Movie> getPage(int pageNunber, int itemsPerPage);
}
