package DAO;

import Factory.ConnectionFactory;
import Model.Biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    private Connection connection = new ConnectionFactory().getConnection();

    public BibliotecaDAO() {
    }

    public void criarTabelaBibliotecas(){

        String sql = "CREATE TABLE IF NOT EXISTS bibliotecas (" +
                "idBiblioteca INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeBiblioteca VARCHAR(50) NOT NULL" +
                ");";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Tabela > Bibliotecas < criada!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca){

        String sql = "INSERT INTO bibliotecas (nomeBiblioteca) VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, biblioteca.getNomeBiblioteca());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while(resultSet.next()){
                biblioteca.setIdBiblioteca(resultSet.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Biblioteca> listarBibliotecas(){

        String sql = "SELECT * FROM bibliotecas";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Biblioteca> bibliotecas = new ArrayList<>();

            while(resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getLong(1));
                biblioteca.setNomeBiblioteca(resultSet.getString(2));
                bibliotecas.add(biblioteca);
            }

            return bibliotecas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarBiblioteca(Biblioteca biblioteca){

        String sql = "DELETE FROM bibliotecas WHERE idBiblioteca = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, biblioteca.getIdBiblioteca());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Biblioteca getBibliotecaById(Long idBiblioteca){

        String sql = "SELECT * FROM bibliotecas WHERE idBiblioteca = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, idBiblioteca);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getLong(1));
                biblioteca.setNomeBiblioteca(resultSet.getString(2));
                return biblioteca;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
