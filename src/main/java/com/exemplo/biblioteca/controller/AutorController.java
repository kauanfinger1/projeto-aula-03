package com.exemplo.biblioteca.controller;

<<<<<<< HEAD
import java.util.List;

=======
import com.exemplo.biblioteca.model.Autor;
import com.exemplo.biblioteca.service.AutorService;
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PutMapping;
=======
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD

import com.exemplo.biblioteca.model.Autor;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.service.AutorService;
=======
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Autor buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor cadastrar(@RequestBody Autor autor) {
        return autorService.cadastrarAutor(autor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        autorService.removerAutor(id);
    }

    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id, @RequestBody Autor autor){
        return autorService.atualizarAutor(id, autor);
    }
<<<<<<< HEAD
    
    @GetMapping("/{id}/livros")
    public List<Livro> listarLivrosdoAutor(@PathVariable Long id){
        return autorService.listarLivrosdoAutor(id);
    }
=======
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611
}
