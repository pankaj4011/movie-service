package com.example.movie_service;

import com.example.movie_service.domain.Genre;
import com.example.movie_service.dto.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.util.List;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class MovieServiceApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testHealth(){
		var response = testRestTemplate.getForEntity("/actuator/health",Object.class);
		log.info("response {}",response.getBody());
		Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
	}

	@Test
	void allMovies() {
		var movies = getMovies("/api/movies");
		Assertions.assertEquals(6,movies.size());
	}

	@Test
	void allMoviesByGenre() {
		var movies = getMovies("/api/movies/ACTION");
		Assertions.assertEquals(3,movies.size());
		Assertions.assertTrue(movies.stream().map(MovieDto::genre).allMatch(Genre.ACTION::equals));
	}


	private List<MovieDto> getMovies(String uri){
		var requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(uri));
		var responseEntity =testRestTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<MovieDto>>() {
		});
		log.info("response {}",responseEntity.getBody());
		Assertions.assertNotNull(responseEntity.getBody());
		return responseEntity.getBody();
	}

}
