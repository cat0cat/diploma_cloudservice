package ru.netology.cloudservice.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.cloudservice.entity.Files;
import ru.netology.cloudservice.entity.User;

import java.util.List;

@Repository
public interface FileRepository  extends JpaRepository<Files, String> {

    Files findByUserAndFilename(User user, String filename);
    void deleteByUserAndFilename(User user, String filename);
    List<Files> findAllByUser(User user, Sort sort);

}
