package programmer;

import sun.JDBC;

import java.util.ResourceBundle;

public class ColaByRef {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        /*
         用ResourceBundle 资源绑定器绑定 xxx.properties 文件时，文件只能在类路径（即 src)下。
         */
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String className = bundle.getString("className");
        Class<?> aClass = Class.forName(className);

        JDBC driver = (JDBC) aClass.newInstance();

        driver.getConnect();

    }
}
