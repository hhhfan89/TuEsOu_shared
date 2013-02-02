package it.vitux.tuesou;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityMapFrag extends FragmentActivity {

public FragmentManager fManager ;
public MapPageFragment plotterFragment;
FragmentTransaction ft;
GoogleMap map;
//private static final LatLng ROMA = new LatLng(42.093230818037,11.7971813678741);


@Override
protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 fManager = getSupportFragmentManager();
 loadMapFragment();
}

private void loadMapFragment() {
 plotterFragment = new MapPageFragment();
 ft = fManager.beginTransaction();
 ft.replace(R.id.allFragmentsFrameLayout, plotterFragment);
 ft.addToBackStack(null);
 ft.commit();
}

private void setPos() {

	ft = fManager.beginTransaction();
	 ft.replace(R.id.allFragmentsFrameLayout, plotterFragment);
	 ft.addToBackStack(null);
	 ft.commit();
	}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
 // Inflate the menu; this adds items to the action bar if it is present.
 getMenuInflater().inflate(R.layout.activity_main, menu);
 return true;
}
}