package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;

public class Buy_detailDAO {

	public boolean addDetail(String resultHistroy,String m_id) {

		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "insert into music_ec.buy_detail(buy_id,m_id)values(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, resultHistroy);
			pStmt.setString(2, m_id);
			pStmt.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {
			closeConn(conn);
		}
	}
	private void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}