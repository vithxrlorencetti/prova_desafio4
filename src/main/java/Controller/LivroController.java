package Controller;

import DAO.LivroDAO;
import Model.Biblioteca;
import Model.Livro;

import java.util.List;

public class LivroController {

    LivroDAO livroDAO = new LivroDAO();

    public void cadastrarLivro(Livro livro){
        livroDAO.cadastrarLivro(livro);
    }

    public List<Livro> listarLivros(){
        return livroDAO.listarLivros();
    }

    public List<Livro> listarLivrosByGenero(Long idGenero){
        return livroDAO.listarLivrosByGenero(idGenero);
    }

    public List<Livro> listarLivrosByBiblioteca(Long idBiblioteca){
        return livroDAO.listarLivrosByBiblioteca(idBiblioteca);
    }

    public void deletarLivro(Livro livro){
        livroDAO.deletarLivro(livro);
    }

    public Livro getLivroById(Long idLivro){
        return livroDAO.getLivroById(idLivro);
    }

}
