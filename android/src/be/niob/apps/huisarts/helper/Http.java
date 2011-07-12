package be.niob.apps.huisarts.helper;

import java.io.IOException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class Http {

	public static String get(String url) throws ClientProtocolException, IOException {
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		BasicResponseHandler handler = new BasicResponseHandler();
		return httpclient.execute(request, handler);
		
	}
	
	public static String post(String url, List<NameValuePair> params) throws ClientProtocolException, IOException {
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
		HttpPost post = new HttpPost(url);
		post.setEntity(entity);
		
		BasicResponseHandler handler = new BasicResponseHandler();
		HttpClient httpclient = new DefaultHttpClient();
		return httpclient.execute(post, handler);
		
	}
	
}
