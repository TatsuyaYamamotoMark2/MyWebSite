package beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicBeans implements Serializable {


	private String m_id;
	private String al_id;
	private String ar_id;
	private String m_name;
	private String m_price;
	private String DL_path;
	private String mp3;
	private String track_no;
	private String al_name;
	private String image;
	private String release_date;
	private String ar_name;
	private String al_price;
	private int count;
	private int rank;

	private boolean purchased;
	private boolean add_cart;





	public MusicBeans(String m_id,String al_id,String ar_id,String m_name,String m_price,String DL_path,String mp3,String track_no,String al_name,String image,String release_date,String ar_name,String al_price,String count) {
		this.setM_id(m_id);
		this.setAl_id(al_id);
		this.setAr_id(ar_id);
		this.setM_name(m_name);
		this.setM_price(m_price);
		this.setDL_path(DL_path);
		this.setMp3(mp3);
		this.setTrack_no(track_no);
		this.setAl_name(al_name);
		this.setImage(image);
		this.setRelease_date(release_date);
		this.setAr_name(ar_name);
	}
	public MusicBeans() {
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getAl_id() {
		return al_id;
	}
	public void setAl_id(String al_id) {
		this.al_id = al_id;
	}
	public String getAr_id() {
		return ar_id;
	}
	public void setAr_id(String ar_id) {
		this.ar_id = ar_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_price() {
		return m_price;
	}
	public void setM_price(String m_price) {
		this.m_price = m_price;
	}
	public String getDL_path() {
		return DL_path;
	}
	public void setDL_path(String dL_path) {
		DL_path = dL_path;
	}
	public String getMp3() {
		return mp3;
	}
	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	public String getAl_name() {
		return al_name;
	}
	public void setAl_name(String al_name) {
		this.al_name = al_name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getAr_name() {
		return ar_name;
	}
	public void setAr_name(String ar_name) {
		this.ar_name = ar_name;
	}	public String getTrack_no() {
		return track_no;
	}	public void setTrack_no(String track_no) {
		this.track_no = track_no;
	}
	public String getFormat_Release_date() {
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdFormat.parse(this.release_date);
			String str = new SimpleDateFormat("yyyy/MM/dd").format(date);
			this.release_date = str;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return release_date;
	}
	public String getAl_price() {
		return al_price;
	}
	public void setAl_price(String ar_price) {

		this.al_price = ar_price;
	}
	public boolean isAdd_cart() {
		return add_cart;
	}
	public void setAdd_cart(boolean add_cart) {
		this.add_cart = add_cart;
	}
	public boolean isPurchased() {
		return purchased;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

}
