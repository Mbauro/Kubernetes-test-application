package producer.Product;

import producer.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import producer.interfaces.ProductDao;

public class ProductDaoImpl implements ProductDao {

    private boolean checkProductId(Connection conn, int product_id){
        String check_query = "SELECT product_name FROM products WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(check_query);
            preparedStatement.setInt(1, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;

    }

    public void insertProduct(Product product){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.openConnection();
        String sql_query = "INSERT INTO products (product_name, quantity) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql_query);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.execute();
            System.out.println("Product Inserted");
            databaseConnection.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String updateProduct(Product product,int product_id){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.openConnection();
        if(!this.checkProductId(conn,product_id)){
            databaseConnection.closeConnection(conn);
            return "Product id not found";
        }

        String sql_query = "UPDATE products SET " +
                "product_name = ?, quantity = ? " +
                "WHERE id = ?";
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql_query);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setInt(3,product_id);
            preparedStatement.execute();
            databaseConnection.closeConnection(conn);
        }catch(SQLException e ){
            e.printStackTrace();
        }
        return "Product updated";
    }

}
