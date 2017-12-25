package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.CartBeans;
import beans.MusicBeans;

public class MusicDAO {


	/**
	 * アーティストIDから楽曲に設定されているか調べる
	 * @param id
	 * @return
	 */
	public boolean findByArtist_id(String id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM music_ec.music WHERE ar_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			//登録済みだった
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			//未登録
		} finally {
			closeConn(conn);
		}
	}
	//曲のIDで曲情報を返す
	public CartBeans findByIdtoCart(String m_id) {
	Connection conn = null;
	try {
		conn = DBManager.getConnection();

		String sql 	= "SELECT * FROM music_ec.music "
					+ "JOIN music_ec.artist "
					+ "ON music_ec.music.ar_id = music_ec.artist.ar_id "
					+ "JOIN music_ec.album "
					+ "ON music_ec.music.al_id = music_ec.album.al_id "
					+ " where music_ec.music.m_id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, m_id);
		ResultSet rs = pStmt.executeQuery();
		if(rs.next()) {
			String m_setid = rs.getString("m_id");
			String al_id = rs.getString("al_id");
			String image = rs.getString("image");
			String m_name = rs.getString("m_name");
			String al_name = rs.getString("al_name");
			String ar_name = rs.getString("ar_name");
			String m_price = rs.getString("m_price");
			CartBeans cart_bean = new CartBeans(m_setid,al_id,image,m_name, al_name, ar_name, m_price);
			return cart_bean;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;

	} finally {
		closeConn(conn);
	}
	return null;
}
	//アルバムの収録曲情報を取得をしてリストで返す
	public List<MusicBeans> findByalbum_id(String album_id) {
		Connection conn = null;
		List<MusicBeans> musicList = new ArrayList<MusicBeans>();

		try {
			conn = DBManager.getConnection();

			String sql 	= "SELECT * FROM music_ec.music "
						+ "JOIN music_ec.artist "
						+ "ON music_ec.music.ar_id = music_ec.artist.ar_id "
						+ "JOIN music_ec.album "
						+ "ON music_ec.music.al_id = music_ec.album.al_id "
						+ " where music_ec.music.al_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, album_id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				MusicBeans mbList = new MusicBeans();
				mbList.setAl_id(album_id);
				mbList.setM_id(rs.getString("m_id"));
				mbList.setAl_name(rs.getString("al_name"));
				mbList.setImage(rs.getString("image"));
				mbList.setRelease_date(rs.getString("release_date"));
				mbList.setAr_name(rs.getString("ar_name"));
				mbList.setM_name(rs.getString("m_name"));
				mbList.setM_price(rs.getString("m_price"));
				mbList.setDL_path(rs.getString("DL_path"));
				mbList.setMp3(rs.getString("mp3"));
				mbList.setTrack_no(rs.getString("track_no"));
				mbList.setAl_price(rs.getString("al_price"));
				musicList.add(mbList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
			}
		return musicList;
	}
	//DB切断
	private void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * アルバムに楽曲を登録する
	 * @param no
	 * @param m_name
	 * @param artist
	 * @param price
	 * @param mp3
	 * @param dl
	 * @param al_id
	 * @return
	 */
	public boolean updateMusic(String no, String m_name, String artist, String price, String mp3, String dl, String al_id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "insert into music_ec.music(al_id,ar_id,m_name,m_price,DL_path,mp3,track_no)values(?,?,?,?,?,?,?)";
			// insertを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, al_id);
			pStmt.setString(2, artist);
			pStmt.setString(3, m_name);
			pStmt.setString(4, price);
			pStmt.setString(5, dl);
			pStmt.setString(6, mp3);
			pStmt.setString(7, no);
			pStmt.executeUpdate();
			return true;

		} catch (SQLException e) {

//			e.printStackTrace();
			return false;

		} finally {
			closeConn(conn);
		}
	}
	public void removeMusicByM_id(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "DELETE from music_ec.music WHERE m_id = ?";
			// insertを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeConn(conn);
		}
	}

}