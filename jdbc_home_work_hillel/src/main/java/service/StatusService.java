package service;

import database.Database;
import entity.Clients;
import entity.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private static final String SELECT_ALL_STATUS_QUERY = "SELECT * FROM statuses";
    private static final String SAVE_STATUS_QUERY = "INSERT INTO statuses (alias, description) VALUES (?,?)";
    private static final String UPDATE_STATUS_QUERY = "UPDATE statuses SET (alias, description) = (?,?) WHERE id = ?";
    private static final String DELETE_STATUS_QUERY = "DELETE FROM statuses WHERE id = ?";
    private static final String JOIN_NAME_MAIL_ALIAS_QUERY = "SELECT c.name, c.email, s.alias FROM clients c " +
            "INNER JOIN client_status cs ON c.id = cs.clients_id " +
            "INNER JOIN statuses s ON cs.statuses_id = s.id WHERE c.age > 18";

    public List<Status> getAll() {
        List<Status> statuses = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STATUS_QUERY);
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setAlias(resultSet.getString("alias"));
                status.setDescription(resultSet.getString("description"));
                statuses.add(status);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    public void update(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_QUERY)) {
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescription());
            preparedStatement.setInt(3, status.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_STATUS_QUERY)) {
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescription());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATUS_QUERY)) {
            if (status.getId() == 0) {
                getId(status);                                      // for new status
            }
            preparedStatement.setInt(1, status.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getId(Status status) {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STATUS_QUERY);
            while (resultSet.next()) {
                if (resultSet.getString("alias").equals(status.getAlias()))
                    status.setId(resultSet.getInt("id"));

            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getJoinNameMailAlias(){
        List<String> joinList = new ArrayList<>();
        try(Connection connection = Database.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(JOIN_NAME_MAIL_ALIAS_QUERY);
            while (resultSet.next()){
                Status status = new Status();
                Clients clients = new Clients();
                clients.setName(resultSet.getString("name"));
                clients.setEmail(resultSet.getString("email"));
                status.setAlias(resultSet.getString("alias"));
                String result = String.format("Name = %s, email = %s, alias = %s", clients.getName(), clients.getEmail(), status.getAlias());
                joinList.add(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return joinList;
    }
}
