package com.app.media.sevice;

import com.app.media.dao.MediaDao;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class MediaServiceImp implements MediaService{

    @Autowired
    private MediaDao mediaDao;

    @Override
    public String uploadImage(MultipartFile file, DBObject metadata) throws IOException {
        return mediaDao.uploadImage(file, metadata);
    }

    @Override
    public GridFSDBFile getImageById(String id) {
        return mediaDao.getImageById(id);
    }
}
