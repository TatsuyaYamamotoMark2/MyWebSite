package beans;

import java.io.Serializable;

public class ArtistBeans  implements Serializable{


	private String ar_id;
	private String ar_name;

	public ArtistBeans() {
	}
	public ArtistBeans(String ar_id, String ar_name) {
	}
	public String getAr_id() {
		return ar_id;
	}
	public void setAr_id(String ar_id) {
		this.ar_id = ar_id;
	}
	public String getAr_name() {
		return ar_name;
	}
	public void setAr_name(String ar_name) {
		this.ar_name = ar_name;
	}


}
