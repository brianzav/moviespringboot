package com.br.senac.dw.filmregistration.repository;

import com.br.senac.dw.filmregistration.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
