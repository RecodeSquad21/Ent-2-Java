package connection;

import java.sql.Connection;
import java.sql.DriverManager;

	
	public class ConnectionMySQL {
		
		public  static Connection createConnectionMySQL() throws Exception{
			
			//Carregar a classe pelo JVM
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Criar  a conexao com o banco
			Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/alfabetizando?user=root&password=12345678");
			return connection;
		}
		
		public static void main(String[]args)throws Exception{
			//Recuperar a conexao com o banco
			Connection con = createConnectionMySQL();
			
			//Teste de conexao
			if(con!=null) {
				System.out.println(con + "\n****Conexao  bem sucedida****\n");
				con.close();
			}	
		}
	}

