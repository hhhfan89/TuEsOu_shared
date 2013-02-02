package it.vitux.tuesou;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapPageFragment extends SupportMapFragment {

	GoogleMap map;
	
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
 Bundle savedInstanceState) {
 super.onCreateView(inflater, container, savedInstanceState);

 View v = inflater.inflate(R.layout.activity_map_fragment, container, false);
// map = getMap();

// map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
 /* Marker startPerc = map.addMarker(new MarkerOptions()
 .position(new LatLng(42.093230818037,11.7971813678741))
 .title("Start")
 .snippet("Inizio del percorso")
 .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));*/

 return v;
}

@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
 super.onViewCreated(view, savedInstanceState);
}


public void setPosition(double lat, double lon) {
	 
	LatLng latLng = new LatLng(lat, lon);
	 CameraPosition pos = new CameraPosition.Builder()
	     .target(latLng)
	     .zoom(18)
	     .tilt(map.getCameraPosition().tilt)
	     .build();
	 map.animateCamera(CameraUpdateFactory.newCameraPosition(pos));
	
}
 }