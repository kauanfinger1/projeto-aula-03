package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Autor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AutorRepository {

    private final List<Autor> autores = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public AutorRepository() {
        save(new Autor(null, "George Orwell", "Britânico", "1903-06-25"));
        save(new Autor(null, "J.K. Rowling", "Britânica", "1965-07-31"));
        save(new Autor(null, "Machado de Assis", "Brasileiro", "1839-06-21"));

        Autor orwell = findById(1L).get();
        Autor rowling = findById(2L).get();
        Autor machado = findById(3L).get();
    }

    public Autor save(Autor autor) {
        if (autor.getId() == null) {
            autor.setId(sequence.incrementAndGet());
            autores.add(autor);
            return autor;
        }

        deleteById(autor.getId());
        autores.add(autor);
        return autor;
    }

    public List<Autor> findAll() {
        return new ArrayList<>(autores);
    }

    public Optional<Autor> findById(Long id) {
        return autores.stream()
                .filter(autor -> autor.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        autores.removeIf(autor -> autor.getId().equals(id));
    }

    
}
