package beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

	public class AlbumBeans implements Serializable {

	private String al_id;
	private String al_name;
	private String image;
	private String release_date;
	private String al_price;


	public AlbumBeans() {

	}
	public AlbumBeans(String al_id,String al_name,String image,String release_date,String al_price) {
		this.al_id			=	al_id;
		this.al_name			=	al_name;
		this.image			=	image;
		this.release_date	=	release_date;
		this.al_price		=	al_price;
	}



	public String getAl_id() {
		return al_id;
	}
	public void setAl_id(String al_id) {
		this.al_id = al_id;
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
	public String getAl_price() {
		return al_price;
	}
	public void setAl_price(String al_price) {
		this.al_price = al_price;
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
}
