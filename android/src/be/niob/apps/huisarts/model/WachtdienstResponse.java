package be.niob.apps.huisarts.model;

import java.util.Map;

public class WachtdienstResponse {
	
	private String type;
	private Wachtdienst wachtdienst;
	private Map<String, String> gemeentes;
	
	private Throwable exception;
	
	public WachtdienstResponse() {}
	
	public WachtdienstResponse(Throwable exception) {
		this.exception = exception;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setWachtdienst(Wachtdienst wachtdienst) {
		this.wachtdienst = wachtdienst;
	}
	public Wachtdienst getWachtdienst() {
		return wachtdienst;
	}
	public void setGemeentes(Map<String, String> gemeentes) {
		this.gemeentes = gemeentes;
	}
	public Map<String, String> getGemeentes() {
		return gemeentes;
	}
	public void setException(Throwable exception) {
		this.exception = exception;
	}
	public Throwable getException() {
		return exception;
	}
	public boolean isSucces() {
		return exception == null;
	}
	
}
