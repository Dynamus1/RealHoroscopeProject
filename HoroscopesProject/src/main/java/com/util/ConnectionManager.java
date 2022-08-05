package com.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    public static ConnectionManager connectionManager;

    public static Connection connection;

    private ConnectionManager(){}

    private ConnectionManager getConnectionManager(){
        if (connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    public static Connection getConnection() {
        if(connection == null){
            connection = connect();
        }
        return connection;
    }

    public static Connection connect(){
        try{
            Properties props = new Properties();
            FileReader fileReader = new FileReader("/Users/curie/Documents/IntelliJ/HoroscopesProject-main/HoroscopesProject" +
                    "/src/main/resources/jdbc.properties");
            //REMOVED C:\\ from filename string -- switched double forward slashes to single backslashes in FileReader
            //filename

            props.load(fileReader);

            String connectionURL;
            StringBuilder urlString = new StringBuilder();
            urlString.append("jdbc:postgresql://");
            urlString.append(props.get("hostname"));
            urlString.append(":");
            urlString.append(props.get("port"));
            urlString.append("/");
            urlString.append(props.get("database"));

            connectionURL = urlString.toString();

            String user = String.valueOf(props.getProperty("user"));
            String password = String.valueOf(props.getProperty("password"));

            System.out.println(connectionURL);
            Class.forName("org.postgresql.Driver");//add all the time
            connection = DriverManager.getConnection(connectionURL,user,password);

            System.out.println(connection.getClientInfo().toString()+" This is to confirm the connection was made");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}

