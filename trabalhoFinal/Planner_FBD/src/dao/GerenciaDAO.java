package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.PLConnection;
import entity.Gerencia;

public class GerenciaDAO {
	private Connection connection;
	private PLConnection PL_connection;
	
	public GerenciaDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}
	
	public boolean create(Gerencia gerencia) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".gerencia (fid, cid, data_de_criacao) VALUES (?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, gerencia.getFid());
			stmt.setInt(2, gerencia.getCid());
			stmt.setString(3, gerencia.getData_da_criacao());
			
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
	
	public boolean delete(Gerencia gerencia) {
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".gerencia WHERE fid = ? AND cid = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, gerencia.getFid());
			stmt.setInt(2, gerencia.getCid());
			
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
	
	public boolean update(Gerencia gerencia) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".gerencia SET fid = ?, cid = ?, data_da_criacao = ? WHERE fid = ? AND cid = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, gerencia.getFid());
			stmt.setInt(2, gerencia.getCid());
			stmt.setString(3,  gerencia.getData_da_criacao());
			stmt.setInt(4, gerencia.getFid());
			stmt.setInt(5, gerencia.getCid());
			
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
	
	public Gerencia load() {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".gerencia WHERE fid = ? AND cid = ?";
		Gerencia gerencia = new Gerencia();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, gerencia.getFid());
			stmt.setInt(2, gerencia.getCid());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				gerencia.setFid(rs.getInt("fid"));
				gerencia.setCid(rs.getInt("cid"));
				gerencia.setData_da_criacao(rs.getString("data_da_criacao"));
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
		return gerencia;
	}
	
	public List<Gerencia> getGerenciaList(){
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".gerencia";
		List<Gerencia> gerencialist = new ArrayList<Gerencia>();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Gerencia gerencia = new Gerencia();
				gerencia.setFid(rs.getInt("fid"));
				gerencia.setCid(rs.getInt("cid"));
				gerencia.setData_da_criacao(rs.getString("data_da_criacao"));
				
				gerencialist.add(gerencia);
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
		return gerencialist;
	}
	
}
