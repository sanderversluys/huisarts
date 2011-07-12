package be.niob.apps.huisarts.model;

public class Wachtdienst {

	private String gemeente;
	private String postcode;
	private String nummer;
	private String nota;
	private String website;
	
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
	public String getGemeente() {
		return gemeente;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	
	public String getNummer() {
		return nummer;
	}
	
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	public String getNota() {
		return nota;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWebsite() {
		return website;
	}
	
}
