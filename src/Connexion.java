
import java.sql.*;

public class Connexion {
    String urlPilote="com.mysql.jdbc.Driver";
    String urlBaseDonnees="jdbc:Mysql://localhost:3306/lecturer-evaluation";//Chemin de connexion a la base des donnees
    Connection con;
        public Connexion(){
    try{
    Class.forName(urlPilote);
    System.out.println("Chargement du pilote de réussi");
    
}catch(ClassNotFoundException ex){
    System.out.println(ex);
}
    try{
        con=DriverManager.getConnection(urlBaseDonnees,"root","");
        System.out.println("Connexion à la base de données réussi");
    
}catch(SQLException ex){
    System.out.println(ex);
}
}
        public Connection ObtenirConnexion(){
        return con;
    }

    Statement prepareStatement(String requete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
