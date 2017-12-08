package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.UserBeans;

public class UserDAO {


	//検索
		public List<UserBeans> userSearch(String login_id, String name, String birth_date_from, String birth_date_to) {
			Connection conn = null;
			List<UserBeans> userList = new ArrayList<UserBeans>();
			String[] str = {login_id,likeSearch(name)};
			for(int i =0;i<str.length;i++) {
				try {
					Integer.parseInt(str[i]);
				}catch(NumberFormatException e){
					str[i] = "'" + str[i] + "'";
				}
			}
			String setLogin_id = str[0];
			String setName = str[1];
			try {
				conn = DBManager.getConnection();
				String sql = "SELECT * FROM music_ec.user";
				if(!login_id.isEmpty()) {
					sql = createSQL(sql, "login_id = " + setLogin_id);
				}
				if(!name.isEmpty()) {
					sql = createSQL(sql, "name like " + setName);
				}
				if(!birth_date_from.isEmpty()) {
					sql = createSQL(sql, "birth_date >= " + "'" + birth_date_from +"'");
				}
				if(!birth_date_to.isEmpty()) {
					sql = createSQL(sql, "birth_date <= "+  "'" +birth_date_to +"'");
				}
				//adminは表示しない
				sql = createSQL(sql, "user_id <> 1");

				 // SELECTを実行し、結果表を取得
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String idSet = rs.getString("user_id");
					String login_idSet = rs.getString("login_id");
					String nameSet = rs.getString("name");
					String birth_dateSet = rs.getString("birth_date");
					String passwordSet = rs.getString("password");
					String create_dateSet = rs.getString("create_date");
					String update_dateSet = rs.getString("update_date");
					String emailSet = rs.getString("email");
					UserBeans ubList = new UserBeans(idSet,login_idSet, nameSet, birth_dateSet, passwordSet, create_dateSet, update_dateSet,emailSet);
					userList.add(ubList);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				closeConn(conn);
			}
		return userList;
		}
	//元のsqlにwhereが含まれていない場合は「where」それ以外は「and」から開始
		private String createSQL(String baseSql, String addSql) {
			StringBuilder resulet = new StringBuilder();
			resulet.append(baseSql);

			if (baseSql.indexOf("where") == -1) {
				resulet.append(" " + "where" + " ");
			} else {
				resulet.append(" " + "and" + " ");
			}
			resulet.append(addSql);
			return resulet.toString();
		}
	//含み検索
	private String likeSearch(String str) {
		if (str.indexOf("%") == -1) {
			str = "%" + str + "%";
		}
		return str;
	}
	//全登録者の情報を取得をしてリストで返す
	public List<UserBeans> findAll() {
		Connection conn = null;
		List<UserBeans> userList = new ArrayList<UserBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM music_ec.user";
			sql = createSQL(sql, "user_id  <> '1'");

			 // SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 結果表に格納されたレコードの内容を
			// UsersBeanインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String id = rs.getString("user_id");
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				String birth_date = rs.getString("birth_date");
				String password = rs.getString("password");
				String create_date = rs.getString("create_date");
				String update_date = rs.getString("update_date");
				String email = rs.getString("email");
				UserBeans ubList = new UserBeans(id,login_id, name, birth_date, password, create_date, update_date,email);
				userList.add(ubList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConn(conn);
			}
		return userList;
	}
	//userIDから情報取得
	public UserBeans findById(String id) {
	Connection conn = null;
	try {
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM music_ec.user WHERE user_id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, id);
		ResultSet rs = pStmt.executeQuery();
		if(rs.next()) {
			//beansを作って取得したデータをプロパティに登録してbeansインスタンスを返す
			UserBeans ub = new UserBeans();
			ub.setId(rs.getString("user_id"));
			ub.setLogin_id(rs.getString("login_id"));
			ub.setName(rs.getString("name"));
			ub.setBirth_date(rs.getString("birth_date"));
			ub.setPassword(rs.getString("password"));
			ub.setCreate_date(rs.getString("create_date"));
			ub.setUpdate_date(rs.getString("update_date"));
			ub.setEmail(rs.getString("email"));
			return ub;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;

	} finally {
		closeConn(conn);
	}
	return null;
}
	//新規登録
	public boolean newUser(String login_id, String name, String birth_date, String password ,String email) {

		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// insert文を準備
			String sql = "insert into music_ec.user(login_id,name,birth_date,password,create_date,update_date,email)values(?,?,?,?,now(),now(),?)";
			// insertを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.setString(2, name);
			pStmt.setString(3, birth_date);
			pStmt.setString(4, password);
			pStmt.setString(5, email);
			pStmt.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		} finally {
			closeConn(conn);
		}
	}
	//重複チェック
	public boolean findByLoginId(String login_id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM music_ec.user WHERE login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
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
	//ログイン
	public UserBeans findByPass(String login_id, String password) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			// SELECT文を準備
			String sql = "SELECT * FROM music_ec.user WHERE login_id = ? and password = ?";

			// SELECTを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			//boolean型rs.next
			if(rs.next()) {
				//beansを作って取得したデータをプロパティに登録してbeansインスタンスを返す
				UserBeans ub = new UserBeans();
				ub.setId(rs.getString("user_id"));
				ub.setLogin_id(rs.getString("login_id"));
				ub.setName(rs.getString("name"));
				ub.setBirth_date(rs.getString("birth_date"));
				ub.setPassword(rs.getString("password"));
				ub.setCreate_date(rs.getString("create_date"));
				ub.setUpdate_date(rs.getString("update_date"));
				ub.setEmail(rs.getString("email"));
				return ub;
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			closeConn(conn);
		}
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
}
