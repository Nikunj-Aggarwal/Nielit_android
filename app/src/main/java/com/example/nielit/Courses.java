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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Courses extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<String> cname = new ArrayList<>();
    ArrayList<String> cfee = new ArrayList<>();
    ArrayList<String> cduration = new ArrayList<>();
    ArrayList<String> celg = new ArrayList<>();
    ArrayList<String> csyll = new ArrayList<>();
    ArrayList<String> image = new ArrayList<>();
    String jsonStr;
    String pos;

    ArrayList<String> img = new ArrayList<>();
    private String TAG = Courses.class.getSimpleName();

    private ProgressDialog pDialog;
    String courseUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        Intent intent = getIntent();
        pos = intent.getStringExtra("pos");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        String server="43.15";


        if(pos.equals("1"))
        {
            //courseUrl = "http://169.254.70.167/example/training/webservice/shortTermCourses";
           // jsonStr = "[{\"CourseName\":\"Certificate Course in Digital Marketing\",\"details\":\"http://nielit.gov.in/sites/default/files/Delhi/digital%20marketing%204%20WEEKS.pdf\",\"CourseId\":\"20040001\",\"duration\":\"40 hrs\",\"fee\":\"6,500/-\",\"eligibility\":\"10+2pass\"},{\"CourseName\":\"Certificate Course in Digital Marketing\",\"details\":\"http://nielit.gov.in/sites/default/files/Delhi/digital%20marketing%206%20WEEKS.pdf\",\"CourseId\":\"20060002\",\"duration\":\"60 hrs\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Certificate Course in Digital Marketing\",\"details\":\"http://nielit.gov.in/sites/default/files/Delhi/digital%20marketing%208%20WEEKS%281%29.pdf\",\"CourseId\":\"20080003\",\"duration\":\"80 hrs\",\"fee\":\"10,000/-\",\"eligibility\":\"10+2pass\"},{\"CourseName\":\"Certified Course in Web Designing\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dweb%20designing\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003dall\\u0026level\\u003dall\\u0026job_des\\u003dall\\u0026nid\\u003d2849\",\"CourseId\":\"21008004\",\"duration\":\"8 Weeks\",\"fee\":\"5,400/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Programming Through C\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ProgrammingThroughC.pdf\",\"CourseId\":\"21006005\",\"duration\":\"6 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Object Oriented Programing Through C++\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/coursesyllabusC.pdf\",\"CourseId\":\"21006006\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Basic knowledge of any programming language\"},{\"CourseName\":\"C and C++\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/C_c%20plus%20plus.pdf\",\"CourseId\":\"21008007\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Programing Through Python\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ProgrammingThroughPython.pdf\",\"CourseId\":\"21006008\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"CCNA Routing and Switching for CCENT Certification\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CCNARoutingandSwitchingICND1.pdf\",\"CourseId\":\"21008009\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"CCNA Routing and Switching for CCNA Certification (3rd and 4th Module)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CCNA%20Routing%20and%20Switching%20for%20CCNA%20Certification%20%283rd%20and%204th%20Module%29-12%20weeks.pdf\",\"CourseId\":\"21012010\",\"duration\":\"12 Weeks\",\"fee\":\"12,500/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"CCNA Routing and Switching for CCNA Certification\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CCNA%20Routing%20and%20Switching%20for%20CCNA%20Certification-20%20weeks.pdf\",\"CourseId\":\"21020011\",\"duration\":\"20 Weeks\",\"fee\":\"20,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Computer System \\u0026 Server Administration\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ComputerSystemandSystemAdministration.pdf\",\"CourseId\":\"21006012\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"10+2\"},{\"CourseName\":\"Certificate Course in Linux, Apache, MySQL and PHP\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28LAMP%29.pdf\",\"CourseId\":\"21006013\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Certificate Course in Linux, Apache, MySQL and PHP\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dall\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003d25\\u0026level\\u003dLevel%205\\u0026job_des\\u003dall\\u0026nid\\u003d2854\",\"CourseId\":\"21008014\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Core Java\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CORE%20JAVA.pdf\",\"CourseId\":\"21006015\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Basic knowledge of any programming language\"},{\"CourseName\":\"Web Application Technologies (J2EE)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Web%20Application%20Technologies%20%28J2EE%29.pdf\",\"CourseId\":\"21006016\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Web Application Technologies (J2EE)with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28J2EE%29withproject.pdf\",\"CourseId\":\"21008017\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"ASP.Net with VB\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Asp.net%20WITH%20VB.net.pdf\",\"CourseId\":\"21006018\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of programs and 10+2\"},{\"CourseName\":\"ASP.Net \\u0026 VB with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Asp.net%20WITH%20VB.net.pdf\",\"CourseId\":\"21008019\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of programs and 10+2\"},{\"CourseName\":\"Programming Through C#\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Csharp.pdf\",\"CourseId\":\"21006020\",\"duration\":\"6 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Web Application Technologies (ASP.Net with c#)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28ASP.NetwithC%23%29.pdf\",\"CourseId\":\"21006021\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Web Application Technologies (ASP.Net with C#) with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28ASP.NetwithC%23%29%20withProject.pdf\",\"CourseId\":\"21008022\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Certified Android Apps Developer\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dCertified%20Android%20Apps%20Developer\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003dall\\u0026level\\u003dall\\u0026job_des\\u003dall\\u0026nid\\u003d2847\",\"CourseId\":\"20100023\",\"duration\":\"100 hrs\",\"fee\":\"15,000/-\",\"eligibility\":\"Core Java,Oops Concept,Database knowledge\"},{\"CourseName\":\"Data Entry and Office Automation(Lateral)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20and%20office%20automation%20lateral.pdf\",\"CourseId\":\"21005024\",\"duration\":\"5 Weeks\",\"fee\":\"3,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks and Having Cleared CCC\"},{\"CourseName\":\"Data Entry and Office Automation\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20direct%20syllabus.pdf\",\"CourseId\":\"21009025\",\"duration\":\"9 Weeks\",\"fee\":\"6,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks and Having Cleared CCC\"},{\"CourseName\":\"Financial Accounting using Tally\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Finnancial%20Accounting%20using%20Tally.pdf\",\"CourseId\":\"21004026\",\"duration\":\"4 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"Basic Knowledge of Computer\"},{\"CourseName\":\"Refresher Course IWD\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ReferesherCourseinIWD.pdf\",\"CourseId\":\"21001027\",\"duration\":\"1 Week\",\"fee\":\"1,500/-\",\"eligibility\":\"10+2\"},{\"CourseName\":\"Refresher Course C\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Refresher-C.pdf\",\"CourseId\":\"21001028\",\"duration\":\"1 Week\",\"fee\":\"1,500/-\",\"eligibility\":\"10+2\"},{\"CourseName\":\"Certificate course in Office Automation(CCOA)\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dOffice%20Automation\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003dall\\u0026level\\u003dall\\u0026job_des\\u003dall\\u0026nid\\u003d2851\",\"CourseId\":\"20080029\",\"duration\":\"80 hrs\",\"fee\":\"3,500/-\",\"eligibility\":\"12th Passed with basic computer and networking knowledge.\"},{\"CourseName\":\"Cyber Security Basic Literacy Course\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/cyber%20security%20basic%20literacy_0.pdf\",\"CourseId\":\"21004030\",\"duration\":\"4 Weeks\",\"fee\":\"6,000/-\",\"eligibility\":\"12th Passed with basic computer and networking knowledge.\"},{\"CourseName\":\"Certificate course in Cloud Computing\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/certificate%20course%20in%20cloud%20computing.pdf\",\"CourseId\":\"20060031\",\"duration\":\"60 hrs\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate Course in Big Data \\u0026 Hadoop\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/certificate%20course%20in%20big%20data%20%26amp%3B%20hadoop.pdf\",\"CourseId\":\"20060032\",\"duration\":\"60 hrs\",\"fee\":\"9,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in System Administration using Linux\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/certificate%20course%20in%20System%20Administration%20using%20Linux.pdf\",\"CourseId\":\"20080033\",\"duration\":\"80 hrs\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things (IOT) using Ardiuno\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/iot_ardiuno.pdf\",\"CourseId\":\"31006034\",\"duration\":\"6 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things(IOT) using Ardiuno with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/iot_ardiuno.pdf\",\"CourseId\":\"31008035\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things(IOT) using Raspberry Pi\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/course_IoT_raspberrypi_final_draft.pdf\",\"CourseId\":\"31006036\",\"duration\":\"6 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things (IOT) using Raspberry Pi with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/course_IoT_raspberrypi_final_draft.pdf\",\"CourseId\":\"31008037\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate Course in VLSI Design\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/VLSI_FINAL.pdf\",\"CourseId\":\"31008038\",\"duration\":\"8 Weeks\",\"fee\":\"12,000/-\",\"eligibility\":\"Engineering Graduates(or Undergoing)\"},{\"CourseName\":\"Certificate Course in Embedded System Design ARM/Cortex Microcontroller\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ARM.pdf\",\"CourseId\":\"31008039\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Engineering Graduates(or Undergoing)\"},{\"CourseName\":\"Embedded system using 8051 and ARM with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/EmbeddedSystemusing8051andARM_WithProject-f.pdf\",\"CourseId\":\"31008040\",\"duration\":\"8 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Pursuing/Passed B.E./B. Tech /BCA/MCA/BSc./MSc.(IT/CS/Electronics) or Graduate (any stream) with PG Diploma (CA/CS/IT)/NIELIT A/B Level /NIELIT CHM-A Level or pursuing AICTE Approved three years diploma in Electronics /Electrical/Computers/Instrumentation or Equivalent\"},{\"CourseName\":\"Embedded system using 8051 and Ardiuno with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/EmbeddedSystemusing8051andArduino_WithProject-f.pdf\",\"CourseId\":\"31008041\",\"duration\":\"8 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Pursuing/Passed B.E./B. Tech /BCA/MCA/BSc./MSc.(IT/CS/Electronics) or Graduate (any stream) with PG Diploma (CA/CS/IT)/NIELIT A/B Level /NIELIT CHM-A Level or pursuing AICTE Approved three years diploma in Electronics /Electrical/Computers/Instrumentation or Equivalent\"},{\"CourseName\":\"Embedded System using 8051 and Arduinoâ€‹\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/EmbeddedSystemusing8051andArduino.pdf\",\"CourseId\":\"31006042\",\"duration\":\"6 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Pursuing/Passed B.E./B. Tech /BCA/MCA/BSc./MSc.(IT/CS/Electronics) or Graduate (any stream) with PG Diploma (CA/CS/IT)/NIELIT A/B Level /NIELIT CHM-A Level or pursuing AICTE Approved three years diploma in Electronics /Electrical/Computers/Instrumentation or Equivalent\"},{\"CourseName\":\"Web Designing\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Web%20Designing-for%20Multimedia.pdf\",\"CourseId\":\"21006043\",\"duration\":\"6 Weeks\",\"fee\":\"5,400/-\",\"eligibility\":\"Basic Knowledge of Computer\"},{\"CourseName\":\"Beginners Course in Flash\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/BeginnerscourseinFlash.pdf\",\"CourseId\":\"21004044\",\"duration\":\"4 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Beginners Course in Photoshop\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/BeginerCourseinPhotoshop.pdf\",\"CourseId\":\"21003045\",\"duration\":\"3 Weeks\",\"fee\":\"4,200/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Certified Course in 2D Animator\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dall\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003d25\\u0026level\\u003dLevel%205\\u0026job_des\\u003dall\\u0026nid\\u003d2863\",\"CourseId\":\"20080046\",\"duration\":\"80 hrs\",\"fee\":\"7,300/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Certified Graphic Designer\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dall\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003d25\\u0026level\\u003dLevel%205\\u0026job_des\\u003dall\\u0026nid\\u003d2861\",\"CourseId\":\"20080047\",\"duration\":\"80 hrs\",\"fee\":\"7,300/-\",\"eligibility\":\"Basic Knowledge of Computer\"},{\"CourseName\":\"3D Studio MAX\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/3DS%20MAX.pdf\",\"CourseId\":\"22003048\",\"duration\":\"3 Months\",\"fee\":\"15,000/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"CCC (Course in Computer Concepts)/ BCC (Basic Computer Course)\",\"details\":\"http://nielit.gov.in/delhi/node/10440\",\"CourseId\":\"21008049\",\"duration\":\"8 Weeks\",\"fee\":\"3,500/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Data Entry and Office Automation (Lateral)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20and%20office%20automation%20lateral.pdf\",\"CourseId\":\"21005050\",\"duration\":\"5 Weeks\",\"fee\":\"3,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks and Having Cleared CCC\"},{\"CourseName\":\"Data Entry and Office Automation\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20direct%20syllabus.pdf\",\"CourseId\":\"21009051\",\"duration\":\"9 Weeks\",\"fee\":\"6,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks\"}]";
            courseUrl = "http://192.168."+server+":8080/example/training/webservice/shortTermCourses";
        } else if (pos.equals("2")) {
           // courseUrl = "http://169.254.70.167/example/training/webservice/longTermCourses";
           // jsonStr = "[{\"CourseName\":\"IT \\u0027O’ Level\",\"details\":\"http://nielit.gov.in/delhi/node/11988\",\"CourseId\":\"12012001\",\"duration\":\"1 Year (Two Semesters)\",\"fee\":\"18,800/-\",\"eligibility\":\"10+2/ITI Certificate after 10/2nd year of a Government recoganized polytechnic engineering diploma after 10\"},{\"CourseName\":\"CHM \\u0027O\\u0027 Level\",\"details\":\"http://nielit.gov.in/content/chm-o-level\",\"CourseId\":\"12012002\",\"duration\":\"1 Year (Two Semesters)\",\"fee\":\"18,050/-\",\"eligibility\":\"\"},{\"CourseName\":\"IT \\u0027A’ Level\",\"details\":\"http://nielit.gov.in/delhi/node/11988\",\"CourseId\":\"12012003\",\"duration\":\"1 Year (Two Semesters)\",\"fee\":\"35,000/-\",\"eligibility\":\"10+2/ITI Certificate after 10/2nd year of a Government recoganized polytechnic engineering diploma after 10\"},{\"CourseName\":\"IT \\u0027B’ Level\",\"details\":\"http://nielit.gov.in//node/11988\",\"CourseId\":\"12018004\",\"duration\":\"1-1/2 Year Full Day (1800 hrs)\",\"fee\":\"50,000/-\",\"eligibility\":\"10+2/ITI Certificate after 10/2nd year of a Government recoganized polytechnic engineering diploma after 10\"},{\"CourseName\":\"Multimedia and Animation Technology ‘O’ level\",\"details\":\"http://nielit.gov.in/content/mat-o-level\",\"CourseId\":\"12012005\",\"duration\":\"1 Year ( Two semesters)\",\"fee\":\"12,500/- per semester\",\"eligibility\":\"\"},{\"CourseName\":\"Certificate Course in Aurduino based Embedded System Design\",\"details\":\"http://nielit.gov.in/delhi/content/certificate-course-arduino-based-embedded-system-design\",\"CourseId\":\"12006006\",\"duration\":\"6 months (300 Hrs)\",\"fee\":\"19,000/-\",\"eligibility\":\"Diploma or B.sc in Electronics/Electronics \\u0026Communication/Electrical/Electrical \\u0026Electronics/ Instrumentation/ Biomedical /Computer Science/Information Technology\"},{\"CourseName\":\"Post Graduate Diploma In Internet of Things(IoT)\",\"details\":\"http://nielit.gov.in/delhi/content/post-graduate-diploma-internet-things-iot\",\"CourseId\":\"12006007\",\"duration\":\"6 months (470 Hrs)\",\"fee\":\"28,000/-\",\"eligibility\":\"M.E./M.Tech or B.E./B.Tech in Electronics \\u0026 Communication/Electrical \\u0026 Electronics/Instrumentation/ Biomedical /Computer Science/ Information Technology\"},{\"CourseName\":\"Post Diploma in VLSI Design, Tools and Technology\",\"details\":\"http://beta.nielit.gov.in/content/post-diploma-vlsi-design-tools-and-technology\",\"CourseId\":\"12006008\",\"duration\":\"6 months (400 Hrs)\",\"fee\":\"22,000/-\",\"eligibility\":\"Diploma Holder, B Sc. Graduate ,B.Tech\"}]";
            courseUrl = "http://192.168."+server+":8080/example/training/webservice/longTermCourses";
        } else if (pos.equals("3")) {
           // courseUrl = "http://169.254.70.167/example/training/webservice/shortTermCourses";
        //    jsonStr = "[{\"CourseName\":\"Certificate Course in Digital Marketing\",\"details\":\"http://nielit.gov.in/sites/default/files/Delhi/digital%20marketing%204%20WEEKS.pdf\",\"CourseId\":\"20040001\",\"duration\":\"40 hrs\",\"fee\":\"6,500/-\",\"eligibility\":\"10+2pass\"},{\"CourseName\":\"Certificate Course in Digital Marketing\",\"details\":\"http://nielit.gov.in/sites/default/files/Delhi/digital%20marketing%206%20WEEKS.pdf\",\"CourseId\":\"20060002\",\"duration\":\"60 hrs\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Certificate Course in Digital Marketing\",\"details\":\"http://nielit.gov.in/sites/default/files/Delhi/digital%20marketing%208%20WEEKS%281%29.pdf\",\"CourseId\":\"20080003\",\"duration\":\"80 hrs\",\"fee\":\"10,000/-\",\"eligibility\":\"10+2pass\"},{\"CourseName\":\"Certified Course in Web Designing\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dweb%20designing\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003dall\\u0026level\\u003dall\\u0026job_des\\u003dall\\u0026nid\\u003d2849\",\"CourseId\":\"21008004\",\"duration\":\"8 Weeks\",\"fee\":\"5,400/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Programming Through C\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ProgrammingThroughC.pdf\",\"CourseId\":\"21006005\",\"duration\":\"6 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Object Oriented Programing Through C++\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/coursesyllabusC.pdf\",\"CourseId\":\"21006006\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Basic knowledge of any programming language\"},{\"CourseName\":\"C and C++\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/C_c%20plus%20plus.pdf\",\"CourseId\":\"21008007\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Programing Through Python\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ProgrammingThroughPython.pdf\",\"CourseId\":\"21006008\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"CCNA Routing and Switching for CCENT Certification\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CCNARoutingandSwitchingICND1.pdf\",\"CourseId\":\"21008009\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"CCNA Routing and Switching for CCNA Certification (3rd and 4th Module)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CCNA%20Routing%20and%20Switching%20for%20CCNA%20Certification%20%283rd%20and%204th%20Module%29-12%20weeks.pdf\",\"CourseId\":\"21012010\",\"duration\":\"12 Weeks\",\"fee\":\"12,500/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"CCNA Routing and Switching for CCNA Certification\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CCNA%20Routing%20and%20Switching%20for%20CCNA%20Certification-20%20weeks.pdf\",\"CourseId\":\"21020011\",\"duration\":\"20 Weeks\",\"fee\":\"20,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Computer System \\u0026 Server Administration\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ComputerSystemandSystemAdministration.pdf\",\"CourseId\":\"21006012\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"10+2\"},{\"CourseName\":\"Certificate Course in Linux, Apache, MySQL and PHP\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28LAMP%29.pdf\",\"CourseId\":\"21006013\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Certificate Course in Linux, Apache, MySQL and PHP\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dall\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003d25\\u0026level\\u003dLevel%205\\u0026job_des\\u003dall\\u0026nid\\u003d2854\",\"CourseId\":\"21008014\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Core Java\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/CORE%20JAVA.pdf\",\"CourseId\":\"21006015\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Basic knowledge of any programming language\"},{\"CourseName\":\"Web Application Technologies (J2EE)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Web%20Application%20Technologies%20%28J2EE%29.pdf\",\"CourseId\":\"21006016\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Web Application Technologies (J2EE)with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28J2EE%29withproject.pdf\",\"CourseId\":\"21008017\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"ASP.Net with VB\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Asp.net%20WITH%20VB.net.pdf\",\"CourseId\":\"21006018\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of programs and 10+2\"},{\"CourseName\":\"ASP.Net \\u0026 VB with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Asp.net%20WITH%20VB.net.pdf\",\"CourseId\":\"21008019\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of programs and 10+2\"},{\"CourseName\":\"Programming Through C#\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Csharp.pdf\",\"CourseId\":\"21006020\",\"duration\":\"6 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Web Application Technologies (ASP.Net with c#)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28ASP.NetwithC%23%29.pdf\",\"CourseId\":\"21006021\",\"duration\":\"6 Weeks\",\"fee\":\"6,800/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Web Application Technologies (ASP.Net with C#) with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/WebApplicationTechnologies%28ASP.NetwithC%23%29%20withProject.pdf\",\"CourseId\":\"21008022\",\"duration\":\"8 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Knowledge of basic computer and Internet\"},{\"CourseName\":\"Certified Android Apps Developer\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dCertified%20Android%20Apps%20Developer\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003dall\\u0026level\\u003dall\\u0026job_des\\u003dall\\u0026nid\\u003d2847\",\"CourseId\":\"20100023\",\"duration\":\"100 hrs\",\"fee\":\"15,000/-\",\"eligibility\":\"Core Java,Oops Concept,Database knowledge\"},{\"CourseName\":\"Data Entry and Office Automation(Lateral)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20and%20office%20automation%20lateral.pdf\",\"CourseId\":\"21005024\",\"duration\":\"5 Weeks\",\"fee\":\"3,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks and Having Cleared CCC\"},{\"CourseName\":\"Data Entry and Office Automation\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20direct%20syllabus.pdf\",\"CourseId\":\"21009025\",\"duration\":\"9 Weeks\",\"fee\":\"6,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks and Having Cleared CCC\"},{\"CourseName\":\"Financial Accounting using Tally\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Finnancial%20Accounting%20using%20Tally.pdf\",\"CourseId\":\"21004026\",\"duration\":\"4 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"Basic Knowledge of Computer\"},{\"CourseName\":\"Refresher Course IWD\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ReferesherCourseinIWD.pdf\",\"CourseId\":\"21001027\",\"duration\":\"1 Week\",\"fee\":\"1,500/-\",\"eligibility\":\"10+2\"},{\"CourseName\":\"Refresher Course C\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Refresher-C.pdf\",\"CourseId\":\"21001028\",\"duration\":\"1 Week\",\"fee\":\"1,500/-\",\"eligibility\":\"10+2\"},{\"CourseName\":\"Certificate course in Office Automation(CCOA)\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dOffice%20Automation\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003dall\\u0026level\\u003dall\\u0026job_des\\u003dall\\u0026nid\\u003d2851\",\"CourseId\":\"20080029\",\"duration\":\"80 hrs\",\"fee\":\"3,500/-\",\"eligibility\":\"12th Passed with basic computer and networking knowledge.\"},{\"CourseName\":\"Cyber Security Basic Literacy Course\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/cyber%20security%20basic%20literacy_0.pdf\",\"CourseId\":\"21004030\",\"duration\":\"4 Weeks\",\"fee\":\"6,000/-\",\"eligibility\":\"12th Passed with basic computer and networking knowledge.\"},{\"CourseName\":\"Certificate course in Cloud Computing\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/certificate%20course%20in%20cloud%20computing.pdf\",\"CourseId\":\"20060031\",\"duration\":\"60 hrs\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate Course in Big Data \\u0026 Hadoop\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/certificate%20course%20in%20big%20data%20%26amp%3B%20hadoop.pdf\",\"CourseId\":\"20060032\",\"duration\":\"60 hrs\",\"fee\":\"9,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in System Administration using Linux\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/certificate%20course%20in%20System%20Administration%20using%20Linux.pdf\",\"CourseId\":\"20080033\",\"duration\":\"80 hrs\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things (IOT) using Ardiuno\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/iot_ardiuno.pdf\",\"CourseId\":\"31006034\",\"duration\":\"6 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things(IOT) using Ardiuno with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/iot_ardiuno.pdf\",\"CourseId\":\"31008035\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things(IOT) using Raspberry Pi\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/course_IoT_raspberrypi_final_draft.pdf\",\"CourseId\":\"31006036\",\"duration\":\"6 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate course in Internet of things (IOT) using Raspberry Pi with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/course_IoT_raspberrypi_final_draft.pdf\",\"CourseId\":\"31008037\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Undergoing B.E.(CS/IT)/B.Tech(CS/IT)/MCA/M.Sc.(CS/IT)/B.Sc(CS/IT)/BCA Or NIELIT A/B -Level/PGDCA\"},{\"CourseName\":\"Certificate Course in VLSI Design\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/VLSI_FINAL.pdf\",\"CourseId\":\"31008038\",\"duration\":\"8 Weeks\",\"fee\":\"12,000/-\",\"eligibility\":\"Engineering Graduates(or Undergoing)\"},{\"CourseName\":\"Certificate Course in Embedded System Design ARM/Cortex Microcontroller\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/ARM.pdf\",\"CourseId\":\"31008039\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Engineering Graduates(or Undergoing)\"},{\"CourseName\":\"Embedded system using 8051 and ARM with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/EmbeddedSystemusing8051andARM_WithProject-f.pdf\",\"CourseId\":\"31008040\",\"duration\":\"8 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Pursuing/Passed B.E./B. Tech /BCA/MCA/BSc./MSc.(IT/CS/Electronics) or Graduate (any stream) with PG Diploma (CA/CS/IT)/NIELIT A/B Level /NIELIT CHM-A Level or pursuing AICTE Approved three years diploma in Electronics /Electrical/Computers/Instrumentation or Equivalent\"},{\"CourseName\":\"Embedded system using 8051 and Ardiuno with project\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/EmbeddedSystemusing8051andArduino_WithProject-f.pdf\",\"CourseId\":\"31008041\",\"duration\":\"8 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Pursuing/Passed B.E./B. Tech /BCA/MCA/BSc./MSc.(IT/CS/Electronics) or Graduate (any stream) with PG Diploma (CA/CS/IT)/NIELIT A/B Level /NIELIT CHM-A Level or pursuing AICTE Approved three years diploma in Electronics /Electrical/Computers/Instrumentation or Equivalent\"},{\"CourseName\":\"Embedded System using 8051 and Arduinoâ€‹\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/EmbeddedSystemusing8051andArduino.pdf\",\"CourseId\":\"31006042\",\"duration\":\"6 Weeks\",\"fee\":\"8,000/-\",\"eligibility\":\"Pursuing/Passed B.E./B. Tech /BCA/MCA/BSc./MSc.(IT/CS/Electronics) or Graduate (any stream) with PG Diploma (CA/CS/IT)/NIELIT A/B Level /NIELIT CHM-A Level or pursuing AICTE Approved three years diploma in Electronics /Electrical/Computers/Instrumentation or Equivalent\"},{\"CourseName\":\"Web Designing\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/Web%20Designing-for%20Multimedia.pdf\",\"CourseId\":\"21006043\",\"duration\":\"6 Weeks\",\"fee\":\"5,400/-\",\"eligibility\":\"Basic Knowledge of Computer\"},{\"CourseName\":\"Beginners Course in Flash\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/BeginnerscourseinFlash.pdf\",\"CourseId\":\"21004044\",\"duration\":\"4 Weeks\",\"fee\":\"5,000/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Beginners Course in Photoshop\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/BeginerCourseinPhotoshop.pdf\",\"CourseId\":\"21003045\",\"duration\":\"3 Weeks\",\"fee\":\"4,200/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Certified Course in 2D Animator\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dall\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003d25\\u0026level\\u003dLevel%205\\u0026job_des\\u003dall\\u0026nid\\u003d2863\",\"CourseId\":\"20080046\",\"duration\":\"80 hrs\",\"fee\":\"7,300/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Certified Graphic Designer\",\"details\":\"http://www.nqr.gov.in/qualification-title?field_qualification_title__value\\u003dall\\u0026field_anticipated_volume_of_trai_value\\u003dall\\u0026sector\\u003d25\\u0026level\\u003dLevel%205\\u0026job_des\\u003dall\\u0026nid\\u003d2861\",\"CourseId\":\"20080047\",\"duration\":\"80 hrs\",\"fee\":\"7,300/-\",\"eligibility\":\"Basic Knowledge of Computer\"},{\"CourseName\":\"3D Studio MAX\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/3DS%20MAX.pdf\",\"CourseId\":\"22003048\",\"duration\":\"3 Months\",\"fee\":\"15,000/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"CCC (Course in Computer Concepts)/ BCC (Basic Computer Course)\",\"details\":\"http://nielit.gov.in/delhi/node/10440\",\"CourseId\":\"21008049\",\"duration\":\"8 Weeks\",\"fee\":\"3,500/-\",\"eligibility\":\"10th\"},{\"CourseName\":\"Data Entry and Office Automation (Lateral)\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20and%20office%20automation%20lateral.pdf\",\"CourseId\":\"21005050\",\"duration\":\"5 Weeks\",\"fee\":\"3,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks and Having Cleared CCC\"},{\"CourseName\":\"Data Entry and Office Automation\",\"details\":\"http://nielit.gov.in/sites/default/files/PDF/Training/Short_Term_Courses/data%20entry%20direct%20syllabus.pdf\",\"CourseId\":\"21009051\",\"duration\":\"9 Weeks\",\"fee\":\"6,500/-\",\"eligibility\":\"10+2 pass in any stream with min.50% marks\"}]";
            courseUrl = "http://192.168."+server+":8080/example/training/webservice/shortTermCourses";

        } else if (pos.equals("4")) {
           // courseUrl = "http://169.254.70.167/example/training/webservice/projecttrainingshortTermCourses";
           // jsonStr = "[{\"CourseName\":\"Certificate Course in Embedded System using 8051 and Arduino\",\"details\":\"null\",\"CourseId\":\"41008001\",\"duration\":\"8 Weeks\",\"fee\":\"9,000/-\",\"eligibility\":\"Basic Electronics,8051 Microcontroller, Arduino, interfacing with sensors and Project\"},{\"CourseName\":\"Certificate Course in Internet of Things (IOT) using Arduino\",\"details\":\"null\",\"CourseId\":\"41008002\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Arduino integrated development environment, Interfacing Sensor \\u0026 Actuators with Arduino , Basic Networking with ESP8266 WiFi module, IoT Protocols, Cloud Platforms for IOT and Project\"},{\"CourseName\":\"Certificate Course in Internet of Things (IOT) using Raspberry Pi\",\"details\":\"null\",\"CourseId\":\"41008003\",\"duration\":\"8 Weeks\",\"fee\":\"10,000/-\",\"eligibility\":\"Getting started with Raspberry Pi ,Booting Up RPi- Operating System and Linux Commands, Working with RPi using Python and Sensing Data using Python ,C Language- Imbibing RPi with C, IoT using Raspberry Pi and Project\"},{\"CourseName\":\"Certificate Course in VLSI Design\",\"details\":\"null\",\"CourseId\":\"41008003\",\"duration\":\"8 Weeks\",\"fee\":\"12,000/-\",\"eligibility\":\"Advanced Digital Design Review, Hardware Description Language (Verilog HDL) ,FPGA Architecture and Prototyping and Project\"}]";
            courseUrl = "http://192.168."+server+":8080/example/training/webservice/projecttrainingshortTermCourses";
        } else if (pos.equals("5")) {
            //courseUrl = "http://169.254.70.167/example/training/webservice/ProjectTraininglongTermCourses";
          //  jsonStr = "[{\"CourseName\":\"Certificate Course in Arduino based Embedded System Design\",\"details\":\"null\",\"CourseId\":\"52006001\",\"duration\":\"6 Months\",\"fee\":\"19,000/-\",\"eligibility\":\"Embedded System Design: Basics, Learning Arduino Platform , The Basics of Sensors and Actuators using Arduino, Controlling Embedded System Based Devices using Arduino and Project\"},{\"CourseName\":\"Post Diploma in VLSI Design, Tools and Technology\",\"details\":\"null\",\"CourseId\":\"52006002\",\"duration\":\"6 Months\",\"fee\":\"22,000/-\",\"eligibility\":\"Programmable Logic Devices (PLDs), System Verilog Code Structure and FPGA Implementation, VLSI Technology, SPICE Modeling, File Interchange Format for VLSI Design and Project\"},{\"CourseName\":\"Post Graduate Diploma in Internet of Things (IoT)\",\"details\":\"null\",\"CourseId\":\"52006003\",\"duration\":\"6 Months\",\"fee\":\"28,000/-\",\"eligibility\":\"The IOT Microcontroller Platform, The Basics of Sensors and Actuators, Interfacing of Android with Internet, Arduino Communication with Android Phone \\u0026 Cloud and Project\"},{\"CourseName\":\"ASP.Net with C#\",\"details\":\"null\",\"CourseId\":\"52006004\",\"duration\":\"6 Months\",\"fee\":\"10,000/-\",\"eligibility\":\"Web server controls, HTML, classes and objects, Server objects, sessions, cookies, ASP Objects, User Sessions and Applications, Data Interface, C# Coding and a Major Project.\"},{\"CourseName\":\"J2EE\",\"details\":\"null\",\"CourseId\":\"52006005\",\"duration\":\"6 Months\",\"fee\":\"10,000/-\",\"eligibility\":\"Java, AWT, Applets, Event Handling, JDBC, RMI, JSP, Database, Beans, Servlets and a Major Project.\"},{\"CourseName\":\"PHP with MySQL\",\"details\":\"null\",\"CourseId\":\"52006006\",\"duration\":\"6 Months\",\"fee\":\"10,000/-\",\"eligibility\":\"HTML, Constructs, Functions, UDF, Database Connectivity, MySQL, User management, stored procedures and a Major Project.\"}]";
            courseUrl = "http://192.168."+server+":8080/example/training/webservice/ProjecttraininglongTermCourses";
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
            pDialog = new ProgressDialog(Courses.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
           http_user sh = new http_user();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(courseUrl);

            String in = "{"+"course:"+jsonStr + "}";
            Log.e(TAG, "Response from url: " + jsonStr);


            if (jsonStr != null ) {
                try {
                    Log.e("tag","inside try");
                    JSONObject jsonObj = new JSONObject(in);

                    Log.e("tag","inside try");
                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("course");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject jsonObject = contacts.getJSONObject(i);

                        Log.e("tag","inside for");

                        cname.add(jsonObject.optString("CourseName"));
                        cfee.add(jsonObject.optString("fee"));
                        cduration.add(jsonObject.optString("duration"));
                        celg.add(jsonObject.optString("eligibility"));
                        csyll.add(jsonObject.optString("details").toString());
                        image.add(jsonObject.opt("ImageUrl").toString());

                        Log.e("TAG", String.valueOf(cname));
                        Log.e("tag","inside for 1");





                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
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
                Log.e(TAG, "Couldn't get json from server.");
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


                ListView lv = findViewById(R.id.lv);
                list_adapter adapter = new list_adapter(Courses.this, cname, cfee, cduration, celg, csyll, image);
                lv.setAdapter(adapter);
                Log.e("tag","adapter called");
        }

    }



}
