package service;

import database.Database;
import entity.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final String SELECT_ALL_CLIENTS_QUERY = "SELECT * FROM clients";
    private static final String SAVE_CLIENTS_QUERY = "INSERT INTO clients (name, email, phone, age, about) VALUES (?,?,?,?,?)";
    private static final String UPDATE_CLIENTS_QUERY = "UPDATE clients SET (name, email, phone, age, about) = (?,?,?,?,?) WHERE id = ?";
    private static final String DELETE_CLIENTS_QUERY = "DELETE FROM clients WHERE id = ?";
    private static final String SELECT_CLIENTS_WHERE_PHONE_QUERY = "SELECT * FROM clients WHERE phone = ?";

    public List<Clients> getAll() {
        List<Clients> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS_QUERY);
            while (resultSet.next()) {
                Clients client = new Clients();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAge(resultSet.getInt("age"));
                client.setAbout(resultSet.getString("about"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void save(Clients client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CLIENTS_QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setInt(4, client.getAge());
            preparedStatement.setString(5, client.getAbout());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Clients client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENTS_QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setInt(4, client.getAge());
            preparedStatement.setString(5, client.getAbout());
            preparedStatement.setInt(6, client.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Clients client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENTS_QUERY)) {
            if (client.getId() == 0) {                  // for new client
                getId(client);
            }
            preparedStatement.setInt(1, client.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getId(Clients client) {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS_QUERY);
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(client.getEmail()))
                    client.setId(resultSet.getInt("id"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Clients> getByPhone(long phone) {
        List<Clients> clientList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTS_WHERE_PHONE_QUERY)) {
            preparedStatement.setLong(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Clients client = new Clients();
                client.setId(resultSet.getInt("id"));
                client.setAge(resultSet.getInt("age"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                clientList.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }
}
