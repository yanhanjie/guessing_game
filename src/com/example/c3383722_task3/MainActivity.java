package com.example.c3383722_task3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private TextView nameOutput;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		MenuInflater inflater = getMenuInflater(); //To inflate the xml
        inflater.inflate(R.menu.options_menu,menu); //Inflate the options 
        return true;

	}
	
	
	//Respond to item selected on OPTIONS MENU 
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.guessing:
        	Intent launchNewIntent = new Intent(MainActivity.this,guessing_game.class);
        	EditText etValue = (EditText) findViewById(R.id.editText1);
        	launchNewIntent.putExtra("Value1", etValue.getText().toString());
        	String a = etValue.getText().toString();
        	if (a.toString().trim().length() > 0){
        		startActivityForResult(launchNewIntent, 0);
        	}
        	else{
        		Toast.makeText(this, "Please Enter Your Name Before Start Game!", Toast.LENGTH_SHORT).show();
			}
        	
            return true;
        case R.id.Game_Place_Hold1:
        	Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.Game_Place_Hold2:
        	Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.Game_Place_Hold3:
        	Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
            return true; 
        
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
}
