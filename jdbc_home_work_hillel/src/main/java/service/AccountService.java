package service;

import database.Database;
import entity.Accounts;
import entity.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountService {
    private static final String SELECT_ALL_ACCOUNTS_QUERY = "SELECT * FROM accounts";
    private static final String SAVE_ACCOUNTS_QUERY = "INSERT INTO accounts (client_id, number, value) VALUES (?,?,?)";
    private static final String UPDATE_ACCOUNTS_QUERY = "UPDATE accounts SET (client_id, number, value) = (?,?,?) WHERE id = ?";
    private static final String DELETE_ACCOUNTS_QUERY = "DELETE FROM accounts WHERE id = ?";
    private static final String SELECT_WHERE_VALUE_MORE_QUERY = "SELECT number FROM accounts WHERE value > ?";
    private static final String SELECT_BY_ID_JOIN_CLIENT_ID_QUERY = "SELECT * FROM clients c INNER JOIN accounts a ON c.id = a.client_id";

    public List<Accounts> getAll() {
        List<Accounts> accounts = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ACCOUNTS_QUERY);
            while (resultSet.next()) {
                Accounts account = new Accounts();
                account.setId(resultSet.getInt("id"));
                account.setClient_id(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                accounts.add(account);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void save(Accounts account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ACCOUNTS_QUERY)) {
            preparedStatement.setInt(1, account.getClient_id());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Accounts accounts) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNTS_QUERY)) {
            preparedStatement.setInt(1, accounts.getClient_id());
            preparedStatement.setString(2, accounts.getNumber());
            preparedStatement.setDouble(3, accounts.getValue());
            preparedStatement.setInt(4, accounts.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Accounts account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNTS_QUERY)) {
            if (account.getId() == 0) {                                 //for new account
                getId(account);
            }
            preparedStatement.setInt(1, account.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getId(Accounts accounts) {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ACCOUNTS_QUERY);
            while (resultSet.next()) {
                if (resultSet.getString("number").equals(accounts.getNumber()))
                    accounts.setId(resultSet.getInt("id"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getByValue(Double value) {
        List<String> numberList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WHERE_VALUE_MORE_QUERY)) {
            preparedStatement.setDouble(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String number = "number = " + resultSet.getString("number");
                numberList.add(number);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberList;
    }

    public Map<Accounts, Clients> getByIdAndClientId() {
        Map<Accounts, Clients> resultMap = new HashMap<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_BY_ID_JOIN_CLIENT_ID_QUERY);
            while (resultSet.next()) {
                Accounts account = new Accounts();
                Clients client = new Clients();
                account.setId(resultSet.getInt("id"));
                account.setClient_id(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAge(resultSet.getInt("age"));
                client.setAbout(resultSet.getString("about"));
                resultMap.put(account, client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
