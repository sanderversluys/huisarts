package be.niob.apps.huisarts;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import be.niob.apps.huisarts.model.WachtdienstResponse;
import be.niob.apps.huisarts.service.WachtdienstService;

public class Main extends Activity implements OnClickListener {

	private EditText evGemeente;
	private EditText evPostcode;
	
	private Button btOk;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initViews();

		/*try {
			Wachtdienst wd = WachtdienstService.getWachtdienstInGemeente("", "9032");
			tvGemeente.setText(wd.getGemeente());
			tvPostcode.setText(wd.getPostcode());
			tvNummer.setText(wd.getNummer());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	private class WachtdienstTask extends AsyncTask<Void, Void, WachtdienstResponse> {

		private String gemeente;
		private String postcode;
		
		@Override
		protected void onPreExecute() {
			gemeente = evGemeente.getText().toString();
			postcode = evPostcode.getText().toString();
		}
		
		@Override
		protected WachtdienstResponse doInBackground(Void... arg0) {
			try {
				return WachtdienstService.getWachtdienstInGemeente(gemeente, postcode);
			} catch (Exception e) {
				e.printStackTrace();
				return new WachtdienstResponse(e);
			}
		}
		
		@Override
		protected void onPostExecute(WachtdienstResponse result) {
			if (result.isSucces()) {
				if (result.getType().equals(WachtdienstService.TYPE_GEMEENTES)) {
					Toast.makeText(Main.this, ""+result.getGemeentes().size(), Toast.LENGTH_LONG).show();
				} else if (result.getType().equals(WachtdienstService.TYPE_WACHTDIENST)) {
					Toast.makeText(Main.this, ""+result.getWachtdienst().getGemeente(), Toast.LENGTH_LONG).show();
				}
			} else {
				Toast.makeText(Main.this, result.getException().getMessage(), Toast.LENGTH_LONG).show();
			}
		}
		
	}

	private void initViews() {
		evGemeente = (EditText) findViewById(R.id.evGemeente);
		evPostcode = (EditText) findViewById(R.id.evPostcode);
		btOk = (Button) findViewById(R.id.btOk);
		btOk.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		if (arg0.getId() == btOk.getId()) {
			
			new WachtdienstTask().execute();
			
			Toast.makeText(this, "klik ok!", Toast.LENGTH_LONG).show();
		}
	}
}