package com.app.movie.dao;

import com.app.movie.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovies(int pageNum, int pageSize);
    Movie addOrUpdateMovie(Movie movie);
    void deleteMovie(String id);
    long getNumberOfFilms();
    Movie getMovieById(String id);
    List<Movie> getPage(int pageNum, int pageSize, String searchQuery);
    List<Movie> searchMovies(String query);

    //TODO: finish paging method
}
