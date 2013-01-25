package it.vitux.tuesou;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class TrackingActivity extends MapActivity {
	
	private MapController mapController; 
	private String providerId = LocationManager.GPS_PROVIDER; 
	private GeoPoint currentPosition;
	private MapView mapView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_map); 
		mapView = (MapView) findViewById(R.id.mapView); 
		mapView.setClickable(true); 
		mapView.setBuiltInZoomControls(true);
		
		mapController = mapView.getController(); 
		mapController.setZoom(30);
		
		mapView.getOverlays().add(new CurrentPositionOverlay()); 
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private LocationListener myLocationListener = new LocationListener() {
		
		public void onStatusChanged(String provider, int status, Bundle extras) { 
			} 
		
		public void onProviderEnabled(String provider) { 
			} 
		
		public void onProviderDisabled(String provider) { 
		 	} 
		
		public void onLocationChanged(Location location) { 
		   setCurrentLocation(location); 
		  	} 
	};
	
	@Override
	protected void onResume() { 
		super.onResume(); 
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE); 
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
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE); 
		locationManager.removeUpdates(myLocationListener); 
	}
	
	private void setCurrentLocation(Location location) { 
		double latitude = location.getLatitude(); 
		double longitude = location.getLongitude(); 
		int latitudeE6 = (int) Math.floor(latitude * 1.0E6); 
		int longitudeE6 = (int) Math.floor(longitude * 1.0E6); 
		GeoPoint geoPoint = new GeoPoint(latitudeE6, longitudeE6); 
		mapController.setCenter(geoPoint); 
		
		this.currentPosition = geoPoint; 
	}
	
	private class CurrentPositionOverlay extends Overlay { 
		
		private Bitmap youarehere; 
		
		public CurrentPositionOverlay() { 
			Resources res = TrackingActivity.this.getResources(); 
		    youarehere = BitmapFactory.decodeResource(res, R.drawable.ic_launcher); 
		} 
		   
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) { 
			if (shadow == false && currentPosition != null) { 
				Point point = new Point(); 
				Projection projection = mapView.getProjection(); 
				projection.toPixels(currentPosition, point); 
				float x = point.x - (youarehere.getWidth() / 2); 
				float y = point.y - youarehere.getHeight(); 
				canvas.drawBitmap(youarehere, x, y, null); 
			} 
		} 
	}
	
}

