package com.example.calcstart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final String KEY_APPLICATION = "KEY_APPLICATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runCalc = findViewById(R.id.button);

        runCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("example://intent");
                Intent runCalcIntent = new Intent(Intent.ACTION_VIEW, uri);
                runCalcIntent.putExtra(KEY_APPLICATION, "Запускатель калькулятора");

                @SuppressLint("WrongConstant") ActivityInfo activityInfo =
                        runCalcIntent.resolveActivityInfo(getPackageManager(), runCalcIntent.getFlags());
                if (activityInfo != null) {
                    startActivity(runCalcIntent);
                }

            }
        });
    }
}