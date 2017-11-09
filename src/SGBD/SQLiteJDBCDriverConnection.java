package SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class SQLiteJDBCDriverConnection {
    
    public Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:Cadastro.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            //System.out.println("A conexão com o banco de dados ocorreu com sucesso!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
        return conn;
    }
      /*String cidade = jTextFieldCidade.getText();
        String bairro =jTextFieldBairro.getText();
        String numero = jTextFieldNumero.getText();
        String rua = jTextFieldRua.getText();
        String comple = jTextFieldComplemento.getText();
        String cep*/
    //CRUD
    public static void create (Connection conn) {
        
        String sql = "CREATE TABLE IF NOT EXISTS Cadastro (";
                sql += "	nome varchar(255) not null primary key,";
                sql += "	telefone varchar(255) not null,";
                sql += "	cep varchar(255)not null,";
                sql += "	rua varchar(255) not null,";
                sql += "	bairro varchar(255)not null,";
                sql += "	numero varchar(255)not null,";
                sql += "	cidade varchar(50)not null,";
                sql += "	complemento varchar(255)";
                sql += ");";
        
        try {
                Statement stmt = conn.createStatement();
                
            // cria uma tabela
            stmt.execute(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   
       public static void insert (Connection conn, String nome, String tel, String cep, String rua, String bairro,String numero, String cidade , String comp) {
        String sql = "INSERT INTO Cadastro (nome, telefone, cep, rua, bairro,numero, cidade , complemento) VALUES(?,?,?,?,?,?,?,?)";
 
        try {
                PreparedStatement pstmt = conn.prepareStatement(sql); 
                
         
                pstmt.setString(1, nome);
                pstmt.setString(2,tel );
                pstmt.setString(3, cep);
                pstmt.setString(4, rua);
                pstmt.setString(5, bairro);
                pstmt.setString(6, numero);
                pstmt.setString(7, cidade);
                pstmt.setString(8, comp);
                
                pstmt.executeUpdate();
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void update (Connection conn, String bairro,String numero, String telefone, String rua , String cep  , String complemento , String cidade , String nome){
        
        String sql = "UPDATE Cadastro SET bairro = ?,numero=?,telefone=? ,rua = ? ,cep =?,complemento = ? ,cidade = ? WHERE nome = ?";
        
        try{
                PreparedStatement pstmt = conn.prepareStatement(sql); 
                
                pstmt.setString(1, bairro);
                pstmt.setString(2, numero);
                pstmt.setString(3, telefone);
                pstmt.setString(4, rua);
                pstmt.setString(5, cep);
                pstmt.setString(6, complemento);
                pstmt.setString(7, cidade);
                pstmt.setString(8, nome);
                pstmt.executeUpdate();
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void delete (Connection conn, String nome){
        
        String sql = "DELETE FROM Cadastro WHERE nome=?";
        
        try{
                PreparedStatement pstmt = conn.prepareStatement(sql); 
                
                pstmt.setString(1, nome);
                pstmt.executeUpdate();
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void select (Connection conn, String nome){
        
        String sql = "SELECT *  "
                     + "FROM Cadastro Where nome = ? ";
        
      
        
        
        try{
                PreparedStatement pstmt = conn.prepareStatement(sql); 
                
                pstmt.setString(1, nome);
                
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
}
    