package com.app.media.sevice;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface MediaService {
    String uploadImage(MultipartFile file, DBObject metadata) throws IOException;
    GridFSDBFile getImageById(String id);
}
