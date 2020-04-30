package org.example.javaee.springmvc.bean;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class TransManager {

    static Map<String,Connection> manage=new HashMap<>();

    public static Connection getConnection(String key) {

        return manage.get(key);
    }

    public static void setConnection(String key,Connection connection) {
        manage.put(key,connection);

    }
}
