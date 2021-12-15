package Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private Long idBiblioteca;
    private String nomeBiblioteca;
    private List<Livro> livrosBiblioteca = new ArrayList<>();

    public Biblioteca() {
    }

    public Biblioteca(String nomeBiblioteca, List<Livro> livros) {
        this.nomeBiblioteca = nomeBiblioteca;
        this.livrosBiblioteca = livros;
    }

    public Long getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Long idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public List<Livro> getLivros() {
        return livrosBiblioteca;
    }

    public void setLivros(List<Livro> livros) {
        this.livrosBiblioteca = livros;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca=" + idBiblioteca +
                ", nomeBiblioteca='" + nomeBiblioteca + '\'' +
                ", livrosBiblioteca=" + livrosBiblioteca +
                '}';
    }
}
