package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import connection.PLConnection;
import entity.Diario;

public class DiarioDAO {
	private Connection connection;
	private PLConnection PL_connection;
	
	public DiarioDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}
	
	public boolean create(Diario diario) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".diario (fid, data_anotacao, anotacao) VALUES (?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, diario.getFid());
			stmt.setString(2, diario.getData_anotacao());
			stmt.setString(3, diario.getAnotacao());
			
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
	
	public boolean delete(int fid) {
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".diario WHERE fid = ? CASCADE";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, fid);
			
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
	
	public boolean update(Diario diario) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".diario SET fid = ?, data_anotacao = ?, anotacao = ? WHERE fid = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, diario.getFid());
			stmt.setString(2, diario.getData_anotacao());
			stmt.setString(3, diario.getAnotacao());
			stmt.setInt(4, diario.getFid());
			
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
	
	public Diario load(int id){
		Diario diario = new Diario();
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".diario";
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				diario.setFid(rs.getInt("id"));
				diario.setData_anotacao(rs.getNString("data_anotacao"));
				diario.setAnotacao(rs.getString("anotacao"));
	
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
		
		return diario;
	}
	
	public List<Diario> getDiarioList(){
		List<Diario> diariolist = new ArrayList<Diario>();
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".diario WHERE id = ?";
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Diario diario = new Diario();
				diario.setFid(rs.getInt("id"));
				diario.setData_anotacao(rs.getNString("data_anotacao"));
				diario.setAnotacao(rs.getString("anotacao"));
				
				diariolist.add(diario);
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
		
		return diariolist;
	}
	
	
}
