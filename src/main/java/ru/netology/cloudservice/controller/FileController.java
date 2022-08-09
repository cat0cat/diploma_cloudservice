package ru.netology.cloudservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.cloudservice.model.FileNameRequest;
import ru.netology.cloudservice.service.FileService;

@RestController
@AllArgsConstructor
@RequestMapping("/file")
public class FileController {

    private FileService service;

    @PostMapping()
    public ResponseEntity<?> uploadFile(@RequestHeader("auth-token") String authToken, @RequestParam("filename") String filename, MultipartFile file) {
        service.uploadFile(authToken, filename, file);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteFile(@RequestHeader("auth-token") String authToken, @RequestParam("filename") String filename) {
        service.deleteFile(authToken, filename);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> downloadFile(@RequestHeader("auth-token") String authToken, @RequestParam("filename") String filename) {
        service.deleteFile(authToken, filename);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editFileName(@RequestHeader("auth-token") String authToken, @RequestParam("filename") String filename, @RequestBody FileNameRequest fileNameRequest) {
        service.editFileName(authToken, filename, fileNameRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
