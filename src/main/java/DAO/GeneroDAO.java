package DAO;

import Factory.ConnectionFactory;
import Model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    private Connection connection = new ConnectionFactory().getConnection();

    public GeneroDAO() {
    }

    public void criarTabelaGeneros(){

        String sql = "CREATE TABLE IF NOT EXISTS generos (" +
                "idGenero INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeGenero VARCHAR(50) NOT NULL" +
                ");";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Tabela > Gêneros < criada!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarGenero(Genero genero){

        String sql = "INSERT INTO generos (nomeGenero) VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while(resultSet.next()){
                genero.setIdGenero(resultSet.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Genero> listarGeneros(){

        String sql = "SELECT * FROM generos";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Genero> generos = new ArrayList<>();

            while(resultSet.next()){
                Genero genero = new Genero();
                genero.setIdGenero(resultSet.getLong(1));
                genero.setNomeGenero(resultSet.getString(2));
                generos.add(genero);
            }

            return generos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarGenero(Genero genero){

        String sql = "DELETE FROM generos WHERE idGenero = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, genero.getIdGenero());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarGenero(Genero genero){

        String sql = "UPDATE generos SET nomeGenero = ? WHERE idGenero = ?";

        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.setLong(2, genero.getIdGenero());
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("\nGenero editado com sucesso!\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Genero getGeneroById(Long idGenero){

        String sql = "SELECT * FROM generos WHERE idGenero = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, idGenero);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Genero genero = new Genero();
                genero.setIdGenero(resultSet.getLong(1));
                genero.setNomeGenero(resultSet.getString(2));
                return genero;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
