package com.app.media.dao;

import com.mongodb.DBObject;

import java.io.InputStream;
import java.util.Map;

public interface MediaDao {
    String uploadImage(InputStream stream, DBObject metadata);

}
