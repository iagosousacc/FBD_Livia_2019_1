package dao;

import java.sql.*;
import java.util.*;
import connection.PLConnection;
import entity.Funcionario;

public class FuncionarioDAO {
	
	private Connection connection;
	private PLConnection PL_connection;
	
	public FuncionarioDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}

    
	public boolean create(Funcionario funcionario) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".Funcionario (id, nome, time) VALUES (?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			stmt.setString(2, funcionario.getNome());
			stmt.setInt(3, funcionario.getTime());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean update(Funcionario funcionario) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".Funcionario SET id = ?, nome = ?, time = ? WHERE id = ?";
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			stmt.setString(2, funcionario.getNome());
			stmt.setInt(3, funcionario.getTime());
			stmt.setInt(4, funcionario.getId());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".funcionario WHERE id = ? CASCADE";
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public Funcionario load(int id) {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".funcionario WHERE id = ?";
		Funcionario func = new Funcionario();
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				func.setId(rs.getInt("id"));
				func.setNome(rs.getNString("nome"));
				func.setTime(rs.getInt("time"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return func;
	}
	
	
	public List<Funcionario> getList() {
		List<Funcionario> listfunc = new ArrayList<Funcionario>();
		
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".funcionario";
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionario func = new Funcionario();
				func.setId(rs.getInt("id"));
				func.setNome(rs.getNString("nome"));
				func.setTime(rs.getInt("time"));
				
				listfunc.add(func);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return listfunc;
	}


}