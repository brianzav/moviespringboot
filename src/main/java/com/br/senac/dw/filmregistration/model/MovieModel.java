package com.br.senac.dw.filmregistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "não deve estar em branco")
    @Size(min = 1, max = 100)
    private String title;

    @NotBlank(message = "não deve estar em branco")
    @Size(min = 1, max = 50)
    private String genre;

    @NotNull(message = "não deve ser nulo")
    private Integer releaseYear;
}
