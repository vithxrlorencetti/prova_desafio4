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

        System.out.println("ID do gênero do livro: ");
        GeneroView generoView = new GeneroView();
        GeneroController generoController = new GeneroController();
        generoView.listarGeneros();
        Genero genero = generoController.getGeneroById(Long.parseLong(input.nextLine()));
        livro.setGeneroLivro(genero);

        System.out.println("ID da biblioteca do livro: ");
        BibliotecaView bibliotecaView = new BibliotecaView();
        BibliotecaController bibliotecaController = new BibliotecaController();
        bibliotecaView.listarBibliotecas();
        Biblioteca biblioteca = bibliotecaController.getBibliotecaById(Long.parseLong(input.nextLine()));
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
        Long idGenero = input.nextLong();
        List<Livro> livrosByGenero = livroController.listarLivrosByGenero(idGenero);

        System.out.println();
        for (int i = 0; i < livrosByGenero.size(); i++) {
            System.out.println(//"ID: " + livrosByGenero.get(i).getIdLivro() +
                      "Nome do livro: " + livrosByGenero.get(i).getNomeLivro()); //+
//                    " | Gênero: " + livrosByGenero.get(i).getGeneroLivro().getNomeGenero() +
//                    " | Biblioteca: " + livrosByGenero.get(i).getBibliotecaLivro().getNomeBiblioteca());
        }
        System.out.println();

    }

    public void listarLivrosByBiblioteca(){

        BibliotecaView bibliotecaView = new BibliotecaView();
        bibliotecaView.listarBibliotecas();
        System.out.println("ID da biblioteca que deseja acessar: ");
        Long idBiblioteca = input.nextLong();
        List<Livro> livrosByBiblioteca = livroController.listarLivrosByBiblioteca(idBiblioteca);

        System.out.println();
        for (int i = 0; i < livrosByBiblioteca.size(); i++) {
            System.out.println(//"ID: " + livrosByGenero.get(i).getIdLivro() +
                    "Nome do livro: " + livrosByBiblioteca.get(i).getNomeLivro()); //+
//                    " | Gênero: " + livrosByGenero.get(i).getGeneroLivro().getNomeGenero() +
//                    " | Biblioteca: " + livrosByGenero.get(i).getBibliotecaLivro().getNomeBiblioteca());
        }
        System.out.println();

    }

    public void deletarLivro(){

        this.listarLivros();
        System.out.println("ID do livro que deseja deletar: ");
        Long idLivro = input.nextLong();
        Livro livro = livroController.getLivroById(idLivro);

        System.out.println("Deletando livro...");
        livroController.deletarLivro(livro);
        System.out.println("Livro deletado!");

    }
}
