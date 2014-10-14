package com.example.flowchart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint({ "NewApi", "ShowToast" })
public class Start_Activity extends ActionBarActivity {
	protected static final int RESULT_SPEECH=1;
	private ImageButton btnspeak;
	private TextView txtText;
	public LinearLayout rl;

	public int x=0,y=0;
	Integer[] imageIDs = {
            R.drawable.ellipse,
            R.drawable.process,
            R.drawable.input,
            R.drawable.decision,
            R.drawable.right_arrow,
            R.drawable.left_arrow,
            R.drawable.down_arrow,
            
       
           };
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_);

		txtText = (TextView) findViewById(R.id.txtText);
		btnspeak = (ImageButton) findViewById(R.id.btnSpeak);
		btnspeak.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	 		        x = (int) btnspeak.getX();
	 	            y = (int) btnspeak.getY();
	 	            btnspeak.layout(x, y, x+btnspeak.getWidth(), y+btnspeak.getHeight());
				try{
					startActivityForResult(intent, RESULT_SPEECH);
					txtText.setText("");
					//circleAc();
				}catch(ActivityNotFoundException a){
					
					Toast t = Toast.makeText(getApplicationContext(), "Device doesnt support speech to text", Toast.LENGTH_SHORT);
					t.show();
				}
				
			}
		});
		
		
	}
	
	private void rightArrow() {
		rl = (LinearLayout) findViewById(R.id.linear01);
        Button b = new Button(this);
        b.setId(100);
       // b.setX(ht);
       // b.setY(wd);
        b.setWidth(20);;
        b.setHeight(20);
        b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        b.setBackgroundResource(imageIDs[4]);
       rl.addView(b);
   
		
	}

	private void circleAc(String str) {
		
			rl = (LinearLayout) findViewById(R.id.linear01);
	        Button b = new Button(this);
	        //LayoutParams
	        b.setText(str);
	      //  LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        b.setId(100);
	        //b.setWidth(20);
	        //b.setX(ht);
	        //b.setY(wd);
	        b.layout(x, y, x+b.getWidth(), y+b.getHeight());
	        //b.setHeight(20);
	       // b.setLayoutParams(params);
	        b.setTextSize(20);
	        b.setX(x);
	        b.setBackgroundResource(imageIDs[0]);
    
	        rl.addView(b);

	}

	private void leftArrow() {
		rl = (LinearLayout) findViewById(R.id.linear01);
        Button b = new Button(this);
        b.setId(100);
       // b.setX(ht);
       // b.setY(wd);
        b.setWidth(20);;
        b.setHeight(20);
        b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        b.setBackgroundResource(imageIDs[5]);
       rl.addView(b);
   
		
	}

	private void downArrow() {
		
		rl = (LinearLayout) findViewById(R.id.linear01);
        Button b = new Button(this);
        b.setId(100);
       // b.setX(ht);
       // b.setY(wd);
        b.setWidth(20);;
        b.setHeight(20);
        b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        b.setBackgroundResource(imageIDs[6]);
       rl.addView(b);
	}

	private void shape(String ch){
		rl = (LinearLayout) findViewById(R.id.linear01);
		String[] cm = ch.split(" ", 2);
       // b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        if(cm[0].equalsIgnoreCase("decision")){
        	 Button b = new Button(this);
             b.setText(cm[1]);
              b.setId(100);
              
             // b.setX(ht);
             // b.setY(wd);
              b.setWidth(20);;
              b.setHeight(20);
             // b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        	b.setBackgroundResource(imageIDs[3]);
        	 rl.addView(b);
        	
        }
        else if(cm[0].equalsIgnoreCase("input"))
        {
        	 Button b = new Button(this);
             b.setText(cm[1]);
              b.setId(100);
              
             // b.setX(ht);
             // b.setY(wd);
              b.setWidth(20);;
              b.setHeight(20);
             // b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        	b.setBackgroundResource(imageIDs[2]);
        	 rl.addView(b);
        }
        else if(cm[0].equalsIgnoreCase("output"))
        {
        	 Button b = new Button(this);
              b.setText(cm[1]);
              b.setId(100);
              
             // b.setX(ht);
             // b.setY(wd);
              b.setWidth(20);;
              b.setHeight(20);
             // b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        	b.setBackgroundResource(imageIDs[2]);
        	 rl.addView(b);
        }
        else if(cm[0].equalsIgnoreCase("process"))
        {
        	 Button b = new Button(this);
              b.setText(cm[1]);
              b.setId(100);
              
             // b.setX(ht);
             // b.setY(wd);
              b.setWidth(20);;
              b.setHeight(20);
             // b.layout(x, y, x+b.getWidth(), y+b.getHeight());
        	b.setBackgroundResource(imageIDs[1]);
        	 rl.addView(b);
        }
        
    	
	}
	
	private void saveBitmap(Bitmap bitmap) {
		File imagePath = new File(Environment
				.getExternalStorageDirectory() + "/Screen" + System.currentTimeMillis() + ".png");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(imagePath);
			bitmap.compress(CompressFormat.JPEG, 100, fos);
			fos.flush();
			fos.close();
			Toast.makeText(getApplicationContext(),
					"File stored successfully", 99).show();
		} catch (FileNotFoundException e) {
			Toast.makeText(getApplicationContext(), e.getMessage(), 99)
					.show();
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), e.getMessage(), 99)
					.show();
		}

	}

	private Bitmap takeScreenshot() {
		View rootView = findViewById(android.R.id.content)
				.getRootView();
		rootView.setDrawingCacheEnabled(true);
		return rootView.getDrawingCache();
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.about) {
			Intent i = new Intent(getApplicationContext(), About.class);
			startActivity(i);
			return true;
		}
		else if (id == R.id.help) {
			Intent i = new Intent(getApplicationContext(), Help.class);
			startActivity(i);
			return true;
		}
	
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode){
		case RESULT_SPEECH: {
			
				if(resultCode == RESULT_OK && null != data){
					
						ArrayList<String> text =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
						txtText.setText(text.get(0));
						String c = text.get(0);
						if(c.equalsIgnoreCase("start")){
							circleAc("start");
						}
						else if (c.equalsIgnoreCase("stop")) {
							circleAc("stop");
						}
						else if (c.equalsIgnoreCase("left arrow")) {
							leftArrow();
						}
						else if (c.equalsIgnoreCase("right arrow")) {
							rightArrow();
						}
						else if (c.equalsIgnoreCase("down arrow")) {
							downArrow();
						}
						else if (c.equalsIgnoreCase("save image")) {
							Bitmap bitmap = takeScreenshot();
							saveBitmap(bitmap);
						}
						
						else
						{
							String var;
							var = c.toString();
							shape(var);
						}
			
				}
		}
		
		}
		
	}


	
}
