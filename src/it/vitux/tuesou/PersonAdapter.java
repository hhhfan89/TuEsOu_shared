package it.vitux.tuesou;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter{

	private Context context;
	private int textViewResourceId;
	private List<Person> people;
	
	public PersonAdapter(Context context, int textViewResourceId, List<Person> list){
		super();
		this.context = context;
		this.textViewResourceId = textViewResourceId;
		this.people = list;
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return people.size();
	}

	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return people.get(i);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Context getContext(){
		return context;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.listitem_tracking, null);
		TextView trackName = (TextView) convertView.findViewById(R.id.trackName);
		TextView dateTrack = (TextView) convertView.findViewById(R.id.dateTrack);
		TextView departureTimeTrack = (TextView) convertView.findViewById(R.id.departureTimeTrack);
		TextView arrivalTimeTrack = (TextView) convertView.findViewById(R.id.arrivalTimeTrack);
		ImageButton personDeleteButton = (ImageButton) convertView.findViewById(R.id.buttonDeleteTrack);
		Person p = (Person) getItem(position);
		trackName.setText(p.getName());
		dateTrack.setText(p.getDate());
		departureTimeTrack.setText(p.getDepartureTime());
		arrivalTimeTrack.setText(p.getArrivalTime());
		personDeleteButton.setId(p.getDeleteTrack());
		
		return convertView;
	}

}
