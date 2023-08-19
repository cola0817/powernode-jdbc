package driver.oracle;

import sun.JDBC;

public class JDBCOracle implements JDBC {
    @Override
    public void getConnect() {
        System.out.println("成功连接到 Oracle 数据库");
    }
}
