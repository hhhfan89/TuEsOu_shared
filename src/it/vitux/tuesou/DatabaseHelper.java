package it.vitux.tuesou;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	//private static final String TUESOU_DB = "tuesou_db";
	//private static final int TUESOU_VERSION = 1;
	
	private static DatabaseHelper mInstance = null;

    private static final String DATABASE_NAME = "databaseName";
    private static final String DATABASE_TABLE = "tableName";
    private static final int DATABASE_VERSION = 1;

    private Context mCxt;
    
    public DatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
        this.mCxt = ctx;
    }
    
    
    public static DatabaseHelper getInstance(Context ctx) {
        /** 
         * use the application context as suggested by CommonsWare.
         * this will ensure that you dont accidentally leak an Activitys
         * context (see this article for more information: 
         * http://developer.android.com/resources/articles/avoiding-memory-leaks.html)
         */
        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    /**
     * constructor should be private to prevent direct instantiation.
     * make call to static factory method "getInstance()" instead.
     * 
     */



	@Override
	public void onCreate(SQLiteDatabase db) {
		//creating the table in database with the username of user that logged
		String sql = "";
		sql += "CREATE TABLE user ("; 
		sql += "  _id INTEGER PRIMARY KEY,";
		sql += "  key TEXT NOT NULL,";
		sql += "  username TEXT NOT NULL";
		sql += ")"; 
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
