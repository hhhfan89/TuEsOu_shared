package it.vitux.tuesou;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class GPSTracker extends Service implements LocationListener {

	private Context mContext;

	// flag for GPS status
	private boolean isGPSEnabled = false;
	private boolean isNetworkEnabled = false;
	private boolean canGetLocation = false;

	private Location location; // location
	private double latitude; // latitude
	private double longitude; // longitude

	// The minimum distance to change Updates in meters
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 0 meters

	// The minimum time between updates in milliseconds
	private static final long MIN_TIME_BW_UPDATES = 20000; // 1 minute

	private String providerId;
	private LocationManager locationManager;

	public GPSTracker(Context context) {
		this.mContext = context;
		getLocation();
	}


	public Location getLocation() {
		try {
			locationManager = (LocationManager) mContext
					.getSystemService(LOCATION_SERVICE);

			// getting GPS status
			isGPSEnabled = locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);

			if(!isGPSEnabled) {
				this.canGetLocation = false;
			}
			else {
				this.canGetLocation = true;
				// if GPS Enabled get lat/long using GPS Services
				if (isGPSEnabled) {
					if (location == null) {
						locationManager.requestLocationUpdates(
								LocationManager.GPS_PROVIDER,
								MIN_TIME_BW_UPDATES,
								MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
						Log.d("GPS Enabled", "GPS Enabled");
						if (locationManager != null) {
							location = locationManager
									.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) {
								latitude = location.getLatitude();
								longitude = location.getLongitude();
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	public double getLatitude(){
		if(location != null){
			latitude = location.getLatitude();
		}
		// return latitude
		return latitude;
	}

	public double getLongitude(){
		if(location != null){
			longitude = location.getLongitude();
		}
		// return longitude
		return longitude;
	}

	/**
	 * Function to check if best network provider
	 * @return boolean
	 * */
	public boolean canGetLocation() {
		return this.canGetLocation;
	}

	/**
	 * Function to show settings alert dialog
	 * On pressing Settings button will launch Settings Options
	 * */
	public void showSettingsAlert(){
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

		// Setting Dialog Title
		alertDialog.setTitle("GPS Settings");

		// Setting Dialog Message
		alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

		// On pressing Settings button
		alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int which) {
				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				mContext.startActivity(intent);
			}
		});

		// on pressing cancel button
		alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}

	public void stopUsingGPS(){
		if(locationManager != null){
			locationManager.removeUpdates(GPSTracker.this);
		}
	}

	public void onLocationChanged(Location location) {
		sendMessage();

	}


	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}


	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}


	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	private void sendMessage() {
		Log.d("sender", "Broadcasting message");
		Intent intent = new Intent("new_coordinates");
		intent.putExtra("new_coordinates", "prova");
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
	}


	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
