package com.br.senac.dw.filmregistration.controller;

import com.br.senac.dw.filmregistration.model.MovieModel;
import com.br.senac.dw.filmregistration.repository.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/filmes")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String listMovies(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "movies/listMovies";
    }

    @GetMapping("/novo")
    public String formMovies(Model model){
        model.addAttribute("movie", new MovieModel());
        return "movies/formMovies";
    }

    @PostMapping("/salvar")
    public String saveMovie(@Valid @ModelAttribute("movie") MovieModel movie, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "movies/formMovies";
        }
        movieRepository.save(movie);
        redirectAttributes.addFlashAttribute("successMessage", "Filme incluído com sucesso");
        return "redirect:/filmes";
    }
}
