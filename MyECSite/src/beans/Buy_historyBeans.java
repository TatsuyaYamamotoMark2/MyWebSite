package beans;

import java.io.Serializable;

public class Buy_historyBeans implements Serializable {

private String buy_id;
private String user_id;
private String buy_date;

private String m_id;


	public Buy_historyBeans() {

	}

	public Buy_historyBeans(String buy_id,String user_id,String buy_date,String m_id) {
		this.buy_id			=	buy_id;
		this.user_id 		=	user_id;
		this.buy_date 		=	buy_date;
		this.setM_id(m_id);
	}

	public String getBuy_id() {
		return buy_id;
	}

	public void setBuy_id(String buy_id) {
		this.buy_id = buy_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}


