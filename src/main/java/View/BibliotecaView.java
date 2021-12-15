package View;

import Controller.BibliotecaController;
import Model.Biblioteca;
import Model.Genero;

import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    Scanner input = new Scanner(System.in);
    BibliotecaController bibliotecaController = new BibliotecaController();


    public void cadastrarBiblioteca(){

        Biblioteca biblioteca = new Biblioteca();
        System.out.println("\nCADASTRO DE BIBLIOTECA\n\n");

        System.out.println("Nome da biblioteca: ");
        biblioteca.setNomeBiblioteca(input.nextLine());

        bibliotecaController.cadastrarBiblioteca(biblioteca);
        System.out.println("Biblioteca > " + biblioteca.getNomeBiblioteca() + " < cadastrada!");

    }

    public void listarBibliotecas(){

        List<Biblioteca> bibliotecas = bibliotecaController.listarBibliotecas();

        System.out.println();
        for (int i = 0; i < bibliotecas.size(); i++) {
            System.out.println("ID: " + bibliotecas.get(i).getIdBiblioteca() + " | Nome da biblioteca: " + bibliotecas.get(i).getNomeBiblioteca());
        }
        System.out.println();

    }

    public void deletarBiblioteca(){

        this.listarBibliotecas();
        System.out.println("ID da biblioteca que deseja deletar: ");
        Long idBiblioteca = input.nextLong();
        Biblioteca biblioteca = bibliotecaController.getBibliotecaById(idBiblioteca);

        System.out.println("Deletando biblioteca...");
        bibliotecaController.deletarBiblioteca(biblioteca);
        System.out.println("Biblioteca deletada!");

    }
}
