package com.example.nielit;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.StrictMode;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static android.text.TextUtils.isEmpty;
import static com.google.android.material.snackbar.Snackbar.*;

public class Registration extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextInputLayout first,surname,email,qualification,phone,category;
    String fname,sname,semail,quali,ph,cate;
    Button btn;
    String text;
    TextView content;
    Spinner spi;
    ArrayList<String> fee = null;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        first = findViewById(R.id.first);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        category = findViewById(R.id.category);
        qualification = findViewById(R.id.qualifi);

        btn = findViewById(R.id.sub);
        txt = findViewById(R.id.texcoufee);

        Intent intent = getIntent();


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        getdata data = new getdata();
        ArrayList<String> cour = data.getcourse();
         fee = data.getfee();

        spi = findViewById(R.id.spinnercourse);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Registration.this, R.layout.support_simple_spinner_dropdown_item,cour);
        spi.setAdapter(arrayAdapter);
       // spi.setSelection(position);

        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt.setText("Rs. "+fee.get(spi.getSelectedItemPosition()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });


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

    public void register()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isEmpty(first.getEditText().getText().toString()) || isEmpty(email.getEditText().getText().toString()) || isEmpty(qualification.getEditText().getText().toString()) || isEmpty(category.getEditText().getText().toString()) || isEmpty(phone.getEditText().getText().toString()) ) {
                    if(isEmpty(first.getEditText().getText().toString()))
                        first.setError("enter value");
                    else
                        first.setError(null);
                    if(isEmpty(email.getEditText().getText().toString()))
                        email.setError("enter value");
                    else
                        email.setError(null);
                    if(isEmpty(qualification.getEditText().getText().toString()))
                        qualification.setError("enter value");
                    else
                        qualification.setError(null);
                    if(isEmpty(category.getEditText().getText().toString()))
                        category.setError("enter value");
                    else
                        category.setError(null);
                    if(isEmpty(phone.getEditText().getText().toString()))
                        phone.setError("enter value");
                    else
                        phone.setError(null);
                }
                else
                {
                    phone.setError(null);
                    category.setError(null);
                    qualification.setError(null);
                    first.setError(null);
                    email.setError(null);
                    Snackbar.make(view,"Submitted", LENGTH_LONG).show();

                   fname = first.getEditText().getText().toString();
                    semail = email.getEditText().getText().toString();
                    sname = surname.getEditText().getText().toString();
                    quali = qualification.getEditText().getText().toString();
                    cate = category.getEditText().getText().toString();

                    ph = phone.getEditText().getText().toString();

                    String server="43.15";

                    System.out.println("the values of name is" + fname);
                    String data = null;
                    try {

                        URL url = new URL("http://192.168."+server+":8080/example/training/webservice/registration");

                        data = URLEncoder.encode("FirstName", "UTF-8")
                                + "=" + URLEncoder.encode(fname, "UTF-8");

                        data += "&" + URLEncoder.encode("LastName", "UTF-8") + "="
                                + URLEncoder.encode(sname, "UTF-8");

                        data += "&" + URLEncoder.encode("E-mail", "UTF-8") + "="
                                + URLEncoder.encode(semail, "UTF-8");

                        data += "&" + URLEncoder.encode("MobileNo", "UTF-8") + "="
                                + URLEncoder.encode(ph, "UTF-8");

                        data += "&" + URLEncoder.encode("Qualification", "UTF-8") + "="
                                + URLEncoder.encode(quali, "UTF-8");

                        data += "&" + URLEncoder.encode("Category", "UTF-8") + "="
                                + URLEncoder.encode(cate, "UTF-8");

                        data += "&" + URLEncoder.encode("CourseName", "UTF-8")
                                + "=" + URLEncoder.encode(spi.getSelectedItem().toString(), "UTF-8");

                        data += "&" + URLEncoder.encode("CourseFee", "UTF-8")
                                + "=" + URLEncoder.encode(txt.getText().toString(), "UTF-8");


                      //  String encodedUrl = url + "?" + data;
                        byte[] postData = new byte[0];
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                            postData = data.getBytes(StandardCharsets.UTF_8);
                        }
                        System.out.println(data);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                        connection.setDoOutput(true);
                        connection.setRequestMethod("POST");
                        connection.setRequestProperty("User-Agent", "Java client");
                        connection.setRequestProperty("Content-Type", "application/x-www-Form-urlencoded");


                        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());

                        wr.write(postData);


                        wr.flush();

                        wr.close();


                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line = null;


                        while ((line = reader.readLine()) != null) {

                            sb.append(line + "\n");

                        }


                        text = sb.toString();


                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Snackbar.make(view,"Submitted", LENGTH_LONG).show();

                }
            } });


    }


}
