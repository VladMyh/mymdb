package com.app.movie.service;

import com.app.movie.Movie;
import com.app.movie.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public ArrayList<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie addOrUpdateMovie(Movie movie) {
        return movieDao.addOrUpdateMovie(movie);
    }

    @Override
    public void deleteMovie(String id) {
        movieDao.deleteMovie(id);
    }

    @Override
    public long getNumberOfFilms() {
        return movieDao.getNumberOfFilms();
    }

    @Override
    public Movie getMovieById(String id) {
        return movieDao.getMovieById(id);
    }

    @Override
    public List<Movie> getPage(int pageNum, int pageSize, String searchQuery) {
        return movieDao.getPage(pageNum, pageSize, searchQuery);
    }

    @Override
    public List<Movie> searchMovies(String query) {
        return movieDao.searchMovies(query);
    }
}
