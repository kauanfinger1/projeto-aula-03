package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Autor;
import com.exemplo.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
<<<<<<< HEAD
import com.exemplo.biblioteca.model.Livro;
=======
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor cadastrarAutor(Autor autor) {
        if (autor.getNome() == null || autor.getNome().isBlank()) {
            throw new ResponseStatusException(BAD_REQUEST, "Nome do autor não pode ser vazio");
        }
        return autorRepository.save(autor);
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Autor não encontrado"));
    }

    public void removerAutor(Long id) {
        buscarPorId(id);
        autorRepository.deleteById(id);
    }

    public Autor atualizarAutor(Long id, Autor autorAtualizado) {
        Autor autorExistente = buscarPorId(id);
        autorExistente.setNome(autorAtualizado.getNome());
        autorExistente.setNacionalidade(autorAtualizado.getNacionalidade());
        autorExistente.setDataNascimento(autorAtualizado.getDataNascimento());
        return autorRepository.save(autorExistente);
    }
<<<<<<< HEAD

    public List<Livro>
    listarLivrosdoAutor(Long id){
        Autor autor = buscarPorId(id);
        return autor.getLivros();
    }
=======
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611
}
