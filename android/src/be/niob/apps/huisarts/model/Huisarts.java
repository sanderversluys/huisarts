package be.niob.apps.huisarts.model;

public class Huisarts {

	private String naam;
	private String type;
	private String adres;
	private String nummer;
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	public String getAdres() {
		return adres;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	
	public String getNummer() {
		return nummer;
	}
	
}
