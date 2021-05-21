package com.example.runtimepermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btncheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncheck=findViewById(R.id.btncheck);

        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CheckRuntimePermission(Manifest.permission.CAMERA,101);
                CheckRuntimePermission(Manifest.permission.READ_EXTERNAL_STORAGE,102);
                CheckRuntimePermission(Manifest.permission.CALL_PHONE,100);
                CheckRuntimePermission(Manifest.permission.READ_CONTACTS,101);

            }
        });
    }

    public void CheckRuntimePermission(String permission,int requestcode){

        if(ContextCompat.checkSelfPermission(MainActivity.this,permission)==PackageManager.PERMISSION_DENIED){

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{permission},requestcode);

        }

        else{

            Toast.makeText(MainActivity.this,"Permission already granted..",Toast.LENGTH_LONG).show();
        }
    }
}