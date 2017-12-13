package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.AlbumBeans;

public class AlbumDAO {

	//キーワード検索
	public List<AlbumBeans> KeywordSearch(String search_value) {
		Connection conn = null;
		List<AlbumBeans> albumList = new ArrayList<AlbumBeans>();
		search_value = "%"+search_value +"%";
		try {
				Integer.parseInt(search_value);
			}catch(NumberFormatException e){
				search_value = "'" + search_value + "'";
			}
		try {
			conn = DBManager.getConnection();

			String sql 	= "SELECT  album.al_id,al_name,image,release_date,al_price "
						+ "FROM music_ec.music "
						+ "JOIN music_ec.artist "
						+ "ON music_ec.music.ar_id = music_ec.artist.ar_id "
						+ "JOIN music_ec.album "
						+ "ON music_ec.music.al_id = music_ec.album.al_id "
						+ "WHERE music_ec.music.m_name LIKE  "+ search_value
						+ "OR music_ec.album.al_name LIKE  "+ search_value
						+ "OR music_ec.artist.ar_name LIKE  "+ search_value
						+ "GROUP BY album.al_id,al_name,image,release_date,al_price";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				AlbumBeans albumbean = new AlbumBeans();
				albumbean.setAl_id(rs.getString("al_id"));
				albumbean.setAl_name(rs.getString("al_name"));
				albumbean.setImage(rs.getString("image"));
				albumbean.setRelease_date(rs.getString("release_date"));
				albumbean.setAl_price(rs.getString("al_price"));
				albumList.add(albumbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
			}
		return albumList;
	}
	//対象選択検索
	public List<AlbumBeans> SelectPatternSearch(String searchPattern,String search_value) {
		Connection conn = null;
		List<AlbumBeans> albumList = new ArrayList<AlbumBeans>();
		search_value = "%"+search_value +"%";
		try {
				Integer.parseInt(search_value);
			}catch(NumberFormatException e){
				search_value = "'" + search_value + "'";
			}
		try {
			conn = DBManager.getConnection();

			String sql 	= "SELECT  album.al_id,al_name,image,release_date,al_price"
						+ " FROM music_ec.music "
						+ "JOIN music_ec.artist "
						+ "ON music_ec.music.ar_id = music_ec.artist.ar_id "
						+ "JOIN music_ec.album "
						+ "ON music_ec.music.al_id = music_ec.album.al_id "
						+ "where music_ec."+ searchPattern + " like  "+ search_value +" "
						+ "GROUP BY album.al_id,al_name,image,release_date,al_price";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				AlbumBeans albumbean = new AlbumBeans();
				albumbean.setAl_id(rs.getString("al_id"));
				albumbean.setAl_name(rs.getString("al_name"));
				albumbean.setImage(rs.getString("image"));
				albumbean.setRelease_date(rs.getString("release_date"));
				albumbean.setAl_price(rs.getString("al_price"));
				albumList.add(albumbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
			}
		return albumList;
	}
	//AlbumIDから情報取得
	public AlbumBeans findById(String id) {
	Connection conn = null;
	try {
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM music_ec.album WHERE al_id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, id);
		ResultSet rs = pStmt.executeQuery();
		if(rs.next()) {
			String al_id = rs.getString("al_id");
			String al_name = rs.getString("al_name");
			String image = rs.getString("image");
			String release_date = rs.getString("release_date");
			String al_price = rs.getString("al_price");
			AlbumBeans album_bean = new AlbumBeans(al_id,al_name, image, release_date, al_price);
			return album_bean;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;

	} finally {
		closeConn(conn);
	}
	return null;
}
	//全アルバムの情報を取得をしてリストで返す
	public List<AlbumBeans> findAll() {
		Connection conn = null;
		List<AlbumBeans> albumList = new ArrayList<AlbumBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM music_ec.album";

			 // SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 結果表に格納されたレコードの内容を
			// UsersBeanインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String al_id = rs.getString("al_id");
				String al_name = rs.getString("al_name");
				String image = rs.getString("image");
				String release_date = rs.getString("release_date");
				String al_price = rs.getString("al_price");
				AlbumBeans albList = new AlbumBeans(al_id,al_name, image, release_date, al_price);
				albumList.add(albList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
			}
		return albumList;
	}
	//データベース切断
	private void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//含み検索
	private String likeSearch(String str) {
		if (str.indexOf("%") == -1) {
			str = "%" + str + "%";
		}
		return str;
	}
}
