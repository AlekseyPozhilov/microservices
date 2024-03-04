package com.belhard.msvc_pozhilov.service;

import java.util.Map;

public interface SongService {
    public Map<String, String> extractMetaData(String filePath);
    public void saveMetaDataToDatabase(String filePath);
}
