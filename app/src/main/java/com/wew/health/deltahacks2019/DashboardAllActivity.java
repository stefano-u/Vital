package com.wew.health.deltahacks2019;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class DashboardAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_all);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        ImageView topBar = findViewById(R.id.topBar);
        topBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });

        ImageView patient2 = findViewById(R.id.patient2);

        patient2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavView = findViewById(R.id.navigation);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_patients:
                        intent = new Intent(getBaseContext(), DashboardAllActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_order:
                        intent = new Intent(getBaseContext(), NewOrderActivity.class);
                        intent.putExtra("SOURCE",0);
                        startActivity(intent);
                        break;

                    case R.id.navigation_settings:

                }
                return true;
            }
        });
    }
}
