package Model;

import java.util.ArrayList;
import java.util.List;

public class Genero {

    private Long idGenero;
    private String nomeGenero;
    private List<Livro> livros = new ArrayList<>();

    public Genero() {
    }

    public Genero(String nomeGenero, List<Livro> livros) {
        this.nomeGenero = nomeGenero;
        this.livros = livros;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", nomeGenero='" + nomeGenero + '\'' +
                ", livros=" + livros +
                '}';
    }
}
