package com.bbs.myBbs.repository;

import com.bbs.myBbs.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = { "boards" })
    List<User> findAll();

    User findByUsername(String username);
}
