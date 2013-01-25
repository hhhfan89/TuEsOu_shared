package it.vitux.tuesou;

import android.app.Dialog; 
import android.content.Context; 
import android.os.Bundle; 
import android.widget.ImageView; 
import android.widget.TextView; 

public class CustomDialog extends Dialog { 

	public CustomDialog(Context context) { 
		super(context); 
 } 


@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.custom_dialog); 
 } 
  
	public void setImage(int resId) { 
		ImageView image = (ImageView) findViewById(R.id.image); 
		image.setImageResource(resId); 
 } 
	public void setMessage(String message) { 
		TextView text = (TextView) findViewById(R.id.customDialogUsernameLabel); 
		text.setText(message); 
 } 
}