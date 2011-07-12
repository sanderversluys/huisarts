package be.niob.apps.huisarts.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import be.niob.apps.huisarts.helper.Http;
import be.niob.apps.huisarts.model.Wachtdienst;
import be.niob.apps.huisarts.model.WachtdienstResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WachtdienstService {

	public static final String TAG = WachtdienstService.class.getName();
	
	public static final String TYPE_GEMEENTES = "gemeentes";
	public static final String TYPE_WACHTDIENST = "wachtdienst";

	public static final String wsUrl = "http://niobservices.appspot.com/huisarts/";
	public static final String wachtdientUrl = wsUrl + "wachtdienst?gemeente=%s&postcode=%s&nr=%s";
	public static final String huisartsUrl = wsUrl + "huisarts?gemeente=%s&postcode=%s";
	
	
	
	/*public static WachtdienstResponse getWachtdienstInGemeente(String nr) throws ClientProtocolException, IOException {
		
	}*/

	public static WachtdienstResponse getWachtdienstInGemeente(String gemeente,
			String postcode) throws ClientProtocolException, IOException, ParseException, JSONException {
		
		String response = Http.get(String.format(wachtdientUrl, URLEncoder.encode(gemeente), URLEncoder.encode(postcode), ""));
		JSONObject json = new JSONObject(response);
		
		String type = json.getString("type");
		
		WachtdienstResponse wr = new WachtdienstResponse();
		wr.setType(type);
		
		Gson gson = new Gson();
		if (type.equals(TYPE_GEMEENTES)) {
			Type typeToken = new TypeToken<Map<String, String>>(){}.getType();
			Map<String, String> gemeentes = gson.fromJson(json.getJSONObject("data").toString(), typeToken);
			wr.setGemeentes(gemeentes);
		} else if (type.equals(TYPE_WACHTDIENST)) {
			Wachtdienst w = gson.fromJson(json.getJSONObject("data").toString(), Wachtdienst.class);
			wr.setWachtdienst(w);
		} else {
			throw new ParseException("The returned JSON was not formed like expected", 0);
		}

		return wr;
	}

}
