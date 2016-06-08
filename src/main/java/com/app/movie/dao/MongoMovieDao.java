package com.app.movie.dao;

import com.app.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
        Movie movie = new Movie();
		movie.setId(id);
        mongoOperation.remove(movie);
    }

    @Override
    public long getNumberOfFilms() {
        return mongoOperation.getCollection("movies").count();
    }

    @Override
    public Movie getMovieById(String id) {
        return mongoOperation.findOne(new Query(Criteria.where("_id").is(id)), Movie.class);
    }

    @Override
    public List<Movie> getPage(int pageNum, int pageSize, String searchQuery) {
		Pattern pattern = Pattern.compile(searchQuery, Pattern.CASE_INSENSITIVE);
		Pageable pageable = new PageRequest(pageNum, pageSize);
		Query query = new Query();
		query.with(pageable);
		query.addCriteria(Criteria.where("title").regex(pattern));

		return mongoOperation.find(query, Movie.class);
    }

    @Override
    public List<Movie> searchMovies(String name) {
        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        return mongoOperation.find(new Query(Criteria.where("title").regex(pattern)), Movie.class);
    }
}
