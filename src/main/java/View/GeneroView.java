package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Model.Biblioteca;
import Model.Genero;

import java.util.List;
import java.util.Scanner;

public class GeneroView {

    Scanner input = new Scanner(System.in);
    GeneroController generoController = new GeneroController();

    public void cadastrarGenero(){

        Genero genero = new Genero();
        System.out.println("\nCADASTRO DE GENERO\n\n");

        System.out.println("Nome do  gênero: ");
        genero.setNomeGenero(input.nextLine());

        generoController.cadastrarGenero(genero);
        System.out.println("Genero > " + genero.getNomeGenero() + " < cadastrado!");
    }

    public void listarGeneros(){

        List<Genero> generos = generoController.listarGeneros();

        System.out.println();
        for (int i = 0; i < generos.size(); i++) {
            System.out.println("ID: " + generos.get(i).getIdGenero() + " | Nome da biblioteca: " + generos.get(i).getNomeGenero());
        }
        System.out.println();

    }
}
