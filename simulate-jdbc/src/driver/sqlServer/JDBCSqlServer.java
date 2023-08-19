package driver.sqlServer;

import sun.JDBC;

public class JDBCSqlServer implements JDBC {
    @Override
    public void getConnect() {
        System.out.println("成功连接到 sqlServer 数据库");

    }
}
