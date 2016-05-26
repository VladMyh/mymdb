package com.app.media.dao;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Repository
public class MongoMediaDao implements MediaDao {

    @Autowired
    private GridFsOperations gridFsOperations;

    @Override
    public String uploadImage(MultipartFile file, DBObject metadata) throws IOException {
        return gridFsOperations.store(file.getInputStream(), metadata).getId().toString();
    }

    @Override
    public GridFSDBFile getImageById(String id) {
        return gridFsOperations.findOne(new Query(Criteria.where("_id").is(id)));
    }
}
