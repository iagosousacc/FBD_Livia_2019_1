package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import connection.PLConnection;
import entity.Meta;

public class MetaDAO {
	private Connection connection;
	private PLConnection PL_connection;
	
	public MetaDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}
	
	public boolean create(Meta meta) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".meta (fid, nome_meta, descricao) VALUES (?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, meta.getFid());
			stmt.setString(2, meta.getNome_meta());
			stmt.setString(3, meta.getDescricao());
			
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
	
	public boolean update(Meta meta) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".meta SET fid = ?, nome_meta = ?, descricao = ? WHERE fid = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, meta.getFid());
			stmt.setString(2, meta.getNome_meta());
			stmt.setString(3, meta.getDescricao());
			
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
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".meta WHERE fid = ? CASCADE";
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
	
	public Meta load(int id) {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".meta WHERE fid = ?";
		Meta meta = new Meta();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				meta.setFid(rs.getInt("fid"));
				meta.setNome_meta(rs.getNString("nome_meta"));
				meta.setDescricao(rs.getString("descricao"));
	
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
		return meta;
		
	}
	
	public List<Meta> getMetaList(){
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".meta";
		List<Meta> metalist = new ArrayList<Meta>();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Meta meta = new Meta();
				meta.setFid(rs.getInt("fid"));
				meta.setNome_meta(rs.getNString("nome_meta"));
				meta.setDescricao(rs.getString("descricao"));
				
				metalist.add(meta);
	
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
		return metalist;
		
		
	}
}
