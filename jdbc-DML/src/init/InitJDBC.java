package init;

import java.sql.*;

public class InitJDBC {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            //1. 注册驱动
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            //2. 获取连接
            String url = "jdbc:mysql://8.130.21.128:3307/mysql";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);

            //3. 获取数据库操作对象
            statement = connection.createStatement();

            //4. 执行 SQL 语句
            String sql = "SELECT * FROM mysql.db";
            ResultSet resultSet = statement.executeQuery(sql);

            // 5.处理查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("host"));
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            // 6. 关闭资源
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
