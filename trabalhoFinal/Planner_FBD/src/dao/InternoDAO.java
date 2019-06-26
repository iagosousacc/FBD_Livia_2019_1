package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.PLConnection;
import entity.Interno;

public class InternoDAO {
	private Connection connection;
	private PLConnection PL_connection;
	
	public InternoDAO(PLConnection PL_connection) {
		this.PL_connection = PL_connection;
	}
	
	public boolean create(Interno interno) {
		String sql = "INSERT INTO " + PL_connection.getSchema() + ".Interno (cid, time0, time1, time2, time3, time4, time5, time6, time7, time8, time9) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, interno.getCid());
			stmt.setInt(2, interno.getTime0());
			stmt.setInt(3, interno.getTime1());
			stmt.setInt(4, interno.getTime2());
			stmt.setInt(5, interno.getTime3());
			stmt.setInt(6, interno.getTime4());
			stmt.setInt(7, interno.getTime5());
			stmt.setInt(8, interno.getTime6());
			stmt.setInt(9, interno.getTime7());
			stmt.setInt(10, interno.getTime8());
			stmt.setInt(11, interno.getTime9());
			
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
	
	public boolean update(Interno interno) {
		String sql = "UPDATE " + PL_connection.getSchema() + ".interno SET cid = ?, time0 = ?, time1 = ?, time2 = ?, time3 = ?, time4 = ?, time5 = ?, time6 = ?, time7 = ?, time8 = ?, time9 = ? WHERE cid = ?";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, interno.getCid());
			stmt.setInt(2, interno.getTime0());
			stmt.setInt(3, interno.getTime1());
			stmt.setInt(4, interno.getTime2());
			stmt.setInt(5, interno.getTime3());
			stmt.setInt(6, interno.getTime4());
			stmt.setInt(7, interno.getTime5());
			stmt.setInt(8, interno.getTime6());
			stmt.setInt(9, interno.getTime7());
			stmt.setInt(10, interno.getTime8());
			stmt.setInt(11, interno.getTime9());
			stmt.setInt(12, interno.getCid());
			
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

	public boolean delete(Interno interno) {
		String sql = "DELETE FROM " + PL_connection.getSchema() + ".interno WHERE cid = ? CASCADE";
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, interno.getCid());
			
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

	public Interno load(int id) {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".interno WHERE cid = ?";
		Interno interno = new Interno();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				interno.setCid(rs.getInt("cid"));
				interno.setTime0(rs.getInt("time0"));
				interno.setTime1(rs.getInt("time1"));
				interno.setTime2(rs.getInt("time2"));
				interno.setTime3(rs.getInt("time3"));
				interno.setTime4(rs.getInt("time4"));
				interno.setTime5(rs.getInt("time5"));
				interno.setTime6(rs.getInt("time6"));
				interno.setTime7(rs.getInt("time7"));
				interno.setTime8(rs.getInt("time8"));
				interno.setTime9(rs.getInt("time9"));
				
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
		return interno;
		
	}
	
	public List<Interno> getInternoList() {
		String sql = "SELECT * FROM " + PL_connection.getSchema() + ".interno";
		List<Interno> internolist = new ArrayList<Interno>();
		try {
			this.connection = this.PL_connection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Interno interno = new Interno();
				interno.setCid(rs.getInt("cid"));
				interno.setTime0(rs.getInt("time0"));
				interno.setTime1(rs.getInt("time1"));
				interno.setTime2(rs.getInt("time2"));
				interno.setTime3(rs.getInt("time3"));
				interno.setTime4(rs.getInt("time4"));
				interno.setTime5(rs.getInt("time5"));
				interno.setTime6(rs.getInt("time6"));
				interno.setTime7(rs.getInt("time7"));
				interno.setTime8(rs.getInt("time8"));
				interno.setTime9(rs.getInt("time9"));
				
				internolist.add(interno);
				
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
		return internolist;
		
	}
	
}
