package producer.database;

import producer.Product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {

    public void insertProduct(Product product){
        DarabaseConnection darabaseConnection = new DarabaseConnection();
        Connection conn = darabaseConnection.openConnection();
        String sql_query = "INSERT INTO products (product_name, quantity) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql_query);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.execute();
            System.out.println("Product Inserted");
            darabaseConnection.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
