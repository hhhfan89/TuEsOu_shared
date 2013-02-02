package it.vitux.tuesou;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapPageFragment extends SupportMapFragment {

	//SupportMapFragment map;
	private GoogleMap mMap;
	private FragmentManager fm;
	

	public MapPageFragment(FragmentManager f1){
		Log.i("a", "mapPageFragment");
		fm = f1;
	}

	/*
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
		Bundle savedInstanceState) {
 	super.onCreateView(inflater, container, savedInstanceState);
 	Log.i("onCreate", "a");
	
	return v;
	
	}*/


	public void setPosition(double lat, double lon) {

		LatLng latLng = new LatLng(lat, lon);
		/*CameraPosition pos = new CameraPosition.Builder()
	     .target(latLng)
	     .zoom(18)
	     .tilt(map.getCameraPosition().tilt)
	     .build();
	 map.animateCamera(CameraUpdateFactory.newCameraPosition(pos));
	 Log.i("vdvd", "vdvd");*/

		/*	Marker startPerc = map.addMarker(new MarkerOptions()
	 .position(new LatLng(42.093230818037,11.7971813678741))
	 .title("Start")
	 .snippet("Inizio del percorso"));*/
	}


	public void setPosition() {
		
		LatLng inizio = new LatLng(41.875489,12.571857);
		LatLng fine = new LatLng(41.875281,12.572973);
		
		List<LatLng> locations = new ArrayList<LatLng>();
		locations.add(inizio);
		locations.add(fine);
		
		Marker startPerc = mMap.addMarker(new MarkerOptions()
		.position(inizio)
		.title("Start")
		.snippet("Inizio del percorso"));
		
		CameraPosition pos = new CameraPosition.Builder()
	     .target(inizio)
	     .zoom(18)
	     .tilt(mMap.getCameraPosition().tilt)
	     .build();
	 mMap.animateCamera(CameraUpdateFactory.newCameraPosition(pos));
	 
	 Polyline p = mMap.addPolyline(new PolylineOptions()
     .add(inizio)
     .width(5)
     .color(Color.RED)
     .geodesic(true));
	 
	 p.setPoints(locations);
	 
	}


	public void setMap(int map) {

		Fragment fragment1 = fm.findFragmentById(map);
		SupportMapFragment mapFragment = (SupportMapFragment) fragment1;
		mMap = mapFragment.getMap();

	}


}