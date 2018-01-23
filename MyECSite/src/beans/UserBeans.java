package beans;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBeans implements Serializable {

	private String id;
	private String login_id;
	private String name;
	private String birth_date;
	private String password;
	private String create_date;
	private String update_date;
	private String email;


	public UserBeans() {

	}
	public UserBeans(String id,String login_id,String name,String birth_date,String password,String create_date,String update_date,String email) {
		this.id				=	id;
		this.login_id 		=	login_id;
		this.name 			=	name;
		this.birth_date	 	= 	birth_date;
		this.password		=	password;
		this.create_date		=	create_date;
		this.update_date		=	update_date;
		this.email			=	email;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public String getFormat_Birth_date() {
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdFormat.parse(this.birth_date);
			String str = new SimpleDateFormat("yyyy年MM月dd日").format(date);
			this.birth_date = str;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreate_date() {
		return create_date;
	}
	public String getFormat_Create_date() {
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = sdFormat.parse(this.create_date);
			String str = new SimpleDateFormat("yyyy年MM月dd日 hh:mm").format(date);
			this.create_date = str;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getFormat_Update_date() {
		try {
		//String型をDate型に変換
		//()にもとの形式をymdで伝える
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = sdFormat.parse(this.update_date);
		//Date型を指定のフォーマットにしてString型文字列で返す
			String str = new SimpleDateFormat("yyyy年MM月dd日 hh:mm").format(date);
			this.update_date = str;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
