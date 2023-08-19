package driver.mysql;

import sun.JDBC;

public class JDBCMySQL implements JDBC {
    @Override
    public void getConnect() {
        System.out.println("成功连接到 MySQL 数据库");
    }
}
