package com.example.movie_service.entity;

import com.example.movie_service.domain.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    private Integer id;

    private String title;

    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
