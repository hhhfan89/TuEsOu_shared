package it.vitux.tuesou;


 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class StartMapActivity extends Activity { 
	
	private Button buttonMap;
	private Intent i;

	
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		Log.i("oo", "prima");
		setContentView(R.layout.layout_login); 
	/*	i = new Intent(this, it.vitux.tuesou.MapsActivity.class);
		i.putExtra("lat", 51.48177);
		i.putExtra("long", 0.0);
		buttonMap = (Button) findViewById(R.id.button_Login);*/
		Log.i("oo", "prima");
		MapsActivity maps = new MapsActivity();/*
		buttonMap.setOnClickListener(new View.OnClickListener() {
			 @Override
	            public void onClick(View arg0) {
	                // create class object
				 startActivity(i);
			 }
		});*/
		//maps.onCreate(null);
		maps.setCurrentLocation(51.48177, 0.0);
		Log.i("oo", "ritornato");
		
		
	}

		
	
}