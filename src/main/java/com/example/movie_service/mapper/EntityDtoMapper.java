package com.example.movie_service.mapper;

import com.example.movie_service.dto.MovieDto;
import com.example.movie_service.entity.Movie;
import org.springframework.beans.BeanUtils;

public class EntityDtoMapper {

    public static MovieDto toDto(Movie movie){
        return new MovieDto(movie.getId(),movie.getTitle(),movie.getReleaseYear(),movie.getGenre());
    }
}
