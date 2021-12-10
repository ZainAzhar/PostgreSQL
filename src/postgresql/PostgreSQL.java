/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgresql;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zain Azhar
 */
public class PostgreSQL {
     Connection conn = null;
    private final String url = "jdbc:postgresql://LocalHost:5435/Ubicua";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection connect()  {

        try {
            try {
                try {
                    Class.forName("org.postgresql.Driver").newInstance();
                } catch (InstantiationException ex) {
                  
                } catch (IllegalAccessException ex) {
                 
                }
            } catch (ClassNotFoundException ex) {
            
            }
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*
    public void getAllCubos(){
try {
Statement stmnt = conn.createStatement();
ResultSet rs = stmnt.executeQuery("SELECT * FROM Basura Order by ID;");
System.out.println("Listado de ID");
System.out.println("============================");
while(rs.next()){
System.out.println(""+rs.getString("ID"));
}
} catch (SQLException ex) { System.out.println(ex.getMessage()); }
}*/
  public void getAllCubos(){ //CONSULTA 1
        try {
            String query = "SELECT fecha_hora FROM basura";
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            
            System.out.println("ID del cubo");
            System.out.println("============================");
            while(rs.next()){
                System.out.println(rs.getString(1).trim()+".");
           
            
            }
            System.out.println("============================");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //logger.log(Level.WARNING, "SQL Exception", ex);
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // FASES UNO cargar el controlador el driver postgres
        PostgreSQL app = new PostgreSQL();
        
        app.connect();
        
        app.getAllCubos();
        System.out.println("probando si funciona el driver postgres");
        app.disconnect();
     
    
}
}
