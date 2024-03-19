package org.ait.competence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Map;

public class DataBaseRA {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseRA.class);
    public static Connection connection() {
        try (InputStream inputStream = DataBaseRA.class.getClassLoader().getResourceAsStream("application.yml")) {
            Yaml yaml = new Yaml();
            Map<String, Object> load = yaml.load(inputStream);

            String usernameDB = (String) load.get("username");
            String userPasswordDB = (String) load.get("password");
            String dbUrl = (String) load.get("url");

            return DriverManager.getConnection(dbUrl, usernameDB, userPasswordDB);
        } catch (IOException | SQLException e) {
            throw new RuntimeException("Error creating database connection", e);
        }
    }

    public static ResultSet requestSelect(String query) {
        try {
            Statement statement = DataBaseRA.connection().createStatement();
            ResultSet result = statement.executeQuery(query);
            result.next();
            return result;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            Connection connection = DataBaseRA.connection();
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void executeUpdate(String query) {
        try (Connection connection = DataBaseRA.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

     public static boolean execute(String query) {
        try {
            return DataBaseRA.connection().createStatement().execute(query);
        } catch (SQLException e) {
            return false;
        }
    }

    public static void requestDelete(String query) {
        try (PreparedStatement preparedStatement = DataBaseRA.connection().prepareStatement(query)) {
//            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}