package com.app.director;

import java.util.ArrayList;

public interface DirectorDao {
    Director getDirectorById(Long id);
    void deleteDirectorById(Long id);
    ArrayList<Director> getAllDirectors();
    void addDirector(Director director);
}
