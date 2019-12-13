package com.example.nielit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zone_wise extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String TAG = zone_wise.class.getSimpleName();
    private ProgressDialog pDialog;
    ArrayList<String> cplace = new ArrayList<>();
    ArrayList<String> cweb = new ArrayList<>();
    String jsonStr;
    String pos;
    String server="43.15";


    HttpURLConnection conn = null;
    String url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_wise);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Intent intent = getIntent();
        pos = (intent.getStringExtra("place"));
        if(pos.equals("101"))
        {   //north ka url
          //  jsonStr = "[{\"CourseId\":\"101\",\"place\":\"Delhi\",\"weblink\":\"http://nielit.gov.in/delhi/\"},{\"CourseId\":\"102\",\"place\":\"Facility at Chandigarh\",\"weblink\":\"http://nielit.gov.in/chandigarh/\"},{\"CourseId\":\"103\",\"place\":\"Gorakhpur\",\"weblink\":\"http://nielit.gov.in/gorakhpur/\"},{\"CourseId\":\"104\",\"place\":\"Haridwar\",\"weblink\":\"http://nielit.gov.in/haridwar/\"},{\"CourseId\":\"105\",\"place\":\"Jammu\",\"weblink\":\"http://nielit.gov.in/jammu/\"},{\"CourseId\":\"106\",\"place\":\"Kurukshetra\",\"weblink\":\"http://nielit.gov.in/kurukshetra/\"},{\"CourseId\":\"107\",\"place\":\"Leh\",\"weblink\":\"http://nielit.gov.in/leh/\"},{\"CourseId\":\"108\",\"place\":\"Lucknow\",\"weblink\":\"http://nielit.gov.in/lucknow/\"},{\"CourseId\":\"109\",\"place\":\"Patna\",\"weblink\":\"http://nielit.gov.in/patna/\"},{\"CourseId\":\"110\",\"place\":\"Permanent Campus at Ropar\",\"weblink\":\"http://nielit.gov.in/chandigarh/\"},{\"CourseId\":\"111\",\"place\":\"Shimla\",\"weblink\":\"http://nielit.gov.in/shimla/\"},{\"CourseId\":\"112\",\"place\":\"Srinagar\",\"weblink\":\"http://nielit.gov.in/srinagar/\"}]";
            url = "http://192.168."+server+":8080/example/training/webservice/north";

        } else if (pos.equals("102")) {
            //courseUrl = south ka url
          //  jsonStr = "[{\"CourseId\":\"401\",\"place\":\"Calicut\",\"weblink\":\"http://nielit.gov.in/calicut/\"},{\"CourseId\":\"402\",\"place\":\"Chennai\",\"weblink\":\"http://nielit.gov.in/chennai/\"}]";
            url = "http://192.168."+server+":8080/example/training/webservice/south";

        } else if (pos.equals("103")) {
            //courseUrl = east ka url
          //  jsonStr = "[{\"CourseId\":\"301\",\"place\":\"Bhubaneswar\",\"weblink\":\"http://beta.nielit.gov.in/bhubaneswar/\"},{\"CourseId\":\"302\",\"place\":\"Kolkata\",\"weblink\":\"http://nielit.gov.in/kolkata/\"},{\"CourseId\":\"303\",\"place\":\"Ranchi\",\"weblink\":\"http://nielit.gov.in/ranchi/\"}]";
            url = "http://192.168."+server+":8080/example/training/webservice/east";

        } else if (pos.equals("104")) {
            //courseUrl = west ka url
          //  jsonStr = "[{\"CourseId\":\"501\",\"place\":\"Aurangabad\",\"weblink\":\"http://nielit.gov.in/aurangabad/\"},{\"CourseId\":\"502\",\"place\":\"Ajmer\",\"weblink\":\"http://nielit.gov.in/ajmer/\"},{\"CourseId\":\"503\",\"place\":\"Pali\",\"weblink\":\"http://beta.nielit.gov.in/pali/\"}]";
            url = "http://192.168."+server+":8080/example/training/webservice/west";

        } else if (pos.equals("105")) {
            //courseUrl = north east ka url
            //jsonStr = "[{\"CourseId\":\"201\",\"place\":\"Agartala\",\"weblink\":\"http://nielit.gov.in/agartala/\"},{\"CourseId\":\"202\",\"place\":\"Aizwal\",\"weblink\":\"http://nielit.gov.in/aizawl/\"},{\"CourseId\":\"203\",\"place\":\"Chuchuyimlang\",\"weblink\":\"http://nielit.gov.in/chuchuyimlang/\"},{\"CourseId\":\"204\",\"place\":\"Churachandpur\",\"weblink\":\"http://nielit.gov.in/churachandpur/\"},{\"CourseId\":\"205\",\"place\":\"Gangtok\",\"weblink\":\"http://nielit.gov.in/gangtok/\"},{\"CourseId\":\"206\",\"place\":\"Guwahati\",\"weblink\":\"http://nielit.gov.in/guwahati/\"},{\"CourseId\":\"207\",\"place\":\"Imphal\",\"weblink\":\"http://nielit.gov.in/imphal/\"},{\"CourseId\":\"208\",\"place\":\"Itanagar\",\"weblink\":\"http://nielit.gov.in/itanagar/\"},{\"CourseId\":\"209\",\"place\":\"Jorhat\",\"weblink\":\"http://nielit.gov.in/jorhat/\"},{\"CourseId\":\"210\",\"place\":\"Kohima\",\"weblink\":\"http://nielit.gov.in/kohima/\"},{\"CourseId\":\"211\",\"place\":\"Kokrajhar\",\"weblink\":\"http://nielit.gov.in/kokrajhar/\"},{\"CourseId\":\"212\",\"place\":\"Lunglei\",\"weblink\":\"http://nielit.gov.in/lunglei/\"},{\"CourseId\":\"213\",\"place\":\"Pasighat\",\"weblink\":\"http://nielit.gov.in/pasighat/\"},{\"CourseId\":\"214\",\"place\":\"Senapati\",\"weblink\":\"http://nielit.gov.in/senapati/\"},{\"CourseId\":\"215\",\"place\":\"Shillong\",\"weblink\":\"http://nielit.gov.in/shillong/\"},{\"CourseId\":\"216\",\"place\":\"Silchar\",\"weblink\":\"http://nielit.gov.in/silchar/\"},{\"CourseId\":\"217\",\"place\":\"Tezpur\",\"weblink\":\"http://nielit.gov.in/tezpur/\"},{\"CourseId\":\"218\",\"place\":\"Tezu\",\"weblink\":\"http://nielit.gov.in/tezu/\"},{\"CourseId\":\"219\",\"place\":\"Tura\",\"weblink\":\"http://nielit.gov.in/tura/\"}]";
            url = "http://192.168."+server+":8080/example/training/webservice/northeast";
        }


        new GetContacts().execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_centres) {
            Intent i = new Intent(this, Centers.class);
            startActivity(i);

        } else if (id == R.id.nav_feedback) {
            Intent i = new Intent(this, Feedback.class);
            startActivity(i);

        } else if (id == R.id.nav_shortTerm) {
            Intent i = new Intent(this, Courses.class);
            i.putExtra("pos","1");
            startActivity(i);

        } else if (id == R.id.nav_longTerm) {
            Intent i = new Intent(this, Courses.class);
            i.putExtra("pos","2");
            startActivity(i);

        } else if (id == R.id.nav_home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_register) {
            Intent i = new Intent(this, Registration.class);
            startActivity(i);

        } else if (id == R.id.nav_our_team) {
            Intent i = new Intent(this, OurTeam.class);
            startActivity(i);

        } else if (id == R.id.nav_summerTraining) {
            Intent i = new Intent(this, Courses.class);
            i.putExtra("pos","3");
            startActivity(i);

        } else if (id == R.id.nav_shortTraining) {
            Intent i = new Intent(this, Courses.class);
            i.putExtra("pos","4");
            startActivity(i);

        } else if (id == R.id.nav_longTraining) {
            Intent i = new Intent(this, Courses.class);
            i.putExtra("pos","5");
            startActivity(i);

        } else if (id == R.id.nav_nsqf) {
            Intent i = new Intent(this, nsqf.class);
            startActivity(i);


        } else if (id == R.id.nav_contactus) {
            Intent i = new Intent(this, ContactUs.class);
            startActivity(i);

        } else if (id == R.id.nav_about_us) {
            Intent i = new Intent(this, AboutUs.class);
            startActivity(i);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(zone_wise.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            http_user sh = new http_user();

            Log.e("pos",pos.toString());

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);



            String in = "{"+"zone:"+jsonStr + "}";

           // Log.e(TAG, "Response from url: " + in);


            if (jsonStr != null) {

                try {
                    Log.e("tag","inside try1");
                    JSONObject jsonObj = new JSONObject(in);


                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("zone");

                    Log.e("tag","inside try");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        Log.e("TAG","inside for");
                        cplace.add(c.getString("place"));
                        cweb.add(c.getString("weblink").toString());


                        Log.e("TAG","inside for");

                    }
                } catch (final JSONException e) {
                  //  Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
            //    Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListView lv = findViewById(R.id.lv);
            center_adapter adapter = new center_adapter(zone_wise.this,cplace,cweb);
            lv.setAdapter(adapter);
        }

    }
}
