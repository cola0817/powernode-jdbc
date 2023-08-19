package programmer;

import driver.mysql.JDBCMySQL;
import driver.oracle.JDBCOracle;
import driver.sqlServer.JDBCSqlServer;
import sun.JDBC;

/**
 * 程序员只需要选择对应的驱动即可无需关心驱动的具体实现 （面向接口编程）
 */
public class Cola {
    public static void main(String[] args) {

        JDBC mysql = new JDBCMySQL();
        mysql.getConnect();

        JDBC oracle = new JDBCOracle();
        oracle.getConnect();

        JDBC sqlServer = new JDBCSqlServer();
        sqlServer.getConnect();

    }
}
