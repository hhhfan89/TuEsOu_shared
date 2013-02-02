package it.vitux.tuesou;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import it.vitux.tuesou.R;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/*public class MainActivity extends SherlockActivity {

	
//private ListView listView;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_personaltracking);
            
            onSearchRequested();
            
            ListView listView = (ListView) findViewById(R.id.trackingListView);
            
            List<Person> list = new ArrayList<Person>();
            
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));
            list.add(new Person("Il mio primo tracciato", "Data: " + "10/10/10", "Ora di partenza: " + "14:21", "Ora di arrivo: " + "14:22", R.id.buttonDeleteTrack));

 
            
            PersonAdapter adapter = new PersonAdapter(this, R.layout.listitem_tracking, list);
            listView.setAdapter(adapter);

    }} 
   



*/


public class MainActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try{
        	setContentView(R.layout.layout_login);
        	EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        }
        catch (NullPointerException e) {
        	//setContentView(R.layout.layout_login);
        }
        /*if(user.getUsername() != null && user.getKey() != null) {

        	//apri layout login e
        	//metti nella textview l'username dell'utente
        }
        else {
        	setContentView(R.layout.layout_login);
        	//fai qualcosa ancora poco chiaro
        }*/
        
        //setContentView(R.layout.layout_userprofile);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getSupportMenuInflater();
    	inflater.inflate(R.menu.activity_userprofile, menu);
        Toast.makeText(this, "Ciao, Mondo!", Toast.LENGTH_LONG).show();
        return true;
    }
}

