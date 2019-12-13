package com.example.nielit;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class getdata {
    ArrayList<String> cname = new ArrayList<>();
    ArrayList<String> cfee = new ArrayList<>();
    String server="43.15";
    String[] courseUrl = new String[]
            {
                    "http://192.168."+server+":8080/example/training/webservice/shortTermCourses",
                    "http://192.168."+server+":8080/example/training/webservice/longTermCourses",
                    "http://192.168."+server+":8080/example/training/webservice/shortTermCourses",
                    "http://192.168."+server+":8080/example/training/webservice/projecttrainingshortTermCourses",
                    "http://192.168."+server+":8080/example/training/webservice/ProjecttraininglongTermCourses"
            };
    public getdata() {



        for (int q = 0; q < 5; q++) {

            http_user sh = new http_user();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(courseUrl[q]);

            String in = "{" + "course:" + jsonStr + "}";
            Log.e("TAG", "Response from url: " + jsonStr);


            if (jsonStr != null) {
                    Log.e("tag", "inside try");
                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(in);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.e("tag", "inside try");
                    // Getting JSON Array node
                JSONArray contacts = null;
                try {
                    contacts = jsonObj.getJSONArray("course");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = contacts.getJSONObject(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.e("tag", "inside for");

                        cname.add(jsonObject.optString("CourseName"));
                        cfee.add(jsonObject.optString("fee"));

                        Log.e("TAG", String.valueOf(cname));
                        Log.e("tag", "inside for 1");


                    }


            }

        }
    }


    public ArrayList<String> getfee()
    {
        return cfee;
    }

    public ArrayList<String> getcourse()
    {
        return cname;
    }
}