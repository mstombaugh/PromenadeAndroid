package com.example.androidhive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidhive.library.DatabaseHandler;
import com.example.androidhive.library.UserFunctions;

public class EditActivity extends Activity 
{
    EditText inputName;
	Button btnChangeName;
	Button btnTakePhoto;
	Button btnAddConnection;
	Button btnViewRoom;
	
	private static String roomName;
	private static String dbID;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_room);
		
		
		// may need to account for newly registered user here
		Intent intent = getIntent();
		// pull info from previous page
		roomName = intent.getStringExtra("name");
		inputName = (EditText) findViewById(R.id.nameRoom);
		inputName.setText(roomName);
		dbID = intent.getStringExtra("id");
		
		btnChangeName = (Button) findViewById(R.id.btnUpdateR);
		btnTakePhoto = (Button) findViewById(R.id.btnPhoto);
		btnAddConnection = (Button) findViewById(R.id.btnConnection);
		btnViewRoom = (Button) findViewById(R.id.btnView);
    	
        btnChangeName.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View arg0) {
				// change room name in database
				UserFunctions userFunction = new UserFunctions();
				String newName = inputName.getText().toString();
				// userFunction.changeRoomName(newName);
			}
			 
		 });
       
        btnTakePhoto.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View arg0) {
				// use photosphere API
				
			}
			 
		 });
        
        btnAddConnection.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View arg0) {
				// go to screen to add connections to room
				
			}
			 
		 });
        
        btnViewRoom.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View arg0) {
				// view room as it is now
				
			}
			 
		 });
		
		 
	}
}
