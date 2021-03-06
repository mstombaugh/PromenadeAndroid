package com.example.androidhive.library;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
 
import android.content.Context;
 
public class UserFunctions {
     
    private JSONParser jsonParser;
     
    // Testing in localhost using wamp or xampp 
    // use http://10.0.2.2/ to connect to your localhost ie http://localhost/
    private static String loginURL = "http://54.186.153.0/API/index.php";
    private static String registerURL = "http://54.186.153.0/API/index.php";
     
    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String houses_tag = "houses";
    private static String rooms_tag = "rooms";
    private static String connections_tag = "connections";
    private static String property_rename_tag = "renameProperty";
    private static String room_rename_tag = "renameRoom";
    
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
     
    /**
     * function make Login Request
     * @param username
     * @param password
     * */
    public JSONObject loginUser(String username, String password){
    	//offload to new thread so this thing stops blowing up
        DatabaseAccessTask dbAccess = new DatabaseAccessTask();
        dbAccess.execute(login_tag , username , password);
        JSONObject json = null;
		try {
			json = dbAccess.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }
     
    /**
     * function make Login Request
     * @param name
     * @param email
     * @param password
     * */
    public JSONObject registerUser(String name, String email, String password){
        // Building Parameters
        /*List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));*/
         
        // getting JSON Object
        DatabaseAccessTask dbAccess = new DatabaseAccessTask();
        dbAccess.execute(register_tag, name , email , password);
        JSONObject json = null;
		try {
			json = dbAccess.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }
     
    /**
     * Function get Login status
     * */
    public boolean isUserLoggedIn(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        int count = db.getRowCount();
        if(count > 0){
            // user logged in
            return true;
        }
        return false;
    }
     
    /**
     * Function to logout user
     * Reset Database
     * */
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }
    
    /*
     * Function to get homes based on user's name
     */
     public JSONObject getHomes(String username){
	DatabaseAccessTask dbAccess = new DatabaseAccessTask();
        dbAccess.execute(houses_tag, username);
        JSONObject json = null;
		try {
			json = dbAccess.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }
    
    public JSONObject getRoom(int propertyID){
	DatabaseAccessTask dbAccess = new DatabaseAccessTask();
        dbAccess.execute(rooms_tag, propertyID.toString());
        JSONObject json = null;
		try {
			json = dbAccess.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }
    
    public JSONObject renameHome(int propertyID, String newName){
	DatabaseAccessTask dbAccess = new DatabaseAccessTask();
        dbAccess.execute(property_rename_tag, propertyID.toString(), newName);
        JSONObject json = null;
		try {
			json = dbAccess.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }
    
    public JSONObject renameRoom(int roomID, String newName){
	DatabaseAccessTask dbAccess = new DatabaseAccessTask();
        dbAccess.execute(room_rename_tag, roomID.toString(), newName);
        JSONObject json = null;
		try {
			json = dbAccess.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }
    
     public JSONObject addProperty(String address, String username, String houseURL, int defaultRoom){
     	
     }
     
     public JSONObject addRoom(String name, int propertyID, String roomURL){
     	
     }
     
}
