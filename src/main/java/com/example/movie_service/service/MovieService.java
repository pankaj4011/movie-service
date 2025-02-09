package com.example.movie_service.service;

import com.example.movie_service.domain.Genre;
import com.example.movie_service.dto.MovieDto;
import com.example.movie_service.mapper.EntityDtoMapper;
import com.example.movie_service.repository.MovieReposiitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieReposiitory movieReposiitory;

    public MovieService(MovieReposiitory movieReposiitory){
        this.movieReposiitory = movieReposiitory;
    }


    public List<MovieDto> getAll(){
       return movieReposiitory.findAll().stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

    public List<MovieDto> getAll(Genre genre){
        return movieReposiitory.findByGenre(genre)
                .stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }
}
