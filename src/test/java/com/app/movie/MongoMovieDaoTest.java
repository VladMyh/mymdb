package com.app.movie;

import com.app.movie.dao.MongoMovieDao;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
public class MongoMovieDaoTest {

    private static Movie testMovie;

    @BeforeClass
    public static void setup(){
        testMovie = new Movie();
        testMovie.setTitle("Movie1");
        testMovie.setRuntimeMinutes(130);
        testMovie.setSynopsis("bla bla bla");

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.YEAR, 2014);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        Date releaseDate = calendar.getTime();
        testMovie.setReleaseDate(releaseDate);

    }

    @Test
    public void testAddMovie(){
        MongoMovieDao mongoMovieDao = new MongoMovieDao();

        Movie test = mongoMovieDao.addMovie(testMovie);

        Assert.assertNotNull(test.getId());
    }
}
