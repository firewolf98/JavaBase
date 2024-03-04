package it.itsvil.corsoformazionedb.sql;
import java.sql.Connection;
import java.sql.DriverManager;


public class Connessione {

	public Connessione() {
	
	}

	public Connection connessione(){
		Connection con = null;
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/corsoformazione?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          con = DriverManager.getConnection(url,"root","Development8!");

      }
      catch(Exception e){
         System.out.println("Connessione Fallita \n");
		 System.out.println(e);
      }
        return con;

    }

}
