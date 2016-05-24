package com.app.media.sevice;

import com.app.media.dao.MediaDao;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class MediaServiceImp implements MediaService{

    @Autowired
    private MediaDao mediaDao;

    @Override
    public String uploadImage(InputStream stream, DBObject metadata) {
        return null;
    }
}
