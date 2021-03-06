package com.example.androidhive.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

public class DatabaseAccessTask extends android.os.AsyncTask<String, Void, JSONObject> {
	
	 private static String login_tag = "login";
	 private static String register_tag = "register";
	    private static String houses_tag = "houses";
	    private static String rooms_tag = "rooms";
	    private static String connections_tag = "connections";
	    private static String property_rename_tag = "renameProperty";
	    private static String room_rename_tag = "renameRoom";

	private static String loginURL = "http://54.186.153.0/API/index.php";
    private static String registerURL = "http://54.186.153.0/API/index.php";
    private JSONParser jsonParser = new JSONParser();

	@Override
	protected JSONObject doInBackground(String... params) {
		// TODO Auto-generated method stub
		int count = params.length;
		//houses
		if(params[0] == houses_tag){
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("tag", params[0]));
			param.add(new BasicNameValuePair("houses", params[0]));
		}//rooms
		else if(params[0] == rooms_tag){
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("tag", params[0]));
			param.add(new BasicNameValuePair("propertyID", params[0]));
		}//rename property
		else if(params[0] == property_rename_tag){
			List<NameValuePair> param = new ArrayList<NameValuePair>();
        		param.add(new BasicNameValuePair("tag", params[0]));
        		param.add(new BasicNameValuePair("propertyID", params[1]));
        		param.add(new BasicNameValuePair("address", params[2]));
        		JSONObject json = jsonParser.getJSONFromUrl(loginURL, param);
	        	return json;
		}//rename room
		else if(params[0] == room_rename_tag){
			List<NameValuePair> param = new ArrayList<NameValuePair>();
        		param.add(new BasicNameValuePair("tag", params[0]));
        		param.add(new BasicNameValuePair("roomID", params[1]));
        		param.add(new BasicNameValuePair("roomName", params[2]));
        		JSONObject json = jsonParser.getJSONFromUrl(loginURL, param);
	        	return json;
		}//login
		else if(count == 3){
			List<NameValuePair> param = new ArrayList<NameValuePair>();
	        	param.add(new BasicNameValuePair("tag", params[0]));
	        	param.add(new BasicNameValuePair("username", params[1]));
	        	param.add(new BasicNameValuePair("password", params[2]));
	        	JSONObject json = jsonParser.getJSONFromUrl(loginURL, param);
	        	return json;
		}//register
		else if(count == 4){
			List<NameValuePair> param = new ArrayList<NameValuePair>();
	        param.add(new BasicNameValuePair("tag", params[0])); //tag
	        param.add(new BasicNameValuePair("username", params[1]));  //username
	        param.add(new BasicNameValuePair("email", params[2]));  //email
	        param.add(new BasicNameValuePair("password", params[3]));  //password
	        JSONObject json = jsonParser.getJSONFromUrl(loginURL, param);
	        return json;
		}
		return null;
	}

}
