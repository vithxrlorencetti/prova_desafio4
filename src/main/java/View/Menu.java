package View;

import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.LivroDAO;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    public void menuPrincipal(){

        while(true){
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*                                               *");
            System.out.println("*   GERENCIAMENTO DE BIBLIOTECAS                *");
            System.out.println("*                                               *");
            System.out.println("*   [1] BIBLIOTECAS                             *");
            System.out.println("*   [2] GÊNEROS                                 *");
            System.out.println("*   [3] LIVROS                                  *");
            System.out.println("*                                               *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    this.menuBibliotecas();
                    break;
                case 2:
                    this.menuGeneros();
                    break;
                case 3:
                    this.menuLivros();
                    break;

            }
        }
    }

    public int menuBibliotecas(){

        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        bibliotecaDAO.criarTabelaBibliotecas();
        BibliotecaView bibliotecaView = new BibliotecaView();

        while(true){
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*                                               *");
            System.out.println("*   GERENCIAMENTO DE BIBLIOTECAS                *");
            System.out.println("*                                               *");
            System.out.println("*   [1] CADASTRAR BIBLIOTECA                    *");
            System.out.println("*   [2] LISTAR BIBLIOTECAS                      *");
            System.out.println("*   [3] VOLTAR                                  *");
            System.out.println("*                                               *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    bibliotecaView.cadastrarBiblioteca();
                    break;
                case 2:
                    bibliotecaView.listarBibliotecas();
                    break;
                case 3:
                    return -1;
            }
        }
    }

    public int menuGeneros(){

        GeneroDAO generoDAO = new GeneroDAO();
        generoDAO.criarTabelaGeneros();
        GeneroView generoView = new GeneroView();

        while(true){
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*                                               *");
            System.out.println("*   GERENCIAMENTO DE GÊNEROS                    *");
            System.out.println("*                                               *");
            System.out.println("*   [1] CADASTRAR GÊNERO                        *");
            System.out.println("*   [2] LISTAR GÊNEROS                          *");
            System.out.println("*   [3] VOLTAR                                  *");
            System.out.println("*                                               *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    generoView.cadastrarGenero();
                    break;
                case 2:
                    generoView.listarGeneros();
                    break;
                case 3:
                    return -1;
            }
        }
    }

    public int menuLivros(){

        LivroDAO livroDAO = new LivroDAO();
        livroDAO.criarTabelaLivros();
        LivroView livroView = new LivroView();

        while(true){
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*                                               *");
            System.out.println("*   GERENCIAMENTO DE LIVROS                     *");
            System.out.println("*                                               *");
            System.out.println("*   [1] CADASTRAR LIVRO                         *");
            System.out.println("*   [2] LISTAR TODOS OS LIVROS                  *");
            System.out.println("*   [3] LISTAR LIVROS POR GÊNERO                *");
            System.out.println("*   [4] LISTAR LIVROS POR BIBLIOTECA            *");
            System.out.println("*   [5] VOLTAR                                  *");
            System.out.println("*                                               *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    livroView.cadastrarLivro();
                    break;
                case 2:
                    livroView.listarLivros();
                    break;
                case 3:
                    livroView.listarLivrosByGenero();
                    break;
                case 4:
                    livroView.listarLivrosByBiblioteca();
                    break;
                case 5:
                    return -1;
            }
        }
    }



}
