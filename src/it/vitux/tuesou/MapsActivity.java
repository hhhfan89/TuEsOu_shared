package it.vitux.tuesou;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MapsActivity extends MapActivity { 
	
	private static final int MILLION = 1000000; 
	MapView map; 
	MapController controller;
	double lat = 0; 
	double lon; 
	GeoPoint myPoint; 
	private Location location;
	
	private String providerId = LocationManager.GPS_PROVIDER;

	public MapsActivity(){
		MapView map = new MapView(null, providerId);
		Log.i("oo", "dopoMap");
		controller = map.getController(); 
		Log.i("oo", "dopoController");
		controller.setZoom(17);
	}
	/*@Override 
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.layout_map); 
		map = (MapView) findViewById(R.id.mapView); 
		Log.i("oo", "dopoMap");
		controller = map.getController(); 
		Log.i("oo", "dopoController");
		controller.setZoom(17); */
		
	/*	LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    Criteria criteria = new Criteria();
	    String provider = locationManager.getBestProvider(criteria, false);
	    Location location = locationManager.getLastKnownLocation(provider);
		
		
		Intent i = getIntent(); 
		location.setLatitude(i.getExtras().getDouble("lat"));
		location.setLongitude(i.getExtras().getDouble("long"));*/
		
		//Log.i("Location", Double.toString(location.getLatitude()));
		//Log.i("Location", Double.toString(location.getLongitude()));
		
		//setCurrentLocation(location);
		
		
		
		/*
		lat = i.getExtras().getDouble("lat");
		lon = i.getExtras().getDouble("long");
		int latE6 = (int) (lat * MILLION); 
		int lonE6 = (int) (lon * MILLION); 
		myPoint = new GeoPoint(latE6, lonE6); */

		
		/*ViewGroup zoom=(ViewGroup)findViewById(R.id.zoom); 
		zoom.addView(map.getZoomControls()); 
		controller = map.getController(); 
		controller.setZoom(17); 
		controller.setCenter(myPoint); */
	//}
		
	public MapView getMap(){
		return map;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/*
	
	private LocationListener myLocationListener = new LocationListener() {
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
		@Override
		public void onProviderEnabled(String provider) {
		}
		@Override
		
		public void onProviderDisabled(String provider) {
		}
		@Override
		public void onLocationChanged(Location location) {
			setCurrentLocation(location);
		}
	};
	
	
	
	@Override
	protected void onResume() {
		super.onResume();
		LocationManager locationManager = (LocationManager) getSystemService(
				LOCATION_SERVICE);
		LocationProvider provider = locationManager.getProvider(providerId);
		if (provider != null && locationManager.isProviderEnabled(providerId)) {
			Location lastKnownLocation = locationManager.getLastKnownLocation(providerId);
			if (lastKnownLocation != null) {
				setCurrentLocation(lastKnownLocation);
			}
			locationManager.requestLocationUpdates(providerId, 1, 1, myLocationListener);
		}
	}
	@Override
	protected void onPause() {
		super.onPause();
		LocationManager locationManager = (LocationManager) getSystemService(
				LOCATION_SERVICE);
		locationManager.removeUpdates(myLocationListener);
	}
	
	*/
	private void setCurrentLocation(Location location) {
		Log.i("ij", "dentro setCurrentLocation");
		double latitude = location.getLatitude();
		double longitude = location.getLongitude();
		int latitudeE6 = (int) Math.floor(latitude * 1.0E6);
		int longitudeE6 = (int) Math.floor(longitude * 1.0E6);
		GeoPoint geoPoint = new GeoPoint(latitudeE6, longitudeE6);
		Log.i("ij", "geoPoint");
		//controller = map.getController();
		controller.setZoom(17); 
		controller.setCenter(geoPoint);
	}
	
	
	public void setCurrentLocation(double lat, double lon) {
		Log.i("ij", "dentro setCurrentLocation");
		double latitude = lat;
		double longitude = lon;
		int latitudeE6 = (int) Math.floor(latitude * 1.0E6);
		int longitudeE6 = (int) Math.floor(longitude * 1.0E6);
		GeoPoint geoPoint = new GeoPoint(latitudeE6, longitudeE6);
		Log.i("ij", "geoPoint");
		controller = map.getController();
		controller.setZoom(17); 
		controller.setCenter(geoPoint);
	}
} 

 /*
public class MapsActivity extends MapActivity 
{    
    MapView mapView; 

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);
 
 
        mapView = (MapView) findViewById(R.id.mapView);
        LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);  
        View zoomView = mapView.getZoomControls(); 
 
        zoomLayout.addView(zoomView, 
            new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, 
                LayoutParams.WRAP_CONTENT)); 
        mapView.displayZoomControls(true);
 
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }
}*/