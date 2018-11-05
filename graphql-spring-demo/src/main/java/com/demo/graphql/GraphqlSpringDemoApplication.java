package com.demo.graphql;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.entity.Movie;
import com.demo.repositories.MovieRepository;

@SpringBootApplication(scanBasePackages = "com.demo")
@EnableJpaRepositories(basePackages = "com.demo")
@EntityScan(basePackages = "com.demo")
public class GraphqlSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner loadMovies(MovieRepository repository) {
		return args -> {
			Stream.of("Signs", "Village", "Fargo").forEach(movie -> repository.save(new Movie(movie, 10L)));
			System.out.println("Loaded movies into databases");
			repository.findAll().forEach(movie -> System.out.println(movie.getName()));
		};
	}
}
