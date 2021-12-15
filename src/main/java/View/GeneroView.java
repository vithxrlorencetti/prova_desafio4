package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

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
            System.out.println("ID: " + generos.get(i).getIdGenero() + " | Nome do gênero: " + generos.get(i).getNomeGenero());
        }
        System.out.println();

    }

    public void editarGenero(){

        this.listarGeneros();
        System.out.println("ID do gênero que deseja editar:");
        Genero genero = generoController.getGeneroById(Long.parseLong(input.nextLine()));

        String aux;
        System.out.println("Novo nome do gênero: ");
        aux = input.nextLine();
        genero.setNomeGenero(aux);
        generoController.editarGenero(genero);

        System.out.println(genero);
        System.out.println("\nGenero editado: ID: " + genero.getIdGenero() + " | Nome do gênero: " + genero.getNomeGenero());
    }

    public void deletarGenero(){

        this.listarGeneros();
        System.out.println("ID do gênero que deseja deletar: ");
        Long idGenero = input.nextLong();
        Genero genero = generoController.getGeneroById(idGenero);

        System.out.println("Deletando gênero...");
        generoController.deletarGenero(genero);
        System.out.println("Gênero deletado!");

    }
}
