package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Voluntario;

public class VoluntarioDao {
	
	//create
		public void save (Voluntario voluntario) {
			
			//criar a query
			String sql= "INSERT INTO Voluntario(nome, sobrenome, cidade, estado, cep, email, apresentacao) VALUES(?,?,?,?,?,?,?)";
			
			//fazer conexao
			Connection conn= null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1,voluntario.getNome());
				pstm.setString(2,voluntario.getSobrenome());
				pstm.setString(3,voluntario.getCidade());
				pstm.setString(4,voluntario.getEstado());
				pstm.setString(5,voluntario.getCep());
				pstm.setString(6,voluntario.getEmail());
				pstm.setString(7,voluntario.getApresentacao());
				pstm.execute();
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				//fecha as conexoes
				try {
					if(pstm!= null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//Read
		public  List<Voluntario> getVoluntario(){
			//criar a query
			String sql = "SELECT * FROM Voluntario";
			
			//faz a lista que rece
			List<Voluntario> voluntarios = new ArrayList<Voluntario>();
			
			Connection conn= null;
			PreparedStatement pstm = null;
			
			//classe que vai recuperar dados do banco
			ResultSet rset = null;
			
			try {
				//executa a conexao com o banco
				conn = ConnectionMySQL.createConnectionMySQL();
				
				//executa a query
				pstm = conn.prepareStatement(sql);
				
				//captura o que foi executado no pstm
				rset = pstm.executeQuery(); 
				
				while(rset.next()) {
					Voluntario voluntario = new Voluntario();
					
					voluntario.setId(rset.getInt("id"));
					voluntario.setNome(rset.getString("nome"));
					voluntario.setSobrenome(rset.getString("sobrenome"));
					voluntario.setCidade(rset.getString("cidade"));
					voluntario.setEstado(rset.getString("estado"));
					voluntario.setCep(rset.getString("cep"));
					voluntario.setEmail(rset.getString("email"));
					voluntario.setApresentacao(rset.getString("apresentacao"));
					
					voluntarios.add(voluntario);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset != null) {
						rset.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return voluntarios;
		}
		
		//UpDate
		public static void update(Voluntario voluntario) {
			String sql = "UPDATE voluntario SET nome= ? WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm =conn.prepareStatement(sql);
				
				//Adiciona o valor nos parametros
				pstm.setString(1,voluntario.getNome());
				pstm.setString(2,voluntario.getSobrenome());
				pstm.setString(3,voluntario.getCidade());
				pstm.setString(4,voluntario.getEstado());
				pstm.setString(5,voluntario.getCep());
				pstm.setString(6,voluntario.getEmail());
				pstm.setString(7,voluntario.getApresentacao());
				pstm.setInt(8, voluntario.getId());
				
				pstm.execute();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//DELETE
		public void deleteById(int id) {
			String sql = "DELETE FROM voluntario WHERE id = ? ";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm =conn.prepareStatement(sql);
				
				pstm.setInt(1,id);
				
				pstm.execute();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}

}
