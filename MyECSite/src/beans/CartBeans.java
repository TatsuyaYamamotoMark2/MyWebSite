package beans;

import java.io.Serializable;

	public class CartBeans implements Serializable {

	private String m_id;
	private String al_id;
	private String image;
	private String m_name;
	private String al_name;
	private String ar_name;
	private String m_price;


	public CartBeans() {

	}
	public CartBeans(String m_id,String al_id,String image,String m_name,String al_name,String ar_name,String m_price) {
		this.setM_id(m_id);
		this.setAl_id(al_id);
		this.setImage(image);
		this.setM_name(m_name);
		this.setAl_name(al_name);
		this.setAr_name(ar_name);
		this.setM_price(m_price);
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getAl_name() {
		return al_name;
	}
	public void setAl_name(String al_name) {
		this.al_name = al_name;
	}
	public String getAr_name() {
		return ar_name;
	}
	public void setAr_name(String ar_name) {
		this.ar_name = ar_name;
	}
	public String getM_price() {
		return m_price;
	}
	public void setM_price(String m_price) {
		this.m_price = m_price;
	}
	public String getAl_id() {
		return al_id;
	}
	public void setAl_id(String al_id) {
		this.al_id = al_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}