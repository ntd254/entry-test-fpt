package org.example.repository;

import org.example.model.BookOnTape;
import org.example.model.Furniture;
import org.example.model.Thing;
import org.example.model.Video;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class RentalSystemRepository {

    private final String url;
    private final String user;
    private final String password;

    public RentalSystemRepository() {
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(new FileReader("src/main/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.url = dbProperties.getProperty("url");
        this.user = dbProperties.getProperty("user");
        this.password = dbProperties.getProperty("password");
    }


    public void save(Thing item) {
        String table;
        if (item instanceof Video) table = "video";
        else if (item instanceof BookOnTape) table = "book_on_tape";
        else table = "furniture";
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+ table +" VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, item.getSerialNumber());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, item.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Furniture> findAllFurniture() {
        ArrayList<Furniture> furniture = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM furniture")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String table = resultSet.getMetaData().getTableName(1);
                furniture.add(new Furniture(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return furniture;
    }

    public Thing findById(String serialNumber) {
        Thing item = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement queryVideo = connection.prepareStatement("SELECT * FROM video WHERE serial_number = ?");
             PreparedStatement queryFurniture = connection.prepareStatement("SELECT * FROM furniture WHERE serial_number = ?");
             PreparedStatement queryBookOnTape = connection.prepareStatement("SELECT * FROM book_on_tape WHERE serial_number = ?")) {
            queryVideo.setString(1, serialNumber);
            queryFurniture.setString(1, serialNumber);
            queryBookOnTape.setString(1, serialNumber);
            ResultSet videos = queryVideo.executeQuery();
            ResultSet furniture = queryFurniture.executeQuery();
            ResultSet bookOnTapes = queryBookOnTape.executeQuery();
            if (videos.next()) item = new Video(videos.getString(1), videos.getString(2), videos.getInt(3));
            if (furniture.next()) item = new Furniture(furniture.getString(1), furniture.getString(2), furniture.getInt(3));
            if (bookOnTapes.next()) item = new BookOnTape(bookOnTapes.getString(1), bookOnTapes.getString(2), bookOnTapes.getInt(3));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return item;
    }
}
