package com.app.media.dao;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaDao {
    String uploadImage(MultipartFile file, DBObject metadata) throws IOException;
    GridFSDBFile getImageById(String id);

}
