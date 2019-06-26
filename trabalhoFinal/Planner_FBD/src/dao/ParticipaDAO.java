package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.PLConnection;
import entity.Participa;

public class ParticipaDAO {
	private Connection connection;
	private PLConnection PL_connection;
	
	public ParticipaDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}
	
	public boolean create(Participa participa) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".participa (fid, cid, compareceu) VALUES (?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, participa.getFid());
			stmt.setInt(2, participa.getCid());
			stmt.setBoolean(3, participa.isCompareceu());
			
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
	
	public boolean update(Participa participa) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".participa SET fid = ?, cid = ?, compareceu = ? WHERE fid = ? AND cid = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, participa.getFid());
			stmt.setInt(2, participa.getCid());
			stmt.setBoolean(3, participa.isCompareceu());
			stmt.setInt(4, participa.getFid());
			stmt.setInt(5, participa.getCid());
			
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
	
	public boolean delete(int fid, int cid) {
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".participa WHERE fid = ? AND cid = ? CASCADE";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, fid);
			stmt.setInt(1, cid);
			
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
	
	public Participa load(int fid, int cid) {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".meta WHERE fid = ? AND cid = ?";
		Participa participa = new Participa();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, fid);
			stmt.setInt(1, cid);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				participa.setFid(rs.getInt("fid"));
				participa.setCid(rs.getInt("cid"));
				participa.setCompareceu(rs.getBoolean("compareceu"));
	
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
		return participa;
		
	}
	
	public List<Participa> getParticipaList(){
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".participa";
		List<Participa> participalist = new ArrayList<Participa>();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Participa participa = new Participa();
				
				participa.setFid(rs.getInt("fid"));
				participa.setCid(rs.getInt("cid"));
				participa.setCompareceu(rs.getBoolean("compareceu"));
				
				participalist.add(participa);
	
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
		return participalist;
		
		
	}
	
}
