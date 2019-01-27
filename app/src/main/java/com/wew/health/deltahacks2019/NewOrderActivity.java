package com.wew.health.deltahacks2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class NewOrderActivity extends AppCompatActivity {

    private int prevActivity = 0;//1 == RecommendationActivity, 0 != Recommendation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_order);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        ImageView exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DashboardActivity.class);
                finish();
                startActivity(intent);
            }
        });

        ImageView menu = findViewById(R.id.menu);
        ImageView serveButton = findViewById(R.id.doneButton);
        prevActivity = getIntent().getIntExtra("SOURCE",0);

        if (prevActivity == 1){
            menu.setImageResource(R.drawable.menu_fruit_selected);
            serveButton.setImageResource(R.drawable.btn_serve_active);
            serveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), OurRecommendationActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), FruitMenuActivity.class);
                    startActivity(intent);
                }
            });
        }


    }
}
