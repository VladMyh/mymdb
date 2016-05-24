package com.app.media.dao;

import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import java.io.InputStream;

@Repository
public class MongoMediaDao implements MediaDao {

    @Autowired
    private GridFsOperations gridFsOperations;

    @Override
    public String uploadImage(InputStream stream, DBObject metedata) {
        gridFsOperations.store(stream, metedata);

        return "";//TODO:return inserted image id
    }
}
