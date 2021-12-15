package Controller;

import DAO.BibliotecaDAO;
import Model.Biblioteca;

import java.util.List;

public class BibliotecaController {

    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();

    public void cadastrarBiblioteca(Biblioteca biblioteca){
        bibliotecaDAO.cadastrarBiblioteca(biblioteca);
    }

    public List<Biblioteca> listarBibliotecas(){
        return bibliotecaDAO.listarBibliotecas();
    }

    public void deletarBiblioteca(Biblioteca biblioteca){
        bibliotecaDAO.deletarBiblioteca(biblioteca);
    }

    public Biblioteca getBibliotecaById(Long idBiblioteca){
        return bibliotecaDAO.getBibliotecaById(idBiblioteca);
    }

}
