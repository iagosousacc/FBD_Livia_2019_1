package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.PLConnection;
import entity.Compromisso;

public class CompromissoDAO {
	private Connection connection;
	private PLConnection PL_connection;
	
	public CompromissoDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}
	
	public boolean create(Compromisso compromisso) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".compromisso (id, nome, data_compromisso, criador, descricao) VALUES (?, ?, ?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, compromisso.getId());
			stmt.setString(2, compromisso.getNome());
			stmt.setString(3, compromisso.getData_compromisso());
			stmt.setString(4,  compromisso.getCriador());
			stmt.setString(5,  compromisso.getDescricao());
			
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
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".compromisso WHERE id = ? CASCADE";
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
	
	public boolean update(Compromisso compromisso) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".compromisso SET id = ?, nome = ?, data_compromisso = ?, criador = ?, descricao = ? WHERE id = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, compromisso.getId());
			stmt.setString(2, compromisso.getNome());
			stmt.setString(3, compromisso.getData_compromisso());
			stmt.setString(4,  compromisso.getCriador());
			stmt.setString(5,  compromisso.getDescricao());
			stmt.setInt(6, compromisso.getId());
			
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
	
	public Compromisso load(int id) {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".compromisso WHERE id = ?";
		Compromisso comp= new Compromisso();
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				comp.setId(rs.getInt("id"));
				comp.setNome(rs.getNString("nome"));
				comp.setData_compromisso(rs.getString("data_compromisso"));
				comp.setCriador(rs.getString("criador"));
				comp.setDescricao(rs.getString("descricao"));
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
		
		return comp;
	}
	
	public List<Compromisso> getCompromissoList(){
		List<Compromisso> complist = new ArrayList<Compromisso>();
		
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".compromisso";
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Compromisso comp = new Compromisso();
				comp.setId(rs.getInt("id"));
				comp.setNome(rs.getNString("nome"));
				comp.setData_compromisso(rs.getString("data_compromisso"));
				comp.setCriador(rs.getString("criador"));
				comp.setDescricao(rs.getString("descricao"));
				
				complist.add(comp);
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
		
		return complist;
	}
	
}
