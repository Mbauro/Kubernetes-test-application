package consumer.product;

import consumer.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {

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

    public String updateProduct(Product product,int product_id){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.openConnection();
        if(!this.checkProductId(conn,product_id)){
            databaseConnection.closeConnection(conn);
            return "Product id not found";
        }
        String select_query = "SELECT quantity FROM products WHERE id = ?";
        int old_quantity = 0;
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(select_query);
            preparedStatement.setInt(1,product_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                old_quantity = resultSet.getInt("quantity");
            }
            if(old_quantity - product.getQuantity() < 0){
                databaseConnection.closeConnection(conn);
                return "The quantity you inserted is not available";
            }else{
                String update_query = "UPDATE products SET " +
                        "quantity = ? " +
                        "WHERE id = ?";
                preparedStatement = conn.prepareStatement(update_query);
                preparedStatement.setInt(1,(old_quantity - product.getQuantity()));
                preparedStatement.setInt(2,product_id);
                preparedStatement.execute();
                databaseConnection.closeConnection(conn);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Product updated";

    }

}
