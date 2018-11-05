package com.demo.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.entity.Movie;
import com.demo.repositories.MovieRepository;

@Component
public class Query implements GraphQLQueryResolver {

	private MovieRepository movieRepository;

	@Autowired
	public Query(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<Movie> movies() {
		return movieRepository.findAll();

	}

}
