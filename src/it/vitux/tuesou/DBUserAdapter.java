
package it.vitux.tuesou;

import it.vitux.tuesou.entity.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBUserAdapter 
{ 

        
    private Context context = null;  
    private DatabaseHelper DBHelper;

    private SQLiteDatabase db;

    public DBUserAdapter(Context ctx) 
    {
        DBHelper = DBHelper.getInstance(ctx);
    }
    
    public User queryUserLogged() {
		SQLiteDatabase db = DBHelper.getWritableDatabase(); 
		Log.i("OK", "Dentro queryUserLogged, dopo sqlite: " + db.toString());
		
		ContentValues values = new ContentValues(); 
		/*values.put("key", "3739ehwj"); 
		values.put("username", "Rossi"); 
		values.put("key", "1111"); 
		values.put("username", "Stefa"); 
		
		long id = db.insert("user", null, values);
		Log.i("OK", "dopo insert");*/
		
		db = DBHelper.getReadableDatabase();
		String query = "SELECT key, username FROM user WHERE (SELECT MAX(_id) FROM user ORDER BY _id ASC)";
		Cursor cursor = db.rawQuery(query, null);
		Log.i("OK", "dopo rawQuery, cursor=" + cursor.getPosition());
		cursor.moveToFirst();	
		
		Log.i("OK", "dopo moveToFirst, getCount=" + cursor.getCount());
		
		if( cursor.getCount()==0){
			Log.i("OK", "return null");
			return null;
		}
		
		//view the last user inserted
		else {
			String key = cursor.getString(cursor.getColumnIndex("key"));
			Log.i("OK", "inside else, after key = " + key);
			String username = cursor.getString(cursor.getColumnIndex("username"));
			Log.i("OK", "inside else, after username = " + username);
			User user = new User();
			user.setUsername(username);
			Log.i("OK", "inside else, dopo setUsername");
			user.setKey(key);
			Log.i("OK", "inside else, after setKey");
			Log.i("OK", "return User from queryUserLogged");
			return user;
		}
	}
        
    
    public User queryUserLogged(String username_toInsert) {
		SQLiteDatabase db = DBHelper.getWritableDatabase(); 
		 Log.i("OK", "Inside queryUserLogged, after sqlite: " + db.toString());
		
		ContentValues values = new ContentValues(); 
		values.put("key", "key1"); 
		values.put("username", username_toInsert); 
		
		long id = db.insert("user", null, values);
		Log.i("OK", "after insert");
		
		db = DBHelper.getReadableDatabase();
		String query = "SELECT key, username FROM user WHERE (SELECT MAX(_id) FROM user ORDER BY _id ASC)";
		Cursor cursor = db.rawQuery(query, null);
		Log.i("OK", "after rawQuery, cursor=" + cursor.getPosition());
		cursor.moveToFirst();	
		
		Log.i("OK", "after moveToFirst, getCount=" + cursor.getCount());
		
		/*
		while(!cursor.isLast()){
			Log.i("OK", "username: " + cursor.getString(cursor.getColumnIndex("username")));
			cursor.moveToNext();
		}
		
		if(cursor.isNull(1) && cursor.isNull(2)) {
			Log.i("OK", "ritorna null");
			return null;
		}*/
		if( cursor.getCount()==0){
			Log.i("OK", "return null");
			return null;
		}
		
		//vede l'ultimo utente inserito
		else {
			String key = cursor.getString(cursor.getColumnIndex("key"));
			Log.i("OK", "inside else, after key = " + key);
			String username = cursor.getString(cursor.getColumnIndex("username"));
			Log.i("OK", "inside else, after username = " + username);
			User user = new User();
			user.setUsername(username);
			Log.i("OK", "inside else, after setUsername");
			user.setKey(key);
			Log.i("OK", "inside else, after setKey");
			Log.i("OK", "return User from1 queryUserLogged");
			return user;
		}
	}
}