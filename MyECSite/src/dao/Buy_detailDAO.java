package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;

/**
 * 購入履歴に紐づく楽曲等詳細を登録するテーブルへのアクセスオブジェクト
 * @author yamamoto_tatsuya
 *
 */
public class Buy_detailDAO  extends DBManager{

	/**
	 * 履歴に登録したときに生成した購入履歴IDと楽曲IDを登録
	 * @param resultHistroy
	 * @param m_id
	 * @return
	 */
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
}