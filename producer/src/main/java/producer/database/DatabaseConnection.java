package producer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private String userName =System.getenv("MYSQL_USER");
    private String password =System.getenv("MYSQL_PASSWORD");
    private String dbms = "mysql";
    private String serverName =System.getenv("SERVER_NAME");
    private String portNumber =System.getenv("PORT");
    private String dbName =System.getenv("DATABASE_NAME");


    private Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        conn = DriverManager.getConnection(
                "jdbc:" + this.dbms + "://" +
                        this.serverName +
                        ":" + this.portNumber + "/"+
                        this.dbName,
                connectionProps);

        System.out.println("Connected to database");
        return conn;
    }

    public Connection openConnection(){
        Connection conn = null;
        try {
             conn = this.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;

    }
    public void closeConnection(Connection conn){
        try {
            conn.close();
            System.out.println("Connection closed");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
