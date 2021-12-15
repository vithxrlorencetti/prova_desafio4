package DAO;

import Factory.ConnectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection connection = new ConnectionFactory().getConnection();

    public LivroDAO() {
    }

    public void criarTabelaLivros(){

        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "idLivro INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeLivro VARCHAR(50) NOT NULL," +
                "idGenero INT," +
                "idBiblioteca INT," +
                "CONSTRAINT fk_idGenero FOREIGN KEY (idGenero)" +
                "REFERENCES generos(idGenero)" +
                "ON DELETE CASCADE," +
                "CONSTRAINT fk_idBiblioteca FOREIGN KEY (idBiblioteca)" +
                "REFERENCES bibliotecas(idBiblioteca)" +
                "ON DELETE CASCADE " +
                ");";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Tabela > Livros < criada!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarLivro(Livro livro){

        String sql = "INSERT INTO livros (nomeLivro, idGenero, idBiblioteca) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setLong(2, livro.getGeneroLivro().getIdGenero());
            preparedStatement.setLong(3, livro.getBibliotecaLivro().getIdBiblioteca());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while(resultSet.next()){
                livro.setIdLivro(resultSet.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarLivros(){

        String sql = "SELECT * FROM livros";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Livro> livros = new ArrayList<>();

            while(resultSet.next()){
                Livro livro = new Livro();
                livro.setIdLivro(resultSet.getLong(1));
                livro.setNomeLivro(resultSet.getString(2));

                GeneroDAO generoDAO = new GeneroDAO();
                Genero genero = generoDAO.getGeneroById(resultSet.getLong("idGenero"));
                livro.setGeneroLivro(genero);

                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                Biblioteca biblioteca = bibliotecaDAO.getBibliotecaById(resultSet.getLong("idBiblioteca"));
                livro.setBibliotecaLivro(biblioteca);

                livros.add(livro);
            }

            return livros;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarLivrosByGenero(Long idGenero){
        String sql = "SELECT livros.nomeLivro, generos.idGenero " +
                "FROM livros " +
                "INNER JOIN generos " +
                "ON livros.idGenero = generos.idGenero " +
                "WHERE generos.idGenero = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //GeneroDAO generoDAO = new GeneroDAO();
            preparedStatement.setLong(1, idGenero);
            //generoDAO.getGeneroById(idGenero);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Livro> listarLivrosByGenero = new ArrayList<>();

            while (resultSet.next()){
                Livro livro = new Livro();
//                POR ALGUM MOTIVO ESSA LINHA QUEBRA O CODIGO
//                livro.setIdLivro(resultSet.getLong("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));

//                ESSE TRECHO TAMBÉM É UM MOTIVO DO ERRO, APESAR DE FUNCIONAR NO LISTAR DE CIMA
//                GeneroDAO generoDAO = new GeneroDAO();
//                Genero genero = generoDAO.getGeneroById(resultSet.getLong("idGenero"));
//                livro.setGeneroLivro(genero);
//
//                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
//                Biblioteca biblioteca = bibliotecaDAO.getBibliotecaById(resultSet.getLong("idBiblioteca"));
//                livro.setBibliotecaLivro(biblioteca);

                listarLivrosByGenero.add(livro);
            }
            return listarLivrosByGenero;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public List<Livro> listarLivrosByBiblioteca(Long idBiblioteca){
        String sql = "SELECT livros.nomeLivro, bibliotecas.idBiblioteca " +
                "FROM livros " +
                "INNER JOIN bibliotecas " +
                "ON livros.idBiblioteca = bibliotecas.idBiblioteca " +
                "WHERE bibliotecas.idBiblioteca = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
            preparedStatement.setLong(1, idBiblioteca);
            //bibliotecaDAO.getBibliotecaById(idBiblioteca);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Livro> listarLivrosByBiblioteca = new ArrayList<>();

            while (resultSet.next()){
                Livro livro = new Livro();

                livro.setNomeLivro(resultSet.getString("nomeLivro"));
//                GeneroDAO generoDAO = new GeneroDAO();
//                Genero genero = generoDAO.getGeneroById(resultSet.getLong("idGenero"));
//                livro.setGeneroLivro(genero);
//
//                Biblioteca biblioteca = bibliotecaDAO.getBibliotecaById(resultSet.getLong("idBiblioteca"));
//                livro.setBibliotecaLivro(biblioteca);

                listarLivrosByBiblioteca.add(livro);
            }
            return listarLivrosByBiblioteca;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public void deletarLivro(Livro livro){

        String sql = "DELETE FROM livros WHERE idLivro = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, livro.getIdLivro());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro getLivroById(Long idLivro){

        String sql = "SELECT * FROM livros WHERE idLivro = ?";
        Livro livro = new Livro();

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, idLivro);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                livro.setIdLivro(resultSet.getLong(1));
                livro.setNomeLivro(resultSet.getString(2));
            }

            preparedStatement.close();
            return livro;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
