package com.app.movie.dao;

import com.app.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MongoMovieDao implements MovieDao {

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public ArrayList<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie addOrUpdateMovie(Movie movie) {
        mongoOperation.save(movie);
        return movie;
    }

    @Override
    public void deleteMovie(String id) {
        mongoOperation.remove(id);
    }

    @Override
    public long getNumberOfFilms() {
        return mongoOperation.getCollection("movies").count();
    }

    @Override
    public Movie getMovieById(String id) {
        return mongoOperation.findOne(new Query(Criteria.where("_id").is(id)), Movie.class);
    }
}
