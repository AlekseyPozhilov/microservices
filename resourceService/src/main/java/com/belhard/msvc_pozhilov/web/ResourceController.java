package com.belhard.msvc_pozhilov.web;

import com.belhard.msvc_pozhilov.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ResourceController {
    private final ResourceService resourceService;

    @PostMapping
    public ResponseEntity<?> uploadResource(@RequestParam("file") MultipartFile file) {
        resourceService.uploadResource(file);
        log.info("Resource uploaded successfully");
        return ResponseEntity.ok().body("{\"message\": \"Resource uploaded successfully\"}");
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getAudioData(@PathVariable Long id) {
        byte[] audioData = resourceService.getAudioData(id);
        log.info("Retrieved audio data for ID: {}", id);
        return ResponseEntity.ok().body(audioData);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteResources(@RequestParam("id") String ids) {
        resourceService.deleteResources(ids);
        log.info("Resources deleted successfully");
        return ResponseEntity.ok().body("{\"message\": \"Resources deleted successfully\"}");
    }
}
