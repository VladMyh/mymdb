package com.app.movie.service;

import com.app.movie.Movie;
import com.app.movie.dao.MovieDao;
import com.app.person.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getAllMovies(int pageNum, int pageSize) {
        return movieDao.getAllMovies(pageNum, pageSize);
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

    @Override
    public List<Movie> getLastFour() {
        return movieDao.getLastFour();
    }

    @Override
    public void addPersonToMovie(String movieId, String personId, JobTitle title) {
        movieDao.addPersonToMovie(movieId, personId, title);
    }

    @Override
    public void deletePersonToMovie(String movieId, String personId, JobTitle title) {
        movieDao.deletePersonToMovie(movieId, personId, title);
    }
}
