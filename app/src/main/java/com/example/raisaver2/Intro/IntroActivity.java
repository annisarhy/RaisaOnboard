package com.example.raisaver2.Intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.raisaver2.Auth.LoginActivity;
import com.example.raisaver2.MainActivity;
import com.example.raisaver2.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnSkip, btnGetStarted;
    LinearLayout linearLayoutSkip, linearLayoutGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Membuat layar fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (restorePreData()){
            Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(loginActivity);
            finish();
        }

        setContentView(R.layout.activity_intro);

        // Views
        btnSkip = findViewById(R.id.btn_skip);
        btnGetStarted = findViewById(R.id.btn_get_started);

        linearLayoutSkip = findViewById(R.id.linear_layout_skip);
        linearLayoutGetStarted = findViewById(R.id.linear_layout_get_started);

        tabIndicator = findViewById(R.id.tab_indicator);

        // Fill data description

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Raisa", "Raisa(Rumah Informasi Geominerba) merupakan sebuah aplikasi yang dibuat untuk memudahkan pengguna untuk mendaftar diklat, menyewa barang, penginapan, dll.", R.mipmap.img_undraw1));
        mList.add(new ScreenItem("User Friendly", "Semua kemudahan tersedia di aplikasi Raisa, Baik dalam segi fitur ataupun pelayanannya.", R.mipmap.img_undraw3));
        mList.add(new ScreenItem("All In One", "Semua fitur yang dibutuhkan anda sekarang telah tersedia di aplikasi Raisa, Ayo coba sekarang juga !", R.mipmap.img_undraw2));


        // Setup ViewPager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        // Setup tab indicator
        tabIndicator.setupWithViewPager(screenPager);

        // Button Skip
        btnSkip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                screenPager.setCurrentItem(screenPager.getCurrentItem()+1, true);
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Button Get Started
        btnGetStarted.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginActivity);

                savePrefsData();
                finish();
            }
        });
    }

    private boolean restorePreData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = preferences.getBoolean("isIntroOpened", false);

        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("isIntroOpened", true);
        editor.apply();
    }

    private void loadLastScreen(){
        linearLayoutSkip.setVisibility(View.INVISIBLE);
        linearLayoutGetStarted.setVisibility(View.VISIBLE);
    }
}
