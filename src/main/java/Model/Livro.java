package Model;

public class Livro {

    private Long idLivro;
    private String nomeLivro;
    private Genero generoLivro;
    private Biblioteca bibliotecaLivro;

    public Livro() {
    }

    public Livro(String nomeLivro, Genero generoLivro, Biblioteca bibliotecaLivro) {
        this.nomeLivro = nomeLivro;
        this.generoLivro = generoLivro;
        this.bibliotecaLivro = bibliotecaLivro;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Genero getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(Genero generoLivro) {
        this.generoLivro = generoLivro;
    }

    public Biblioteca getBibliotecaLivro() {
        return bibliotecaLivro;
    }

    public void setBibliotecaLivro(Biblioteca bibliotecaLivro) {
        this.bibliotecaLivro = bibliotecaLivro;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", generoLivro=" + generoLivro +
                ", bibliotecaLivro=" + bibliotecaLivro +
                '}';
    }
}
