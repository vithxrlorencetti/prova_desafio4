package Controller;

import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import Model.Biblioteca;
import Model.Genero;

import java.util.List;

public class GeneroController {

    GeneroDAO generoDAO = new GeneroDAO();

    public void cadastrarGenero(Genero genero){
        generoDAO.cadastrarGenero(genero);
    }

    public List<Genero> listarGeneros(){
        return generoDAO.listarGeneros();
    }

    public void deletarGenero(Genero genero){
        generoDAO.deletarGenero(genero);
    }

    public void editarGenero(Genero genero){
        generoDAO.editarGenero(genero);
    }

    public Genero getGeneroById(Long idGenero){
        return generoDAO.getGeneroById(idGenero);
    }

}
