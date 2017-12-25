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
						+ "WHERE "
						+ "("
						+ "music_ec.music.m_name LIKE  "+ search_value
						+ "OR music_ec.album.al_name LIKE  "+ search_value
						+ "OR music_ec.artist.ar_name LIKE  "+ search_value
						+ ")"
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
	//該当ユーザーの購入済み曲を含む全アルバムのみ取得
	public List<AlbumBeans> findAllPurchased(String user_id) {
		Connection conn = null;
		List<AlbumBeans> albumList = new ArrayList<AlbumBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql 	= "SELECT  album.al_id,album.al_name,album.al_price,album.image  "+
							"FROM music_ec.album  " +
							"JOIN music_ec.music ON album.al_id = music.al_id " +
							"JOIN music_ec.buy_detail ON buy_detail.m_id = music.m_id " +
							"JOIN music_ec.buy_history ON buy_history.buy_id = buy_detail.buy_id " +
							"where music_ec.buy_history.user_id = ? " +
							"GROUP BY album.al_id,album.al_name,album.al_price,album.image ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				AlbumBeans album = new AlbumBeans();
				album.setAl_id(rs.getString("al_id"));
				album.setAl_name(rs.getString("al_name"));
				album.setAl_price(rs.getString("al_price"));
				album.setImage(rs.getString("image"));
				albumList.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
			}
		return albumList;
	}
	//該当ユーザーの購入済み曲を含むアルバムの検索対象選択検索
	public List<AlbumBeans> SelectPatternSearchPurchased(String user_id,String searchPattern,String search_value) {
		Connection conn = null;
		List<AlbumBeans> albumList = new ArrayList<AlbumBeans>();
		search_value = "%"+search_value +"%";
		try {
				Integer.parseInt(search_value);
			}catch(NumberFormatException e){
				search_value = "'" + search_value + "'";
			}
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			// SELECT文を準備
			String sql 	=
					"SELECT  album.al_id,album.al_name,album.al_price,album.image " +
					"FROM music_ec.album  " +
					"JOIN music_ec.music ON music_ec.album.al_id = music_ec.music.al_id " +
					"JOIN music_ec.artist ON music_ec.music.ar_id = music_ec.artist.ar_id " +
					"JOIN music_ec.buy_detail ON music_ec.buy_detail.m_id = music_ec.music.m_id " +
					"JOIN music_ec.buy_history ON music_ec.buy_history.buy_id = music_ec.buy_detail.buy_id " +
					"where music_ec.buy_history.user_id = ? " +
					"AND music_ec."+ searchPattern + " like  "+ search_value +" "+
					"GROUP BY album.al_id,album.al_name,album.al_price,album.image ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				AlbumBeans album = new AlbumBeans();
				album.setAl_id(rs.getString("al_id"));
				album.setAl_name(rs.getString("al_name"));
				album.setAl_price(rs.getString("al_price"));
				album.setImage(rs.getString("image"));
				albumList.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
			}
		return albumList;
	}
	//該当ユーザーの購入済み曲を含むアルバムのキーワード検索
	public List<AlbumBeans> KeywordSearchPurchased(String search_value,String user_id) {
		Connection conn = null;
		List<AlbumBeans> albumList = new ArrayList<AlbumBeans>();

				search_value = "%"+search_value +"%";
				search_value = "'" + search_value + "'";

		try {
			conn = DBManager.getConnection();

			String sql 	="SELECT  album.al_id,album.al_name,album.al_price,album.image "
						+"FROM music_ec.album  "
						+"JOIN music_ec.music ON music_ec.album.al_id = music_ec.music.al_id "
						+"JOIN music_ec.artist ON music_ec.music.ar_id = music_ec.artist.ar_id "
						+"JOIN music_ec.buy_detail ON music_ec.buy_detail.m_id = music_ec.music.m_id "
						+"JOIN music_ec.buy_history ON music_ec.buy_history.buy_id = music_ec.buy_detail.buy_id "
						+ "WHERE music_ec.buy_history.user_id = ?  "
						+ "AND "
						+ "("
						+ "music_ec.music.m_name LIKE  "+ search_value
						+ " OR music_ec.album.al_name LIKE  "+ search_value
						+ " OR music_ec.artist.ar_name LIKE  "+ search_value
						+ ")"
						+ " GROUP BY album.al_id,al_name,image,release_date,al_price";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				AlbumBeans albumbean = new AlbumBeans();
				albumbean.setAl_id(rs.getString("al_id"));
				albumbean.setAl_name(rs.getString("al_name"));
				albumbean.setImage(rs.getString("image"));
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
	//アルバムの削除
	public boolean removeById(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "DELETE from music_ec.album WHERE al_id = ?";
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
	//アルバムの追加
	public boolean addAlbum(String al_name,String image) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "insert into music_ec.album(al_name,image,release_date)values(?,?,now())";
			// insertを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, al_name);
			pStmt.setString(2, image);
			pStmt.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {
			closeConn(conn);
		}
	}
	//アルバムの更新
	public boolean updateAlbum(String name, String image, String al_id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "update music_ec.album set al_name = ?, image = ? where al_id = ?";
			// insertを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, image);
			pStmt.setString(3, al_id);
			pStmt.executeUpdate();
			System.out.println(pStmt);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {
			closeConn(conn);
		}
	}
}

