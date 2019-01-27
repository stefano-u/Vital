package com.wew.health.deltahacks2019;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class OurRecommendationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendation);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        ImageView exitButton = findViewById(R.id.recommendation);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewOrderActivity.class);
                finish();
                startActivity(intent);
            }
        });

        final ImageView avocadoToastUnchecked = findViewById(R.id.avocadoToast);
        final ImageView serveButton = findViewById(R.id.serveButton);
        avocadoToastUnchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avocadoToastUnchecked.setImageResource(R.drawable.list_avocado_toast_selected);
                serveButton.setImageResource(R.drawable.btn_serve_active);
                serveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Toast.makeText(OurRecommendationActivity.this, "You have prepared a meal", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), ServedActivity.class);
                        finish();
                        startActivity(intent);

                    }
                });
            }
        });

    }
}
