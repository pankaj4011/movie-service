package com.example.movie_service.repository;

import com.example.movie_service.domain.Genre;
import com.example.movie_service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieReposiitory extends JpaRepository<Movie,Integer> {
    List<Movie> findByGenre(Genre genre);
}
