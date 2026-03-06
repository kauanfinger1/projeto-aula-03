package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.exemplo.biblioteca.model.Autor;

@Repository
public class BibliotecaRepository {

    private final AutorRepository autorRepository;
    private final List<Livro> livros = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public BibliotecaRepository(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;

        Autor machado = autorRepository.findById(3L).get();
        Autor orwell = autorRepository.findById(1L).get();

        Livro l1 = new Livro(null, "Dom Casmurro", machado, 1899, "9788535910663", true);
        Livro l2 = new Livro(null, "1984", orwell, 1949, "9788535914845", false);

        machado.getLivros().add(l1);
        orwell.getLivros().add(l2);

        save(l1);
        save(l2);
    }

    public Livro save(Livro livro) {
        if (livro.getId() == null) {
            livro.setId(sequence.incrementAndGet());
            livros.add(livro);
            return livro;
        }

        deleteById(livro.getId());
        livros.add(livro);
        return livro;
    }

    public List<Livro> findAll() {
        return new ArrayList<>(livros);
    }

    public Optional<Livro> findById(Long id) {
        return livros.stream()
                .filter(livro -> livro.getId().equals(id))
                .findFirst();
    }

    public List<Livro> findByTitulo(String titulo) {
        String termo = titulo.toLowerCase();
        return livros.stream()
                .filter(livro -> livro.getTitulo() != null && livro.getTitulo().toLowerCase().contains(termo))
                .toList();
    }

    public void deleteById(Long id) {
        livros.removeIf(livro -> livro.getId().equals(id));
    }
}
