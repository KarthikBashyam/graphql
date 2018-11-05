package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
