package com.example.c3383722_task3;


import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class guessing_game extends Activity {

	private TextView nameOutput;
	//private EditText nameInput;
    private TextView numberOutput;
	private EditText numberInput;
	private TextView numOutput;
	private TextView remaintimes;
	private EditText difficultyinput;
	private TextView difficultyoutput;
	TextView result;
	int randomnumber;
	int guessnumber;
	int times;
	int i;
	Button button1; 
	Button button2;
	String valueReceived;
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.guessing_game);
		
		Bundle extras = getIntent().getExtras();
		String valueReceived = extras.getString("Value1");
		nameOutput = (TextView) findViewById(R.id.outputName);
		nameOutput.setText("Player Name£º" + valueReceived);
		
		numberInput = (EditText) findViewById(R.id.editNumber);
		remaintimes = (TextView) findViewById(R.id.textView3);
		
		difficultyinput = (EditText) findViewById(R.id.editText1);
        difficultyoutput = (TextView) findViewById(R.id.textView5);
		result = (TextView) findViewById(R.id.textView4);
		
	
		button1 = (Button) findViewById(R.id.startgame);

        button2 = (Button) findViewById(R.id.guess);
		
		//randomoutput =(TextView) findViewById(R.id.rannum);
	}
	
	
	
public void startgame(View startgame){
		
	  
		//String name = nameInput.getText().toString();
		String difficulty = difficultyinput.getText().toString();
		//if (name.toString().trim().length() > 0){
			if(difficulty.toString().trim().length()>0){
			difficultyoutput.setText("Difficulity: " + difficulty);
			int i = Integer.parseInt(difficulty);
			 if (i>5){
			 Random r = new Random();
			 randomnumber = r.nextInt(i+1);
			 times = 5;
			 remaintimes.setText("Remain Times: " + times);
			 result.setTextColor(Color.parseColor("#00FF00"));
			 result.setText("Result: Good Luck & Have Fun!");	
			}
			
			else {
				result.setTextColor(Color.parseColor("#B0171F"));
				result.setText("Result: Please Enter vaild difficulty!");
			}
			}
			else{
				result.setTextColor(Color.parseColor("#B0171F"));
				result.setText("Result: Please Enter the difficulty!");	
			}
		//}	
		//else{
		//result.setTextColor(Color.parseColor("#B0171F"));
		//result.setText("Result: Please Enter Your Name!");	
		//}
		}
	
public void guess (View guess){
	if (times >0){
	times = times -1;
	remaintimes.setText("Remain Times: " + times);
	String difficulty = difficultyinput.getText().toString();
	int i = Integer.parseInt(difficulty);
	String number = numberInput.getText().toString();
	int guessnumber = Integer.parseInt(number);
	remaintimes.setText("Remain Times: " + times);
	
	if((guessnumber <=i) && (guessnumber >=0)){
	
	if(guessnumber > randomnumber){
	result.setTextColor(Color.parseColor("#B0171F"));
	result.setText("Result: " + guessnumber + " is Bigger than random number!");
	}
	
	else if (guessnumber < randomnumber ){
	result.setTextColor(Color.parseColor("#FFFF00"));
	result.setText("Result: " + guessnumber + " is Smaller than random number!");
	}
	
	else{
	result.setTextColor(Color.parseColor("#00FF00"));	
	result.setText("Result: " + guessnumber + " is Correct!");	
	}
	}
	else {
	result.setTextColor(Color.parseColor("#00FF00"));		
	result.setText("Result: Please enter valid number!");		
	}
	}
	else {
	result.setText("Result: Game Over. The correct number is: "+randomnumber);	
	}
    }

    public void onClick(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    this.startActivity(intent);
    String stringresult = result.getText().toString();
    Toast.makeText(this, stringresult, Toast.LENGTH_SHORT).show();
  }







}