package com.app.mobile.file.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;





import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
public class FileController {

    @Value("${upload.directory}") // Assuming you have configured this in application.properties
    private String uploadDirectory;

    private static final List<String> ALLOWED_FILE_EXTENSIONS = Arrays.asList("jpg", "jpeg", "png", "gif");
    private static final long MAX_FILE_SIZE = 5242880; // 5 MB in bytes

    @PostMapping("/api/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Check if the file is empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Please upload a file");
            }

            // Check file size
            if (file.getSize() > MAX_FILE_SIZE) {
                return ResponseEntity.badRequest().body("File size exceeds the limit of 5MB");
            }

            // Get file extension
            String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

            // Check file extension
            if (!ALLOWED_FILE_EXTENSIONS.contains(fileExtension.toLowerCase())) {
                return ResponseEntity.badRequest().body("Unsupported file type. Allowed types are: jpg, jpeg, png, gif");
            }

            // Normalize file name
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Copy file to the target location
            Path targetLocation = Paths.get(uploadDirectory).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);

            // Generate URL for the uploaded file
            String fileUrl = "http://yourdomain.com/uploads/" + fileName; // Replace with your actual domain

            return ResponseEntity.ok().body(fileUrl);
        } catch (IOException ex) {
            return ResponseEntity.status(500).body("Failed to upload file");
        }
    }

    @GetMapping("/api/files/{fileName:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        try {
            // Load file as Resource
            Path filePath = Paths.get(uploadDirectory).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            // Check if file exists
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
}
