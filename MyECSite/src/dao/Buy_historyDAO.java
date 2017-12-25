package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import base.DBManager;
import beans.Buy_historyBeans;

public class Buy_historyDAO {


	/**
	 * 購入履歴IDの取得
	 * @param user_id
	 * @return
	 */
	public List<Buy_historyBeans> getHistory(String user_id) {
		Connection conn = null;
		List<Buy_historyBeans> userHistoryList = new ArrayList<Buy_historyBeans>();
		try {
			conn = DBManager.getConnection();

			String sql 	= "SELECT buy_history.buy_date,buy_history.buy_id,music.m_id "
						+ "FROM music_ec.buy_history "
						+ "JOIN music_ec.buy_detail "
						+ "ON music_ec.buy_history.buy_id = music_ec.buy_detail.buy_id "
						+ "JOIN music_ec.music "
						+ "ON music_ec.music.m_id = music_ec.buy_detail.m_id "
						+ " where music_ec.buy_history.user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				Buy_historyBeans BHBean = new Buy_historyBeans();
				BHBean.setBuy_id(rs.getString("buy_id"));
				BHBean.setUser_id(user_id);
				BHBean.setM_id(rs.getString("m_id"));
				BHBean.setBuy_date(rs.getString("buy_date"));
				userHistoryList.add(BHBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			closeConn(conn);
		}
		return userHistoryList;
	}
	/**
	 * 購入履歴の登録及び生成された購入IDの取得
	 * @param user_id
	 * @return
	 */
	public int addHistory(String user_id) {

		int resultID = -1;
		Connection conn = null;
		try {
			//追加
			conn = DBManager.getConnection();
			String sql = "insert into music_ec.buy_history(user_id,buy_date)values(?,now())";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, user_id);
			pStmt.executeUpdate();

			//ID取得
			  try (ResultSet rs = pStmt.getGeneratedKeys()) {
				    if (rs.next()) {
				    	resultID = rs.getInt(1);
				    }
				  }


			return resultID;

		} catch (SQLException e) {
			e.printStackTrace();
			return resultID;
		} finally {
			closeConn(conn);
		}
	}
	/**
	 * SQLコネクションの破棄
	 * @param conn
	 */
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