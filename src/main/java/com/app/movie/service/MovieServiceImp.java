package com.app.movie.service;

import com.app.movie.Movie;
import com.app.movie.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public void deleteMovie(Long id) {

    }

    @Override
    public long getNumberOfFilms() {
        return 0;
    }

    @Override
    public Movie getMovieById(String id) {
        return movieDao.getMovieById(id);
    }
}
