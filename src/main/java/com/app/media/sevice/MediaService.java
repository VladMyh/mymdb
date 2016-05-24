package com.app.media.sevice;

import com.mongodb.DBObject;

import java.io.InputStream;

public interface MediaService {
    String uploadImage(InputStream stream, DBObject metadata);
}
