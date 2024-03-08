package com.belhard.msvc_pozhilov.web;

import com.belhard.msvc_pozhilov.dto.SongDto;
import com.belhard.msvc_pozhilov.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
public class SongController {
    private final SongService songService;

    @PostMapping
    public ResponseEntity<Long> createSong(@RequestBody SongDto songDto) {
        songService.createSong(songDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDto> getSongById(@PathVariable Long id) {
        SongDto song = songService.getSongById(id);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSongs(@RequestParam List<Long> ids) {
        songService.deleteSongs(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
