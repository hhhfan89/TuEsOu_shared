package it.vitux.tuesou;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import it.vitux.tuesou.R;

import android.widget.SimpleAdapter;




public class MainActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final UserFunction userFunction = new UserFunction();
        Log.i("OK", "Creazione user function");
        User user = userFunction.getInstanceUser(getApplicationContext());
        
        //vuol dire che ha trovato un utente, cioè l'ultimo loggato!
        if(user!=null){
        	//per semplicità ho fatto che entra direttamente nel profilo utente
        	setContentView(R.layout.layout_userprofile);
        	TextView username = (TextView) findViewById(R.id.textViewUsernameLabel);
        	username.setText(user.getUsername());
        	
        	/*setContentView(R.layout.layout_login);
        	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
     
        	//Se l'utente già esiste
        	if(user.getUsername() != null && user.getKey() != null) {
        		EditText editTextUsername = (EditText) findViewById(R.id.username_login);
        		editTextUsername.setText(user.getUsername());
        	}
        	else {
        		Toast.makeText(MainActivity.this,"Non esiste", Toast.LENGTH_LONG).show();
        	}*/
        }
        //non ha trovato nessun utente nel db (prima volta che usa il programma)
        else{
        	setContentView(R.layout.layout_login);
        
        	
    	final EditText txtUserName = (EditText)findViewById(R.id.username_login);
		final EditText txtPassword = (EditText)findViewById(R.id.password_login);
		Button btnLogin = (Button)findViewById(R.id.button_Login);
		
		btnLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				String username = txtUserName.getText().toString();
				String password = txtPassword.getText().toString();
				try{
					if(username.length() > 0 && password.length() >0)
					{	
						User user = userFunction.getInstanceUser(getApplicationContext(), username);
						setContentView(R.layout.layout_userprofile);
			        	TextView username_profile = (TextView) findViewById(R.id.textViewUsernameLabel);
			        	username_profile.setText(user.getUsername());
					}
					
				}catch(Exception e)
				{
					Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
				}
			}
			
		});
	}
    }





    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getSupportMenuInflater();
    	inflater.inflate(R.menu.activity_userprofile, menu);
        Toast.makeText(this, "Ciao, Mondo!", Toast.LENGTH_LONG).show();
        return true;
    }
}



