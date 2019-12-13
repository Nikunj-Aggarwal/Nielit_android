package com.example.nielit;

import android.content.Intent;
import android.media.Image;
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

import android.view.Menu;
import android.widget.ImageView;

public class OurTeam extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        ImageView our = findViewById(R.id.our);
        our.setImageResource(R.drawable.ourteam);
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
}
