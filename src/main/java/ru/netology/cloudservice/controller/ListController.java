package ru.netology.cloudservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.cloudservice.model.FileResponse;
import ru.netology.cloudservice.service.FileService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/list")
public class ListController {

    private final FileService service;

    @GetMapping
    List<FileResponse> getAllFiles(@RequestHeader("auth-token") String authToken, @RequestParam("limit") Integer limit) {
        return service.getAllFiles(authToken, limit);
    }
}
