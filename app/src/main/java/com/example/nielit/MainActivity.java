package com.example.nielit;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Integer[] images = {
            R.drawable.pos1,
            R.drawable.pos2,
            R.drawable.pos3,
            R.drawable.pos4,
            R.drawable.pos5
    };

    Integer[] shortcourse_image = {
            R.drawable.digital,
            R.drawable.web,
            R.drawable.digital,
            R.drawable.digital,

            R.drawable.c

    };

    String[] shortname = new String[]{

            "Certificate Course in Digital Marketing",
            "Certified Course in Web Designing",
            "Certificate Course in Digital Marketing",
            "Certificate Course in Digital Marketing",

            "Programming Through C"
    };

    String[] shortfee = new String[]{
            "Rs.6500/-",
            "Rs.5400/-",
            "Rs.8000/-",
            "Rs.10,000/-",

            "Rs.5000/-"
    };

    String[] shortduration = new String[]{
            "40hrs",
            "6 weeks",
            "60hrs",
            "80hrs",

            "6 weeks"
    };

    Integer[] longcourse_image = {
            R.drawable.olevel,
            R.drawable.chmolevel,
            R.drawable.ita,
            R.drawable.blevel,
            R.drawable.multimedia

    };

    String[] longname = new String[]{

            "IT 'O’ Level",
            "CHM 'O’ Level",
            "ITA 'A’ Level",
            "ITA 'B’ Level",
            "Multimedia and Animation Technology ‘O’ level"
    };

    String[] longfee = new String[]{
            "Rs.18,800/-",
            "Rs.18,050/-",
            "Rs.35,000/-",
            "Rs.50,000/-",
            "Rs.25,000/-"
    };

    String[] longduration = new String[]{
            "1 Year",
            "1 Year",
            "1 Year",
            "1-1/2 Year",
            "1 Year"
    };

    Integer[] longpcourse_image = {
            R.drawable.arduino,
            R.drawable.vlsi,
            R.drawable.iot,
            R.drawable.asp,
            R.drawable.j2ee

    };

    String[] longpname = new String[]{

            "Certificate Course in Arduino based Embedded System Design",
            "Post Diploma in VLSI Design, Tools and Technology",
            "Post Graduate Diploma in Internet of Things (IoT)",
            "ASP.Net with C#",
            "J2EE"
    };

    String[] longpfee = new String[]{
            "Rs.19,00/-",
            "Rs.22,000/-",
            "Rs.28,000/-",
            "Rs.10,000/-",
            "Rs.10,000/-"
    };

    String[] longpduration = new String[]{
            "6 Months",
            "6 Months",
            "6 Months",
            "6 Months",
            "6 Months"
    };

    Integer[] shortpcourse_image = {
            R.drawable.arduino,
            R.drawable.iot,
            R.drawable.iot,
            R.drawable.vlsi

    };

    String[] shortpname = new String[]{

            "Certificate Course in Embedded System using 8051 and Arduino",
            "Certificate Course in Internet of Things (IOT) using Arduino",
            "Certificate Course in Internet of Things (IOT) using Raspberry Pi",
            "Certificate Course in VLSI Design"
    };

    String[] shortpfee = new String[]{
            "Rs.9,000/-",
            "Rs.10,000/-",
            "Rs.10,000/-",
            "Rs.12,00/-"
    };

    String[] shortpduration = new String[]{
            "8 Weeks",
            "8 Weeks",
            "8 Weeks",
            "8 Weeks"
    };




    RecyclerView rv, short_term, long_term, summer_training, shortTraining,longTraining;
    TextView shortmore, longmore, summermore, shortpmore, longpmore;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        rv = findViewById(R.id.top_horizontal_scroll);
        short_term = findViewById(R.id.shortterm_horizontal_scroll);
        long_term = findViewById(R.id.longterm_horizontal_scroll);
        summer_training = findViewById(R.id.summer_horizontal_scroll);
        shortTraining = findViewById(R.id.shortProject_scroll);
        longTraining = findViewById(R.id.longproject_horizontal_scroll);

        shortmore = findViewById(R.id.shortmore);
        longmore = findViewById(R.id.longmore);
        summermore = findViewById(R.id.summermore);
        shortpmore = findViewById(R.id.spmore);
        longpmore = findViewById(R.id.longpmore);

        btn = findViewById(R.id.ns);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        setRecyclerView();



        shortmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Courses.class);
                i.putExtra("pos","1");
                startActivity(i);
            }
        });

        longmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Courses.class);
                i.putExtra("pos","2");
                startActivity(i);
            }
        });

        summermore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Courses.class);
                i.putExtra("pos","3");
                startActivity(i);
            }
        });

        shortpmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Courses.class);
                i.putExtra("pos","4");
                startActivity(i);
            }
        });

        longpmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Courses.class);
                i.putExtra("pos","5");
                startActivity(i);
            }
        });

       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, nsqf.class);
                startActivity(i);
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

        public void setRecyclerView ()
        {


            LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            rv.setLayoutManager(manager);
            top_scroller_adapter adapter = new top_scroller_adapter(images);
            rv.setAdapter(adapter);


            LinearLayoutManager m = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            short_term.setLayoutManager(m);
            course_adapter ad = new course_adapter(shortcourse_image, shortname, shortfee,shortduration);
            short_term.setAdapter(ad);


            LinearLayoutManager m1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            long_term.setLayoutManager(m1);
            course_adapter ad1 = new course_adapter(longcourse_image, longname, longfee,longduration);
            long_term.setAdapter(ad1);


            LinearLayoutManager m2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            summer_training.setLayoutManager(m2);
            course_adapter ad2 = new course_adapter(shortcourse_image, shortname, shortfee,shortduration);
            summer_training.setAdapter(ad2);


            LinearLayoutManager m3 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            shortTraining.setLayoutManager(m3);
            course_adapter ad3 = new course_adapter(shortpcourse_image, shortpname, shortpfee,shortpduration);
            shortTraining.setAdapter(ad3);

            LinearLayoutManager m4 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            longTraining.setLayoutManager(m4);
            course_adapter ad4 = new course_adapter(longpcourse_image, longpname, longpfee,longpduration);
            longTraining.setAdapter(ad4);

        }
    }