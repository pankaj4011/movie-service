package com.example.movie_service.dto;

import com.example.movie_service.domain.Genre;

public record MovieDto(Integer id, String title, Integer releaseYear, Genre genre) {
}
