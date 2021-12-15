package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.List;
import java.util.Scanner;

public class LivroView {

    Scanner input = new Scanner(System.in);
    LivroController livroController = new LivroController();


    public void cadastrarLivro(){

        Livro livro = new Livro();
        System.out.println("\nCADASTRO DE LIVRO\n\n");
        System.out.println("Nome do livro: ");
        livro.setNomeLivro(input.nextLine());
        input.nextLine();

        System.out.println("ID do gênero do livro: ");
        GeneroView generoView = new GeneroView();
        GeneroController generoController = new GeneroController();
        generoView.listarGeneros();
        Genero genero = generoController.getGeneroById(input.nextLong());
        livro.setGeneroLivro(genero);

        System.out.println("ID da biblioteca do livro: ");
        BibliotecaView bibliotecaView = new BibliotecaView();
        BibliotecaController bibliotecaController = new BibliotecaController();
        bibliotecaView.listarBibliotecas();
        Biblioteca biblioteca = bibliotecaController.getBibliotecaById(input.nextLong());
        livro.setBibliotecaLivro(biblioteca);

        livroController.cadastrarLivro(livro);

        System.out.println("Livro > " + livro.getNomeLivro() + " < cadastrado!");
    }

    public void listarLivros(){

        List<Livro> livros = livroController.listarLivros();

        System.out.println();
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("ID: " + livros.get(i).getIdLivro() +
                               " | Nome do livro: " + livros.get(i).getNomeLivro() +
                               " | Gênero: " + livros.get(i).getGeneroLivro().getNomeGenero() +
                               " | Biblioteca: " + livros.get(i).getBibliotecaLivro().getNomeBiblioteca());
        }
        System.out.println();

    }

    public void listarLivrosByGenero(){

        GeneroView generoView = new GeneroView();
        generoView.listarGeneros();
        System.out.println("ID do gênero que deseja acessar: ");
        List<Livro> livrosByGenero = livroController.listarLivrosByGenero(input.nextLong());

        System.out.println();
        for (int i = 0; i < livrosByGenero.size(); i++) {
            System.out.println("ID: " + livrosByGenero.get(i).getIdLivro() +
                    " | Nome do livro: " + livrosByGenero.get(i).getNomeLivro() +
                    " | Gênero: " + livrosByGenero.get(i).getGeneroLivro().getNomeGenero() +
                    " | Biblioteca: " + livrosByGenero.get(i).getBibliotecaLivro().getNomeBiblioteca());
        }
        System.out.println();

    }

    public void listarLivrosByBiblioteca(){

        BibliotecaView bibliotecaView = new BibliotecaView();
        bibliotecaView.listarBibliotecas();
        System.out.println("ID da biblioteca que deseja acessar: ");
        List<Livro> livrosByBiblioteca = livroController.listarLivrosByBiblioteca(input.nextLong());

        System.out.println();
        for (int i = 0; i < livrosByBiblioteca.size(); i++) {
            System.out.println("ID: " + livrosByBiblioteca.get(i).getIdLivro() +
                    " | Nome do livro: " + livrosByBiblioteca.get(i).getNomeLivro() +
                    " | Gênero: " + livrosByBiblioteca.get(i).getGeneroLivro().getNomeGenero() +
                    " | Biblioteca: " + livrosByBiblioteca.get(i).getBibliotecaLivro().getNomeBiblioteca());
        }
        System.out.println();

    }
}
