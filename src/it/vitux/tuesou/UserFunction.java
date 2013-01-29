package it.vitux.tuesou;

import it.vitux.tuesou.entity.User;
import android.content.Context;
import android.util.Log;

public class UserFunction {
	
	public UserFunction() {
		
	}
	
	/**
	 * @return
	 */
	public User getInstanceUser(Context cxt) {
		
		DBUserAdapter dbUserAdapter = new DBUserAdapter(cxt);
		 Log.i("OK", "Prima di queryUserLogged");
		return dbUserAdapter.queryUserLogged();
		
	}
	
	
	
	
	public User getInstanceUser(Context cxt, String username) {
		
		DBUserAdapter dbUserAdapter = new DBUserAdapter(cxt);
		 Log.i("OK", "Prima di queryUserLogged");
		return dbUserAdapter.queryUserLogged(username);
		
	}
	
	
	
}
