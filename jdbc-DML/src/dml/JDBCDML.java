package dml;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCDML {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;

        try {

            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

            String driver = bundle.getString("driver");
            String url = bundle.getString("url");
            String user = bundle.getString("user");
            String password = bundle.getString("password");


            Class.forName(driver);

            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            String sql = "INSERT INTO test(user,host,age) VALUES ('cola','127.0.0.1',21)";
            int count = statement.executeUpdate(sql);
            System.out.println("result "+(count == 1?"插入成功":"插入失败"));

            String select_sql = "SELECT * FROM test";
            ResultSet resultSet = statement.executeQuery(select_sql);
            while (resultSet.next()){
                System.out.println(
                        resultSet.getString("host")+
                        resultSet.getString("user")+
                         resultSet.getString("age"));

            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
    }
}
