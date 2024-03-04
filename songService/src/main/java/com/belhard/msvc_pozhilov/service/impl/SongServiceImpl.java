package com.belhard.msvc_pozhilov.service.impl;

import com.belhard.msvc_pozhilov.data.entity.SongEntity;
import com.belhard.msvc_pozhilov.data.repository.SongRepository;
import com.belhard.msvc_pozhilov.service.MyMapper;
import com.belhard.msvc_pozhilov.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final MyMapper myMapper;

    @Override
    public Map<String, String> extractMetaData(String filePath) {
        Map<String, String> metadataMap = new HashMap<>();

        try (InputStream stream = new FileInputStream(filePath)) {
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            ParseContext context = new ParseContext();

            parser.parse(stream, handler, metadata, context);

            metadataMap.put("title", metadata.get("title"));
            metadataMap.put("artist", metadata.get("xmpDM:artist"));
            metadataMap.put("album", metadata.get("xmpDM:album"));
            metadataMap.put("length", metadata.get("xmpDM:duration"));
            metadataMap.put("year", metadata.get("xmpDM:year"));


        } catch (Exception e) {
            log.error("Error extracting metadata from file: " + e.getMessage());
        }

        return metadataMap;
    }

    @Override
    public void saveMetaDataToDatabase(String filePath) {
        Map<String, String> metadataMap = extractMetaData(filePath);

        SongEntity songEntity = new SongEntity();
        songEntity.setTitle(metadataMap.get("title"));
        songEntity.setArtist(metadataMap.get("artist"));
        songEntity.setAlbum(metadataMap.get("album"));
        songEntity.setLength(Integer.valueOf(metadataMap.get("length")));
        songEntity.setResourceID(Integer.valueOf(metadataMap.get("resourceID")));
        songEntity.setYear(Integer.valueOf(metadataMap.get("year")));


        songRepository.save(songEntity);
    }
}
