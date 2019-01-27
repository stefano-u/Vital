package com.wew.health.deltahacks2019;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private int filterType = 0;//0 == alerts only, 1 == all patients
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        ImageView patient2 = findViewById(R.id.patient2);

        patient2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        final ImageView topBar = findViewById(R.id.topBar);
        final ImageView patient3 = findViewById(R.id.patient3);
        topBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(view.getContext(), DashboardAllActivity.class);
                //startActivity(intent);
                if (filterType == 0){
                    topBar.setImageResource(R.drawable.nav_top_all);
                    patient3.setVisibility(View.VISIBLE);
                    filterType = 1;
                }else if (filterType == 1){
                    topBar.setImageResource(R.drawable.nav_top);
                    patient3.setVisibility(View.GONE);
                    filterType = 0;
                }
            }
        });

        BottomNavigationView bottomNavView = findViewById(R.id.navigation);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_patients:
                        intent = new Intent(getBaseContext(), DashboardActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_order:
                        intent = new Intent(getBaseContext(), PersonChoiceActivity.class);
                        intent.putExtra("SOURCE",0);
                        startActivity(intent);
                        break;

                    case R.id.navigation_settings:
                        //nope
                }
                return true;
            }
        });


    }
}
