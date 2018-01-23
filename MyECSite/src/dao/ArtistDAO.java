package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ArtistBeans;

/**
 * アーティストテーブルへのアクセスオブジェクト
 * @author yamamoto_tatsuya
 *
 */
public class ArtistDAO  extends DBManager{


	/**
	 * 全アーティストのインスタンスリストを返す
	 * @return
	 */
	public List<ArtistBeans> findAll() {
		Connection conn = null;
		List<ArtistBeans> aritstList = new ArrayList<ArtistBeans>();

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM music_ec.artist";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ArtistBeans artist = new ArtistBeans();
				artist.setAr_id(rs.getString("ar_id"));
				artist.setAr_name(rs.getString("ar_name"));
				aritstList.add(artist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
		}
		return aritstList;
	}

	/**
	 * IDからアーティストを検索しインスタンスを返す
	 * @param id
	 * @return
	 */
	public ArtistBeans findById(String id) {
			Connection conn = null;
			try {
				conn = DBManager.getConnection();
				String sql = "SELECT * FROM music_ec.artist WHERE ar_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, id);
				ResultSet rs = pStmt.executeQuery();
				if(rs.next()) {
					ArtistBeans artist_bean = new ArtistBeans();
					artist_bean.setAr_id(rs.getString("ar_id"));
					artist_bean.setAr_name(rs.getString("ar_name"));
					return artist_bean;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;

			} finally {
				closeConn(conn);
			}
			return null;
	}

	/**
	 * アーティストの削除
	 * @param id
	 * @return
	 */
	public boolean removeById(String id) {

		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "DELETE from music_ec.artist WHERE ar_id = ?";
//			String sql = "update music_ec.artist set  ar_name = 'unknown' where ar_id = ?";

			// insertを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		} finally {
			closeConn(conn);
		}
	}

	/**
	 * 新規アーティストの登録
	 * @param ar_name
	 * @return
	 */
	public boolean addArtist(String ar_name) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "insert into music_ec.artist(ar_name)values(?)";
			// insertを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, ar_name);

			pStmt.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {
			closeConn(conn);
		}
	}

	/**
	 * アーティスト名の更新
	 * @param name
	 * @param id
	 * @return
	 */
	public boolean updateArtist(String name, String id) {
		Connection conn = null;
		try {
			// データベースへ接続t
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "update music_ec.artist set  ar_name = ? where ar_id = ?";
			// insertに値を詰めて
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, id);
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
