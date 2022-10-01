package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aluno;

public class AlunoDao {
	
	//create
		public static void save(Aluno alunos) {
			
			//criar a query
			String sql= "INSERT INTO Aluno(nome,idade) VALUES(?,?)";
			
			//fazer conexao
			Connection conn= null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1,alunos.getNome());
				pstm.setString(2,alunos.getIdade());
				
				pstm.execute();
				
			}catch (Exception e) {
				
				e.printStackTrace();
						
			} finally {
				
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		//Read
		public  List<Aluno> getAluno(){
			//criar a query
			String sql = "SELECT * FROM Aluno";
			
			//faz a lista que rece
			List<Aluno> alunos = new ArrayList<Aluno>();
			
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
					Aluno aluno = new Aluno();
					
					aluno.setId(rset.getInt("id"));
					aluno.setNome(rset.getString("nome"));
					aluno.setIdade(rset.getString("idade"));
					
					alunos.add(aluno);
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
			return alunos;
		}
		
		//UpDate
		public static void update(Aluno aluno) {
			String sql = "UPDATE aluno SET nome= ?, idade= ? WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm =conn.prepareStatement(sql);
				
				//Adiciona o valor nos parametros
				pstm.setString(1, aluno.getNome());
				pstm.setString(2, aluno.getIdade());
				pstm.setInt(3, aluno.getId());
				
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
			String sql = "DELETE FROM aluno WHERE id = ? ";
			
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
