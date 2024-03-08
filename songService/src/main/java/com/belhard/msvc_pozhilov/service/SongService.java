package com.belhard.msvc_pozhilov.service;

import com.belhard.msvc_pozhilov.dto.SongDto;

import java.util.List;
import java.util.Map;

public interface SongService {
    public Map<String, String> extractMetaData(String filePath);
    public void saveMetaDataToDatabase(String filePath);
    public void createSong(SongDto songDto);
    public SongDto getSongById(Long id);
    public void deleteSongs(List<Long> ids);
}
