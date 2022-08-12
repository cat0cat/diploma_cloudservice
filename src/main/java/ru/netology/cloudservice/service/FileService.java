package ru.netology.cloudservice.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.cloudservice.entity.Files;
import ru.netology.cloudservice.entity.User;
import ru.netology.cloudservice.exceptions.InputDataException;
import ru.netology.cloudservice.exceptions.UnauthorizedException;
import ru.netology.cloudservice.model.FileNameRequest;
import ru.netology.cloudservice.model.FileResponse;
import ru.netology.cloudservice.repository.AuthorizationRepository;
import ru.netology.cloudservice.repository.FileRepository;
import ru.netology.cloudservice.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FileService {

    FileRepository fileRepository;
    AuthorizationRepository authorizationRepository;
    UserRepository userRepository;

    public void uploadFile(String authToken, String filename, MultipartFile file) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        fileRepository.save(new Files(filename, LocalDateTime.now(), file.getSize(), user));
    }

    public void deleteFile(String authToken, String filename) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        fileRepository.deleteByUserAndFilename(user, filename);
    }

    public void editFileName(String authToken, String filename, FileNameRequest fileNameRequest) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        if (fileNameRequest.getFileName() != null) {
            Files editFile = fileRepository.findByUserAndFilename(user, filename);
            editFile.setFilename(fileNameRequest.getFileName());
            fileRepository.save(fileRepository.findByUserAndFilename(user, editFile.getFilename()));
        } else {
            throw new InputDataException("Error input data");
        }
    }

    public List<FileResponse> getAllFiles(String authToken, Integer limit) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedException("Unauthorized error");
        }
        return fileRepository.findAllByUser(user, Sort.by("filename")).stream()
                .map(f -> new FileResponse(f.getFilename(), f.getSize()))
                .collect(Collectors.toList());
    }

    private User getUser(String authToken) {
        final String username = authorizationRepository.getUserNameByToken(authToken);
            return userRepository.findByLogin(username)
                    .orElseThrow(() -> new UnauthorizedException("Unauthorized error"));
    }

}
