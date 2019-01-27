package com.wew.health.deltahacks2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class FruitMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_menu);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        final ImageView avocado = findViewById(R.id.avocado);
        final ImageView serveButton = findViewById(R.id.serveButton);
        avocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avocado.setImageResource(R.drawable.list_avocado_selected);
                serveButton.setImageResource(R.drawable.btn_serve_active);
                serveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),NewOrderActivity.class);
                        intent.putExtra("SOURCE",1);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
