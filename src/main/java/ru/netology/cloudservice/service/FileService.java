package ru.netology.cloudservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.cloudservice.entity.File;
import ru.netology.cloudservice.model.FileNameRequest;
import ru.netology.cloudservice.repository.FileRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FileService {

    FileRepository fileRepository;

    public void uploadFile(String authToken, String filename, MultipartFile file) {
    }

    public void deleteFile(String authToken, String filename) {
    }

    public void editFileName(String authToken, String filename, FileNameRequest editFileNameRQ) {
    }

    public List<File> getAllFiles(String authToken, Integer limit) {
        return null;
    }
}
