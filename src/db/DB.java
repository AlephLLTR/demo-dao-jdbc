package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    /**
     * getConnection() criará uma conexão com o banco de dados utilizando os argumentos em db.properties, caso algum problema ocorra, um DBException() será lançado
     */
    public static Connection getConnection() {
        
        if (conn == null) {
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                conn = DriverManager.getConnection(url, properties);
            } catch (SQLException err) {
                throw new DBException(err.getMessage());
            }
        }
        return conn;
    }


    /**
     * O método privado loadProperties() irá carregar o arquivo db.properties e retornar as propriedades lidas, caso algum problema ocorra, um DBException() será lançado
     */
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(fs);
            return properties;
        } catch (IOException err) {
            throw new DBException(err.getMessage());
        }
    }

    /**
     * O método público closeConnection() irá fechar uma conexão existente criada pelo método getConnection(), caso algum problema ocorra, um DBException() será lançado
     */
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException err) {
                throw new DBException(err.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if (st != null) {
            try {
                st.close();
            } catch (SQLException err) {
                throw new DBException(err.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException err) {
                throw new DBException(err.getMessage());
            }
        }
    }

}
