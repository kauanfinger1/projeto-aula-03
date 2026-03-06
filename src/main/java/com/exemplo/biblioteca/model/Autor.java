package com.exemplo.biblioteca.model;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611
public class Autor {

    private Long id;
    private String nome;
    private String nacionalidade;
    private String dataNascimento;

<<<<<<< HEAD
    private List<Livro> livros = new ArrayList<>();

=======
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611
    public Autor() {
    }

    public Autor(Long id, String nome, String nacionalidade, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
<<<<<<< HEAD

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
=======
}
>>>>>>> 873cf8af20d888d671d7f3344a84856c52410611
