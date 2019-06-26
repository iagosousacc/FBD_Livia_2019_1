package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.PLConnection;
import entity.Externo;

public class ExternoDAO {
	private Connection connection;
	private PLConnection PL_connection;
	
	public ExternoDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}

	public boolean create(Externo externo) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".externo (cid, cliente, local_compromisso, forma_de_locomocao) VALUES (?, ?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, externo.getCid());
			stmt.setString(2, externo.getCliente());
			stmt.setString(3, externo.getLocal_compromisso());
			stmt.setString(4,  externo.getForma_de_alocacao());
			
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
	
	public boolean delete(int cid) {
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".externo WHERE cid = ? CASCADE";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
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
	
	public boolean update(Externo externo) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".externo SET cid = ?, cliente = ?, local_compromisso = ?, forma_de_locomocao = ?, WHERE id = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, externo.getCid());
			stmt.setString(2, externo.getCliente());
			stmt.setString(3, externo.getLocal_compromisso());
			stmt.setString(4,  externo.getForma_de_alocacao());
			stmt.setInt(5, externo.getCid());
			
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
	
	public Externo load(int cid) {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".externo WHERE cid = ?";
		Externo externo = new Externo();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cid);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				externo.setCid(rs.getInt("cid"));
				externo.setCliente(rs.getNString("cliente"));
				externo.setLocal_compromisso(rs.getString("local_compromisso"));
				externo.setForma_de_alocacao(rs.getString("forma_de_alocacao"));
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
		
		return externo;
	}
	
	public List<Externo> getExternoList() {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".externo";
		List<Externo> externolist = new ArrayList<Externo>();
		
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Externo externo = new Externo();
				externo.setCid(rs.getInt("cid"));
				externo.setCliente(rs.getNString("cliente"));
				externo.setLocal_compromisso(rs.getString("local_compromisso"));
				externo.setForma_de_alocacao(rs.getString("forma_de_alocacao"));
				externolist.add(externo);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return externolist;
	}
	
}
